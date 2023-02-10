package by.a1qa.models.db;

import lombok.Data;

import java.util.Objects;

@Data
public class TestTable extends BaseDataBaseModel {
    private String name;
    private int statusId;
    private String methodName;
    private int projectId;
    private int sessionId;
    private String startTime;
    private String endTime;
    private String env;
    private String browser;
    private int authorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestTable testTable = (TestTable) o;
        return getStatusId() == testTable.getStatusId() && getProjectId() == testTable.getProjectId()
                && getSessionId() == testTable.getSessionId() && getAuthorId() == testTable.getAuthorId()
                && Objects.equals(getName(), testTable.getName()) && Objects.equals(getMethodName(), testTable.getMethodName())
                && Objects.equals(getStartTime(), testTable.getStartTime()) && Objects.equals(getEndTime(), testTable.getEndTime())
                && Objects.equals(getEnv(), testTable.getEnv()) && Objects.equals(getBrowser(), testTable.getBrowser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStatusId(), getMethodName(), getProjectId(), getSessionId(),
                getStartTime(), getEndTime(), getEnv(), getBrowser(), getAuthorId());
    }
}
