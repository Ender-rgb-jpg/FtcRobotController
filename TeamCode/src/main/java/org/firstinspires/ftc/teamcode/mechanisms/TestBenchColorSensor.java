package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TestBenchColorSensor {

    NormalizedColorSensor colorSensor;

    public enum DetectedColor {
        GREEN,
        PURPLE,
        YELLOW,
        RED,
        BLUE,
        UNKNOWN



    }
    public void init(HardwareMap hwMap) {
        colorSensor = hwMap.get(NormalizedColorSensor.class, "sensor_color_distance");
        colorSensor.setGain(10);
    }

    public DetectedColor getDetectedColor(Telemetry telemetry) {
        NormalizedRGBA colors = colorSensor.getNormalizedColors();

        float normRed, normGreen, normBlue;
        normRed = colors.red / colors.alpha;
        normGreen = colors.green / colors.alpha;
        normBlue = colors.blue / colors.alpha;

        telemetry.addData("red", normRed);
        telemetry.addData("green", normGreen);
        telemetry.addData("blue", normBlue);


        if(normRed > .1 && normGreen < .08 && normBlue < .06) {
            return DetectedColor.RED;
        } else if (normRed < .04 && normGreen < .07 && normBlue > .13) {
            return DetectedColor.BLUE;
        } else if (normRed < .07 && normGreen > .29 && normBlue < .21) {
            return DetectedColor.GREEN;
        } else if (normRed > .01 && normGreen > .01 && normBlue < .19) {
            return DetectedColor.PURPLE;
        } else if (normRed > .17 && normGreen < .22 && normBlue > .06) {
            return DetectedColor.YELLOW;
        }
        else {
            return DetectedColor.UNKNOWN;
        }
        /*
              red green blue
        RED = .1, .08, .06
        BLUE = .04, .07, .13
        GREEN = .07, .29, .21
        PURPLE = .01, .01, .19
        YELLOW = .17, .22, .06
         */
    }
}

