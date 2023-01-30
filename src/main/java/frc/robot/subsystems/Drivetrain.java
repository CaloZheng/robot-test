// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private final WPI_TalonSRX frontLeft = new WPI_TalonSRX(5);
  private final WPI_TalonSRX frontRight = new WPI_TalonSRX(6);
  private final WPI_VictorSPX backLeft = new WPI_VictorSPX(1);
  private final WPI_VictorSPX backRight = new WPI_VictorSPX(3);

  private final MotorControllerGroup leftMotors = new MotorControllerGroup(frontLeft, backLeft);
  private final MotorControllerGroup rightMotors = new MotorControllerGroup(frontRight, backRight);

  private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  private final AHRS gyro = new AHRS();

  public Drivetrain() {
    rightMotors.setInverted(true);
  }

  public void arcadeDrive(double speed, double rotation) {
    SmartDashboard.putNumber("speed", speed);
    SmartDashboard.putNumber("rotation", rotation);
    drive.arcadeDrive(speed, rotation);
  }

  public void turn(double speed) {
    leftMotors.set(-speed);
    rightMotors.set(speed);
  }

  public double getGyroYaw() {
    return gyro.getYaw();
  }

  @Override
  public void periodic() {}
}
