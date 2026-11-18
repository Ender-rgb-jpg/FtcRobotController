package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;

@Autonomous
@Disabled
public class RightAutoWallShoot2 extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    ElapsedTime time = new ElapsedTime();
    boolean startCounting = true;

    @Override
    public void init() {
        drive.init(hardwareMap);

    }

    @Override
    public void loop() {
        while (startCounting) {
            time.reset();
            startCounting = false;
        }
        if (time.seconds() >= 3 && time.seconds() < 4.5) {
            drive.drive(-.68, 0);
        }
    }
}






