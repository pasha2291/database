package by.a1qa.utils.logger;

import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@UtilityClass
public class CustomLogger {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void info(String message){
        LOGGER.log(Level.INFO, message);
    }

    public static void logResponse(Response response) {
        info(String.format("getStatusCode(): %s; getStatusLine(): %s; getBody(): %s", response.getStatusCode(),
                response.getStatusLine(), response.getBody().prettyPrint()));
    }

    public static void logRequest(FilterableRequestSpecification requestSpec) {
        info(String.format("getMethod(): %s; getURI(): %s; getHeaders(): %s;", requestSpec.getMethod(),
                requestSpec.getURI(), requestSpec.getHeaders()));
    }
}
