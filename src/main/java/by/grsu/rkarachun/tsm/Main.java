package by.grsu.rkarachun.tsm;

import java.sql.Timestamp;
import java.util.Date;

import by.grsu.rkarachun.tsm.db.model.*;

public class Main {
	public static void main(String[] args) {
	    Driver driver = new Driver();
	    Car car = new Car();
	    Order order = new Order();
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
	    
	    order.setId(1);
	    order.setClientId(1);
	    order.setCarId(1);
	    order.setPrice(5);
	    order.setDistance(12);
	    order.setOrderTime(new Timestamp(new Date().getTime()));
	    order.setArrivalTime(new Timestamp(new Date().getTime()));
	    order.setOrderFinish(new Timestamp(new Date().getTime()));
	    
	    client.setId(1);
	    client.setClientName("Wolf");
	    
	    System.out.println(driver.toString());
	    System.out.println(car.toString());
	    System.out.println(order.toString());
	    System.out.println(client.toString());
	}
}
