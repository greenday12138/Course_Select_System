delete from tc;
delete from sc;
delete from course;
delete from teacher;
delete from student;
delete from major;
delete from department;



insert into department values ('2016000001', '计算机系', '13348768434', '全国排名第十');
insert into department values ('2016000002', '艺术系', '13343458434', '全国排名第八');

insert into major values ('3040000001',  '计算机科学与技术专业', '027-7000011', '学习编程',  '2016000001');
insert into major values ('3040000002',  '油画专业', '027-7000012', '学习画画',  '2016000002');

insert into student values ('2016171072005','钱浩军', '男', '3333', '23', '19078761234', '3422451234@qq.com', '陇南第一中学', '甘肃 陇南', '看书', '2016000002', '3040000002');
insert into student values ('2016141460006', '王海波', '男', '4444', '22', '13600231234', '5636671234@qq.com', '绵阳第二中学', '四川 绵阳', '看书', '2016000001', '3040000001');

insert into teacher values ('10101','李明', '男', '5555', '42', '江安 ,二基楼 B502', '图形图像研究',  '13698761234', '教授',  '3456671234@qq.com',  '2016000001');
insert into teacher values ('10102','李红', '女', '6666', '41', '江安 ,二基楼 B503', '人工智能',  '13698761254', '副教授',  '3456671284@qq.com',  '2016000001');

insert into course values ('101260030', '艺术设计史', '01', '3', '必修', '50', '1-18周', '星期一', '0304','江安', '一教A座','A101', '2016000002', '3040000002');
insert into course values ('304026020', '汇编语言程序设计', '02', '2','必修','50', '1-18周', '星期二', '0507', '望江', '一教A座','A103', '2016000001', '3040000001');

insert into sc values ('0', '2016171072005', '101260030', '01');
insert into sc values ('1', '2016141460006', '304026020', '02');

insert into tc values ('0', '10101', '304026020', '02');
insert into tc  values('1','10102','101260030', '01');

