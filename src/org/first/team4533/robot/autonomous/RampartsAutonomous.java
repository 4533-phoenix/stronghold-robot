package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.commands.TimedClimbRetract;
import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RampartsAutonomous extends CommandGroup {
    
	private static final long DRIVE_FORWARD_DURATION = 3000;
	private static final long DRIVE_BACKWARD_DURATION = 3000;
	private static final long CLIMB_DURATION = 1000;
    
    public  RampartsAutonomous() {
    	this.addSequential(new TimedClimbRetract(CLIMB_DURATION));
    	this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION, -.9));
    	this.addSequential(new TimedDriveBackward(DRIVE_BACKWARD_DURATION, .9));
    }
    
    
    //This is the auto configuarion for the rough terrain
    //3000 at -.9 for rough terrain
}
