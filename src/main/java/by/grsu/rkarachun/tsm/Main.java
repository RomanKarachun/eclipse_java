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
	    driver.setCar("Audi");
	    driver.setPhoneNumber("375299003564");
	    
	    car.setId(1);
	    car.setOwnerId(1);
	    car.setComfortLevel("Comfort");
	    car.setNumberSeats(4);
	    car.setFree(true);
	    
	    ord.setId(1);
	    ord.setClientId(1);
	    ord.setCarId(1);
	    ord.setPrice(5);
	    ord.setDistance(12);
	    ord.setOrderTime(new Timestamp(new Date().getTime()));
	    ord.setArrivalTime(new Timestamp(new Date().getTime()));
	    ord.setOrderFinish(new Timestamp(new Date().getTime()));
	    
	    client.setId(1);
	    client.setName("Wolf");
	    
	    System.out.println(driver.toString());
	    System.out.println(car.toString());
	    System.out.println(ord.toString());
	    System.out.println(client.toString());
	}
}
