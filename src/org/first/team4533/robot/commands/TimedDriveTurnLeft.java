package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.DriveSystem;


/**
 *
 */
public class TimedDriveTurnLeft extends TimedCommand {

	private DriveSystem drive;

	public TimedDriveTurnLeft(long duration) {
		super(duration);
		this.drive = DriveSystem.getInstance();
		this.requires(this.drive);
	}

	@Override
	protected void end() {
		this.drive.stop();
	}

	@Override
	protected void execute() {
		this.drive.turnLeft();
	}

	@Override
	protected void interrupted() {
	}
}
