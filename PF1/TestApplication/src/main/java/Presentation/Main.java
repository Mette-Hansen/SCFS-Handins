
package Presentation;

import Domain.Domain;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //TODO Scanner
        /**
         * CO2Sensor s = new CO2Sensor("CO2 Sensor");
         *         TemperatureSensor t = new TemperatureSensor();
         *
         *         s.start();
         *         t.start();
         *
         *         System.out.println(s.getValue());
         *         System.out.println(t.value());
         */

        /**
         * I skal udvikle et Command-Line Interface hvor der kan vælges hvilken sensor man ønsker
         * at have den seneste værdi udskrevet fra.
         */

        Domain domain = new Domain();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select an option: \n 1) See CO2 value \n 2) See Temperature value");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            System.out.println(domain.getCo2SensorName() + " has the value: " + domain.getCo2SensorValue());

        }
        if (input.equals("2")) {
            System.out.println(domain.getTemperatureSensorName() + " has the value: " + domain.getTemperatureSensorValue());

        }
        else {
            System.out.println("---------");
            System.exit(0);
        }


        //System.out.println(domain.getCo2SensorName());
        //System.out.println(domain.getCo2SensorValue());
        //System.out.println(domain.getTemperatureSensorName());
        //System.out.println(domain.getTemperatureSensorValue());
    }
}
