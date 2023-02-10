package by.a1qa.database.tests;

import by.a1qa.constants.DbTestDataPaths;
import by.a1qa.models.db.ProjectTable;
import by.a1qa.steps.DataBaseSteps;
import by.a1qa.utils.database.DataBaseConnection;
import by.a1qa.models.db.AuthorTable;
import by.a1qa.models.db.SessionTable;
import by.a1qa.models.db.TestTable;
import by.a1qa.utils.CurrentTimeUtil;
import by.a1qa.utils.fileprocessing.JSONCustomParser;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest {
    private AuthorTable authorTable;
    private ProjectTable projectTable;
    private SessionTable sessionTable;
    private TestTable testTable;

    @BeforeClass
    public void beforeClass() {
        DataBaseConnection.getConnection();
        authorTable = JSONCustomParser.getObjectFromJsonResPath(DbTestDataPaths.AUTHOR_FILE_PATH, AuthorTable.class);
        projectTable = JSONCustomParser.getObjectFromJsonResPath(DbTestDataPaths.PROJECT_FILE_PATH, ProjectTable.class);
        authorTable = DataBaseSteps.getAuthorTableId(authorTable);
        projectTable = DataBaseSteps.getProjectTableId(projectTable);
        sessionTable = JSONCustomParser.getObjectFromJsonResPath(DbTestDataPaths.SESSION_FILE_PATH, SessionTable.class);
        sessionTable.setCreatedTime(CurrentTimeUtil.getCurrentTime());
        sessionTable.setSessionKey(CurrentTimeUtil.getCurrentTime());
        sessionTable.setId(DataBaseSteps.createSessionTable(sessionTable));
    }

    @AfterClass
    public void afterClass() {
        DataBaseConnection.closeConnection();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        ITestResult result = Reporter.getCurrentTestResult();
        testTable = JSONCustomParser.getObjectFromJsonResPath(DbTestDataPaths.TEST_FILE_PATH, TestTable.class);
        testTable.setName(result.getInstanceName());
        testTable.setMethodName(method.getName());
        testTable.setProjectId(projectTable.getId());
        testTable.setSessionId(sessionTable.getId());
        testTable.setStartTime(CurrentTimeUtil.getCurrentTime());
        testTable.setAuthorId(authorTable.getId());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        testTable.setEndTime(CurrentTimeUtil.getCurrentTime());
        testTable.setStatusId(result.getStatus());
        DataBaseSteps.createTestTable(testTable);
    }
}
