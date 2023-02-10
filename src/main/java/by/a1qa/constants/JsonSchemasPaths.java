package by.a1qa.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonSchemasPaths {
    private static final String JSON_SCHEMAS_PATH = "jsonschemas/%s";
    public static final String ALL_POSTS_JSON_SCHEMA_PATH = String.format(JSON_SCHEMAS_PATH, "allPostsSchema.json");
    public static final String ALL_USERS_JSON_SCHEMA_PATH = String.format(JSON_SCHEMAS_PATH, "allUsersSchema.json");
}
