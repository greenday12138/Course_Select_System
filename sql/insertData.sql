use redPanda;
delete from tc;
delete from sc;
delete from course;
delete from teacher;
delete from student;
delete from major;
delete from department;



insert into department values ('2016000001', '计算机学院', '13348768434', '全国排名第十');
insert into department values ('2016000002', '艺术学院', '18343480464', '全国排名第八');
insert into department values ('2016000003', '法学学院', '13355658403', '全国排名第三');
insert into department values ('2016000004', '经济学院', '15843458464', '全国排名第六');
insert into department values ('2016000005', '化学学院', '16343423489', '全国排名第四');
insert into department values ('2016000006', '公共管理学院', '15343458456', '全国排名第三十');
insert into department values ('2016000007', '建筑学院', '18343454522', '全国排名第十八');




insert into major values ('3040000001',  '计算机科学与技术专业', '027-7000011', '学习编程',  '2016000001');
insert into major values ('3040000002',  '油画专业', '027-7000012', '学习画画',  '2016000002');
insert into major values ('3040000003',  '声乐专业', '027-7000013', '学习乐曲',  '2016000002');
insert into major values ('3040000004',  '法学专业', '027-7000022', '学习法律',  '2016000003');
insert into major values ('3040000005',  '物联网专业', '027-7000032', '学习网络',  '2016000001');
insert into major values ('3040000006',  '国民经济管理专业', '027-7000044', '学习经济',  '2016000004');
insert into major values ('3040000007',  '编导专业', '027-7000056', '学习画画',  '2016000002');
insert into major values ('3040000008',  '化学工程专业', '027-7000034', '学习化学工艺',  '2016000005');
insert into major values ('3040000009',  '行政管理专业', '027-7000010', '学习管理',  '2016000006');
insert into major values ('3040000010',  '金融学专业', '027-7000089', '学习金融',  '2016000003');
insert into major values ('3040000011',  '教育经济管理专业', '027-7000080', '学习教育经济',  '2016000003');
insert into major values ('3040000012',  '土木工程专业', '027-7000062', '学习土木工程',  '2016000007');



insert into student values ('2016171072005','钱浩军', '男', '3333', '23', '19078761234', '3422451234@qq.com', '陇南第一中学', '甘肃 陇南', '看书', '2016000002', '3040000002');
insert into student values ('2016141460006', '王海波', '男', '4444', '22', '13600231234', '5636671234@qq.com', '绵阳第二中学', '四川 绵阳', '看书', '2016000001', '3040000001');
insert into student values ('2016181962002', '李明', '男', '1234', '22', '13698761234', '3456671234@qq.com', '成都第二中学', '四川 成都', '看书', '2016000002', '3040000003');
insert into student values ('2016181962003', '徐梦玲', '女', '0306', '22', '18698763550', '1255271234@qq.com', '天水第一中学', '甘肃 天水', '看综艺', '2016000003', '3040000004');
insert into student values ('2016141462004', '李泽洋', '男', '1348', '20', '13898093534', '3689671234@qq.com', '成都第二中学', '四川 成都', '打游戏', '2016000002', '3040000002');
insert into student values ('2016171900108','李思婷', '女', '1369', '23', '13690251234', '3501671234@qq.com', '成都第二十中学', '四川 成都', '读书', '2016000001', '3040000005');
insert into student values ('2016171902009', '孟雨灵', '女', '1314', '22', '13604672234', '893471234@qq.com', '成都阳明中学', '四川 成都', '运动', '2016000004', '3040000006');
insert into student values ('2016161505100','陈梓菲', '女', '1520', '20', '13691471234', '3466671256@qq.com', '成都第二中学', '四川 成都', '读书', '2016000002', '3040000007');
insert into student values ('2016161803011', '罗明瑞', '男', '1212', '22', '13639061234', '3601671234@qq.com', '成都第四中学', '四川 成都', '运动', '2016000005', '3040000008');
insert into student values ('2016141540012', '廖温峰', '男', '1111', '22', '18398761234', '5636674534@qq.com', '北京第二中学', '北京', '旅游', '2016000006','3040000009');
insert into student values ('2016167820013', '刘道涛', '男', '1001', '22', '17692371234', '346671004@qq.com', '上海第二附属中学', '上海', '打篮球', '2016000004', '3040000010');
insert into student values ('2016148730014', '胡斯涵', '男', '0601', '22', '18398561234', '39023767104@qq.com', '成都第二附属中学', '四川 成都', '读书', '2016000006', '3040000011');
insert into student values ('2016456790015', '李清素', '女', '1415', '22', '13348768434', '7346671614@qq.com', '武汉第二中学', '湖北 武汉', '读书', '2016000007', '3040000012');



