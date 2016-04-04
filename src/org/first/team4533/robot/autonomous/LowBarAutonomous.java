package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.commands.TimedClimbRetract;
import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;
import org.first.team4533.robot.commands.TimedDriveTurnRight;
import org.first.team4533.robot.commands.TimedIntakeOut;
import org.first.team4533.robot.commands.TimedPivotRetract;



import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *Autonomous used for the low bar
 *It is currently disabled because we could no ensure that, when
 *retracting the arms and putting the pivot down, it would fit
 *under the low bar without breaking the bar or the robot
 */
public class LowBarAutonomous extends CommandGroup{
	private static final long DRIVE_BACKWARD_DURATION = 0;
	private static final long DRIVE_FORWARD_DURATION = 3000; 					//These are all values that never change, in this case time periods
	private static final long DRIVE_TURN_RIGHT_DURATION = 1000;					//which are measured in milliseconds. divide by 1000 to get in
	private static final long DRIVE_FORWARD_SHOOT_DURATION = 2000;				//seconds. 
	private static final long CLIMB_RETRACT_DURATION = 1000;
	private static final long PIVOT_RETRACT_DURATION = 1000;
	private static final long INTAKE_SCORE_DURATION = 2000;

	public LowBarAutonomous() {
		this.addSequential(new TimedClimbRetract(CLIMB_RETRACT_DURATION));				//This pulls the arm down out of starting config
		this.addSequential(new TimedPivotRetract(PIVOT_RETRACT_DURATION));				//This puts the pivot down so that it MIGHT fit under the low bar
		/*this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION, -.5));			//These are the commands executed in order
		this.addSequential(new TimedDriveTurnRight(DRIVE_TURN_RIGHT_DURATION, .5));		//backwards is forwards right now and vice versa
		this.addSequential(new TimedDriveForward(DRIVE_FORWARD_SHOOT_DURATION, -.5));
		this.addSequential(new TimedIntakeOut(INTAKE_SCORE_DURATION));*/
	}
	
	//This is the autonomous configuration for the low bar
	//5000 at -.5 for low bar	
}
