package dk.sdu.mmmi;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class TempPublish {

    public static void main(String[] args) throws InterruptedException {
        ISensor temp = new TemperatureSensorAdapter("Temp");
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        ITopic<Object> topic = hz.getReliableTopic("temp");


        while (true) {
            topic.publish(temp.getValue());
            //topic.publish(temp.getName());
            //getName omitted, but works.
            System.out.println("Written: " + temp.getValue() + "degrees celsius");
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
