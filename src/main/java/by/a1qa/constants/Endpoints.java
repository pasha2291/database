package by.a1qa.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Endpoints {
    public static final String ALL_POSTS = "/posts";
    public static final String POST_WITH_ID = String.format("%s/{id}", ALL_POSTS);
    public static final String ALL_USERS = "/users";
    public static final String USER_WITH_ID = String.format("%s/{id}", ALL_USERS);
}
