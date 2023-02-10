package by.a1qa.utils;

import by.a1qa.utils.logger.CustomLogger;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

@UtilityClass
public class RandomStringUtil {
    private static final int MAX_BODY_LENGTH = 50;
    private static final int MAX_TITLE_LENGTH = 10;
    private static Random random = new Random();

    private static String getRandomString(int maxLength) {
        return RandomStringUtils.random(random.nextInt(maxLength) + 1,
                true, true);
    }

    public static String getRandomBody() {
        String result = getRandomString(MAX_BODY_LENGTH);
        CustomLogger.info(String.format("RandomStringUtil.getRandomBody() : %s", result));
        return result;
    }

    public static String getRandomTitle() {
        String result = getRandomString(MAX_TITLE_LENGTH);
        CustomLogger.info(String.format("RandomStringUtil.getRandomTitle() : %s", result));
        return result;
    }
}
