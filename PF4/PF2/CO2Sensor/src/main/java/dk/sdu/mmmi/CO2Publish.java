package dk.sdu.mmmi;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class CO2Publish {
    public static void main(String[] args) throws InterruptedException {
        ISensor co2 = new CO2SensorAdapter("CO2");
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        ITopic<Object> topic = hz.getReliableTopic("co2");


        while (true) {
            topic.publish(co2.getValue());
            //topic.publish(co2.getName());
            //getName omitted, but works.
            System.out.println("Written: " + co2.getValue() + "PPM");
            sleepMillis(500);
        }

    }

    public static boolean sleepMillis(int millis) {
        try {
            MILLISECONDS.sleep(millis);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
        return true;
    }
}
