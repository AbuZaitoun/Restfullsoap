package com.example.Restfullsoap;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/help")
    public String help(){
        return "This is a toy project, it's built to prove the idea that I understood the concepts " +
                "of multiple technologies, you can send your try to request the link:" +
                " http://localhost:8080/greeting?name=Hadi\n Additionally, you can writing the following command inside the project's directory:" +
                "curl --header \"content-type: text/xml\" -d @request.xml http://localhost:8080/ws";
    }
    @GetMapping("/soap")
    public String soap(){
        String command = "curl --header \"content-type: text/xml\" -d @request.xml http://localhost:8080/ws";
        String url = "http://localhost:8080/ws";

        try {
            URL obj = new URL(url);
            HttpURLConnection conn;
            conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestProperty("Content-Type", "text/xml");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStream wr = new DataOutputStream(conn.getOutputStream());

            BufferedReader br = new BufferedReader(new FileReader(new File("request.xml")));

            //reading file and writing to URL
            System.out.println("Request:-");
            String st;
            while ((st = br.readLine()) != null) {
                System.out.print(st);
                wr.write(st.getBytes());
            }

            //Flush&close the writing to URL.
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;

            StringBuilder response = new StringBuilder();
            while ((output = in.readLine()) != null) {
                response.append(output).append("\n");
            }

            in.close();
            System.out.println("Response:-" + response.toString());
            return response.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // printing result from response
        return "";
    }
}