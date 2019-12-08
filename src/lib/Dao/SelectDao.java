package lib.Dao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class SelectDao {
    public JSONArray select(JSONArray ja, Connection con,String id){
        JSONObject jo=null;
        Map<String,String> map=null;
        PreparedStatement pstmt=null;
        String sql=null;
        ResultSet rs=null;
        JSONArray result=new JSONArray();
        try{
        for(int i=0;i<ja.size();i++) {

            map = ja.getJSONObject(i);
            sql="select * from sc where Cnumber="+map.get("course_id")+" and Corder="+map.get("course_seq")+" and Snumber="+id+";";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            if(rs.next()){
                jo=new JSONObject();
                jo.put("course_id",rs.getString("Cnumber"));
                jo.put("course_seq",rs.getString("Corder"));
                jo.put("info","0");
                result.add(jo);
                continue;
            }
            //计算该课程有多少学生选了
            sql="select count(Snumber) as co ,Csection  from sc,course where course.Cnumber=sc.Cnumber and course.Corder=sc.Corder and course.Cnumber="+ map.get("course_id")+" and course.Corder="+map.get("course_seq")+";";
            System.out.println(sql);
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            int co=0;
            Map<Integer,Integer> has=new HashMap<>();
            while(rs.next()){
                co=rs.getInt("co");
                int tem = rs.getInt("Csection");
                int ta = tem % 100;
                int tb = tem / 100;

            }
            //查询课容量
            sql = "select * from course where Cnumber=" + map.get("course_id") + " and Corder=" + map.get("course_seq") + ";";
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            int capacity=0;
            while (rs.next()){
                capacity=rs.getInt("Ccapacity");
            }
            //可能插入新纪录
            if(capacity-co!=0){
                sql="insert into sc(Snumber,Cnumber,Corder) values('"+id+"'"+","+"'"+map.get("course_id")+"'"+","+"'"+map.get("course_seq")+"'"+")"+";";
                System.out.println(sql);
                pstmt=con.prepareStatement(sql);
                pstmt.execute();
                jo=new JSONObject();
                jo.put("course_id",map.get("course_id"));
                jo.put("course_seq",map.get("course_seq"));
                jo.put("info","1");
                result.add(jo);
            }
            else{
                jo=new JSONObject();
                jo.put("course_id",map.get("course_id"));
                jo.put("course_seq",map.get("course_seq"));
                jo.put("info","0");
                result.add(jo);
            }
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result ;
    }
}
