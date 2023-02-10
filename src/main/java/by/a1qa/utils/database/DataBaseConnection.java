package by.a1qa.utils.database;

import by.a1qa.data.TestDataManager;
import by.a1qa.utils.logger.CustomLogger;
import lombok.experimental.UtilityClass;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@UtilityClass
public class DataBaseConnection {

    private static Connection connection;

    public static Connection getConnection() {
        if(connection == null) {
            CustomLogger.info("DataBaseConnection.getConnection() : initializing");
            connection = new Sql2o(TestDataManager.getDataBaseURL(), TestDataManager.getUserName(),
                    TestDataManager.getUserPassword()).open();
        }
        return connection;
    }

    public static void closeConnection() {
        CustomLogger.info("DataBaseConnection.closeConnection()");
        connection.close();
        connection = null;
    }
}
