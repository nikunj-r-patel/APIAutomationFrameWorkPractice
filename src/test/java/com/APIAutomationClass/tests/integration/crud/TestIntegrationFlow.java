package com.APIAutomationClass.tests.integration.sample;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    // Create Booking
    // Get Booking
    // Update Booking
    // Delete Booking

    @Test(groups = {"integration"}, priority = 1)
    @Description ("TC#INT01- Step1. Verify that the Booking can be created.")
    public void testCreateBooking () {
        Assert.assertTrue(true);
    }
    @Test(groups = {"integration"}, priority = 2)
    @Description ("TC#INT02- Step2. Verify the Booking by ID")
    public void testVerifyBookingById () {
        Assert.assertTrue(true);
    }
    @Test (groups = { " inegration"}, priority = 3 )
    @Description ( " TC#INT03- Step3. Verify Update Booking by ID ")
    public void testUpdateBookingById () {
        Assert.assertTrue(true);
    }
    @Test (groups = {"integration"}, priority = 4 )
    @Description (" TC#INT04. Step4. verify Delete Booking by ID")
    public void testDeleteBookingById () {
        Assert.assertTrue(true);

    }
}
