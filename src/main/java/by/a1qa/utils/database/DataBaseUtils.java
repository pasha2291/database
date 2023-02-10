package by.a1qa.utils.database;

import by.a1qa.models.db.BaseDataBaseModel;
import lombok.experimental.UtilityClass;
import org.sql2o.Connection;

import java.math.BigInteger;
import java.util.List;

@UtilityClass
public class DataBaseUtils {

    private static final String ID = "id";
    private static Connection connection = DataBaseConnection.getConnection();

    public static <T extends BaseDataBaseModel> List<T> selectList(String request, Class<T> tClass) {
        return connection.createQuery(request).setAutoDeriveColumnNames(Boolean.TRUE).executeAndFetch(tClass);
    }

    public static <T extends BaseDataBaseModel> int create(String request, T tModel) {
        BigInteger bigInteger = (BigInteger)connection.createQuery(request).bind(tModel).executeUpdate().getKey();
        return bigInteger.intValue();
    }

    public static <T extends BaseDataBaseModel> void delete(String request, T tModel) {
        connection.createQuery(request).addParameter(ID, tModel.getId()).executeUpdate();
    }
}
