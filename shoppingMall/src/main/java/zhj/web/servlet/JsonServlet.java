package zhj.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import zhj.service.UserService;
import zhj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询注册的用户名是否存在
 */
@WebServlet("/jsonServlet")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        UserService service = new UserServiceImpl();
        boolean flag = true;
        if (username != null && username.length() > 0){
            flag = service.findByName(username);
        }
        Map<String,Boolean> map = new HashMap<>();
        map.put("exist",flag);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
