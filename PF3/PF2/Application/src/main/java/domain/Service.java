package domain;

public class Service {
    private String name, ip;
    private int port;

    public Service(String name, String ip, int port) {
        this.name = name;
        this.port = port;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}
