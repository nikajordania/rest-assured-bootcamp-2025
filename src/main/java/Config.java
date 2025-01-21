import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
class Config {
    public static String apiKey;
    public static String taskFile;

    public Config() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find config.properties");
            }
            properties.load(input);
            apiKey = properties.getProperty("api.key");
            taskFile = properties.getProperty("task.name");
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties", e);
        }
    }
}
