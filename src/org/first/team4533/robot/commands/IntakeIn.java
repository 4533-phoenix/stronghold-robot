package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeIn extends Command {
	private IntakeSystem intake;

    public IntakeIn() {
        this.intake = IntakeSystem.getInstance();
        requires(intake);
    }

    protected void execute() {
    	this.intake.in();
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
    
    protected void initialize() {
    }
}
