package domain;

public interface SensorSystem {
    //public abstract modifiers implied due to interface
    double getCo2SensorValue();
    String getCo2SensorName();
    double getTemperatureSensorValue();
    String getTemperatureSensorName();

}
