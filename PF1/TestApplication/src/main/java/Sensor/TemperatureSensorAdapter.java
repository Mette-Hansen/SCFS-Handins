package Sensor;

import dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor;

public class TemperatureSensorAdapter implements ISensor{
    private TemperatureSensor t;

    public TemperatureSensorAdapter(){
        t = new TemperatureSensor();
        t.start();
    }

    @Override
    public String getName() {
        return "TemperatureSensor";
    }

    @Override
    public Double getValue() {
        return (Double) t.value();
    }
}
