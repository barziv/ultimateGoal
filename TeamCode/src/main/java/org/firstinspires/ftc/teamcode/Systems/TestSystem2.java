package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Abstract.SystemBase;

import java.util.HashMap;
import java.util.Map;

public class TestSystem2 extends SystemBase {
    private Map<String, DcMotor> _systemMotors = new HashMap<String, DcMotor>();
    private Gamepad _gamepad;

    public TestSystem2(DcMotor motor, Gamepad gamepad) {
        _systemMotors.put("someMotor", motor);
        _gamepad = gamepad;
    }

    @Override
    public void run() {
        while (true) {
            if (_gamepad.b) {
                _systemMotors.get("someMotor").setPower(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}