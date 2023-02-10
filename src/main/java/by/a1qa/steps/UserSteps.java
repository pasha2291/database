package by.a1qa.steps;

import by.a1qa.constants.Parameters;
import by.a1qa.constants.Endpoints;
import by.a1qa.utils.logger.CustomLogger;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserSteps extends BaseSteps{

    public static Response getAllUsers() {
        CustomLogger.info("UserSteps.getAllUsers()");
        return baseRequest().get(Endpoints.ALL_USERS);
    }

    public static Response getUserByID(int id) {
        CustomLogger.info(String.format("PostSteps.getUserByID : %d", id));
        return baseRequest().pathParam(Parameters.ID, id).get(Endpoints.USER_WITH_ID);
    }
}
