package com.bridgelabz.cabInvoiceGenerator;

public class Ride {
	public double distance;
	public int time;
    public boolean rideType;
	public Ride(double distance, int time,boolean rideType) {
		this.distance = distance;
		this.time = time;
		this.rideType = rideType;
	}
}
