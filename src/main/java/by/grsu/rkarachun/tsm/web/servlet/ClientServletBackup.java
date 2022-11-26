package by.grsu.rkarachun.tsm.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.dao.impl.ClientDaoImpl;
import by.grsu.rkarachun.tsm.db.model.Client;

public class ClientServletBackup extends HttpServlet{
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer clientId = Integer.parseInt(req.getParameter("id")); // read request parameter
		Client clientById = clientDao.getById(clientId); // from DB

		res.setContentType("text/html");// setting the content type

		PrintWriter pw = res.getWriter();// get the stream to write the data

		// writing html in the stream
		pw.println("<html><body>");

		if (clientById == null) {
			pw.println("no client by id=" + clientId);
		} else {
			pw.println(clientById.toString());
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
			String paramClientName = req.getParameter("clientName");
			String paramPhoneNumber = req.getParameter("phoneNumber");
			Client clientEntity = new Client();
			clientEntity.setClientName(paramClientName);
			clientEntity.setPhoneNumber(paramPhoneNumber);
			pw.println("Saved:" + clientEntity);

		} catch (Exception e) {
			pw.println("Error:" + e.toString());
		}

		pw.println("</body></html>");
		pw.close();
	}

}
