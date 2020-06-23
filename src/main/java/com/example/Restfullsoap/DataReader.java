package com.example.Restfullsoap;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.Value;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class DataReader {
    private final AerospikeClient client;
    private Key key;
    DataReader(){
        client = ConnectionSingleton.getAerospikeClient();
    }

    public User readUser(int target_id){
        key = new Key("test", "users", target_id);
        Record record = client.get(new Policy(), key);

        User user = new User();
        user.setAge(record.getInt("age"));
        user.setBio(record.getString("bio"));
        user.setName(record.getString("name"));
        user.setId(target_id);

        return user;
    }

    public void closeConnection(){
        client.close();
    }
}
