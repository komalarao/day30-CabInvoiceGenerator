package com.bridgelabz.cabInvoiceGenerator;

public class InVoiceDescription {
	public int totalNoOfRide;
    public double fare;
    public double avgFare;
    public boolean normalRide;

    public InVoiceDescription(int totalNoOfRide, double fare, boolean normalRide) {
        this.totalNoOfRide = totalNoOfRide;
        this.fare = fare;
        this.avgFare = avgFare;
        this.normalRide = normalRide;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InVoiceDescription other = (InVoiceDescription) obj;
        if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
            return false;
        if (totalNoOfRide != other.totalNoOfRide)
            return false;
        return true;

    }

    @Override
    public String toString() {
        return "InvoiceDescription{" +
                "totalNoOfRide=" + totalNoOfRide +
                ", fare=" + fare +
                ", avgFare=" + avgFare +
                ", normalRide=" + normalRide +
                '}';
    }
    }

