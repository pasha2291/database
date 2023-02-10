package by.a1qa.data;

import by.a1qa.constants.DbTestDataPaths;
import by.a1qa.utils.fileprocessing.JSONCustomParser;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataManager {

    private static final String URL = "url";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";

    public static String getDataBaseURL() {
        return JSONCustomParser.getElementByNameFromResPath(DbTestDataPaths.DATA_BASE_CREDENTIALS_FILE_PATH, URL);
    }

    public static String getUserName() {
        return JSONCustomParser.getElementByNameFromResPath(DbTestDataPaths.DATA_BASE_CREDENTIALS_FILE_PATH, USER_NAME);
    }

    public static String getUserPassword() {
        return JSONCustomParser.getElementByNameFromResPath(DbTestDataPaths.DATA_BASE_CREDENTIALS_FILE_PATH, PASSWORD);
    }
}
