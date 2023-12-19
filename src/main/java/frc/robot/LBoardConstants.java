package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public class LBoardConstants extends DriveBaseConstants {
	public LBoardConstants() {

		kFrontLeftDriveID = 1;
		kBackLeftDriveID = 7;
		kFrontRightDriveID = 3;
		kBackRightDriveID = 5;

		kFrontLeftSteerID = 2;
		kBackLeftSteerID = 8;
		kFrontRightSteerID = 4;
		kBackRightSteerID = 6;

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
