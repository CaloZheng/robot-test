// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain;

public class ArcadeDriveCmd extends CommandBase {
  private Drivetrain drivetrain;
  private DoubleSupplier speedFunction;
  private DoubleSupplier rotationFunction;

  public ArcadeDriveCmd(Drivetrain drivetrain, DoubleSupplier speedFunction, DoubleSupplier rotationFunction) {
    this.speedFunction = speedFunction;
    this.rotationFunction = rotationFunction;
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(speedFunction.getAsDouble(), rotationFunction.getAsDouble() * 0.6);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
