/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Solenoid;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */



public class Robot extends TimedRobot {
  Victor backRight = new Victor(0);
  Victor frontRight = new Victor(1);
  SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);
  Victor backLeft = new Victor(3);
  Victor frontLeft = new Victor(4);
  SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(right, left);  
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();
  Solenoid exampleSolenoid = new Solenoid(1);
  Victor tshirt = new Victor(5);


  
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    
   
  }

public class GyroSample extends SampleRobot {
  
}

  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (m_timer.get() < 10.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
      m_robotDrive.stopMotor(); // stop robot
    }
  }

  @Override
  public void teleopInit() {
  }

  //@Override
  public void teleopPeriodic() {
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
    if(m_stick.getRawButtonPressed(3)){ //X
      tshirt.setSpeed(1.0);
      exampleSolenoid.set(true);
    }
    else if(m_stick.getRawButtonPressed(4)){//Y
     tshirt.setSpeed(0.0);
     exampleSolenoid.set(false);
  }
}

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
