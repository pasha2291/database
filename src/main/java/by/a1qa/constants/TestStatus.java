package by.a1qa.constants;

import lombok.Getter;

@Getter
public enum TestStatus {
    PASSED(1), FAILED(2), SKIPPED(3);

    private final int id;

    TestStatus(int id) {
        this.id = id;
    }
}
