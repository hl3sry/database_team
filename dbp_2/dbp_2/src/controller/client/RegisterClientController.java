package controller.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Client;
import model.service.ExistingUserException;
import model.service.ClientManager;

public class RegisterClientController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterClientController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Client client = new Client(
			request.getParameter("userId"),
			request.getParameter("password"),
			request.getParameter("email"),
			request.getParameter("phone"));
		
        log.debug("Create Client : {}", client);

		try {
			ClientManager manager = ClientManager.getInstance();
			manager.create(client);
	        return "redirect:/client/main";		// ���� �� ����� ����Ʈ ȭ������ redirect
	        
		} catch (ExistingUserException e) {		// ���� �߻� �� ȸ������ form���� forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", client);
			return "/client/clientRegisterForm.jsp";
		}
    }
}
