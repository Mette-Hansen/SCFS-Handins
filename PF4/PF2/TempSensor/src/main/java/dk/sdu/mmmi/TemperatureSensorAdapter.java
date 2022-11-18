package dk.sdu.mmmi;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor;

//TODO
// 1. Client applikation skal abonnere (addMessageListener(Topic)) på det Topic, som bliver publiceret (publish(...)) af Temperature Sensor-  og CO2 Sensor applikationerne.
// 2. Det vil altså sige, at Temperature Sensor-  og CO2 Sensor applikationerne er ansvarlig for at publicere sensorværdier på dette topic.
// 3. Det er op til jer at afgøre hvilket interval det skal ske med
/*https://docs.hazelcast.com/imdg/4.2/data-structures/topic*/
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
