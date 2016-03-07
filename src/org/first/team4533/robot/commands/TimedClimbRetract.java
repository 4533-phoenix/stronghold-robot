package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.ClimbSystem;

/**
 *A timed command used for autonomous that takes in a time and a motor power
 *The idea for this one is to retract the climber at the input power for the input time
 */
public class TimedClimbRetract extends TimedCommand {

	private ClimbSystem climb;

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
