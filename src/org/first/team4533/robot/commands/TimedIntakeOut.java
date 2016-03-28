package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.IntakeSystem;

/**
 *
 */
public class TimedIntakeOut extends TimedCommand {

	private IntakeSystem intake;

	public TimedIntakeOut(long duration) {
		super(duration);
		this.intake = IntakeSystem.getInstance();
		this.requires(this.intake);
	}

	@Override
	protected void end() {
		this.intake.stop();
	}

	@Override
	protected void execute() {
		this.intake.out();
	}

	@Override
	protected void interrupted() {
	}
}
