package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Application implements SensorSystem {
    private Socket socket1, socket2;
    private BufferedReader input1, input2;
    private PrintWriter output1, output2;

    public Application() {
        try {
            //CO2 sensor server
            socket1 = new Socket("localhost", 5000);
            input1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            output1 = new PrintWriter(socket1.getOutputStream(), true);
            output1.println("Sending 1");

            //Temp sensor server
            socket2 = new Socket("localhost", 5001);
            input2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
            output2 = new PrintWriter(socket2.getOutputStream(), true);
            output2.println("Sending 2");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //public static void main(String[] args) throws IOException {
    //    //Socket socket1 = new Socket("localhost", 5000);
    //    //BufferedReader input = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
    //    //PrintWriter output = new PrintWriter(socket1.getOutputStream(), true);
    //    //what the client sends (request)
    //    output.println("Sending");
    //    System.out.println(input.readLine());
    //    System.out.println(input.readLine());
    //
    //    Socket socket2 = new Socket("localhost", 5001);
    //    BufferedReader input2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
    //    PrintWriter output2 = new PrintWriter(socket2.getOutputStream(), true);
    //    //what the client sends (request)
    //    output2.println("Sending");
    //    System.out.println(input2.readLine());
    //    System.out.println(input2.readLine());
    //
    //}

    @Override
    public double getCo2SensorValue() {
        double co2Val = 0.0;
        try {
            co2Val = Double.parseDouble(input1.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return co2Val;
    }

    @Override
    public String getCo2SensorName() {
        String co2name = "";
        try {
            co2name = input1.readLine();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return co2name;
    }

    @Override
    public double getTemperatureSensorValue() {
        Double aDouble = 0.0;
        try {
            aDouble = new Double(input2.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return aDouble;
    }

    @Override
    public String getTemperatureSensorName() {
        String tempVal = "";
        try {
            tempVal = input2.readLine();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return tempVal;
    }

    //Just for testing.
    //public static void main(String[] args) {
    //    Application application = new Application();
    //    //Names: work
    //    //System.out.println(application.getCo2SensorName());
    //    //System.out.println(application.getTemperatureSensorName());
    //
    //    //Values:
    //    System.out.println(application.getCo2SensorValue());
    //    System.out.println(application.getTemperatureSensorValue());
    //
    //
    //}
}