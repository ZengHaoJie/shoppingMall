package zhj.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import zhj.domain.Orders;
import zhj.domain.User;
import zhj.service.GoodsService;
import zhj.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户添加订单
 */
@WebServlet("/addOrderServlet")
public class AddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        String gid = request.getParameter("gid");
        String num = request.getParameter("num");
        String money = request.getParameter("money");
        Orders order = new Orders();
        order.setUid(uid);
        order.setGid(Integer.parseInt(gid));
        order.setNum(Integer.parseInt(num));
        order.setMoney(Double.parseDouble(money));
        GoodsService service = new GoodsServiceImpl();
        Boolean flag = service.addOrder(order);
        Map<String,Boolean> map = new HashMap<>();
        map.put("exist",flag);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
