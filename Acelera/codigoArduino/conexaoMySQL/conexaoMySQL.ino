#include <Ethernet.h>
#include <SPI.h>

#define portaHTTP 80

byte mac[] = { 0x00, 0xAA, 0xBB, 0xCC, 0xDE, 0x02};
//Conexão com o Servidor Apache Local
byte servidor[] = {192,168,0,166}; //IP do meu computador

EthernetClient clienteArduino;

float sensor1 = 1;
float sensor2 = 3;
float sensor3 = 5;

/*
  Inserir aqui os sensores que vai mandar dados pro SQL.
*/

void setup() 
{
  //Conectando Ethernet Shield na rede wifi e atribuindo um endereço ip ao mesmo
  Serial.begin(9600);
  Ethernet.begin(mac);

  if(Ethernet.begin(mac) == 0)
  {
    Serial.println("Falha ao conectar-se com a rede...");
    Ethernet.begin(mac);  
  }
  
  Serial.print("Conectado a rede, no ip: ");
  Serial.println(Ethernet.localIP());
}

void loop() 
{
  /*if(clienteArduino.available())
  {
    char dadosRetornados = clienteArduino.read();
    Serial.print(dadosRetornados);
  }
  if(!clienteArduino.connected())
  {
    clienteArduino.stop();
  }
  
  char comando = Serial.read();

  if(comando == '1')
  { */
      sensor1++;
      sensor2++;
      sensor3++;    

       Serial.println("Conectando ao servidor e enviando dados para o MySQL: ");
       
       Serial.print("Sensor1: ");
       Serial.println(sensor1);
       
       Serial.print("Sensor2: ");
       Serial.println(sensor2);
       
       Serial.print("Sensor3: ");
       Serial.println(sensor3);
  
      if(clienteArduino.connect(servidor, portaHTTP))
      {
        //clienteArduino.println("GET /arduinoSQL/enviar.php HTTP/1.0");
        clienteArduino.print("GET /arduinoSQL/insert.php");
        
        clienteArduino.print("?s1=");
        clienteArduino.print(sensor1);
        clienteArduino.print("&s2=");
        clienteArduino.print(sensor2);
        clienteArduino.print("&s3=");
        clienteArduino.print(sensor3);
        
        clienteArduino.println(" HTTP/1.0");
        
        clienteArduino.println("Host: 192.168.0.166");
        clienteArduino.println("Connection: close");
        clienteArduino.println();
        clienteArduino.stop();
      }
      else
      {
        Serial.println("Falha na conexão com o servidor");
        clienteArduino.stop();
      }
  //}

    delay(5000);
}
