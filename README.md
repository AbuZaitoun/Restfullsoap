# Restfullsoap
A small toy project that supports both SOAP and REST using Spring boot

To run the project, build gradle with the following command: 
./gradlew bootRun

The program has two web services, one built with SOAP (Simple Object Access Protocol), and one built with REST (Representational State Transfer)
To try REST, kindly request the following url: 
http://localhost:8080/help
As for SOAP, send request.xml file using this command: 
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws

Features are simple, they're just a proof of concept.  

Added one more REST call, requesting http://localhost:8080/soap now makes a soap request and prints the response.
