package zhj.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import zhj.domain.User;
import zhj.service.UserService;
import zhj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 用户的登录验证
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String vcode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        session.removeAttribute("code");
        if (code == null){
            request.setAttribute("msg","验证码已过期，请重新登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        if (vcode == null || !code.equalsIgnoreCase(vcode)){
            request.setAttribute("msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        UserService service = new UserServiceImpl();
        User user = service.login(username,password);
        if (user != null){
            session.setAttribute("user",user);
            response.sendRedirect("/indexServlet");
        }else {
            request.setAttribute("msg","用户名密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
