package zhj.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 获取验证码
 */
@WebServlet("/codeServlet")
public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义验证码的长和宽
        int height = 30;
        int width = 80;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //创建画笔对象g
        Graphics g = image.getGraphics();
        g.setColor(Color.GRAY);
        //填充一个矩形
        g.fillRect(0,0,width,height);
        g.setColor(Color.BLACK);
        //设置矩形边框
        g.drawRect(0,0,width-1,height-1);

        //生成随机数
        Random r = new Random();
        //定义随机字母
        String str = "ABCDEFGHIJKLMNOQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        g.setColor(Color.YELLOW);
        g.setFont(new Font("黑体",Font.BOLD,22));
        //生成4位随机验证码
        for (int i = 1; i <= 4; i++) {
            int index = r.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            g.drawString(ch+"",width/6*i,height/4*3);
        }

        //获取验证码
        String code = sb.toString();
        //把验证码存储到session中
        request.getSession().setAttribute("code",code);
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
