package by.a1qa.utils;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@UtilityClass
public class RandomRepeatedIntegerUtil {
    private static final String RANGE = "123456789";
    private static final Integer MAX_ITEMS_COUNT = 5;
    private static Random random = new Random();

    private static Integer getRandomRepeatedIntegerValue() {
        StringBuilder result = new StringBuilder();
        result.append(RANGE.charAt(random.nextInt(RANGE.length())));
        result.append(result.charAt(0));
        return Integer.parseInt(result.toString());
    }

    public static List<Integer> getRepeatedValueList() {
        List<Integer> listOfId = new ArrayList<>();
        for (int i = 0; i < MAX_ITEMS_COUNT; i++) {
            Integer value = getRandomRepeatedIntegerValue();
            if(!listOfId.contains(value)) {
                listOfId.add(value);
            }
        }
        return listOfId;
    }
}
