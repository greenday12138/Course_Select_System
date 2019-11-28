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

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    String course_id,course_name,college,campus,section,attribute,weekday,course_seq,duration,building,classroom,capacity;
    int credit;
}
