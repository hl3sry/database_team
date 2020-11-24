package controller.ceo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Ceo;
import model.service.ExistingUserException;
import model.service.CeoManager;

public class RegisterCeoController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterCeoController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Ceo ceo = new Ceo(request.getParameter("ceoId"), request.getParameter("name"), request.getParameter("phone"),
				request.getParameter("ceoNum"), request.getParameter("password"));

		log.debug("Create Ceo : {}", ceo);

		try {
			CeoManager manager = CeoManager.getInstance();
			manager.create(ceo);
			//return "redirect:/ceo/main"; // 성공 시 사용자 리스트 화면으로 redirect
			return "redirect:/user/login";

		} catch (ExistingUserException e) { // 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("ceo", ceo);
			return "/ceo/ceoRegisterForm.jsp";
		}
	}
}
