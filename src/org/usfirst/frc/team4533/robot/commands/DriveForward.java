package org.usfirst.frc.team4533.robot.commands;

//import org.first.team4533.robot.commands.TimedCommand;
import org.first.team4533.robot.subsystems.DriveSystem;

public class DriveForward {
	private DriveSystem drive;
	private final double speed;

	public DriveForward(double speed) {
		this.speed = speed;
		this.drive = DriveSystem.getInstance();
	}

	protected void execute() {
		this.drive.forward(this.speed);
	}

	protected void end() {
		this.drive.stop();
	}

	protected void interrupted() {
		this.drive.stop();
	}
}
