package com.bridgelabz.cabInvoiceGenerator;

public class EnhancedInVoice {
	public int totalNoOfRide;
    public double fare;
    public double avgFare;

    public EnhancedInVoice(int totalNoOfRide, double fare, double avgFare) {
        this.totalNoOfRide = totalNoOfRide;
        this.fare = fare;
        this.avgFare = avgFare;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EnhancedInVoice other = (EnhancedInVoice) obj;
        if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
            return false;
        if (totalNoOfRide != other.totalNoOfRide)
            return false;
        return true;
    }
}
