//------------------- ex2b -------------------
/*-----( Import needed libraries )-----*/
#include <SPI.h>
#include <Ethernet.h>

// Enter a MAC address and IP address for your controller below.
// The IP address will be dependent on your local network:
byte mac[] = {
  0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };

/*-----( Declare objects )-----*/
IPAddress arduinoIp(192,168,???, ???);
IPAddress gateway(192, 168, ???, ???);
IPAddress subnet(255, 255, 255, 0);
IPAddress serverIp(204, 77, 50, 53);
int serverPort = 80;
char pageName[] = "/propertymonitor/api/sensorreadings";
EthernetClient client;
// Declare http Post request data
char json[41];  // Must be large enough to hold entire JSON payload
#define SENSORID ???
//--------------------------------------------

#define trigPin 6
#define echoPin 5
// ...

void setup() 
{
  // ...

  //------------------- ex2b -------------------
  // start the Ethernet connection and the server:
  if (Ethernet.begin(mac) == 0) Ethernet.begin(mac, arduinoIp, gateway, subnet);
  delay(1000);
  //--------------------------------------------
}

void loop() 
{
  //------------------- ex2b -------------------
  Ethernet.maintain();
  //--------------------------------------------
  
  // ...
    sprintf(json, "{'SensorId':%d,'Value':%d}", SENSORID, avgDistance); // Cast currTempReading to int
    Serial.println(json);
    postPage(json);
  // ...
}

//...

//------------------- ex2b -------------------
// --------------------------------- postPage()  ---------------------------------
// ---------------------- Performs http Post of json payload ---------------------
byte postPage(char* json)
{
  int inChar;
  Serial.println("postPage() connecting...");

  if (client.connect(serverIp, serverPort)) {
    Serial.println("postPage() connected");

    // send http header
//    client.println("POST /propertymonitor/api/sensorreadings HTTP/1.1");
    client.print("POST ");
    client.print(pageName);
    client.println(" HTTP/1.1");
    client.println("Host: 192.168.???.???"); // or generate from your server variable to not hardwire
    client.println("User-Agent: Arduino/uno ethernet");
    client.println("Connection: close");
    client.println("Content-Type: application/json");
    client.print("Content-Length: ");
    client.println(strlen(json));// number of bytes in the payload
    client.println();// important: need an empty line here
    // send payload
    client.println(json);
  }
  else
  {
    Serial.println(F("postPage() connect failed"));
    return 0;
  }

  int connectLoop = 0;

  while(client.connected())
  {
    while(client.available())
    {
      inChar = client.read();
//      Serial.write(inChar);
      connectLoop = 0;
    }

    delay(1);
    connectLoop++;
    if(connectLoop > 10000)
    {
      Serial.println();
      Serial.println(F("Timeout"));
      client.stop();
    }
  }

  Serial.println(F("disconnecting."));
  Serial.println();
  
  client.stop();
  return 1;
}
  //--------------------------------------------
