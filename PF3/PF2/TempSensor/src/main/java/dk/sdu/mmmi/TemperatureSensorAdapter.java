package dk.sdu.mmmi;

import dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor;

public class TemperatureSensorAdapter implements ISensor {


    private final TemperatureSensor sensor;
    private final String name;

    public TemperatureSensorAdapter(String sensorName)
    {
        this.name = sensorName;
        this.sensor = new TemperatureSensor();
        this.sensor.start();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getValue() {
        return Double.parseDouble(sensor.value().toString());
    }
}
