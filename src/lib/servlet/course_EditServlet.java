package lib.servlet;

import lib.Dao.CourseDao;
import lib.Dao.Dbutil;
import lib.Model.Course;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

@WebServlet(urlPatterns = "/course_Edit", name = "course_Edit")
public class course_EditServlet extends HttpServlet {
    Dbutil dbutil = new Dbutil();
    CourseDao courseDao = new CourseDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromdata = req.getParameter("fromdata");
        System.out.println(fromdata);
        JSONObject jo=JSONObject.fromObject(fromdata);
        Map<String,String> map=jo;
        //String password=map.get("password");
        CourseDao courseDao=new CourseDao();
        Course course = new Course();
        course.setCourse_id(map.get("id"));
        course.setCourse_seq(map.get("seq"));
     //   course.setTeacher_id(map.get("id"));
        course.setCourse_name(map.get("name"));
        course.setAttribute(map.get("attribute"));
        course.setDuration(map.get("duration"));
        course.setWeekday(map.get("days"));
        course.setDescription(map.get("description"));
        course.setRefer(map.get("refer"));
        course.setWeek_end(map.get("week_start"));
        course.setWeek_end(map.get("week_end"));



        Connection con = null;
        try {
            System.out.println("开始连接数据库");
            con = dbutil.getCon();
            System.out.println("数据库连接成功");
            if (!courseDao.t_Course_Edit(con, course)) {
                System.out.println("修改课程出错");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", "");
                jsonObject.put("seq", "");
                jsonObject.put("message", "edit course error.");
                jsonObject.put("ur", "");
                resp.getWriter().write(jsonObject.toString());
                System.out.println(jsonObject.toString());
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("message","success!");
                jsonObject.put("ur","course_manage.html");
                resp.setContentType("text/javascript;charset=utf-8");
                resp.getWriter().write(jsonObject.toString());
                System.out.println(jsonObject.toString());
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
