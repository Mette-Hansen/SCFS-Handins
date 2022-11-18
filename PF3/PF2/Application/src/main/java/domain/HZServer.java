package domain;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;

public class HZServer {
    private static final String MAP_NAME = "my-service-registry";
    private static final String IP = "127.0.0.1";

    private static void registerService(MultiMap<String, String> map, Service service) {
        String endpoint = String.format("%s:%d", service.getIp(), service.getPort());
        map.put(service.getName(), endpoint);
    }

    public static void main(String[] args) {
        //initialize hazelcast server/instance
        HazelcastInstance hazelcast = Hazelcast.newHazelcastInstance();
        //create a simple map
        MultiMap<String, String> map = hazelcast.getMultiMap(MAP_NAME);
        //map.clear();

        //CO2 and Temp services
        Service serviceCO2 = new Service("co2", IP, 5000);
        Service serviceTemp = new Service("temp", IP, 5001);
        // add key-value to map
        registerService(map, serviceCO2);
        registerService(map, serviceTemp);

        //TEST - Co2 and Temp are keys
        //Collection<String> servicesEndpoints = map.get("co2");
        //System.out.println(servicesEndpoints);

        // Shutdown() is not run --> to let the server run
        //hazelcast.shutdown();
    }
}
