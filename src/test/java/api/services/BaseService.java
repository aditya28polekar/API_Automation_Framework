package api.services;

import api.filters.LoggingAndReportingFilter;
import io.restassured.RestAssured;

public class BaseService {
    static {
        RestAssured.filters(new LoggingAndReportingFilter());
    }
}
