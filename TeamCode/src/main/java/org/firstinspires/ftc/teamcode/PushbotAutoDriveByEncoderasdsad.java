package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

@Autonomous(name="Pushbot: Auto Drive By Encoder", group="Pushbot")
//@Disabled
public class PushbotAutoDriveByEncoderasdsad extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime     runtime = new ElapsedTime();

    robot r = new robot();

    @Override
    public void runOpMode() {
        r.init(hardwareMap);

        waitForStart();

        ReleaseHooks();
        FlyRight(0.3,10,30);
        sleep(500);
        Drive(0.3,10,-82);
        sleep(500);
        CatchHooks();
        sleep(500);
        Drive(0.6,10,120);
        sleep(500);
        /*TurnLeft(0.5,10,180);
        ReleaseHooks();*/
    }

    public void CatchHooks()
    {
        r.hook_left.setPosition(0.25);
        r.hook_right.setPosition(1);
    }

    public void ReleaseHooks()
    {
        r.hook_left.setPosition(0.7);
        r.hook_right.setPosition(0.4);
    }
    public void Drive(double speed, double timeoutS,int cm) {

        if (opModeIsActive()) {

            int ticks=cm*14;

            r.left_back.setTargetPosition(r.left_back.getCurrentPosition() + ticks);
            r.left_front.setTargetPosition(r.left_front.getCurrentPosition() + ticks);
            r.right_back.setTargetPosition(r.right_back.getCurrentPosition() - ticks);
            r.right_front.setTargetPosition(r.right_front.getCurrentPosition() - ticks);

            r.left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.left_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            r.left_back.setPower(speed);
            r.left_front.setPower(speed);
            r.right_back.setPower(speed+0.1);
            r.right_front.setPower(speed+0.1);

            while (opModeIsActive() && (runtime.seconds() < timeoutS) && (r.left_back.isBusy())&& (r.left_front.isBusy())&& (r.right_back.isBusy()) &&(r.right_front.isBusy())) {

            }

            r.left_back.setPower(0);
            r.left_front.setPower(0);
            r.right_back.setPower(0);
            r.right_front.setPower(0);

            r.left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }

    public void TurnRight(double speed, double timeoutS,int degrees) {

        if (opModeIsActive()) {

            int ticks=(int)(0.55833333333*degrees*10);

            r.left_back.setTargetPosition(r.left_back.getCurrentPosition()+ticks);
            r.left_front.setTargetPosition(r.left_front.getCurrentPosition()+ticks);
            r.right_back.setTargetPosition(r.right_back.getCurrentPosition()+ticks);
            r.right_front.setTargetPosition(r.right_front.getCurrentPosition()+ticks);

            r.left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.left_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            r.left_back.setPower(speed);
            r.left_front.setPower(speed);
            r.right_back.setPower(speed);
            r.right_front.setPower(speed);

            while (opModeIsActive() && (runtime.seconds() < timeoutS) && (r.left_back.isBusy())&& (r.left_front.isBusy())&& (r.right_back.isBusy()) &&(r.right_front.isBusy())) {

            }

            r.left_back.setPower(0);
            r.left_front.setPower(0);
            r.right_back.setPower(0);
            r.right_front.setPower(0);

            r.left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }

    public void TurnLeft(double speed, double timeoutS,int degrees) {

        if (opModeIsActive()) {

            int ticks=(int)(0.55833333333*degrees*10);

            r.left_back.setTargetPosition(r.left_back.getCurrentPosition()-ticks);
            r.left_front.setTargetPosition(r.left_front.getCurrentPosition()-ticks);
            r.right_back.setTargetPosition(r.right_back.getCurrentPosition()-ticks);
            r.right_front.setTargetPosition(r.right_front.getCurrentPosition()-ticks);

            r.left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.left_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            r.left_back.setPower(speed);
            r.left_front.setPower(speed);
            r.right_back.setPower(speed);
            r.right_front.setPower(speed);

            while (opModeIsActive() && (runtime.seconds() < timeoutS) && (r.left_back.isBusy())&& (r.left_front.isBusy())&& (r.right_back.isBusy()) &&(r.right_front.isBusy())) {

            }

            r.left_back.setPower(0);
            r.left_front.setPower(0);
            r.right_back.setPower(0);
            r.right_front.setPower(0);

            r.left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }

    /*public void FlyRight(double speed, double timeoutS,int cm) {

        if (opModeIsActive()) {

            int ticks=(int)(cm*15.5);// 17.3611111112

            r.left_back.setTargetPosition(-Math.abs(ticks));
            r.left_front.setTargetPosition(Math.abs(ticks));
            r.right_back.setTargetPosition(-Math.abs(ticks));
            r.right_front.setTargetPosition(Math.abs(ticks));

            r.left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.left_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            r.left_back.setPower(speed);
            r.left_front.setPower(speed);
            r.right_back.setPower(speed+0.15);
            r.right_front.setPower(speed+0.15);

            while (opModeIsActive() && (runtime.seconds() < timeoutS) && (r.left_back.isBusy())&& (r.left_front.isBusy())&& (r.right_back.isBusy()) &&(r.right_front.isBusy())) {

            }

            r.left_back.setPower(0);
            r.left_front.setPower(0);
            r.right_back.setPower(0);
            r.right_front.setPower(0);

            r.left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }*/

    public void FlyRight(double speed, double timeoutS,int cm)
    {
        Flyleft(speed, timeoutS, -cm);
    }

    public void Flyleft(double speed, double timeoutS,int cm) {

        if (opModeIsActive()) {

            int ticks=(int)(cm*17.3611111112);

            r.left_back.setTargetPosition(ticks+r.left_back.getCurrentPosition());
            r.left_front.setTargetPosition(-ticks+r.left_front.getCurrentPosition());
            r.right_back.setTargetPosition(ticks+r.right_back.getCurrentPosition());
            r.right_front.setTargetPosition(-ticks+r.right_front.getCurrentPosition());

            r.left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.left_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            r.right_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            r.left_back.setPower(speed);
            r.left_front.setPower(speed);
            r.right_back.setPower(speed+0.13);
            r.right_front.setPower(speed+0.13);

            while (opModeIsActive() && (runtime.seconds() < timeoutS) && (r.left_back.isBusy())&& (r.left_front.isBusy())&& (r.right_back.isBusy()) &&(r.right_front.isBusy())) {

            }

            r.left_back.setPower(0);
            r.left_front.setPower(0);
            r.right_back.setPower(0);
            r.right_front.setPower(0);

            r.left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            r.right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        }


    }


}
