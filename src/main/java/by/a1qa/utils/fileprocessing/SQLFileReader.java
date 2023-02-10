package by.a1qa.utils.fileprocessing;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.FileReader;

@UtilityClass
public class SQLFileReader {

    @SneakyThrows
    public static String getRequestFromResourcePath(String path) {
        path = FileFullPath.getFileFullPath(path);
        return new BufferedReader(new FileReader(path)).readLine();
    }
}
