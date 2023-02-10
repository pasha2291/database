package by.a1qa.database.tests;

import by.a1qa.constants.DbTestDataPaths;
import by.a1qa.models.db.AuthorTable;
import by.a1qa.models.db.ProjectTable;
import by.a1qa.steps.DataBaseSteps;
import by.a1qa.utils.database.DataBaseConnection;
import by.a1qa.models.db.TestTable;
import by.a1qa.utils.fileprocessing.JSONCustomParser;
import by.a1qa.utils.logger.CustomLogger;
import by.a1qa.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ProcessingOfTestDataTest {

    @Test
    public void runTest() {
        CustomLogger.info("Start of processing of tests data tests");
        String startTime = CurrentTimeUtil.getCurrentTime();

        AuthorTable currentAuthorTable = JSONCustomParser.getObjectFromJsonResPath(DbTestDataPaths.AUTHOR_FILE_PATH, AuthorTable.class);
        ProjectTable currentProjectTable = JSONCustomParser.getObjectFromJsonResPath(DbTestDataPaths.PROJECT_FILE_PATH, ProjectTable.class);

        List<Integer> listOfId = RandomRepeatedIntegerUtil.getRepeatedValueList();
        List<TestTable> testById = DataBaseSteps.selectTestTableList()
                .stream()
                .filter(test -> listOfId.contains(test.getId()))
                .collect(Collectors.toList());

        currentAuthorTable = DataBaseSteps.getAuthorTableId(currentAuthorTable);
        currentProjectTable = DataBaseSteps.getProjectTableId(currentProjectTable);

        TestTableUpdateUtil.updateTestTable(testById, currentAuthorTable.getId(), currentProjectTable.getId(), startTime);

        testById
                .stream()
                .forEach(testTable -> testTable.setId(DataBaseSteps.createTestTable(testTable)));

        CustomLogger.info("Assert that the database is updated with new records");
        List<TestTable> actualTableList = DataBaseSteps.selectTestTableList();
        Assert.assertTrue(actualTableList.containsAll(testById), "The database should be updated with new records!");

        testById
                .stream()
                .forEach(DataBaseSteps::deleteTestTable);

        actualTableList = DataBaseSteps.selectTestTableList();

        CustomLogger.info("Assert that the new records were deleted from the database");
        Assert.assertFalse(ListUtil.isFirstListContainAnyElementFromSecond(actualTableList, testById),
                "New records should be deleted from the database");

        DataBaseConnection.closeConnection();
        CustomLogger.info("End of processing of tests data tests");
    }
}
