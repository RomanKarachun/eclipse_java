package by.grsu.rkarachun.tsm;

import java.sql.Timestamp;
import java.util.Date;

import by.grsu.rkarachun.tsm.db.model.*;

public class Main {
	public static void main(String[] args) {
	    Driver driver = new Driver();
	    Car car = new Car();
	    Ord ord = new Ord();
	    Client client = new Client();
	    driver.setId(1);
	    driver.setDriverName("Kunickiy");
	    driver.setPhoneNumber("375299003564");
	    
	    car.setId(1);
	    car.setDriverId(1);
	    
	    ord.setId(1);
	    ord.setClientId(1);
	    ord.setCarId(1);
	    ord.setPrice(5);
	    ord.setDistance(12);
	    ord.setOrderTime(new Timestamp(new Date().getTime()));
	    ord.setArrivalTime(new Timestamp(new Date().getTime()));
	    ord.setOrderFinish(new Timestamp(new Date().getTime()));
	    
	    client.setId(1);
	    client.setClientName("Karachun");
	    client.setPhoneNumber("375298009031");
	    
	    System.out.println(driver.toString());
	    System.out.println(car.toString());
	    System.out.println(ord.toString());
	    System.out.println(client.toString());
	}
}
