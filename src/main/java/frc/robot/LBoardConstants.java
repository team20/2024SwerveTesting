package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public class LBoardConstants extends DriveBaseConstants {
	public LBoardConstants() {

		kFrontLeftDriveID = 8;
		kBackLeftDriveID = 1;
		kFrontRightDriveID = 2;
		kBackRightDriveID = 3;

		kFrontLeftSteerID = 4;
		kBackLeftSteerID = 5;
		kFrontRightSteerID = 6;
		kBackRightSteerID = 7;

		kFrontLeftModuleOffsetDegrees = 0;
		kBackLeftModuleOffsetDegrees = 0;
		kFrontRightModuleOffsetDegrees = 0;
		kBackRightModuleOffsetDegrees = 0;

		kFrontLeftModuleOffset = new Translation2d(0, 0);
		kBackLeftModuleOffset = new Translation2d(0, 0);
		kFrontRightModuleOffset = new Translation2d(0, 0);
		kBackRightModuleOffset = new Translation2d(0, 0);
	}
}
