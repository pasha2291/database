package by.a1qa.steps;

import by.a1qa.constants.Parameters;
import by.a1qa.utils.fileprocessing.FileFullPath;
import by.a1qa.utils.logger.CustomLogger;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.util.List;

@UtilityClass
public class ResponseSteps {

    public static <T> T getObject(Response response, Class<T> tClass) {
        CustomLogger.info(String.format("ResponseSteps.getObject() : %s", tClass));
        return response.as(tClass);
    }

    public static <T> List<T> getList(Response response, Class<T> tClass) {
        CustomLogger.info(String.format("ResponseSteps.getList() : %s", tClass));
        return response
                .body()
                .jsonPath()
                .getList(Parameters.POINT, tClass);
    }

    public static void checkStatusCode(Response response, int statusCode) {
        CustomLogger.info(String.format("ResponseSteps.checkStatusCode() : %d", statusCode));
        response.then().statusCode(statusCode);
    }

    public static void checkResponseIsJson(Response response, String schemaPath) {
        schemaPath = FileFullPath.getFileFullPath(schemaPath);
        CustomLogger.info(String.format("ResponseSteps.checkResponseIsJson() : %s", schemaPath));
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
    }
}
