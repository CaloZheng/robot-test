// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.TurnDegreesCmd;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain driveSubsystem = new Drivetrain();
  private final Joystick controller = new Joystick(0);
  private final Trigger button = new JoystickButton(controller, 1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(
      driveSubsystem,
      () -> -controller.getRawAxis(1),
      () -> -controller.getRawAxis(0)
    ));

    // button.onTrue(new TurnDegreesCmd(driveSubsystem, 90.0));
  }
}
