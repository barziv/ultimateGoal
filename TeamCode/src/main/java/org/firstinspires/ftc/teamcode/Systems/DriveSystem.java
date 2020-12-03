package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Abstract.SystemBase;

public class DriveSystem extends SystemBase {

    private DcMotor _leftFront;
    private DcMotor _leftBack;
    private DcMotor _rightFront;
    private DcMotor _rightBack;

    private Gamepad _gamepad;

    public DriveSystem(DcMotor leftFront, DcMotor leftBack, DcMotor rightFront, DcMotor rightBack, Gamepad gamepad) {
        _leftBack = leftBack;
        _leftFront = leftFront;
        _rightBack = rightBack;
        _rightFront = rightFront;
        _gamepad = gamepad;
    }


    @Override
    public void run() {
        double levitationPower = 0.75;

        while (true) {
            if (_gamepad.right_trigger > 0) {
                DriveForward(_gamepad.right_trigger);
            }
            else if (_gamepad.left_trigger > 0) {
                DriveBackward(_gamepad.left_trigger);
            }
            else if (_gamepad.left_stick_x != 0) {
                Turn(_gamepad.left_stick_x);
            }
            else if (_gamepad.dpad_right) {
                RightLevitation(levitationPower);
            }
            else if (_gamepad.dpad_left) {
                LeftLevitation(levitationPower);
            }
            else {
                StopAllMotors();
            }
        }
    }

    private void DriveForward(double power) {
        _rightFront.setPower(power);
        _rightBack.setPower(power);
        _leftFront.setPower(-power);
        _leftBack.setPower(-power);
    }

    private void DriveBackward(double power) {
        DriveForward(-power);
    }

    private void Turn(double power) {
        _rightFront.setPower(power);
        _rightBack.setPower(power);
        _leftFront.setPower(power);
        _leftBack.setPower(power);
    }

    private void LeftLevitation(double power) {
        _rightFront.setPower(-power);
        _rightBack.setPower(power);
        _leftFront.setPower(power);
        _leftBack.setPower(-power);
    }

    private void RightLevitation(double power) {
        LeftLevitation(-power);
    }

    private void StopAllMotors() {
        _rightFront.setPower(0);
        _rightBack.setPower(0);
        _leftFront.setPower(0);
        _leftBack.setPower(0);
    }
}
