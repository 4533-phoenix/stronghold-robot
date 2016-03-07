package org.first.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/* 
 * This command is not used EXPLICITLY in the code, but rather is used to create all of the timed
 * methods that we use for autonomous
 * Note that Each of the command methods with "Timed" in them extends TimedCommand and not Command
 * lLike the rest of the commands 
 */

public abstract class TimedCommand extends Command {

	/**
	 * The amount of time in milliseconds that the command should run.
	 */
	private long duration;
	/**
	 * The time in milliseconds of when the command started.
	 */
	private long startTime;

	/**
	 * Create a new timed command with the specified duration.
	 * 
	 * @param duration
	 *            the amount of time in milliseconds that the command should
	 *            run.
	 */
	public TimedCommand(long duration) {
		this.duration = duration;
	}

	protected void initialize() {
		this.startTime = System.currentTimeMillis();
		System.out.println("Start Time: " + this.startTime);
	}

	protected boolean isFinished() {
		long currentTime = System.currentTimeMillis();
		long elapsedTime = currentTime - this.startTime;
		return (elapsedTime >= this.duration);
	}
}
