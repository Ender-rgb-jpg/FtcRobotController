package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBenchColorSensor;
@Disabled
@TeleOp
public class ColorSensor extends OpMode {
    TestBenchColorSensor bench = new TestBenchColorSensor();
    TestBenchColorSensor.DetectedColor detectedColor;

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
       detectedColor = bench.getDetectedColor(telemetry);
       telemetry.addData("color detected", detectedColor);
    }
}
