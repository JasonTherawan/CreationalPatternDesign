package creationalPattern;

// Singleton Pattern
public class ConfigManager {
    private static final ConfigManager INSTANCE = new ConfigManager();
    private ConfigManager() {} // Private constructor
    public static ConfigManager getInstance() {
        return INSTANCE;
    }
}
