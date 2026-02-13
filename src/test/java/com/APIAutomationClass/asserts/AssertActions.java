package com.APIAutomationClass.asserts;

import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.assertEquals;



public class AssertActions {
    // Common Assertions - can be reused
    public void verifyRespnseBody (String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyRespnseBody (int actual, int expected, int description) {
        assertEquals(actual, expected, description);
    }
    public void verifyStatusCode (Response response, Integer expected) {
        assertEquals(response.getStatusCode(), expected);
    }
    public void verifyStringKey (String keyActual, String keyExpected) {
        assertThat(keyActual).isNotNull().isNotEmpty().isNotBlank();
        assertThat(keyActual).isEqualTo(keyExpected);

    }
}
