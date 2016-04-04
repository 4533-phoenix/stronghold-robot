package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.commands.TimedClimbRetract;
import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RoughTerrainAutonomous extends CommandGroup {
	
	private static final long DRIVE_FORWARD_DURATION = 3000;
	private static final long DRIVE_BACKWARD_DURATION = 2500;
	private static final long CLIMB_DURATION = 1000;
    
    public  RoughTerrainAutonomous() {
    	this.addSequential(new TimedClimbRetract(CLIMB_DURATION));						//This pulls the arm down out of starting config
    	this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION, -.9));			//We go forward over the RT
    	this.addSequential(new TimedDriveBackward(DRIVE_BACKWARD_DURATION, .9));		//Then go backwards and DO NOt go over the white line
    	//This allows us to be in position to go back over it immediately				//If we did then it would be a penalty
    }
    
    
    //This is the auto configuarion for the rough terrain
    //3000 at -.9 for rough terrain
}
