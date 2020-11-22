package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.user.*;
import controller.client.*;
import controller.ceo.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
    	mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/client/main", new ForwardController("/client/clientMain.jsp"));
        mappings.put("/ceo/main", new ForwardController("/ceo/ceoMain.jsp"));
        mappings.put("/client/register/form", new ForwardController("/client/clientRegisterForm.jsp"));
        mappings.put("/ceo/register/form", new ForwardController("/ceo/ceoRegisterForm.jsp"));
        
        mappings.put("/client/register", new RegisterClientController());
        mappings.put("/ceo/register", new RegisterCeoController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
