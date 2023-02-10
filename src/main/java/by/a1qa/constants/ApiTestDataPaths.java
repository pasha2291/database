package by.a1qa.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiTestDataPaths {
    private static final String API_TEST_DATA_PATH = "apitestdata/%s";
    public static final String ID_TEST_DATA_PATH = String.format(API_TEST_DATA_PATH, "idData.json");
    public static final String TEST_2_JSON_FILE_PATH = String.format(API_TEST_DATA_PATH, "test2ExpectedResult.json");
    public static final String TEST_5_AND_6_JSON_FILE_PATH = String.format(API_TEST_DATA_PATH, "test5And6ExpectedResult.json");
}
