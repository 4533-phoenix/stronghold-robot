package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.commands.TimedClimbRetract;
import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoatAutonomous extends CommandGroup {
    
	private static final long DRIVE_FORWARD_DURATION = 2000;
	private static final long DRIVE_BACKWARD_DURATION = 2000;
	private static final long CLIMB_DURATION = 1000;
    
    public  MoatAutonomous() {
    	this.addSequential(new TimedClimbRetract(CLIMB_DURATION));
    	this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION, -.9));
    	this.addSequential(new TimedDriveBackward(DRIVE_BACKWARD_DURATION, .9));
    }
    
    
    //This is the auto configuarion for the moat
    //3000 at -.9 for moat
}
