package com.APIAutomationClass.tests.integration.crud;

import com.APIAutomationClass.base.BaseTest;
import com.APIAutomationClass.endpoints.APIConstants;
import com.APIAutomationClass.pojos.Booking;
import com.APIAutomationClass.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestIntegrationFlow extends BaseTest {

    // Create Booking
    // Get Booking
    // Update Booking
    // Delete Booking

    @Test(groups = {"integration"}, priority = 1)
    @Description ("TC#INT01- Step1. Verify that the Booking can be created.")
    public void testCreateBooking (ITestContext iTestContext) throws Exception {

        requestSpecification.basePath(APIConstants.BASE_PATH);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.bookingPayloadFromPojoToString()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseFromStringToObject(response.asString());
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());




    }
    @Test(groups = {"integration"}, priority = 2)
    @Description ("TC#INT02- Step2. Verify the Booking by ID")
    public void testVerifyBookingById (ITestContext iTestContext) throws Exception {
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basepathGET = APIConstants.BASE_PATH +"/"+ bookingid;
        System.out.println("basepathGET ====> "+basepathGET);
        requestSpecification.basePath(basepathGET);
//        requestSpecification.basePath(APIConstants.BASE_PATH+"/"+bookingid);
        response = RestAssured.given(requestSpecification).when().get();
        validatableResponse = response.then().log().all();
        Booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertThat(booking.getFirstname()).isNotNull().isNotEmpty().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("A.James1111");
        assertActions.verifyStringKey(booking.getFirstname(), "A.James1111");
        validatableResponse.statusCode(200);
    }
    @Test (groups = { " inegration"}, priority = 3 )
    @Description ( " TC#INT03- Step3. Verify Update Booking by ID ")
    public void testUpdateBookingById (ITestContext iTestContext) throws Exception {
        String token = getToken();
        iTestContext.setAttribute("token", token);
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basepathUPDATE = APIConstants.BASE_PATH +"/"+ bookingid;
        System.out.println("basepathUPDATE in Update  ====> "+basepathUPDATE);
        requestSpecification.basePath(basepathUPDATE).cookie("token", token);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.updateBookingPayloadFromPojoToString()).put();
        validatableResponse = response.then().log().all();
        Booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertThat(booking.getFirstname()).isNotNull().isNotEmpty().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("A.James2222");
        assertActions.verifyStringKey(booking.getFirstname(), "A.James2222");
        assertActions.verifyStringKey(booking.getLastname(), "Brown2222");
        assertActions.verifyRespnseBody(booking.getLastname(), "Brown2222", "To verify the last name");
        validatableResponse.statusCode(200);
        System.out.println("bookingid after update is ===> "+ response.then().extract().body().path("booking.bookingid"));







    }
    @Test (groups = {"integration"}, priority = 4 )
    @Description (" TC#INT04. Step4. verify Delete Booking by ID")
    public void testDeleteBookingById (ITestContext iTestContext) throws Exception {
        String token = (String) iTestContext.getAttribute("token");
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basepathDELETE = APIConstants.BASE_PATH +"/"+ bookingid;
        System.out.println("basepathDELETE ====> "+basepathDELETE);
        requestSpecification.basePath(basepathDELETE).cookie("token", token);
        validatableResponse= RestAssured.given().spec(requestSpecification).when().delete().then().log().all();
        validatableResponse.statusCode(201);

    }
}
