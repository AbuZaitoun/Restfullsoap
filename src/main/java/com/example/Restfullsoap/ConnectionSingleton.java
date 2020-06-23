package com.example.Restfullsoap;

import com.aerospike.client.AerospikeClient;

public class ConnectionSingleton {
    private static final String host_name = "localhost";
    private static final int port_number = 3000;
    private static AerospikeClient aerospikeClient;

    public static AerospikeClient getAerospikeClient() {
        if (aerospikeClient == null){
            aerospikeClient = new AerospikeClient(host_name, port_number);
        }
        return aerospikeClient;
    }
}
