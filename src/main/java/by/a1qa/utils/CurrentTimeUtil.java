package by.a1qa.utils;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class CurrentTimeUtil {
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.0";

    public static String getCurrentTime() {
        return new SimpleDateFormat(TIME_FORMAT).format(new Date());
    }
}
