/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

/**
 *
 * @author Anders
 */
public interface ISensor {
    public String getName();
    public Double getValue();
}
/**
 * I skal implementere 2 Adapter-klasser som implementerer
 * ISensor-interfacet og eksponerer værdierne fra hhv. CO2Sensor og TemperatureSensor.
 * Det skal i gøre, uden at ændre i implementeringen af klasserne CO2Sensor og TemperatureSensor.
 * Dette simulerer situationen, hvor i er afhængig af en implementering, nogle andre har lavet.
 * Jeres Adapter-klasser skal i placere i Sensor-laget. Det betyder også at i gerne må (og bør) ændre pakken på ISensor-interfacet.
 * I kan finde hjælp til anvendelsen af sensorerne i Test klassen.
 */
