package creationalPattern;

import model.ServerConfig;

// Factory Pattern
public class ConfigFactory {
    public static ServerConfig createConfig(String type) {
        if ("HTTP".equalsIgnoreCase(type)) {
            return new ServerConfig("HTTP", 8080, "localhost", 100);
        } else if ("FTP".equalsIgnoreCase(type)) {
            return new ServerConfig("FTP", 21, "localhost", 50);
        }
        return null;
    }
}
