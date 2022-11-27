package by.grsu.rkarachun.tsm.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.dao.impl.CarDaoImpl;
import by.grsu.rkarachun.tsm.db.dao.impl.DriverDaoImpl;
import by.grsu.rkarachun.tsm.db.model.Car;
import by.grsu.rkarachun.tsm.db.model.Driver;
import by.grsu.rkarachun.tsm.web.dto.CarDto;
import by.grsu.rkarachun.tsm.web.dto.DriverDto;

public class CarServlet extends HttpServlet{
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;
	private static final IDao<Integer, Driver> driverDao = DriverDaoImpl.INSTANCE;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet");
		String viewParam = req.getParameter("view");
		if ("edit".equals(viewParam)) {
			handleEditView(req, res);
		} else {
			handleListView(req, res);
		}
	}

	private void handleListView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Car> cars = carDao.getAll(); // get data

		List<CarDto> dtos = cars.stream().map((entity) -> {
			CarDto dto = new CarDto();
			// copy necessary fields as-is
			dto.setId(entity.getId());
			dto.setCarName(entity.getCarName());
			dto.setComfortLevel(entity.getComfortLevel());
			dto.setNumberSeats(entity.getNumberSeats());
			dto.setFree(entity.getFree());

			// build data for complex fields
			Driver driver = driverDao.getById(entity.getDriverId());
			dto.setCarName(driver.getDriverName());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); // set data as request attribute (like "add to map") to be used later in JSP
		req.getRequestDispatcher("car-list.jsp").forward(req, res); // delegate request processing to JSP
	}


	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String carIdStr = req.getParameter("id");
		CarDto dto = new CarDto();
		if (!Strings.isNullOrEmpty(carIdStr)) {
			// object edit
			Integer carId = Integer.parseInt(carIdStr);
			Car entity = carDao.getById(carId);
			dto.setId(entity.getId());
			dto.setCarName(entity.getCarName());
			dto.setComfortLevel(entity.getComfortLevel());
			dto.setNumberSeats(entity.getNumberSeats());
			dto.setFree(entity.getFree());
		}
		req.setAttribute("dto", dto);
		req.setAttribute("allModels", getAllModelsDtos());
		req.getRequestDispatcher("car-edit.jsp").forward(req, res);
	}

	private List<DriverDto> getAllModelsDtos() {
		return driverDao.getAll().stream().map((entity) -> {
			DriverDto dto = new DriverDto();
			dto.setId(entity.getId());
			dto.setDriverName(entity.getDriverName());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Car car = new Car();
		String carIdStr = req.getParameter("id");
		String driverIdStr = req.getParameter("driverId");

		car.setCarName(req.getParameter("carName"));
		car.setComfortLevel(req.getParameter("comfortLevel"));
		car.setNumberSeats(Integer.parseInt(req.getParameter("numberSeats")));
		car.setFree(Boolean.parseBoolean(req.getParameter("free")));
		car.setDriverId(driverIdStr == null ? null : Integer.parseInt(driverIdStr));
		if (Strings.isNullOrEmpty(carIdStr)) {
			// new entity
			carDao.insert(car);
		} else {
			// updated entity
			car.setId(Integer.parseInt(carIdStr));
			carDao.update(car);
		}
		res.sendRedirect("/car"); // will send 302 back to client and client will execute GET /car
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		carDao.delete(Integer.parseInt(req.getParameter("id")));
	}

}
