package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.ClimbSystem;
import org.first.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedClimbRetract extends TimedCommand {

	private ClimbSystem climb;

	//private static final double DEFAULT_RETRACT_SPEED = -0.50;

	public TimedClimbRetract(long duration) {
		super(duration);
		this.climb = ClimbSystem.getInstance();
		this.requires(this.climb);
	}

	@Override
	protected void end() {
		this.climb.climbStop();
	}

	@Override
	protected void execute() {
		this.climb.up();
	}

	@Override
	protected void interrupted() {
	}
}
