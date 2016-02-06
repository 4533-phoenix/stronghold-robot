package org.first.team4533.robot.commands;

//import org.first.team4533.robot.commands.TimedCommand;
import org.first.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command{
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

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
