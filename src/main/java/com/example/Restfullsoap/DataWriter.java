package com.example.Restfullsoap;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;

public class DataWriter {

    private final AerospikeClient client;

    DataWriter(){
        client = ConnectionSingleton.getAerospikeClient();
    }
    public void writeUser(User user){

        Key key = null;

        key = new Key("test", "users", user.getId());
        Bin name_bin = new Bin("name", user.getName());
        Bin age_bin = new Bin("age", user.getAge());
        Bin bio_bin = new Bin("bio", user.getBio());

        client.put(new WritePolicy(), key, name_bin, age_bin, bio_bin);
    }

    public void closeConnection(){
        client.close();
    }

}
