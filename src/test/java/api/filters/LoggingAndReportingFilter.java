package api.filters;

import com.aventstack.extentreports.Status;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.Logger;
import utility.ExtentReporterUtility;
import utility.LoggerUtlity;

public class LoggingAndReportingFilter implements Filter {

    Logger logger = LoggerUtlity.getLogger(LoggingAndReportingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logAndReportRequest(filterableRequestSpecification);
        Response response= filterContext.next(filterableRequestSpecification, filterableResponseSpecification);//Request is going to executed
        logAndReportResponse(response);
        return response;//test for assertion
    }

    public void logAndReportRequest(FilterableRequestSpecification requestSpecification){
        logger.info("URI : "+ requestSpecification.getURI());
        logger.info("BASE URI:"+ requestSpecification.getBaseUri());
        logger.info("Request Header:"+ requestSpecification.getHeaders());
        logger.info("Request PayLoad:"+ requestSpecification.getBody());

        ExtentReporterUtility.getTest().log(Status.INFO , requestSpecification.getMethod() + " /URI : " + requestSpecification.getURI());
        ExtentReporterUtility.logHeaders(requestSpecification.getHeaders().asList());
        ExtentReporterUtility.logJson(requestSpecification.getBody());
    }
    public void logAndReportResponse(Response response) {
        logger.info("STATUS CODE:"+ response.getStatusCode());
        logger.info("Response Header :"+ response.headers());
        logger.info("Request Body:"+ response.getBody().prettyPrint());

        ExtentReporterUtility.getTest().log(Status.INFO , "Response Details : ");
        ExtentReporterUtility.getTest().log(Status.INFO , "Status Code : "+ response.getStatusCode());
        ExtentReporterUtility.logHeaders(response.getHeaders().asList());
        ExtentReporterUtility.logJson(response.getBody().prettyPrint());
    }
}
