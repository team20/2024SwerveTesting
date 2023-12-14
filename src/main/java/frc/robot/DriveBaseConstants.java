package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public abstract class DriveBaseConstants {
	public int kFrontLeftDriveID;
	public int kBackLeftDriveID;
	public int kFrontRightDriveID;
	public int kBackRightDriveID;

	public int kFrontLeftSteerID;
	public int kBackLeftSteerID;
	public int kFrontRightSteerID;
	public int kBackRightSteerID;

	public double kFrontLeftModuleOffsetDegrees;
	public double kBackLeftModuleOffsetDegrees;
	public double kFrontRightModuleOffsetDegrees;
	public double kBackRightModuleOffsetDegrees;

	public Translation2d kFrontLeftModuleOffset;
	public Translation2d kBackLeftModuleOffset;
	public Translation2d kFrontRightModuleOffset;
	public Translation2d kBackRightModuleOffset;

	public boolean kFrontLeftSteerInvert = false;
	public boolean kBackLeftSteerInvert = false;
	public boolean kFrontRightSteerInvert = false;
	public boolean kBackRightSteerInvert = false;

	public boolean kFrontLeftDriveInvert = false;
	public boolean kBackLeftDriveInvert = false;
	public boolean kFrontRightDriveInvert = false;
	public boolean kBackRightDriveInvert = false;
}
