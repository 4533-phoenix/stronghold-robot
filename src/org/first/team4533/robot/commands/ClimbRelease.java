package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.ClimbSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbRelease extends Command {

	private ClimbSystem climb;

    public ClimbRelease() {
        this.climb = ClimbSystem.getInstance();
        requires(climb);
    }

    protected void initialize() {
    }

    protected void execute() {
    	this.climb.release();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	this.climb.stop();
    }

    protected void interrupted() {
    	this.climb.stop();
    }
}
