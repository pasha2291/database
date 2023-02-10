package by.a1qa.constants;

import by.a1qa.utils.fileprocessing.SQLFileReader;

public enum SqlQueries {
    SELECT_ALL_FROM_PROJECT_ORDER_BY_ID("allFromProjectOrderByID.sql"),
    SELECT_ALL_FROM_AUTHOR_ORDER_BY_ID("allFromAuthorOrderByID.sql"),
    SELECT_ALL_FROM_TEST_ORDER_BY_ID("allFromTestOrderByID.sql"),
    ADD_NEW_PROJECT("addNewProject.sql"),
    ADD_NEW_AUTHOR("addNewAuthor.sql"),
    ADD_NEW_SESSION("addNewSession.sql"),
    ADD_NEW_TEST("addNewTest.sql"),
    DELETE_TEST_BY_ID("deleteTestById.sql");

    private static final String SQL_QUERY_PATH = "sqlqueries/%s";
    private final String queryPath;

    SqlQueries(String queryPath) {
        this.queryPath = queryPath;
    }

    public String getQuery() {
        return SQLFileReader.getRequestFromResourcePath(String.format(SQL_QUERY_PATH, queryPath));
    }
}
