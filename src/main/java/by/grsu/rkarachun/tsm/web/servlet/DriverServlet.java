package by.grsu.rkarachun.tsm.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.dao.impl.DriverDaoImpl;
import by.grsu.rkarachun.tsm.db.model.Car;
import by.grsu.rkarachun.tsm.db.model.Driver;
import by.grsu.rkarachun.tsm.web.dto.DriverDto;
import by.grsu.rkarachun.tsm.web.dto.TableStateDto;

public class DriverServlet extends AbstractListServlet{
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
		int totalDrivers = driverDao.count(); // get count of ALL items

		final TableStateDto tableStateDto = resolveTableStateDto(req, totalDrivers); // init TableStateDto for specific
																					// Servlet and saves it in current
																					// request using key
																					// "currentPageTableState" to be
																					// used by 'paging' component

		List<Driver> drivers = driverDao.find(tableStateDto); // get data using paging and sorting params

		List<DriverDto> dtos = drivers.stream().map((entity) -> {
			DriverDto dto = new DriverDto();
			// copy necessary fields as-is
			dto.setId(entity.getId());
			dto.setDriverName(entity.getDriverName());
			dto.setPhoneNumber(entity.getPhoneNumber());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); // set data as request attribute (like "add to map") to be used later in JSP
		req.getRequestDispatcher("driver-list.jsp").forward(req, res); // delegate request processing to JSP
	}


	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String driverIdStr = req.getParameter("id");
		DriverDto dto = new DriverDto();
		if (!Strings.isNullOrEmpty(driverIdStr)) {
			// object edit
			Integer driverId = Integer.parseInt(driverIdStr);
			Driver entity = driverDao.getById(driverId);
			dto.setId(entity.getId());
			dto.setDriverName(entity.getDriverName());
			dto.setPhoneNumber(entity.getPhoneNumber());
		}	
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("driver-edit.jsp").forward(req, res);
		}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Driver driver = new Driver();
		String driverIdStr = req.getParameter("id");

		driver.setDriverName(req.getParameter("driverName"));
		driver.setPhoneNumber(req.getParameter("phoneNumber"));
		if (Strings.isNullOrEmpty(driverIdStr)) {
			// new entity
			driverDao.insert(driver);
		} else {
			// updated entity
			driver.setId(Integer.parseInt(driverIdStr));
			driverDao.update(driver);
		}
		res.sendRedirect("/driver"); // will send 302 back to client and client will execute GET /car
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		driverDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}
