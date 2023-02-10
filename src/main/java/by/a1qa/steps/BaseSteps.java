package by.a1qa.steps;

import by.a1qa.data.ConfigDataManager;
import by.a1qa.utils.logger.CustomFilter;
import by.a1qa.utils.logger.CustomLogger;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseSteps {

    protected static RequestSpecification baseRequest() {
        final String BASE_URL = ConfigDataManager.getBaseURL();
        CustomLogger.info(String.format("BaseSteps.baseRequest() : %s", BASE_URL));
        return given()
                .filter(new CustomFilter())
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }
}
