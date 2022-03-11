package driverAllocator.entity;

import com.sun.deploy.util.StringUtils;

public class Driver {
    int id;
    int tripCount;
    int cumulativeDistance;
    Trip trip;
    boolean isRegistered;
    String name;

    public Driver(int id) {
        this.id = id;
    }

    public Driver(String driverId) {
        this.name = driverId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return (name != null) ? name: "Driver-" + id;
    }
    public int getTripCount() {
        return tripCount;
    }

    public void updateTripCount(int tripCount) {
        this.tripCount += tripCount;
    }

    public int getCumulativeDistance() {
        return cumulativeDistance;
    }

    public void updateDistance(int distance) {
        this.cumulativeDistance += distance;
    }

    public void attachTrip(Trip trip) {
        this.trip = trip;
    }

    public Trip getTrip() {
        return trip;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}
