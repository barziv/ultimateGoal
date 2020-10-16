package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Function;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Abstract.SystemBase;
import org.firstinspires.ftc.teamcode.Systems.Systems;
import org.firstinspires.ftc.teamcode.Systems.TestSystem;
import org.firstinspires.ftc.teamcode.Systems.TestSystem2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class Bootstraper {
    private HardwareMap _robotHardware;
    private Gamepad _gamepad1;
    private Gamepad _gamepad2;

    public Bootstraper() { }

    public Map<Systems, SystemBase> Init(Gamepad gamepad1, Gamepad gamepad2, HardwareMap robotHardware, Telemetry telemetry) {
        _robotHardware = robotHardware;
        _gamepad1 = gamepad1;
        _gamepad2 = gamepad2;
        Map<Systems, SystemBase> systems = new HashMap<Systems, SystemBase>();

        systems.put(Systems.DRIVE, CreateTestSystem(telemetry));
        systems.put(Systems.TEST_SYSTEM, CreateTestSystem2());
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