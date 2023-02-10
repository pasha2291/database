package by.a1qa.steps;

import by.a1qa.constants.Parameters;
import by.a1qa.constants.Endpoints;
import by.a1qa.utils.logger.CustomLogger;
import by.a1qa.models.api.Post;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PostSteps extends BaseSteps {

    public static Response getAllPosts() {
        CustomLogger.info("PostSteps.getAllPosts()");
        return baseRequest().get(Endpoints.ALL_POSTS);
    }

    public static Response getPostByID(int id) {
        CustomLogger.info(String.format("PostSteps.getAllPosts() : %d", id));
        return baseRequest().pathParam(Parameters.ID, id).get(Endpoints.POST_WITH_ID);
    }

    public static Response postPostObject(Post post) {
        CustomLogger.info(String.format("PostSteps.postPostObject : %s", post));
        return baseRequest().body(post).post(Endpoints.ALL_POSTS);
    }
}
