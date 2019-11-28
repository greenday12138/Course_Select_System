package lib.servlet;

import lib.Dao.Dbutil;
import lib.Dao.UserDao;
import lib.Model.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;


@WebServlet(urlPatterns = "/signin", name = "signin")
public class SigninServlet extends HttpServlet {
    Dbutil dbutil = new Dbutil();
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入doPost");
        String fromdata = req.getParameter("fromdata");
        JSONObject jo=JSONObject.fromObject(fromdata);
        System.out.println("2");
        System.out.println(jo);
        Map<String,String> map=jo;
        String id=map.get("id");
        System.out.println(id);
        String password=map.get("password");

        User user = new User(id, password);
        Connection con = null;
        try {
            System.out.println("开始连接数据库");
            //con = dbutil.getCon();
            System.out.println("数据库连接成功");
           // User currentUser = userDao.signin(con, user);

            User currentUser=new User(id,password);
            currentUser.setName("111");

            if (currentUser == null){
                System.out.println("出错");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", "");
                jsonObject.put("name", "");
                jsonObject.put("message", "错误");

            }
            else {
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", currentUser);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", currentUser.getId());
                jsonObject.put("name", currentUser.getName());
                jsonObject.put("message", "正确");
                jsonObject.put("ur", "teacher/index_teacher.html");
                //System.out.println(jsonObject);
                resp.getWriter().write(jsonObject.toString());

                //resp.send
                //jsonObject.toString();
                /*if (currentUser.getRole() == 0) {
                    resp.sendRedirect("admin/index.jsp");
                } else if (currentUser.getRole() == 1){
                    resp.sendRedirect("resources/pages/index_teacher.html");
                } else {
                    resp.sendRedirect("student/index.jsp");
                }*/
              //  System.out.println("跳转");
                //resp.sendRedirect("resources/pages/teacher/index_teacher.html");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                dbutil.closeCon(con);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
