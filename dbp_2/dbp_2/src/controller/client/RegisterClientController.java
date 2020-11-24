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
			request.getParameter("clientId"),
			request.getParameter("name"),
			request.getParameter("phone"),
			request.getParameter("password"), 
			request.getParameter("addrgu"), 
			request.getParameter("addrdong"));
		
        log.debug("Create Client : {}", client);

		try {
			ClientManager manager = ClientManager.getInstance();
			manager.create(client);
	        //return "redirect:/client/main";		// 성공 시 사용자 리스트 화면으로 redirect
			return "redirect:/user/login";
	        
		} catch (ExistingUserException e) {		// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("client", client);
			return "/client/clientRegisterForm.jsp";
		}
    }
}
