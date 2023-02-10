package by.a1qa.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DbTestDataPaths {
    private static final String DB_TEST_DATA_PATH = "dbtestdata/%s";
    public static final String DATA_BASE_CREDENTIALS_FILE_PATH = String.format(DB_TEST_DATA_PATH, "credentials.json");
    public static final String AUTHOR_FILE_PATH = String.format(DB_TEST_DATA_PATH, "author.json");
    public static final String PROJECT_FILE_PATH = String.format(DB_TEST_DATA_PATH, "project.json");
    public static final String SESSION_FILE_PATH = String.format(DB_TEST_DATA_PATH, "session.json");
    public static final String TEST_FILE_PATH = String.format(DB_TEST_DATA_PATH, "test.json");
}
