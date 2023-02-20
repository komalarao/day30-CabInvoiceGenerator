package com.bridgelabz.cabInvoiceGenerator;

import org.junit.*;

public class MoneyGeneratorTest {

	InvoiceGenerator  invoiceGenerator = new InvoiceGenerator();
    @BeforeClass
    public static void printBeforeAllMsg() {
        System.out.println("-------Welcome to the Cab Invoice Generator Program-------");
    }
    @After
    public void PrintAfterEachTestCasePass(){
        System.out.println("passed");
    }
    @Test
    public void givenDistanceAndTime_shouldReturnCalculateFareForNormalRide() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFareForRideType(distance, time, true);
        Assert.assertEquals(25.0, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnCalculateFalseFareForPremiumRide() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFareForRideType(distance, time, false);
        Assert.assertEquals(40.0, fare, 0.0);
    }

    @Test
    public void givenRides_shouldReturnInvoiceCostForNormalRide() {

        Ride[] rides = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
        double fare = invoiceGenerator.calculateFareForMultipleRides(rides, true);
        Assert.assertEquals(30.0, fare, 0.0);
    }

    @Test
    public void givenRides_shouldReturnInvoiceCostForPremiumRide() {

        Ride[] rides = { new Ride(2.0, 5, false), new Ride(0.1, 1, false) };
        double fare = invoiceGenerator.calculateFareForMultipleRides(rides, false);
        Assert.assertEquals(60.0, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceDescriptionForNormalRide() {
        Ride[] rides = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
        InVoiceDescription actualDescription = invoiceGenerator.calculateFareDescription(rides, true);
        InVoiceDescription expectedDescription = new InVoiceDescription(2, 30.0, true);
        Assert.assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceDescriptionForPremiumRide() {
        Ride[] rides = { new Ride(2.0, 5, false), new Ride(0.1, 1, false) };
        InVoiceDescription actualDescription = invoiceGenerator.calculateFareDescription(rides, false);
        InVoiceDescription expectedDescription = new InVoiceDescription(2, 60.0, false);
        Assert.assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void givenUserId_shouldReturnInvoiceDescriptionListForNormalRide() {
        String userId = "abc@gmail.com";
        Ride[] rides = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
        invoiceGenerator.addRides("abc@gmail.com", rides, true);
        Ride[] rides1 = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
        invoiceGenerator.addRides(userId, rides1, true);
        InVoiceDescription actualDescription = invoiceGenerator.getInvoiceDescription(userId, true);
        InVoiceDescription expectedDescription = new InVoiceDescription(2, 30.0, true);
        Assert.assertEquals(expectedDescription, actualDescription);
    }
}
