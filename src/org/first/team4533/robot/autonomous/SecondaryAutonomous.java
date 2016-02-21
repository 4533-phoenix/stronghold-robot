package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;
import org.first.team4533.robot.commands.TimedDriveTurnLeft;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Used for when we are 1 defense from the low bar
 */
public class SecondaryAutonomous extends CommandGroup {
    
	private static final long DRIVE_FORWARD_OVER_OBSTACLE_DURATION = 10000;
	private static final long DRIVE_FORWARD_REPOSITION_DURATION = 2000;
	//private static final long DRIVE_BACKWARD_DURATION = 0;
	private static final long DRIVE_TURNLEFT_DURATION = 1000;
	private static final long DRIVE_TURNRIGHT_DURATION = 1000;

	public SecondaryAutonomous() {
		this.addSequential(new TimedDriveTurnLeft(DRIVE_TURNLEFT_DURATION));
		this.addSequential(new TimedDriveForward(DRIVE_FORWARD_REPOSITION_DURATION));
		this.addSequential(new TimedDriveBackward(DRIVE_TURNRIGHT_DURATION));
		this.addSequential(new TimedDriveForward(DRIVE_FORWARD_OVER_OBSTACLE_DURATION));
		
	}
}
