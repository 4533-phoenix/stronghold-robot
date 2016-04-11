package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.commands.TimedClimbRetract;
import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;
import org.first.team4533.robot.commands.TimedDriveTurnLeft;
import org.first.team4533.robot.commands.TimedDriveTurnRight;
import org.first.team4533.robot.commands.TimedIntakeOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Used for when we are lined up on the low bar
 */
public class RockWallAutonomous extends CommandGroup {
    
	private static final long DRIVE_FORWARD_DURATION = 3000;
	private static final long DRIVE_BACKWARD_DURATION = 4000;
	private static final long DRIVE_TURN_DURATION = 500;
	private static final long DRIVE_SCORE_DURATION = 500;
	private static final long CLIMB_DURATION = 1000;
	private static final long INTAKE_DURATION = 2000;

	public RockWallAutonomous(int pos) {
		if(pos == 2) {
    		this.addSequential(new TimedClimbRetract(CLIMB_DURATION));
    		this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION, -.9));
    		this.addSequential(new TimedDriveTurnRight(DRIVE_TURN_DURATION, .5));
    		this.addSequential(new TimedDriveForward(DRIVE_SCORE_DURATION, .6));
    		this.addSequential(new TimedIntakeOut(INTAKE_DURATION));
    	}
    	else if(pos == 5){
    		this.addSequential(new TimedClimbRetract(CLIMB_DURATION));
    		this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION, -.9));
    		this.addSequential(new TimedDriveTurnLeft(DRIVE_TURN_DURATION, .5));
    		this.addSequential(new TimedDriveForward(DRIVE_SCORE_DURATION, .6));
    		this.addSequential(new TimedIntakeOut(INTAKE_DURATION));
    	}
    	else if(pos == 3 || pos == 4) {
    		this.addSequential(new TimedClimbRetract(CLIMB_DURATION));					//This pulls the arm down out of starting config
    		this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION, -.9));
    	}
    	else {
    		this.addSequential(new TimedClimbRetract(CLIMB_DURATION));
    	}
	}
	
	//This is the auto configuarion for the rock wall
	//4000 at -.9 for rock wall	
}
