package lib.Model;

/**
 * Created by ttop5 on 16-4-22.
 */
public class Course {
    public String getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCollege() {
        return college;
    }

    public String getCampus() {
        return campus;
    }

    public String getSection() {
        return section;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getWeekday() {
        return weekday;
    }

    public String getCourse_seq() {
        return course_seq;
    }

    public String getDuration() {
        return duration;
    }

    public String getBuilding() {
        return building;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getCapacity() {
        return capacity;
    }

    public int getCredit() {
        return credit;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public void setCourse_seq(String course_seq) {
        this.course_seq = course_seq;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String getWeek_start() {
        return week_start;
    }

    public void setWeek_start(String week_start) {
        this.week_start = week_start;
    }

    public String getWeek_end() {
        return week_end;
    }

    public void setWeek_end(String week_end) {
        this.week_end = week_end;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }



    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }
    String teacher_id;
    String course_id;
    String course_name;
    String college;
    String campus;
    String section;
    String attribute;
    String weekday;
    String course_seq;
    String duration;
    String building;
    String classroom;
    String capacity;
    String description;
    String refer;
    String week_start;
    String week_end;
    String Dname;
    String Mname;
    int credit,order;
}
