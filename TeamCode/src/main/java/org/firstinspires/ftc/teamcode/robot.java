package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class robot {
    public DcMotor left_front;
    public DcMotor left_back;
    public DcMotor right_front;
    public DcMotor right_back;

    public DcMotor pump_left;
    public DcMotor pump_right;

    public DcMotor lift1;
    public DcMotor lift2;

    public Servo round;

    public Servo catchS;

    public Servo hook_left;
    public Servo hook_right;
    public ColorSensor sensorColor;
    public DistanceSensor sensorDistance;

    HardwareMap hwMap;

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        drive_init(hwMap);
        pump_init(hwMap);
        catch_init(hwMap);
        lift_init(hwMap);
        hooks_init(hwMap);
    }

    public void drive_init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        left_back  = hwMap.get(DcMotor.class, "left_back");
        left_front  = hwMap.get(DcMotor.class, "left_front");
        right_back = hwMap.get(DcMotor.class, "right_back");
        right_front = hwMap.get(DcMotor.class, "right_front");

        left_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void pump_init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        pump_right  = hwMap.get(DcMotor.class, "pump_right");
        pump_left = hwMap.get(DcMotor.class, "pump_left");
    }

    public void catch_init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        catchS = hwMap.get(Servo.class, "serveS");
        sensorColor = hwMap.get(ColorSensor.class, "sensor_color_distance");
        sensorDistance = hwMap.get(DistanceSensor.class, "sensor_color_distance");
    }

    public void hooks_init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        hook_left = hwMap.get(Servo.class, "hook_left");
        hook_right = hwMap.get(Servo.class, "hook_right");
    }

    public void lift_init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        round = hwMap.get(Servo.class, "round");
        lift1 = hwMap.get(DcMotor.class, "lift1");
        lift2 = hwMap.get(DcMotor.class, "lift2");

        lift1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}

