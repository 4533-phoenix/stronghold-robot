package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.DriveSystem;

public class TimedDriveBackward extends TimedCommand {

	private DriveSystem drive;

	private static final double DEFAULT_DRIVE_SPEED = -0.50;

	public TimedDriveBackward(long duration) {
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
		this.drive.forward(DEFAULT_DRIVE_SPEED);
	}

	@Override
	protected void interrupted() {
	}

}
