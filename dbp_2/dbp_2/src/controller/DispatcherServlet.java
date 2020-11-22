package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebServlet(name = "userSevlet", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private RequestMapping rm;

    @Override
    public void init() throws ServletException {
        rm = new RequestMapping();
        rm.initMapping();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException {
    	log.debug("Method : {}, Request URI : {}, ServletPath : {}", 
    			request.getMethod(), request.getRequestURI());
    	String contextPath = request.getContextPath();
    	String servletPath = request.getServletPath();
    	
    	// URL �� servletPath�� �����Ǵ� controller�� ����
        Controller controller = rm.findController(servletPath);
        try {
        	// controller�� ���� request ó�� ��, �̵��� uri�� ��ȯ ����
            String uri = controller.execute(request, response);
            
 			// ��ȯ�� uri�� ���� forwarding �Ǵ� redirection ���θ� �����ϰ� �̵� 
            if (uri.startsWith("redirect:")) {	
            	// redirection ����
            	String targetUri = contextPath + uri.substring("redirect:".length());
            	response.sendRedirect(targetUri);	// redirect to url            
            }
            else {
            	// forwarding ����
            	RequestDispatcher rd = request.getRequestDispatcher(uri);
                rd.forward(request, response);		// forward to the view page
            }                   
        } catch (Exception e) {
            log.error("Exception : {}", e);
            throw new ServletException(e.getMessage());
        }
    }
}
