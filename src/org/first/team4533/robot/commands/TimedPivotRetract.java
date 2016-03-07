package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.PivotSystem;

/**
 *This is a timed method used for autonomous that takes in a given time and motor power
 *The idea of this method is to pull in the pivot at the input power for the input time
 */
public class TimedPivotRetract extends TimedCommand {
	private PivotSystem pivot;

	public TimedPivotRetract(long duration) {
		super(duration);
		this.pivot = PivotSystem.getInstance();
		this.requires(this.pivot);
	}

	@Override
	protected void end() {
		this.pivot.stop();
	}

	@Override
	protected void execute() {
		this.pivot.in();
	}

	@Override
	protected void interrupted() {
	}

  }
