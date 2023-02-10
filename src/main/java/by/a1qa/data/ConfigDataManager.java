package by.a1qa.data;

import by.a1qa.utils.fileprocessing.JSONCustomParser;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigDataManager {

    private static final String BASE_URL = "baseUrl";
    private static final String CONFIG_FILE = "config.json";

    public static String getBaseURL() {
        return JSONCustomParser.getElementByNameFromResPath(CONFIG_FILE, BASE_URL);
    }
}
