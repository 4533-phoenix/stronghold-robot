package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.DriveSystem;

public class TimedDriveBackward extends TimedCommand {

	private DriveSystem drive;

	private static double DEFAULT_DRIVE_SPEED;

	public TimedDriveBackward(long duration, double speed) {
		super(duration);
		DEFAULT_DRIVE_SPEED = speed;
		this.drive = DriveSystem.getInstance();
		this.requires(this.drive);
	}

	@Override
	protected void end() {
		this.drive.stop();
	}

	@Override
	protected void execute() {
		this.drive.forward(DEFAULT_DRIVE_SPEED);
	}

	@Override
	protected void interrupted() {
	}

}
