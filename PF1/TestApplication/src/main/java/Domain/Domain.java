package Domain;

import Sensor.CO2SensorAdapter;
import Sensor.ISensor;
import Sensor.TemperatureSensorAdapter;

public class Domain {

    /**
     * Domain-laget skal indeholde klasse(r) der kan håndtere kald fra bruger-interfacet,
     * kalder metoder på instanser af jeres Adapter-klasser for at returnere den nuværende værdi for sensorerne,
     * når der bliver bedt om det fra brugerinterfacet.
     */
    private ISensor co2SensorAdapter;
    private ISensor temperatureSensorAdapter;

    public Domain() {
        co2SensorAdapter = new CO2SensorAdapter();
        temperatureSensorAdapter = new TemperatureSensorAdapter();
    }

    public String getCo2SensorName() {
        return co2SensorAdapter.getName();
    }

    public Double getCo2SensorValue() {
        return co2SensorAdapter.getValue();
    }

    public String getTemperatureSensorName(){
        return temperatureSensorAdapter.getName();
    }

    public Double getTemperatureSensorValue(){
        return temperatureSensorAdapter.getValue();
    }
}
