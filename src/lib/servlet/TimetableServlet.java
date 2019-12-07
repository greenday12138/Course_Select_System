package lib.servlet;

import lib.Dao.CourseDao;
import lib.Dao.Dbutil;
import lib.Model.Course;
import lib.Model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(urlPatterns = "/timetable", name = "timetable")
public class TimetableServlet extends HttpServlet {
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
        JSONObject jo=JSONObject.fromObject("fromdata"+fromdata);
        Map<String,String> map=jo;
        String id=map.get("id");
        // int len=id.length();

        //String password=map.get("password");

        User user = new User();
        user.setId(id);
        Connection con = null;
        try {
            ArrayList<Course> allCourse= new ArrayList<Course>();

            System.out.println("开始连接数据库");
            con = dbutil.getCon();
            System.out.println("数据库连接成功");


            allCourse=courseDao.getCourseTimetable(con,user);

            //HttpSession session = req.getSession();
            //session.setAttribute("currentUser", currentUser);
            //JSONObject []jsonObject = new JSONObject[100];
            JSONArray allJsonObject=new JSONArray();

            for (Course course:allCourse) {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("title",course.getCourse_name());
                jsonObject.put("description",course.getDeacription());
                jsonObject.put("daysOfWeek",course.getWeekday());
                jsonObject.put("startTime",course.getStart_time());
                jsonObject.put("endTime",course.getEnd_time());
                jsonObject.put("startRecur",course.getStart_recur());
                jsonObject.put("endRecur",course.getEnd_recur());
                jsonObject.put("textColor",course.getTextcolor());
                jsonObject.put("backgroundColor",course.getBackgroundcolor());
                jsonObject.put("borderColor",course.getBordercolor());
                allJsonObject.add(jsonObject);
            }
            resp.setContentType("text/javascript;charset=utf-8");
            resp.getWriter().write(allJsonObject.toString());
            System.out.println(allJsonObject.toString());

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
