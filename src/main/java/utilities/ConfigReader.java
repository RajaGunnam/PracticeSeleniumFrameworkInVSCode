package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream inputStream = new FileInputStream("C:\\Users\\RAJA\\IdeaProjects\\SelAutFramework\\src\\test\\resources\\config.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to a Configuration File", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
