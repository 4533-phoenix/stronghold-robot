package org.first.team4533.pixy;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.SerialPort;

public class Pixy {
	/**
	 * Default baudrate for serial communications with the Pixy.
	 */
	private static final int PIXY_BAUDRATE = 19200;

	/**
	 * Pixy 16-bit sync word for regular signature blocks.
	 */
	private static final int PIXY_SYNC_WORD = 0xAA55;

	/**
	 * Pixy 16-bit sync word for color-code signature blocks.
	 */
	private static final int PIXY_SYNC_WORD_CC = 0xAA56;

	/**
	 * Pixy 16-bit sync word to indicate if comms are out of sync.
	 */
	private static final int PIXY_SYNC_WORD_X = 0x55AA;

	private static final int PIXY_EMPTY_WORD = 0x0000;

	public static final int PIXY_MAX_BLOCKS = 100;

	/**
	 * The serial port used to communicate with the Pixy.
	 */
	private SerialPort pixy;

	public Pixy() {
		this.pixy = new SerialPort(PIXY_BAUDRATE, SerialPort.Port.kMXP);
	}

	/**
	 * Get a 16-bit word from the pixy.
	 * 
	 * @return an int representation of the 16-bit word.
	 */
	private int getWord() {
		byte[] word = this.pixy.read(2);
		return ((int) word[1] & 0xFF) | ((int) word[0] & 0xFF);
	}

	/**
	 * Seek to the start of the next frame of blocks.
	 * 
	 * @return 
	 */
	private int seekToStart() {
		int word = 0xFFFF;
		int lastWord = 0xFFFF;
		boolean found = false;
		
		while (!found) {
			word = this.getWord();

			found = ((word == PIXY_EMPTY_WORD && lastWord == PIXY_EMPTY_WORD)
					|| (word == PIXY_SYNC_WORD && lastWord == PIXY_SYNC_WORD)
					|| (word == PIXY_SYNC_WORD_CC && lastWord == PIXY_SYNC_WORD));
			
			if (word == PIXY_SYNC_WORD_X) {
				this.pixy.read(1);
			}

			lastWord = word;
		}

		return word;
	}

	private PixyBlockType getBlockType(int word) {
		PixyBlockType type = PixyBlockType.UNKNOWN_BLOCK;

		if (word == PIXY_SYNC_WORD) {
			type = PixyBlockType.NORMAL_BLOCK;
		} else if (word == PIXY_SYNC_WORD_CC) {
			type = PixyBlockType.COLOR_CODE_BLOCK;
		}

		return type;
	}

	/**
	 * Get the current data blocks from the Pixy.
	 * 
	 * @return the data blocks found.
	 */
	public List<PixyBlock> getBlock() {
		List<PixyBlock> blocks = new ArrayList<PixyBlock>();
		PixyBlock block = null;

		// Find the start of the block.
		int startWord = this.seekToStart();
		PixyBlockType type =  this.getBlockType(startWord);
				
		for (int i = 0; i < PIXY_MAX_BLOCKS; i++) {
			
			int checksum = this.getWord();

			if (type == PixyBlockType.NORMAL_BLOCK) {
				/*
				 * If the checksum is the same as the sync word, then we have
				 * reached the end of the frame.
				 */
				if (checksum == PIXY_SYNC_WORD) {
					break;
				}

				int signature = this.getWord();
				int x = this.getWord();
				int y = this.getWord();
				int width = this.getWord();
				int height = this.getWord();

				block = new PixyBlock(signature, x, y, width, height);
				block.setChecksum(checksum);
				
				blocks.add(block);
			} else if (type == PixyBlockType.COLOR_CODE_BLOCK) {

				/*
				 * If the checksum is the same as the sync word, then we have
				 * reached the end of the frame.
				 */
				if (checksum == PIXY_SYNC_WORD) {
					break;
				}
			}

			/* Get the type of the next block. */
			type = this.getBlockType(this.getWord());
		}

		return blocks;
	}
}