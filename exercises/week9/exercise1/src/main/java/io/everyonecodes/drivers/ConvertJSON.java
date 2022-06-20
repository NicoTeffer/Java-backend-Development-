package io.everyonecodes.drivers;

import com.google.gson.Gson;

import java.util.Set;

public class ConvertJSON {
    public static Driver getDriver(Driver driver) {
        driver.setId("Driver_ID");
        driver.setUsername("DriverName");
        driver.setPassword("pw123");
        driver.setAvailable(true);
        driver.setAuthorities(Set.of("ROLE_DRIVER"));
        return driver;
    }
    public static void main(String[] args) {
        Driver driver = new Driver();
        getDriver(driver);
        System.out.println("The JSON representation of Object driver is: ");
        System.out.println(new Gson().toJson(driver));
    }
}
