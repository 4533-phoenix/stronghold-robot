package org.first.team4533.robot.commands;

import org.first.team4533.robot.subsystems.PivotSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PivotOut extends Command {
	private PivotSystem pivot;

    public PivotOut() {
        this.pivot = PivotSystem.getInstance();
        requires(pivot);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.pivot.out();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.pivot.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.pivot.stop();
    }
}
