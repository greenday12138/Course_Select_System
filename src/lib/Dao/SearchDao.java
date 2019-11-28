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
        String course_id=map.get("course_id");
        String course_name=map.get("course_name");
        String teacher_name=map.get("teacher_name");
        String college=map.get("college");
        String campus=map.get("campus");
        String section=map.get("section");
        String attribute=map.get("attribute");
        String weekday=map.get("weekday");
        PreparedStatement pstmt=null;
        Course cr=null;
        Teacher tr=null;
        try{
            String sql=null;
            sql="";
            pstmt=con.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            JSONObject js=null;
            JSONArray jsa=new JSONArray();
            if(rs.next()){
                cr=new Course();
                tr=new Teacher();
                //根据查询结果填充两个类，并且构造json发送

                //添加json项

            }
        }
    }
}
