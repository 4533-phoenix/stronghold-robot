package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.DriveSystem;
import org.first.team4533.robot.subsystems.PivotSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedPivotRetract extends TimedCommand {
	private PivotSystem pivot;

	//private static final double DEFAULT_DRIVE_SPEED = 0.80;

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
