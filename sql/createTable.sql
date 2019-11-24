CREATE TABLE student (
    Snumber     NUMERIC(13, 0)  not NULL,  -- 学号
    Sname       VARCHAR(20)     not NULL,  -- 姓名
    Ssex        VARCHAR(2)      not NULL,  -- 性别
    Sage        NUMERIC(3, 0)   not NULL,  -- 年龄
    Sphone      NUMERIC(11, 0)  not NULL,  -- 电话
    Semail      VARCHAR(20, 0)  not NULL,  -- 邮箱
    ShighSchool VARCHAR(10, 0)  not NULL,  -- 高中毕业学校
    Sorigo      VARCHAR(10, 0)  not NULL,  -- 籍贯
    Shobby      VARCHAR(100, 0),           -- 爱好
    Dname       VARCHAR(50, 0)  not NULL,  -- 学生所属的系
    Mname       VARCHAR(50, 0)  not NULL,  -- 学生所属的专业
    Cname       VARCHAR(40)    not NULL,   -- 课程名
    Ctime       TIME           not NULL,   -- 上课时间
    Tname       VARCHAR(10)     not NULL,  -- 老师姓名

    PRIMARY KEY (Snumber),
    FOREIGN KEY (Dname) REFERENCES department(Dname) ON DELETE SET NULL,
    FOREIGN KEY (Mname) REFERENCES major(Mname) ON DELETE SET NULL,

);


CREATE TABLE course (
    Cnumber     NUMERIC(10, 0) not NULL,   -- 课程号
    Cname       VARCHAR(40)    not NULL,   -- 课程名   
    Corder      NUMERIC(2, 0)  not NULL,   -- 课序号
    Ccredit     NUMERIC(2, 0)  not NULL,   -- 学分  
    Cproperty   VARCHAR(4)     not NULL,   -- 课程属性: 选修/必修
    Ccapacity   NUMERIC(3, 0)  not NULL,   -- 课容量
    Ctime       TIME           not NULL,   -- 上课时间
    Cweek       VARCHAR(3)     not NULL,   -- 上课星期
    Mname       VARCHAR(50)    not NULL,   -- 所属专业
    Pschool     VARCHAR(5)     not NULL,   -- 校区
    Proom       VARCHAR(15)    not NULL,   -- 上课教室
    Tname       VARCHAR(10)     not NULL,  -- 姓名
    Dname       VARCHAR(20, 0)  not NULL,  -- 姓名
    PRIMARY KEY (Cnumber, Corder),
    FOREIGN KEY (Mname) REFERENCES major(Mname) ON DELETE SET NULL,
    FOREIGN KEY (Pschool, Proom) REFERENCES place(Pschool, Proom) ON DELETE SET NULL,
    FOREIGN KEY (Dname) REFERENCES department(Dname) ON DELETE SET NULL,
    FOREIGN KEY (Tname) REFERENCES teacher(Tname) ON DELETE SET NULL
);


CREATE TABLE teacher (
    Tnumber     NUMERIC(10, 0)  not NULL,  -- 工号
    Tname       VARCHAR(10)     not NULL,  -- 姓名
    Tsex        VARCHAR(2)      not NULL,  -- 性别
    Tage        NUMERIC(3, 0)   not NULL,  -- 年龄
    Tprofile    VARCHAR(200, 0) not NULL,  -- 个人简介
    Tachievement VARCHAR(200, 0) not NULL, -- 个人成就
    Tplace      VARCHAR(50, 0)  not NULL,  -- 办公地点
    Tresearch   VARCHAR(50, 0)  not NULL,  -- 研究方向
    Tduty       VARCHAR(10, 0)  not NULL,  -- 职务
    Tphone      NUMERIC(11, 0)  not NULL,  -- 联系方式
    Tpost       VARCHAR(10)  not NULL,     -- 职称
    Tpage       VARCHAR(50)  not NULL,     -- 个人主页
    Temail      VARCHAR(50)  not NULL,     -- 邮箱
    Dname       VARCHAR(50, 0)  not NULL,  -- 老师所属的系
    Cname       VARCHAR(40)    not NULL,   -- 课程名  
    Cnumber     NUMERIC(10, 0) not NULL,   -- 课程号
    Corder      NUMERIC(2, 0)  not NULL,   -- 课序号
    Ccredit     NUMERIC(2, 0)  not NULL,   -- 学分  
    Cproperty   VARCHAR(4)     not NULL,   -- 课程属性: 选修/必修
    PRIMARY KEY (Tnumber),
    FOREIGN KEY (Dname) REFERENCES department(Dname) ON DELETE SET NULL,
    FOREIGN KEY (Cname, Cnumber, Corder, Ccredit, Cproperty) 
    REFERENCES course(Cname, Cnumber, Corder, Ccredit, Cproperty) ON DELETE SET NULL
);

CREATE TABLE major (
    Mnumber     NUMERIC(10, 0)  not NULL,  -- 专业号
    Mname       VARCHAR(50, 0)  not NULL,  -- 专业名
    Mphone      NUMERIC(11, 0)  not NULL,  -- 专业教务联系方式
    Mintroduce  VARCHAR(200, 0) not NULL,  -- 专业介绍
    Dname       VARCHAR(50, 0)  not NULL,  -- 老师所属的系
    FOREIGN KEY (Dname) REFERENCES department(Dname) ON DELETE SET NULL

);

CREATE TABLE department (
    Dnumber     NUMERIC(10, 0)  not NULL,  -- 系号
    Dname       VARCHAR(20, 0)  not NULL,  -- 系名
    Dphone      NUMERIC(11, 0)  not NULL,
    Dintroduce  VARCHAR(200, 0) not NULL,
    PRIMARY KEY (Dnumber)
);

CREATE TABLE place (
    Pschool     VARCHAR(5)      not NULL,   -- 校区
    Proom       VARCHAR(15)     not NULL,   -- 教室
);
