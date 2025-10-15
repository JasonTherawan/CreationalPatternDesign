package model;

public class ServerConfig {
    private String protocol;
    private int port;
    private String host;
    private int maxConnections;

    public ServerConfig(String protocol, int port, String host, int maxConnections) {
        this.protocol = protocol;
        this.port = port;
        this.host = host;
        this.maxConnections = maxConnections;
    }
    
    // For Prototype
    public ServerConfig(ServerConfig other) {
         this.protocol = other.protocol;
         this.port = other.port;
         this.host = other.host;
         this.maxConnections = other.maxConnections;
    }

    @Override
	public Object clone() throws CloneNotSupportedException {
        return new ServerConfig(this);
    }
}
