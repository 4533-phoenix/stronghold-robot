package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.commands.TimedDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RoughTerrainAutonomous extends CommandGroup {
	
	private static final long DRIVE_FORWARD_DURATION = 3000;
    
    public  RoughTerrainAutonomous() {
    	this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION, -.9));	
    }
    
    
    //This is the auto configuarion for the rough terrain
    //3000 at -.9 for rough terrain
}
