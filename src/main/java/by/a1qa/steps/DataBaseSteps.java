package by.a1qa.steps;

import by.a1qa.constants.SqlQueries;
import by.a1qa.models.db.AuthorTable;
import by.a1qa.models.db.ProjectTable;
import by.a1qa.models.db.SessionTable;
import by.a1qa.models.db.TestTable;
import by.a1qa.utils.logger.CustomLogger;
import by.a1qa.utils.database.DataBaseUtils;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class DataBaseSteps {

    public static List<TestTable> selectTestTableList() {
        return DataBaseUtils.selectList(SqlQueries.SELECT_ALL_FROM_TEST_ORDER_BY_ID.getQuery(), TestTable.class);
    }

    public static List<AuthorTable> selectAuthorTableList() {
        return DataBaseUtils.selectList(SqlQueries.SELECT_ALL_FROM_AUTHOR_ORDER_BY_ID.getQuery(), AuthorTable.class);
    }

    public static List<ProjectTable> selectProjectTableList() {
        return DataBaseUtils.selectList(SqlQueries.SELECT_ALL_FROM_PROJECT_ORDER_BY_ID.getQuery(), ProjectTable.class);
    }

    public static int createAuthorTable(AuthorTable authorTable) {
        return DataBaseUtils.create(SqlQueries.ADD_NEW_AUTHOR.getQuery(), authorTable);
    }

    public static int createProjectTable(ProjectTable projectTable) {
        return DataBaseUtils.create(SqlQueries.ADD_NEW_PROJECT.getQuery(), projectTable);
    }

    public static int createTestTable(TestTable testTable) {
        return DataBaseUtils.create(SqlQueries.ADD_NEW_TEST.getQuery(), testTable);
    }

    public static int createSessionTable(SessionTable sessionTable) {
        return DataBaseUtils.create(SqlQueries.ADD_NEW_SESSION.getQuery(), sessionTable);
    }

    public static void deleteTestTable(TestTable testTable) {
        DataBaseUtils.delete(SqlQueries.DELETE_TEST_BY_ID.getQuery(), testTable);
    }

    public static AuthorTable getAuthorTableId(AuthorTable authorTable) {
        List<AuthorTable> list = selectAuthorTableList();
        return list
                .stream()
                .filter(element -> element.equals(authorTable))
                .findFirst()
                .orElseGet(() -> {
                    CustomLogger.info("getAuthorTableId: AuthorTable is not created");
                    authorTable.setId(DataBaseSteps.createAuthorTable(authorTable));
                    return authorTable;
                });
    }

    public static ProjectTable getProjectTableId(ProjectTable projectTable) {
        List<ProjectTable> list = selectProjectTableList();
        return list
                .stream()
                .filter(element -> element.equals(projectTable))
                .findFirst()
                .orElseGet(() -> {
                    CustomLogger.info("getProjectTableId: ProjectTable is not created");
                    projectTable.setId(DataBaseSteps.createProjectTable(projectTable));
                    return projectTable;
                });
    }
}
