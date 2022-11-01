package by.grsu.rkarachun.tsm;

import java.sql.Timestamp;
import java.util.Date;

import by.grsu.rkarachun.tsm.db.model.*;

public class Main {
	public static void main(String[] args) {
	    Driver driver = new Driver();
	    Car car = new Car();
	    Order_object order_object = new Order_object();
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
	    
	    order_object.setId(1);
	    order_object.setClientId(1);
	    order_object.setCarId(1);
	    order_object.setPrice(5);
	    order_object.setDistance(12);
	    order_object.setOrderTime(new Timestamp(new Date().getTime()));
	    order_object.setArrivalTime(new Timestamp(new Date().getTime()));
	    order_object.setOrderFinish(new Timestamp(new Date().getTime()));
	    
	    client.setId(1);
	    client.setName("Wolf");
	    
	    System.out.println(driver.toString());
	    System.out.println(car.toString());
	    System.out.println(order_object.toString());
	    System.out.println(client.toString());
	}
}
