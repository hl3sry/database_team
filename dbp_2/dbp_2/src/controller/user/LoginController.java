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
				// 모델에 로그인 처리를 위임
				ClientManager manager = ClientManager.getInstance();
				manager.login(userId, password);
		
				// 세션에 사용자 이이디 저장
				HttpSession session = request.getSession();
	            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
	            
	            return "redirect:/client/main";	
			} 
			if(position.equals("n2")) {
				// 모델에 로그인 처리를 위임
				CeoManager manager = CeoManager.getInstance();
				manager.login(userId, password);
		
				// 세션에 사용자 이이디 저장
				HttpSession session = request.getSession();
	            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
	            
	            return "redirect:/ceo/main";	
			}
			
			return "redirect:/user/login";
					
		} catch (Exception e) {
			/* UserNotFoundException이나 PasswordMismatchException 발생 시
			 * 다시 login form을 사용자에게 전송하고 오류 메세지도 출력
			 */
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/user/loginForm.jsp";			
		}	
    }
}
