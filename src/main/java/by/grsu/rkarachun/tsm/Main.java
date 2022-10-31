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
	    driver.setDriver_name("Kunickiy");
	    driver.setCar("Audi");
	    driver.setPhone_number("375299003564");
	    
	    car.setId(1);
	  //  car.setOwner_id(1);
	   // car.setComfort_level("Comfort");
	  //  car.setNumber_of_seats(4);
	    car.setFree(true);
	    
	    order.setId(1);
	    order.setClient_id(1);
	    order.setCar_id(1);
	    order.setPrice(5);
	    order.setDistance(12);
	    order.setOrder_time(new Timestamp(new Date().getTime()));
	    order.setArrival_time(new Timestamp(new Date().getTime()));
	    order.setOrder_finish(new Timestamp(new Date().getTime()));
	    
	    client.setId(1);
	//    client.setClient_name("Wolf");
	    
	    System.out.println(driver.toString());
	    System.out.println(car.toString());
	    System.out.println(order.toString());
	    System.out.println(client.toString());
	}
}
