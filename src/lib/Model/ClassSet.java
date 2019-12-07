package lib.Model;

import java.util.ArrayList;

public class ClassSet {
    ArrayList<String> classSchool=new ArrayList<String>();
    ArrayList<String> classFloor=new ArrayList<String>();
    //ArrayList<String> classRoom=new ArrayList<String>();
    public ClassSet(){
        classSchool.add("望江");
        classSchool.add("江安");
        classFloor.add("一教A");
        classFloor.add("一教B");
        classFloor.add("一教C");
        classFloor.add("一教D");
        classFloor.add("综合楼B");
        classFloor.add("综合楼C");
    }

    public ArrayList<String> getClassSchool() {
        return classSchool;
    }

    public ArrayList<String> getClassFloor() {
        return classFloor;
    }
}
