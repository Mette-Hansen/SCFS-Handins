package domain;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;
import dk.sdu.mmmi.*;

//TODO
// 1. Brug hazelcast som event broker
// 2.  Client applikation skal abonnere (addMessageListener(Topic)) på det Topic, som bliver publiceret (publish(...)) af Temperature Sensor-  og CO2 Sensor applikationerne.
// 3. Gør brug af ISensor interfacet

/**
 * Title: Reliable Topic
 * Author: JakeSCahill
 * Date: 2021
 * Code version: 4.2
 * Availability: https://docs.hazelcast.com/imdg/4.2/data-structures/reliable-topic
 * <p>
 * Hej Anders, jeg har brugt ovenstående til at udarbejde denne opgave.
 */
public class Application implements SensorSystem {
    private final ISensor co2SensorAdapter;
    private final ISensor temperatureSensorAdapter;


    public Application() {
        this.co2SensorAdapter = new CO2SensorAdapter("CO2 Sensor 1");
        this.temperatureSensorAdapter = new TemperatureSensorAdapter("Temperature Sensor 1");
    }


    public double getCo2SensorValue() {
        return co2SensorAdapter.getValue();
    }

    public String getCo2SensorName() {
        return co2SensorAdapter.getName();
    }

    public double getTemperatureSensorValue() {
        return temperatureSensorAdapter.getValue();
    }

    public String getTemperatureSensorName() {
        return temperatureSensorAdapter.getName();
    }

    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        ITopic<Object> tempTopic = hz.getReliableTopic("temp");
        ITopic<Object> co2Topic = hz.getReliableTopic("co2");
        tempTopic.addMessageListener(new MessageListenerImpl());
        co2Topic.addMessageListener(new MessageListenerImpl());
    }

    private static class MessageListenerImpl implements MessageListener<Object> {
        public void onMessage(Message<Object> m) {
            System.out.println("Received: " + m.getSource() + " has value: "+ m.getMessageObject());
        }
    }

}