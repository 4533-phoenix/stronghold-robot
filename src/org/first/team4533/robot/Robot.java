
package org.first.team4533.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

import org.first.team4533.robot.autonomous.DefaultAutonomous;
import org.first.team4533.robot.autonomous.SecondaryAutonomous;
import org.first.team4533.robot.subsystems.ClimbSystem;
import org.first.team4533.robot.subsystems.DriveSystem;
import org.first.team4533.robot.subsystems.IntakeSystem;
import org.first.team4533.robot.subsystems.PivotSystem;


/**
 * Main class that is executed when robot is turned on
 */
public class Robot extends IterativeRobot {

	private CommandGroup autonomousCommand;
	private SendableChooser autoChooser;
	//private CameraServer cameraServer;

    public void robotInit() {
    	/*USBCamera camera = new USBCamera();
    	cameraServer = CameraServer.getInstance();
        cameraServer.setQuality(50);
        cameraServer.startAutomaticCapture(camera);*/
    	
    	ClimbSystem.initialize();
    	PivotSystem.initialize();
    	DriveSystem.initialize();
        IntakeSystem.initialize();
        OI.initialize();
        
        
        /*autoChooser = new SendableChooser();
        autoChooser.addDefault("Default program", new DefaultAutonomous());
        autoChooser.addObject("1 Defense off program", new SecondaryAutonomous());
        //autoChooser.addObject("2 Defense of program" , new TertiaryAutonomous());
        SmartDashboard.putData("Autonomous mode chooser", autoChooser);*/
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	this.autonomousCommand = 
    			new DefaultAutonomous();//(CommandGroup) autoChooser.getSelected();
        this.autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) {
        	autonomousCommand.cancel();
        }
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
