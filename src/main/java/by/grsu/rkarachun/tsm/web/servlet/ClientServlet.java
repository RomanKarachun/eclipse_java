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
import by.grsu.rkarachun.tsm.db.dao.impl.ClientDaoImpl;
import by.grsu.rkarachun.tsm.db.model.Car;
import by.grsu.rkarachun.tsm.db.model.Client;
import by.grsu.rkarachun.tsm.web.dto.ClientDto;
import by.grsu.rkarachun.tsm.web.dto.TableStateDto;

public class ClientServlet extends AbstractListServlet{
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
		int totalClients = clientDao.count(); // get count of ALL items

		final TableStateDto tableStateDto = resolveTableStateDto(req, totalClients); // init TableStateDto for specific
																					// Servlet and saves it in current
																					// request using key
																					// "currentPageTableState" to be
																					// used by 'paging' component

		List<Client> clients = clientDao.find(tableStateDto); // get data using paging and sorting params

		List<ClientDto> dtos = clients.stream().map((entity) -> {
			ClientDto dto = new ClientDto();
			// copy necessary fields as-is
			dto.setId(entity.getId());
			dto.setClientName(entity.getClientName());
			dto.setPhoneNumber(entity.getPhoneNumber());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); // set data as request attribute (like "add to map") to be used later in JSP
		req.getRequestDispatcher("client-list.jsp").forward(req, res); // delegate request processing to JSP
	}


	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String clientIdStr = req.getParameter("id");
		ClientDto dto = new ClientDto();
		if (!Strings.isNullOrEmpty(clientIdStr)) {
			// object edit
			Integer clientId = Integer.parseInt(clientIdStr);
			Client entity = clientDao.getById(clientId);
			dto.setId(entity.getId());
			dto.setClientName(entity.getClientName());
			dto.setPhoneNumber(entity.getPhoneNumber());
		}	
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("client-edit.jsp").forward(req, res);
		}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Client client = new Client();
		String clientIdStr = req.getParameter("id");

		client.setClientName(req.getParameter("clientName"));
		client.setPhoneNumber(req.getParameter("phoneNumber"));
		if (Strings.isNullOrEmpty(clientIdStr)) {
			// new entity
			clientDao.insert(client);
		} else {
			// updated entity
			client.setId(Integer.parseInt(clientIdStr));
			clientDao.update(client);
		}
		res.sendRedirect("/client"); // will send 302 back to client and client will execute GET /car
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		clientDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}