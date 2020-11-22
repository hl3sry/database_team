package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.ClientManager;
import model.service.CeoManager;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String position = request.getParameter("position");
    	String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		try {
			if(position.equals("n1")) {
				// �𵨿� �α��� ó���� ����
				ClientManager manager = ClientManager.getInstance();
				manager.login(userId, password);
		
				// ���ǿ� ����� ���̵� ����
				HttpSession session = request.getSession();
	            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
	            
	            return "redirect:/client/main";	
			} 
			if(position.equals("n2")) {
				// �𵨿� �α��� ó���� ����
				CeoManager manager = CeoManager.getInstance();
				manager.login(userId, password);
		
				// ���ǿ� ����� ���̵� ����
				HttpSession session = request.getSession();
	            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
	            
	            return "redirect:/ceo/main";	
			}
			
			return "redirect:/user/login";
					
		} catch (Exception e) {
			/* UserNotFoundException�̳� PasswordMismatchException �߻� ��
			 * �ٽ� login form�� ����ڿ��� �����ϰ� ���� �޼����� ���
			 */
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/user/loginForm.jsp";			
		}	
    }
}
