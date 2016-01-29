package org.usfirst.frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import org.first.team4533.robot.subsystems.DriveSystem;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {
	private DriveSystem drive;
	private Joystick driver;

	public DriveWithJoystick() {
		this.drive = DriveSystem.getInstance();
		driver = new Joystick(0);
		this.requires(drive);
	}

	protected void execute() {
		this.drive.driveWithJoystick(this.driver);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}
}
