package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.ClimbSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BrakeStop extends Command {

	private ClimbSystem climb;

    public BrakeStop() {
        this.climb = ClimbSystem.getInstance();
        requires(climb);
    }

    protected void initialize() {
    }

    protected void execute() {
    	this.climb.brakeStop();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	this.climb.brakeStop();
    }

    protected void interrupted() {
    	this.climb.brakeStop();
    }
}
