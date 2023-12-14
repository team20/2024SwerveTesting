package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public final class Constants {
	private static final DriveBaseConstants DriveBase = new LBoardConstants();

	public static final class ControllerConstants {
		public static final int kDriverControllerPort = 0;
		public static final int kOperatorControllerPort = 1;
		public static final double kDeadzone = 0.1;
		public static final double kTriggerDeadzone = .05;

		public static final class Axis {
			public static final int kLeftX = 0;
			public static final int kLeftY = 1;
			public static final int kRightX = 2;
			public static final int kLeftTrigger = 3;
			public static final int kRightTrigger = 4;
			public static final int kRightY = 5;
		}

		public static final class Button {
			/** Left middle button */
			public static final int kSquare = 1;
			/** Bottom button */
			public static final int kX = 2;
			/** Right middle button */
			public static final int kCircle = 3;
			/** Top button */
			public static final int kTriangle = 4;
			public static final int kLeftBumper = 5;
			public static final int kRightBumper = 6;
			public static final int kLeftTrigger = 7;
			public static final int kRightTrigger = 8;
			public static final int kShare = 9;
			public static final int kOptions = 10;
			public static final int kLeftStick = 11;
			public static final int kRightStick = 12;
			public static final int kPS = 13;
			public static final int kTrackpad = 14;
		}

		public static final class DPad {
			public static final int kUp = 0;
			public static final int kRight = 90;
			public static final int kDown = 180;
			public static final int kLeft = 270;
		}
	}

	public static final class DriveConstants {
		public static final int kFrontLeftSteerID = DriveBase.kFrontLeftSteerID;
		public static final boolean kFrontLeftSteerInvert = DriveBase.kFrontLeftSteerInvert;
		public static final double kFrontLeftSteerOffsetDegrees = DriveBase.kFrontLeftModuleOffsetDegrees;
		public static final Translation2d kFrontLeftOffsetMeters = DriveBase.kFrontLeftModuleOffset;

		public static final int kFrontRightSteerID = DriveBase.kFrontRightSteerID;
		public static final boolean kFrontRightSteerInvert = DriveBase.kFrontRightSteerInvert;
		public static final double kFrontRightSteerOffsetDegrees = DriveBase.kFrontRightModuleOffsetDegrees;
		public static final Translation2d kFrontRightOffsetMeters = DriveBase.kFrontRightModuleOffset;

		public static final int kBackLeftSteerID = DriveBase.kBackLeftSteerID;
		public static final boolean kBackLeftSteerInvert = DriveBase.kBackLeftSteerInvert;
		public static final double kBackLeftSteerOffsetDegrees = DriveBase.kBackLeftModuleOffsetDegrees;
		public static final Translation2d kBackLeftOffsetMeters = DriveBase.kBackLeftModuleOffset;

		public static final int kBackRightSteerID = DriveBase.kBackRightSteerID;
		public static final boolean kBackRightSteerInvert = DriveBase.kBackRightSteerInvert;
		public static final double kBackRightSteerOffsetDegrees = DriveBase.kBackRightModuleOffsetDegrees;
		public static final Translation2d kBackRightOffsetMeters = DriveBase.kBackRightModuleOffset;

		public static final int kFrontLeftDriveID = DriveBase.kFrontLeftDriveID;
		public static final int kFrontRightDriveID = DriveBase.kFrontRightDriveID;

		public static final int kBackLeftDriveID = DriveBase.kBackLeftDriveID;
		public static final int kBackRightDriveID = DriveBase.kBackRightDriveID;

		public static final double kModuleResponseTimeSeconds = 0.20;
		// TODO re-evaluate current limits
		public static final int kSmartCurrentLimit = 55;
		public static final double kPeakCurrentLimit = 65;
		public static final int kPeakCurrentDurationMillis = 0;

		public static final int kP = 0;
		public static final int kI = 0;
		public static final int kIz = 1;
		public static final int kD = 0;
	}
}
