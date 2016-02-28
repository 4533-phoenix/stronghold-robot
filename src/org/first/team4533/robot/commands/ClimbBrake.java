package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.ClimbSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbBrake extends Command {

	private ClimbSystem climb;

    public ClimbBrake() {
        this.climb = ClimbSystem.getInstance();
        requires(climb);
    }

    protected void initialize() {
    }

    protected void execute() {
    	this.climb.brake();
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
