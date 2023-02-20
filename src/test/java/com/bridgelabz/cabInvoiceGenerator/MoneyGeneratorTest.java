package com.bridgelabz.cabInvoiceGenerator;

import org.junit.*;

public class MoneyGeneratorTest {

	MoneyGenerator invoiceGenerator = new MoneyGenerator();

	@Before
	public void printBeforeAllMsg() {
		System.out.println("-------Welcome to the Cab Invoice Generator Program-------");
	}

	@After
	public void PrintAfterEachTestCasePass() {
		System.out.println("passed");
	}

	@Test
	public void givenDistanceAndTime_shouldReturn_CalculateFare() {
		double distance = 2.0;
		double time = 5.0;
		double fare = invoiceGenerator.travelCost(distance, time);
		Assert.assertEquals(25.0, fare, 0);
	}

	@Test
	public void givenLessDistanceAndTime_shouldReturn_MinimumCalculateFare() {
		double distance = 0.1;
		double time = 1;
		double fare = invoiceGenerator.travelCost(distance, time);
		Assert.assertEquals(5, fare, 0);
	}

	@Test
	public void givenMultipleRides_shouldReturn_invoiceCost() {
		Ride[] rides = { new Ride(4, 25), new Ride(10, 60) };
		double fare = invoiceGenerator.calculateFareForMultipleRides(rides);
		Assert.assertEquals(225.0, fare, 0);
	}

	@Test
	public void givenMultipleRides_shouldReturn_invoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		EnhancedInVoice actualDescription = invoiceGenerator.calculateFareDescription(rides);
		EnhancedInVoice expectedDescription = new EnhancedInVoice(2, 30.0, 2.0);
		Assert.assertEquals(expectedDescription, actualDescription);
	}
}
