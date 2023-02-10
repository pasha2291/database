package by.a1qa.utils;

import by.a1qa.constants.DbTestDataPaths;
import by.a1qa.models.db.TestTable;
import by.a1qa.constants.TestStatus;
import by.a1qa.utils.fileprocessing.JSONCustomParser;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class TestTableUpdateUtil {

    public static void updateTestTable(List<TestTable> testTableList, int authorId, int projectId, String testStartTime) {
        TestTable testTable = JSONCustomParser.getObjectFromJsonResPath(DbTestDataPaths.TEST_FILE_PATH, TestTable.class);
        for (TestTable current : testTableList){
            current.setAuthorId(authorId);
            current.setProjectId(projectId);
            current.setEnv(testTable.getEnv());
            if(current.getStatusId() == TestStatus.PASSED.getId()) {
                current.setStatusId(TestStatus.SKIPPED.getId());
            }
            current.setStartTime(testStartTime);
            current.setEndTime(CurrentTimeUtil.getCurrentTime());
        }
    }
}
