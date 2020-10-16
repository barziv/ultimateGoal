package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Abstract.SystemBase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class TestSystem extends SystemBase {
    private Map<String, DcMotor> _systemMotors = new HashMap<String, DcMotor>();
    private Gamepad _gamepad;
    private Telemetry _telemetry;
    private Callable<Boolean> _opModeIsActive;

    public TestSystem(DcMotor motor, Gamepad gamepad, Telemetry telemetry) {
        _systemMotors.put("someMotor", motor);
        _gamepad = gamepad;
        _telemetry = telemetry;
    }

    @Override
    public void run() {
        while (true) {
            if (_gamepad.a) {
                _telemetry.addData("Status", "a is pressed");
                _telemetry.update();
                _systemMotors.get("someMotor").setPower(1);
            }
            else {
                _systemMotors.get("someMotor").setPower(0);
            }
        }
    }
}