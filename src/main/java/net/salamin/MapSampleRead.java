package net.salamin;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Map;

public class MapSampleRead {
    public static void main(String[] args) {

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("hello-world");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);


        IMap <String,String> map = client.getMap("my-distributed-map");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        client.shutdown();
    }
}