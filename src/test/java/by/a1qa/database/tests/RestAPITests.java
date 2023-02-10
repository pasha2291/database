package by.a1qa.database.tests;

import by.a1qa.constants.ApiTestDataPaths;
import by.a1qa.constants.JsonSchemasPaths;
import by.a1qa.constants.Parameters;
import by.a1qa.utils.logger.CustomLogger;
import by.a1qa.models.api.Post;
import by.a1qa.models.api.User;
import by.a1qa.steps.PostSteps;
import by.a1qa.steps.ResponseSteps;
import by.a1qa.steps.UserSteps;
import by.a1qa.utils.fileprocessing.JSONCustomParser;
import by.a1qa.utils.RandomStringUtil;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RestAPITests extends BaseTest {

    @Test
    public void runTest1() {
        CustomLogger.info("Start of tests 1");
        Response response = PostSteps.getAllPosts();
        ResponseSteps.checkStatusCode(response, HttpStatus.SC_OK);
        ResponseSteps.checkResponseIsJson(response, JsonSchemasPaths.ALL_POSTS_JSON_SCHEMA_PATH);
        List<Post> actualResult = ResponseSteps.getList(response, Post.class);
        List<Post> expectedResult = actualResult
                .stream()
                .sorted(Comparator.comparing(Post::getId))
                .collect(Collectors.toList());
        CustomLogger.info("Assert that posts are sorted ascending (by id).");
        Assert.assertEquals(actualResult, expectedResult, "Posts response should be sorted by id (ascending order)!");
    }

    @Test
    public void runTest2() {
        CustomLogger.info("Start of tests 2");
        Response response = PostSteps.getPostByID(Integer.parseInt(
                JSONCustomParser.getElementByNameFromResPath(ApiTestDataPaths.ID_TEST_DATA_PATH, Parameters.ID_SECOND_TEST)));
        ResponseSteps.checkStatusCode(response, HttpStatus.SC_OK);
        Post actualResult = ResponseSteps.getObject(response, Post.class);
        Post expectedResult = JSONCustomParser.getObjectFromJsonResPath(ApiTestDataPaths.TEST_2_JSON_FILE_PATH, Post.class);
        CustomLogger.info("Assert that received post equals to expected one (userId = 10, id = 99)");
        Assert.assertEquals(actualResult, expectedResult, "Received post should be equals to expected one (userId = 10, id = 99)!");
    }

    @Test
    public void runTest3() {
        CustomLogger.info("Start of tests 3");
        Response response = PostSteps.getPostByID(Integer.parseInt(
                JSONCustomParser.getElementByNameFromResPath(ApiTestDataPaths.ID_TEST_DATA_PATH, Parameters.ID_THIRD_TEST)));
        ResponseSteps.checkStatusCode(response, HttpStatus.SC_NOT_FOUND);
        Post actualResult = ResponseSteps.getObject(response, Post.class);
        CustomLogger.info("Assert that received post body is empty");
        Assert.assertNull(actualResult.getId(), "Received post's body(ID) should be null!");
        Assert.assertNull(actualResult.getUserId(), "Received post's body(UserID) should be null!");
        Assert.assertNull(actualResult.getTitle(), "Received post's body(Title) should be null!");
        Assert.assertNull(actualResult.getBody(), "Received post's body(Body) should be null!");
    }

    @Test
    public void runTest4() {
        CustomLogger.info("Start of tests 4");
        Post expectedPost =
                new Post(Integer.parseInt(JSONCustomParser.getElementByNameFromResPath(ApiTestDataPaths.ID_TEST_DATA_PATH, Parameters.USER_ID_FOURTH_TEST)),
                        Integer.parseInt(JSONCustomParser.getElementByNameFromResPath(ApiTestDataPaths.ID_TEST_DATA_PATH, Parameters.ID_FOURTH_TEST)),
                        RandomStringUtil.getRandomTitle(), RandomStringUtil.getRandomBody());
        Response response = PostSteps.postPostObject(expectedPost);
        ResponseSteps.checkStatusCode(response, HttpStatus.SC_CREATED);
        Post actualPost = ResponseSteps.getObject(response, Post.class);
        CustomLogger.info("Assert that received post equals to expected one");
        Assert.assertEquals(actualPost, expectedPost, "Received post should be equal to expected one!");
    }

    @Test
    public void runTest5() {
        CustomLogger.info("Start of tests 5");
        User expectedUser = JSONCustomParser.getObjectFromJsonResPath(ApiTestDataPaths.TEST_5_AND_6_JSON_FILE_PATH, User.class);
        Response response = UserSteps.getAllUsers();
        ResponseSteps.checkStatusCode(response, HttpStatus.SC_OK);
        ResponseSteps.checkResponseIsJson(response, JsonSchemasPaths.ALL_USERS_JSON_SCHEMA_PATH);
        List<User> userList = ResponseSteps.getList(response, User.class);
        CustomLogger.info("Assert that respond contains expected User(id = 5)");
        Assert.assertTrue(userList.contains(expectedUser), "Respond should contain expected User(id = 5)!");
    }

    @Test
    public void runTest6() {
        CustomLogger.info("Start of tests 6");
        User expectedUser = JSONCustomParser.getObjectFromJsonResPath(ApiTestDataPaths.TEST_5_AND_6_JSON_FILE_PATH, User.class);
        Response response = UserSteps.getUserByID(Integer.parseInt(
                JSONCustomParser.getElementByNameFromResPath(ApiTestDataPaths.ID_TEST_DATA_PATH, Parameters.ID_SIXTH_TEST)));
        ResponseSteps.checkStatusCode(response, HttpStatus.SC_OK);
        User actualUser = ResponseSteps.getObject(response, User.class);
        CustomLogger.info("Assert that received user equals to expected one");
        Assert.assertEquals(actualUser, expectedUser, "Received user should be equal to expected one!");
    }
}
