package lib.Dao;

import lib.Model.Course;
import lib.Model.Teacher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchDao {
    public JSONArray Search(Map<String,String> map, Connection con) throws SQLException {
        JSONArray jsa = new JSONArray();
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
            sql="select distinct Cnumber ,Tname from tc,teacher where tc.Tnumber=teacher.Tnumber and teacher.Tname like ?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,"%"+tr.getName()+"%");
            ResultSet rs=pstmt.executeQuery();
            Set<String> set1=new HashSet<String>();
            while(rs.next()){
                set1.add(rs.getString("Cnumber"));
                if(tr.getName().equals(""))
                tr.setName(rs.getString("Tname"));
            }
            sql="select distinct Dname,Cnumber from course,department where course.Dnumber=department.Dnumber And Dname like ?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,"%"+cr.getCollege());
            Set<String> set2=new HashSet<String>();
            while(rs.next()){
                if(cr.getCollege().equals(""))
                    cr.setCollege(rs.getString("Dname"));
                set2.add(rs.getString("Cnumber"));
            }
            sql = "select * from course where Cnumber like ? AND Cname like ? AND Cschool like ? AND Cpropery like ? AND Cweek like ?  ";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,"%"+cr.getCourse_id()+"%");
            pstmt.setString(2,"%"+cr.getCourse_name()+"%");
            pstmt.setString(3,"%"+cr.getCampus()+"%");
            pstmt.setString(4,"%"+cr.getAttribute()+"%");
            pstmt.setString(5,"%"+cr.getWeekday()+"%");
            rs = pstmt.executeQuery();
            JSONObject js = null;
            while(rs.next()) {
                boolean p=false;
                if(!cr.getSection().equals("")) {
                    int tem = rs.getInt("Csection");
                    int ta = tem % 100;
                    int tb = tem / 100;
                    if (Integer.parseInt(cr.getSection()) >= tb && Integer.parseInt(cr.getSection()) <= ta)
                        p = true;
                }
                else
                    p=true;
                if(p&&set1.contains(rs.getString("Tname"))&&set2.contains(rs.getString("Dname"))){
                    if(tr.getName().equals("")){
                        sql="select distinct Tname from tc,teacher where "+rs.getString("Cnumber")+"=Cnumber and teacher.Tnumber=tc.Tnumber";
                        PreparedStatement ppp=con.prepareStatement(sql);
                        ResultSet rrr=ppp.executeQuery();
                        if(rrr.next())
                            tr.setName(rrr.getString("Tname"));
                    }
                    if(cr.getCollege().equals("")){
                        sql="select distinct Dname from department,course where department.Dnumber=course.Dnumber and Cnumber="+rs.getString("Cnumber");
                        PreparedStatement ppp=con.prepareStatement(sql);
                        ResultSet rrr=ppp.executeQuery();
                        if(rrr.next())
                            cr.setCollege(rrr.getString("Dname"));
                    }
                    js=new JSONObject();
                    Course crp = new Course();
                    js.put("weekday",rs.getString("Cweek"));
                    js.put("attribute",rs.getString("Cproperty"));
                    js.put("campus",rs.getString("Cschool"));
                    js.put("course_name",rs.getString("Cname"));
                    js.put("course_id",rs.getString("Cnumber"));
                    js.put("building",rs.getString("Cfoor"));
                    js.put("capacity",rs.getInt("Ccapacity"));
                    js.put("classroom",rs.getString("Croom"));
                    js.put("course_seq",rs.getInt("Corder"));
                    js.put("credit",rs.getInt("Ccredit"));
                    js.put("section",rs.getString("Csection"));
                    js.put("duration",rs.getString("Ctime"));
                    js.put("teacher_name",tr.getName());
                    //添加json项
                    jsa.add(js);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsa;
    }
}
