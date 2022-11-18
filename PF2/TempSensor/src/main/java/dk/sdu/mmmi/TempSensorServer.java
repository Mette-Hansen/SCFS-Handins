package dk.sdu.mmmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TempSensorServer {
    public static void main(String[] args) throws IOException {
        ISensor temp = new TemperatureSensorAdapter("temp");

        ServerSocket serverSocket = new ServerSocket(5001);
        Socket client = serverSocket.accept();

        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter output = new PrintWriter(client.getOutputStream(),true);

        while (true) {
            String in = input.readLine();
            System.out.println("Client send: " + in);
            //String out = "Test";
            output.println(temp.getName());
            output.println(temp.getValue());
        }

    }
}