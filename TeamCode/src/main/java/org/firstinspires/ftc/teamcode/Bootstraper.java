package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Abstract.SystemBase;
import org.firstinspires.ftc.teamcode.Systems.TestSystem;
import org.firstinspires.ftc.teamcode.Systems.TestSystem2;

import java.util.HashMap;
import java.util.Map;

public class Bootstraper {
    private HardwareMap _robotHardware;
    private Gamepad _gamepad1;
    private Gamepad _gamepad2;

    public Bootstraper(Gamepad gamepad1, Gamepad gamepad2) {
        _gamepad1 = gamepad1;
        _gamepad2 = gamepad2;
    }

    public Map<String, SystemBase> Init(HardwareMap robotHardware, Telemetry telemetry) {
        _robotHardware = robotHardware;
        Map<String, SystemBase> systems = new HashMap<String, SystemBase>();
        systems.put("testSystem", CreateTestSystem(telemetry));
        systems.put("testSystem2", CreateTestSystem2());
        return systems;
    }

    private SystemBase CreateTestSystem(Telemetry telemetry) {
        DcMotor Motor;
        Motor = _robotHardware.get(DcMotor.class, "Motor1");
        return new TestSystem(Motor, _gamepad1, telemetry);
    }

    private SystemBase CreateTestSystem2() {
        DcMotor Motor;
        Motor = _robotHardware.get(DcMotor.class, "Motor2");
        return new TestSystem2(Motor, _gamepad1);
    }
}