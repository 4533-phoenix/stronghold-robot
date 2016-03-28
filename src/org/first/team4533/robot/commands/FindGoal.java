package org.first.team4533.robot.commands;

import org.first.team4533.pixy.Pixy;
import org.first.team4533.robot.subsystems.DriveSystem;
import org.first.team4533.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FindGoal extends Command {
	
	private Pixy pixy;
	private DriveSystem drive;
	private IntakeSystem intake;

    public FindGoal() {
    	this.pixy = Pixy.getInstance();
    	this.drive = DriveSystem.getInstance();
    	this.intake = IntakeSystem.getInstance();
    }

    // Called just before this Command runs the first time
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(pixy.getBlock()==/*Create a block/array of blocks that are the target?>*/pixy.getBlock()){
    		this.intake.out();
    	}
    	else {
    		this.drive.turnRight();
    		try {
				wait(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		this.drive.stop();
    		try {
				wait(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		this.drive.turnLeft();
    		try {
				wait(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		this.drive.stop();
    		this.execute();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.drive.stop();
    }
    
    protected void initialize() {
    }
}
