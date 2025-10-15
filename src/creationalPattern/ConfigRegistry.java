package creationalPattern;

import model.ServerConfig;

// Prototype Pattern
public class ConfigRegistry {
    private java.util.Map<String, ServerConfig> prototypes = new java.util.HashMap<>();

    public ConfigRegistry() {
        // Pre-load prototypes
        prototypes.put("DEFAULT_HTTP", new ServerConfig("HTTP", 80, "default", 10));
    }

    public ServerConfig createByClone(String key) throws CloneNotSupportedException {
        return (ServerConfig) prototypes.get(key).clone();
    }
}
