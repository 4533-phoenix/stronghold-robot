package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.commands.TimedClimbRetract;
import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Used for when we are lined up on the low bar
 */
public class RockWallAutonomous extends CommandGroup {
    
	private static final long DRIVE_FORWARD_DURATION = 3000;
	private static final long DRIVE_BACKWARD_DURATION = 4000;
	private static final long CLIMB_DURATION = 1000;

	public RockWallAutonomous() {
		this.addSequential(new TimedClimbRetract(CLIMB_DURATION));							//This pulls the arm down out of starting config
		this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION, -.9));	
		//this.addSequential(new TimedDriveBackward(DRIVE_BACKWARD_DURATION, .9));		//Our robot does not allow us to go backwards over the RW
	}
	
	//This is the auto configuarion for the rock wall
	//4000 at -.9 for rock wall	
}
