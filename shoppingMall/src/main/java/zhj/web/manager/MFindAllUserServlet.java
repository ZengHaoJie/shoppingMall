package zhj.web.manager;

import zhj.dao.UserDao;
import zhj.domain.User;
import zhj.service.UserService;
import zhj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 管理端查询所有用户
 */
@WebServlet("/mFindAllUserServlet")
public class MFindAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserService service = new UserServiceImpl();
        List<User> userList = service.findAllUser();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/MUserIndex.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
