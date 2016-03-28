package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.DriveSystem;


/**
 *
 */
public class TimedDriveTurnRight extends TimedCommand {

	private DriveSystem drive;
	private static double DEFAULT_DRIVE_SPEED;

	public TimedDriveTurnRight(long duration, double speed) {
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
		this.drive.turnRight(DEFAULT_DRIVE_SPEED, -DEFAULT_DRIVE_SPEED);
	}

	@Override
	protected void interrupted() {
	}
}
