package Sensor;

import dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor;

public class CO2SensorAdapter implements ISensor{
    private CO2Sensor co2Sensor;
    private String id;

    public CO2SensorAdapter(){
        id = "idk what to do with this";
        co2Sensor = new CO2Sensor(id);
        co2Sensor.start();
    }

    @Override
    public String getName() {
        return "CO2Sensor";
    }

    @Override
    public Double getValue() {
        return Double.valueOf(co2Sensor.getValue());
    }
}
