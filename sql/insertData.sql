delete from course;
delete from teacher;
delete from student ;
delete from major ;
delete from department;
delete from place;



insert into course values ('101260030', '艺术设计史', '01', '3', '必修', '50', '1-18周', '周一，3-4节','艺术系');
insert into course values ('101272010', '影视编导专题讲座、影视表演专题讲座', '02', '1', '选修', '100', '2-7周', '周一，10-11节','艺术系');
insert into course values ('101953030', '景观设计史', '05', '3', '必修', '60', '1-18周', '周一，5-7节','艺术系');
insert into course values ('304026020', '汇编语言程序设计', '02', '2','必修','50', '1-18周', '周二，5-7节','计算机系');




insert into teacher values ('10101','李明', '男', '42', '江安 ,二基楼 B502', '图形图像研究',  '13698761234', '教授',  '3456671234@qq.com',  '计算机系' , '汇编语言程序设计' ,'304026020'  ,'02','02''必修');
insert into teacher values ('10102','李红', '女', '41', '江安 ,二基楼 B503', '人工智能',  '13698761254', '副教授',  '3456671284@qq.com',  '计算机系' , '汇编语言程序' ,'304026021'  ,'03','02''必修');



insert into student values ('2016181962003', '徐梦玲', '女', '1111', '22', '18698763550', '1255271234@qq.com', '天水第一中学', '甘肃 天水', '看综艺', '法学系', '法学专业');

insert into student values ('2016141462004', '李泽洋', '男', '2222', '20', '13898093534', '3689671234@qq.com', '成都第二中学', '四川 成都', '打游戏', '艺术系', '油画专业');

insert into student values ('2016171072005','钱浩军', '男', '3333', '23', '19078761234', '3422451234@qq.com', '陇南第一中学', '甘肃 陇南', '看书', '数学系', '基础数学专业');

insert into student values ('2016141460006', '王海波', '男', '4444', '22', '13600231234', '5636671234@qq.com', '绵阳第二中学', '四川 绵阳', '看书', '计算机系', '计算机科学与技术专业');



insert into major values ('3040000001',  '计算机科学与技术专业', '027-7000011', '学习编程',  '计算机系');
insert into major values ('3040000002',  '油画专业', '027-7000012', '学习画画',  '艺术系');


insert into department values ('2016000001', '计算机系', '13348768434', '全国排名第十');
insert into department values ('2016000002', '艺术系', '13343458434', '全国排名第八');

insert into place values ('江安校区', '一教A101');
insert into place values ('江安校区', '一教B101');
insert into place values ('江安校区', '一教C101');
insert into place values ('望江校区', '基础教学楼C201');
