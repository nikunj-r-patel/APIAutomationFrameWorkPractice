package com.APIAutomationClass.tests.integration.crud;

import com.APIAutomationClass.base.BaseTest;
import com.APIAutomationClass.endpoints.APIConstants;
import com.APIAutomationClass.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import  static org.assertj.core.api.Assertions.*;

public class testVerifyCreateBookingPOST01 extends BaseTest {



    @Description("Verify that POST request is working fine")
    @Test()
     public void tsetVerifyCreateBookingPOST01 () {
        requestSpecification
                .basePath(APIConstants.BASE_PATH);
      //requestSpecification.body(payloadManager.bookingPayloadFromPojoToString());
        response= RestAssured.given(requestSpecification)
                .when()
                .body(payloadManager.bookingPayloadFromPojoToString())
                .post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // restAssured -validation
        validatableResponse.body("booking.firstname", Matchers.equalTo("A.James1111"));
        // AssertJ
        BookingResponse bookingResponse = payloadManager.bookingResponseFromStringToObject(response.asString());
        assertThat(bookingResponse.getBookingid()).isNotNull().isNotZero().isPositive();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotBlank().isNotEmpty().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualToIgnoringCase("A.James1111");
        assertThat(bookingResponse.getBooking().getLastname()).isNotBlank().isNotEmpty().isNotNull();
        assertThat(bookingResponse.getBooking().getLastname()).isEqualToIgnoringCase("Brown1111");
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"A.James1111");
        System.out.println("The actual Firstname in responce is ====>"+bookingResponse.getBooking().getFirstname());

        // TestNG Assertions
        assertActions.verifyStatusCode(response,200);
        assertActions.verifyRespnseBody((bookingResponse.getBooking().getFirstname()),"A.James1111","to verify the Firstname");

     }
}
