package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeStop extends Command {

	private IntakeSystem intake;

    public IntakeStop() {
        this.intake = IntakeSystem.getInstance();
        requires(intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	this.intake.stop();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	this.intake.stop();
    }

    protected void interrupted() {
    	this.intake.stop();
    }
}
