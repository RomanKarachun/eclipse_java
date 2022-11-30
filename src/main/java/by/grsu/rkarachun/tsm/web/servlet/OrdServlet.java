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
import by.grsu.rkarachun.tsm.db.dao.impl.OrdDaoImpl;
import by.grsu.rkarachun.tsm.db.dao.impl.CarDaoImpl;
import by.grsu.rkarachun.tsm.db.dao.impl.ClientDaoImpl;
import by.grsu.rkarachun.tsm.db.model.Ord;
import by.grsu.rkarachun.tsm.db.model.Car;
import by.grsu.rkarachun.tsm.db.model.Client;
import by.grsu.rkarachun.tsm.web.dto.ClientDto;
import by.grsu.rkarachun.tsm.web.dto.CarDto;
import by.grsu.rkarachun.tsm.web.dto.OrdDto;

public class OrdServlet extends HttpServlet{
	private static final IDao<Integer, Ord> ordDao = OrdDaoImpl.INSTANCE;
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;

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
		List<Ord> ords = ordDao.getAll(); // get data

		List<OrdDto> dtos = ords.stream().map((entity) -> {
			OrdDto dto = new OrdDto();
			// copy necessary fields as-is
			dto.setId(entity.getId());
			dto.setPrice(entity.getPrice());
			dto.setDistance(entity.getDistance());
			dto.setOrderTime(entity.getOrderTime());
			dto.setArrivalTime(entity.getArrivalTime());
			dto.setOrderFinish(entity.getOrderFinish());

			// build data for complex fields
			Client client = clientDao.getById(entity.getClientId());
			dto.setClientName(client.getClientName());

			Car car = carDao.getById(entity.getCarId());
			dto.setCarName(car.getCarName());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); // set data as request attribute (like "add to map") to be used later in JSP
		req.getRequestDispatcher("ord-list.jsp").forward(req, res); // delegate request processing to JSP
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ordIdStr = req.getParameter("id");
		OrdDto dto = new OrdDto();
		if (!Strings.isNullOrEmpty(ordIdStr)) {
			// object edit
			Integer ordId = Integer.parseInt(ordIdStr);
			Ord entity = ordDao.getById(ordId);
			dto.setId(entity.getId());
			dto.setClientId(entity.getClientId());
			dto.setCarId(entity.getCarId());
			dto.setPrice(entity.getPrice());
			dto.setDistance(entity.getDistance());
			dto.setOrderTime(entity.getOrderTime());
			dto.setArrivalTime(entity.getArrivalTime());
			dto.setOrderFinish(entity.getOrderFinish());;
		}
		req.setAttribute("dto", dto);
		req.setAttribute("allCars", getAllCarsDtos());
		req.setAttribute("allClients", getAllClientsDtos());
		req.getRequestDispatcher("ord-edit.jsp").forward(req, res);
	}

	private List<CarDto> getAllCarsDtos() {
		return carDao.getAll().stream().map((entity) -> {
			CarDto dto = new CarDto();
			dto.setId(entity.getId());
			dto.setCarName(entity.getCarName());
			return dto;
		}).collect(Collectors.toList());
	}
	
	private List<ClientDto> getAllClientsDtos() {
		return clientDao.getAll().stream().map((entity) -> {
			ClientDto dto = new ClientDto();
			dto.setId(entity.getId());
			dto.setClientName(entity.getClientName());
			return dto;
		}).collect(Collectors.toList());
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Ord ord = new Ord();
		String ordIdStr = req.getParameter("id");
		String clientIdStr = req.getParameter("clientId");
		String carIdStr = req.getParameter("carId");

		ord.setPrice(Integer.parseInt((req.getParameter("price"))));
		ord.setDistance(Integer.parseInt((req.getParameter("distance"))));
		ord.setClientId(clientIdStr == null ? null : Integer.parseInt(clientIdStr));
		ord.setCarId(carIdStr == null ? null : Integer.parseInt(carIdStr));
		ord.setOrderTime(new Timestamp(new Date().getTime()));
		ord.setArrivalTime(new Timestamp(new Date().getTime()));
		ord.setOrderFinish(new Timestamp(new Date().getTime()));
		if (Strings.isNullOrEmpty(ordIdStr)) {
			// new entity
			ordDao.insert(ord);
		} else {
			ord.setId(Integer.parseInt(ordIdStr));
			ordDao.update(ord);
		}
		res.sendRedirect("/ord"); // will send 302 back to client and client will execute GET /car
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		ordDao.delete(Integer.parseInt(req.getParameter("id")));
	}

}
