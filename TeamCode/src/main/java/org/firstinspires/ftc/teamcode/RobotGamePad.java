package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.ThreadPool;

import org.firstinspires.ftc.teamcode.Abstract.SystemBase;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TeleOp(name="Robot main gamepad", group="Linear Opmode")
//@Disabled
public class RobotGamePad extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    private Bootstraper _bootstraper = new Bootstraper(gamepad1, gamepad2);
    private Map<String, SystemBase> _systems;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        _systems = _bootstraper.Init(hardwareMap, telemetry);

        waitForStart();
        runtime.reset();

        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (String systemName : _systems.keySet()) {
//            Thread thread = new Thread(system);
//            thread.start();
            pool.submit(_systems.get(systemName));
//            pool.execute();
        }

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
