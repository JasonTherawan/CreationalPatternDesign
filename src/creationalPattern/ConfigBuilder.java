package creationalPattern;

import model.ServerConfig;

// Builder Pattern
public class ConfigBuilder {
    private String protocol = "HTTP";
    private int port = 80;
    private String host = "default";
    private int maxConnections = 10;

    public ConfigBuilder setProtocol(String protocol) { this.protocol = protocol; return this; }
    public ConfigBuilder setPort(int port) { this.port = port; return this; }
    public ConfigBuilder setHost(String host) { this.host = host; return this; }
    public ConfigBuilder setMaxConnections(int max) { this.maxConnections = max; return this; }

    public ServerConfig build() {
        return new ServerConfig(protocol, port, host, maxConnections);
    }
}
