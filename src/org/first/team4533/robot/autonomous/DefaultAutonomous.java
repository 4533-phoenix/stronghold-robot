package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.RobotMap;
import org.first.team4533.robot.commands.TimedClimbRetract;
import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;
import org.first.team4533.robot.commands.TimedDriveTurnRight;
import org.first.team4533.robot.commands.TimedPivotRetract;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DefaultAutonomous extends CommandGroup{
	private static final long DRIVE_BACKWARD_DURATION = 0;
	private static final long DRIVE_FORWARD_DURATION = 4000; 					//These are all values that never change, in this case time periods
	private static final long DRIVE_TURN_RIGHT_DURATION = 1000;					//which are measured in milliseconds. divide by 1000 to get in
	private static final long DRIVE_FORWARD_SHOOT_DURATION = 2000;				//seconds. 
	private static final long CLIMB_RETRACT_DURATION = 1000;
	private static final long PIVOT_RETRACT_DURATION = 2000;

	public DefaultAutonomous() {
		//this.addSequential(new TimedClimbRetract(CLIMB_RETRACT_DURATION));
		//this.addSequential(new TimedPivotRetract(PIVOT_RETRACT_DURATION));
		//this.addSequential(new TimedDriveForward(DRIVE_BACKWARD_DURATION));
		this.addSequential(new TimedDriveBackward(DRIVE_FORWARD_DURATION, .8));				//These are the commands executed in order
		//this.addSequential(new TimedDriveTurnRight(DRIVE_TURN_RIGHT_DURATION));		//backwards is forwards right now and vice versa
		//this.addSequential(new TimedDriveBackward(DRIVE_FORWARD_SHOOT_DURATION));
	}
	
	//5000 at -.5 for low bar
	//4000 at -.9 for rock wall		
	//3000 at -.9 for rough terrain

}
