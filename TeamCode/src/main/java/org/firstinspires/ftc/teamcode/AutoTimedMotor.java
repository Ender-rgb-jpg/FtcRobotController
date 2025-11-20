package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanisms.TestBench;
import org.firstinspires.ftc.teamcode.mechanisms.TestBenchServo;

@Autonomous
public class AutoTimedMotor extends OpMode {
    TestBenchServo bench = new TestBenchServo();
    MecanumDrive drive = new MecanumDrive();
    ElapsedTime time = new ElapsedTime();
    boolean startCounting = true;

    @Override
    public void init() {
        bench.init(hardwareMap);
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        while (startCounting) {
            time.reset();
            startCounting = false;
        }
        if (time.seconds() >= 5 && time.seconds() < 7) {
            drive.drive(-.1, 0, 0);
        } else {
            drive.stop();
        }
    }
}
