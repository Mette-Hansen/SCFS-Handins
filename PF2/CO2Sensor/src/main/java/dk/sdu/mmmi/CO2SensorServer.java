package dk.sdu.mmmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CO2SensorServer {
    public static void main(String[] args) throws IOException {
        ISensor co2 = new CO2SensorAdapter("co2");

        System.out.println(co2.getValue());
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket client = serverSocket.accept();

        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter output = new PrintWriter(client.getOutputStream(),true);

        while (true) {
            String in = input.readLine();
            System.out.println("Client send: " + in);
            //String out = "Test";
            output.println(co2.getName());
            output.println(co2.getValue());
        }

    }
}