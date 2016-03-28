package org.first.team4533.pixy;

public class PixyBlock {
	private int signature;
	private int x;
	private int y;
	private int width;
	private int height;
	private int checksum;
	
	public PixyBlock(int signature, int x, int y, int width, int height) {
		this.signature = signature;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int getSignature() {
		return this.signature;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getChecksum() {
		return this.checksum;
	}
	
	public void setChecksum(int checksum) {
		this.checksum = checksum;
	}
	
	public boolean verifyChecksum() {
		int sum = 0;
		
		sum += this.signature;
		sum += this.x;
		sum += this.y;
		sum += this.width;
		sum += this.height;
		
		return (sum == this.checksum);
	}
}