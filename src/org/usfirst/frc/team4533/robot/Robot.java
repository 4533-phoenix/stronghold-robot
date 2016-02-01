
package org.usfirst.frc.team4533.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.first.team4533.robot.OI;
import org.first.team4533.robot.autonomous.DefaultAutonomous;
import org.first.team4533.robot.subsystems.DriveSystem;


/**
 * Main class that is executed when robot is turned on
 */
public class Robot extends IterativeRobot {

	private Command autonomousCommand;

    public void robotInit() {
    	
    	
    	DriveSystem.initialize();
        
        OI.initialize();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	this.autonomousCommand = new DefaultAutonomous();
        this.autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }


    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
