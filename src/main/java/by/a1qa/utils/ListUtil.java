package by.a1qa.utils;

import by.a1qa.utils.logger.CustomLogger;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ListUtil {

    public static <T> boolean isFirstListContainAnyElementFromSecond(List<T> first, List<T> second) {
        boolean result = false;
        for(T current : second) {
            if(first.contains(current)) {
                result = true;
            }
        }
        CustomLogger.info(String.format("ListUtil.isFirstListContainAnyElementFromSecond() : %s", result));
        return result;
    }
}
