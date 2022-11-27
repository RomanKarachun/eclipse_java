package by.grsu.rkarachun.tsm.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.dao.impl.DriverDaoImpl;
import by.grsu.rkarachun.tsm.db.model.Driver;

public class DriverServlet extends HttpServlet{
	private static final IDao<Integer, Driver> driverDao = DriverDaoImpl.INSTANCE;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer driverId = Integer.parseInt(req.getParameter("id")); // read request parameter
		Driver driverById = driverDao.getById(driverId); // from DB

		res.setContentType("text/html");// setting the content type

		PrintWriter pw = res.getWriter();// get the stream to write the data

		// writing html in the stream
		pw.println("<html><body>");

		if (driverById == null) {
			pw.println("no driver by id=" + driverId);
		} else {
			pw.println(driverById.toString());
		}

		pw.println("</body></html>");
		pw.close();// closing the stream
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();// get the stream to write the data
		pw.println("<html><body>");
		try {
			String paramDriverName = req.getParameter("driverName");
			String paramPhoneNumber = req.getParameter("phoneNumber");
			Driver driverEntity = new Driver();
			driverEntity.setDriverName(paramDriverName);
			driverEntity.setPhoneNumber(paramPhoneNumber);
			pw.println("Saved:" + driverEntity);

		} catch (Exception e) {
			pw.println("Error:" + e.toString());
		}

		pw.println("</body></html>");
		pw.close();
	}
}
