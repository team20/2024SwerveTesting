package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public class LBoardConstants extends DriveBaseConstants {
	public int kFrontLeftDriveID = 0;
	public int kBackLeftDriveID = 0;
	public int kFrontRightDriveID = 0;
	public int kBackRightDriveID = 0;

	public int kFrontLeftSteerID = 0;
	public int kBackLeftSteerID = 0;
	public int kFrontRightSteerID = 0;
	public int kBackRightSteerID = 0;

	public double kFrontLeftModuleOffsetDegrees = 0;
	public double kBackLeftModuleOffsetDegrees = 0;
	public double kFrontRightModuleOffsetDegrees = 0;
	public double kBackRightModuleOffsetDegrees = 0;

	public Translation2d kFrontLeftModuleOffset = new Translation2d(0, 0);
	public Translation2d kBackLeftModuleOffset = new Translation2d(0, 0);
	public Translation2d kFrontRightModuleOffset = new Translation2d(0, 0);
	public Translation2d kBackRightModuleOffset = new Translation2d(0, 0);
}
