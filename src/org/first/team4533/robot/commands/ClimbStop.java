package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.ClimbSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbStop extends Command {

	private ClimbSystem climb;

    public ClimbStop() {
        this.climb = ClimbSystem.getInstance();
        requires(climb);
    }

    protected void initialize() {
    }

    protected void execute() {
    	this.climb.climbStop();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	this.climb.climbStop();
    }

    protected void interrupted() {
    	this.climb.climbStop();
    }
}
