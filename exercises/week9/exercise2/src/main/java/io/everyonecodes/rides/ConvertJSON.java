package io.everyonecodes.rides;

import com.google.gson.Gson;

public class ConvertJSON {
    public static Driver getDriver(Driver driver) {
        driver.setUsername("lucas");
        driver.setCarType("Toyota Yaris");
        return driver;
    }

    public static Rides getRide(Rides ride) {
        ride.setCustomerUserName("customerUserName1");
        ride.setDistanceTraveled(12.12);
        ride.setPrice(25.60);
        return ride;
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        Rides rides = new Rides();
        getDriver(driver);
        getRide(rides);
        System.out.println("The JSON representation of Object driver is: ");
        System.out.println(new Gson().toJson(driver));
        System.out.println("The JSON representation of Object rides is: ");
        System.out.println(new Gson().toJson(rides));
    }

}
