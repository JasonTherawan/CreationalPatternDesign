package creationalPattern;

import model.ServerConfig;

// Abstract Factory Pattern
public class HttpServiceFactory implements ServiceFactory {
    @Override
    public ServerConfig createConfig() {
        return new ServerConfig("HTTP", 8080, "localhost", 100);
    }
}
