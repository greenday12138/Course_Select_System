package lib.Dao;

import lib.Model.Course;
import lib.Model.Teacher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class SearchDao {
    public void Search(Map<String,String> map, Connection con) throws SQLException {
        Course cr=null;
        Teacher tr=null;
        cr.setCourse_id(map.get("course_id"));//
        cr.setCourse_name(map.get("course_name"));//
        tr.setName(map.get("teacher_name"));
        cr.setCollege(map.get("college"));
        cr.setCampus(map.get("campus"));//
        cr.setSection(map.get("section"));
        cr.setAttribute(map.get("attribute"));//
        cr.setWeekday(map.get("weekday"));//
        PreparedStatement pstmt=null;


        try {
            String sql = null;
            sql = "select * from course where (Dnumber)(Cnumber=? AND Cname=? AND Cschool=? AND Cpropery=? AND Cweek=? )  ";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,cr.getCourse_id());
            pstmt.setString(2,cr.getCourse_name());
            pstmt.setString(3,cr.getCampus());
            pstmt.setString(4,cr.getAttribute());
            pstmt.setString(5,cr.getWeekday());//还少了一个学院
            ResultSet rs = pstmt.executeQuery();
            JSONObject js = null;
            JSONArray jsa = new JSONArray();
            if (rs.next()) {
                cr = new Course();
                tr = new Teacher();
                //根据查询结果填充两个类，并且构造json发送

                //添加json项

            }
        } finally {

        }

    }
}
