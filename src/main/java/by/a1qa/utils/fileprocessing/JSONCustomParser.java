package by.a1qa.utils.fileprocessing;

import by.a1qa.utils.logger.CustomLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

@UtilityClass
public class JSONCustomParser {
    private static JSONParser parser = new JSONParser();
    private static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static String getElementByNameFromResPath(String path, String elementName) {
        CustomLogger.info(String.format("JSONCustomParser.parseElementByName() : %s : %s", path, elementName));
        path = FileFullPath.getFileFullPath(path);
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
        return (String) jsonObject.get(elementName);
    }

    @SneakyThrows
    public static <T> T getObjectFromJsonResPath(String path, Class<T> tClass) {
        CustomLogger.info(String.format("JSONCustomParser.getObjectFromJSON() : %s : %s", path, tClass));
        path = FileFullPath.getFileFullPath(path);
        return objectMapper.readValue(new File(path), tClass);
    }
}
