CREATE TABLE student (
    Snumber     VARCHAR(13),  -- 学号
    Sname       VARCHAR(20),  -- 姓名
    Ssex        VARCHAR(2) ,  -- 性别
    Spassword   VARCHAR(20),  -- 密码
    Sage        NUMERIC(3, 0)   CHECK (Sage > 0),  -- 年龄
    Sphone      VARCHAR(11, 0),  -- 电话
    Semail      VARCHAR(20, 0),  -- 邮箱
    ShighSchool VARCHAR(10, 0),  -- 高中毕业学校
    Sorigo      VARCHAR(10, 0),  -- 籍贯
    Shobby      VARCHAR(100, 0), -- 爱好
    Dname       VARCHAR(50, 0),  -- 学生所属的系
    Mname       VARCHAR(50, 0),  -- 学生所属的专业
    Cname       VARCHAR(40),     -- 课程名
    Ctime       VARCHAR(10),     -- 上课时间
    Tname       VARCHAR(10),     -- 老师姓名

    PRIMARY KEY (Snumber),
    FOREIGN KEY (Dname) REFERENCES department(Dname) ON DELETE SET NULL,
    FOREIGN KEY (Mname) REFERENCES major(Mname) ON DELETE SET NULL,

);


CREATE TABLE course (
    Cnumber     VARCHAR(10),   -- 课程号
    Cname       VARCHAR(40),   -- 课程名   
    Corder      NUMERIC(2, 0), -- 课序号
    Ccredit     NUMERIC(2, 0)    CHECK (Ccredit > 0),   -- 学分  
    Cproperty   VARCHAR(4),    -- 课程属性: 选修/必修
    Ccapacity   NUMERIC(3, 0)    CHECK (Ccapacity > 0),   -- 课容量
    Ctime       VARCHAR(10),   -- 上课时间
    Cweek       VARCHAR(3) ,   -- 上课星期
    Mname       VARCHAR(50),   -- 所属专业
    Pschool     VARCHAR(5),    -- 校区
    Proom       VARCHAR(15),   -- 上课教室
    Tname       VARCHAR(10),   -- 姓名
    Dname       VARCHAR(20),   -- 姓名
    PRIMARY KEY (Cnumber, Corder),
    FOREIGN KEY (Mname) REFERENCES major(Mname) ON DELETE SET NULL,
    FOREIGN KEY (Pschool, Proom) REFERENCES place(Pschool, Proom) ON DELETE SET NULL,
    FOREIGN KEY (Dname) REFERENCES department(Dname) ON DELETE SET NULL,
    FOREIGN KEY (Tname) REFERENCES teacher(Tname) ON DELETE SET NULL
);


CREATE TABLE teacher (
    Tnumber     VARCHAR(10),  -- 工号
    Tname       VARCHAR(10),  -- 姓名
    Tsex        VARCHAR(2),   -- 性别
    Tage        NUMERIC(3, 0)     CHECK(Tage > 0),  -- 年龄
    Tplace      VARCHAR(50, 0), -- 办公地点
    Tresearch   VARCHAR(50, 0), -- 研究方向
    Tphone      VARCHAR(11),    -- 联系方式
    Tpost       VARCHAR(10),    -- 职称
    Temail      VARCHAR(50),    -- 邮箱
    Dname       VARCHAR(50, 0), -- 老师所属的系
    Cname       VARCHAR(40),    -- 课程名  
    Cnumber     VARCHAR(10),    -- 课程号
    Corder      NUMERIC(2, 0),  -- 课序号
    Ccredit     NUMERIC(2, 0),  -- 学分  
    Cproperty   VARCHAR(4),     -- 课程属性: 选修/必修
    PRIMARY KEY (Tnumber),
    FOREIGN KEY (Dname) REFERENCES department(Dname) ON DELETE SET NULL,
    FOREIGN KEY (Cname, Cnumber, Corder, Ccredit, Cproperty) 
    REFERENCES course(Cname, Cnumber, Corder, Ccredit, Cproperty) ON DELETE SET NULL
);


CREATE TABLE major (
    Mnumber     VARCHAR(10),     -- 专业号
    Mname       VARCHAR(50, 0),  -- 专业名
    Mphone      VARCHAR(11),     -- 专业教务联系方式
    Mintroduce  VARCHAR(200, 0), -- 专业介绍
    Dname       VARCHAR(50, 0),  -- 专业所属的系
    FOREIGN KEY (Dname) REFERENCES department(Dname) ON DELETE SET NULL

);

CREATE TABLE department (
    Dnumber     VARCHAR(10),  -- 系号
    Dname       VARCHAR(20),  -- 系名
    Dphone      VARCHAR(11),
    Dintroduce  VARCHAR(200),
    PRIMARY KEY (Dnumber)
);

CREATE TABLE place (
    Pschool     VARCHAR(5),   -- 校区
    Proom       VARCHAR(15),   -- 教室
);
