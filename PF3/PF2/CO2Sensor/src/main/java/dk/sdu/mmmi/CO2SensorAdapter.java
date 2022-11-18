package dk.sdu.mmmi;


import dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor;

public class CO2SensorAdapter implements ISensor {


    private final CO2Sensor sensor;

    public CO2SensorAdapter(String sensorName)
    {
        this.sensor = new CO2Sensor(sensorName);
        this.sensor.start();
    }

    @Override
    public String getName() {
        return sensor.getId();
    }

    @Override
    public Double getValue() {
        return sensor.getValue().doubleValue();
    }
}
