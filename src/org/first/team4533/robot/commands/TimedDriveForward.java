package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.DriveSystem;

public class TimedDriveForward extends TimedCommand {

	private DriveSystem drive;

	private static double DEFAULT_DRIVE_SPEED;			//motor speed for autonomous driving forward

	public TimedDriveForward(long duration, double speed) {
		super(duration);
		this.drive = DriveSystem.getInstance();
		this.requires(this.drive);
		DEFAULT_DRIVE_SPEED = speed;
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