insert into teacher values ('10101','李明', '男', '5555', '42', '江安 ,二基楼 B502', '图形图像研究',  '13698761234', '教授',  '3456671234@qq.com',  '2016000001');
insert into teacher values ('10102','李红', '女', '6666', '41', '江安 ,二基楼 B503', '人工智能',  '13698761254', '副教授',  '3456671284@qq.com',  '2016000001');
insert into teacher values ('10103','张科', '男', '1234', '50', '望江 ,综合楼 B502', '油画',  '18398761234', '教授',  '5636674534@qq.com',  '2016000002');
insert into teacher values ('10104','刘涛', '女', '5678', '41', '望江 ,综合楼 B503', '法律文书',  '19045761254', '副教授',  '3456671234@qq.com',  '2016000003');
insert into teacher values ('10105','李洋', '男', '5656', '45', '望江 ,综合楼 B502', '国民经济',  '13698761234', '教授',  '39023767104@qq.com',  '2016000004');
insert into teacher values ('10106','孟雨', '女', '3366', '36', '望江 ,综合楼 B503', '化工工艺',  '17692371234', '副教授',  '1255271234@qq.com',  '2016000005');
insert into teacher values ('10107','王波', '男', '5555', '49', '江安 ,二基楼 B502', '公共管理究',  '18900371234', '教授',  '5636671234@qq.com',  '2016000006');
insert into teacher values ('10108','徐梦', '女', '6666', '43', '江安 ,二基楼 B503', '建筑',  '13348761254', '副教授',  '7346671614@qq.com',  '2016000007');





insert into course values ('101260030', '艺术设计史', '01', '3', '必修', '50', '1-18周', '星期一', '0304','江安', '第一教学楼C座','101', '2016000002', '3040000002');
insert into course values ('304026020', '汇编语言程序设计', '02', '2','必修','50', '1-18周', '星期二', '0507', '望江', '第一教学楼A座','103', '2016000001', '3040000001');
insert into course values ('304026025', '算法设计', '03', '2','必修','50', '1-18周', '星期三', '0508', '江安', '第一教学楼B座','103', '2016000001', '3040000001');
insert into course values ('101260032', 'c++', '02', '3', '必修', '50', '1-18周', '星期四', '0809','江安', '第一教学楼A座','102', '2016000001', '3040000001');
insert into course values ('101272010', '影视编导专题讲座、影视表演专题讲座', '02', '1', '选修', '100', '2-7周', '星期一','0102','江安', '第一教学楼D座', '102', '2016000002','3040000007');
insert into course values ('101953030', '景观设计史', '05', '3', '必修', '60', '1-18周', '星期一','0507','江安','第一教学楼A座','104','2016000002','3040000002');
insert into course values ('103003020', '法理学', '03', '2', '必修', '60', '1-18周', '星期三','0102','江安','第一教学楼B座','104','2016000003','3040000004');
insert into course values ('103005020', '法律文书', '04', '2', '必修', '60', '1-18周', '星期四','0102','江安','综合楼B座','104','2016000003','3040000004');




insert into sc values ('1', '2016141460006', '304026020', '02');
insert into sc values ('2', '2016181962002', '304026025', '03');
insert into sc values ('3', '2016181962003', '101260032', '02');
insert into sc values ('4', '2016141462004', '101272010', '02');
insert into sc values ('5', '2016171900108', '101953030', '05');
insert into sc values ('6', '2016171902009', '103003020', '03');
insert into sc values ('7', '2016161505100', '103005020', '04');
insert into sc values ('8', '2016171072005', '101260030', '01');




insert into tc  values('1','10102','101260030', '01');
insert into tc  values('2','10101','304026025', '03');
insert into tc  values('3','10102','101260032', '02');
insert into tc values ('4', '10103', '101272010', '02');
insert into tc  values('5','10103','101953030', '05');
insert into tc  values('6','10104','103003020', '03');
insert into tc  values('7','10104', '103005020', '04');
insert into tc values ('8', '10101', '304026020', '02');