/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : mangersystem

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 15/06/2020 21:52:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `g_Chinese` double(30, 0) NULL DEFAULT NULL COMMENT '语文分数',
  `g_math` double(30, 0) NULL DEFAULT NULL COMMENT '数学分数',
  `g_english` double(30, 0) NULL DEFAULT NULL COMMENT '英语分数',
  `g_polity` double(30, 0) NULL DEFAULT NULL COMMENT '思政分数',
  `g_music` double(30, 0) NULL DEFAULT NULL COMMENT '音乐分数',
  `g_history` double(30, 0) NULL DEFAULT NULL COMMENT '历史分数',
  `g_computer` double(30, 0) NULL DEFAULT NULL COMMENT '计算机分数',
  `g_sum` double(30, 0) NULL DEFAULT NULL COMMENT '总分',
  `g_avg` double(30, 0) NULL DEFAULT NULL COMMENT '平均分'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1915925001', 0, 100, 100, NULL, NULL, NULL, NULL, 200, 29);
INSERT INTO `grade` VALUES ('1915925002', 20, 80, 50, NULL, NULL, NULL, NULL, 150, 21);
INSERT INTO `grade` VALUES ('1915925003', 90, NULL, 50, NULL, NULL, 0, NULL, 140, 20);
INSERT INTO `grade` VALUES ('1915925004', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925005', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925006', NULL, NULL, 100, NULL, NULL, NULL, NULL, 100, 14);
INSERT INTO `grade` VALUES ('1915925007', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925008', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925009', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925010', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925011', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925012', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925013', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925014', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925015', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925016', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925017', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925018', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925019', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925020', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925021', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925022', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925023', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925024', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925025', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925026', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925027', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925028', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925029', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925030', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925031', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925032', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925033', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `grade` VALUES ('1915925034', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);

-- ----------------------------
-- Table structure for manger
-- ----------------------------
DROP TABLE IF EXISTS `manger`;
CREATE TABLE `manger`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of manger
-- ----------------------------
INSERT INTO `manger` VALUES (1, '1915925001', '123456', '152号管理员');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学科',
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '题库',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, '英语', '--The headmaster hurried to the concert hall only _________ the speaker_______. <br>A.to find; left  <br>B. to find; gone <br>C.finding; left  <br>D. finding; gone#B~\r\n-- failed again. I wish I _________ harder.?―But you _________. <br>A.had worked; hadn’t  <br>B. worked; don’t <br>C.had worked; didn’t  <br>D. worked; didn’t#C~\r\n--Why not go out for a walk before breakfast? ―Oh，yes. _________ is my favorite time of day.  <br>A.In the early morning   <br>B. Early morning  <br>C.The early of morning   <br>D. The early morning that#B~\r\n--It was not until liberation that _________ to his hometown.  <br>A.did he return   <br>B. was he returned  <br>C.he did return   <br>D. he returned#D~\r\n--I\'d like a pen which _________ well.―Will this one _________? <br>A.writes; do  <br>B. writes; work <br>C. is written; do  <br>D. is written;work#A~\r\n--Can you finish the writing on time?? --_________.? <br>A.Never mind  <br>B. With pleasure <br>C.No problem  <br>D. All right#C~\r\n--When _______ we meet again?? --_______ it any time you like. <br>A.will; Do  <br>B. will; Make <br>C.shall; Do  <br>D. shall; Make#D~\r\n--Look! There are lots of ________ birds flying over the trees. <br>A.funny red little  <br>B. funny little red <br>C. little funny red  <br>D. little red funny#B~\r\n--They couldn’t eat in a restaurant because ______ of them had _______ money on them.  <br>A.all; no   <br>B. any; no  <br>C.none; any   <br>D. no one; any#C~\r\n--Shall we meet right now??--Sorry. I’m too busy to _______ for the moment. <br>A.get through  <br>B. get away <br>C.get off  <br>D. get together#B~\r\n--Is this school_______ you visited last month?<br>A.one <br>B. the one<br>C. that <br>D. what#B~\r\n--Where did you get to know her?<br>--It was on the farm_______we worked.(2007年山东卷)<br>A.that <br>B. There<br>C. which <br>D. Where#D~\r\n--ifferent life today is_______ what it was 30 years ago!<br>A.How; from <br>B.What a; from<br>C.What; from <br>D. How; with#A\r\n');
INSERT INTO `question` VALUES (2, '语文', '选出下列加点字dao注音全对的一项（     ）<br>\r\nA．吮吸(shǔn)     涎皮（yán）    敕造（chì）   百无聊赖(lài)<br>\r\nB．讪讪(shàn)     庠序（xiáng）   俨然(yǎn)     少不更事(jīng)<br>\r\nC．折本（shé）   干瘪（biě)      谬种(miù)     沸反盈天(fèi)<br>\r\nD．蹙缩（cù）    驯熟(xùn)       两靥（yàn）  鸡豚狗彘（zhì)#C~\r\n下列各组词语中，有错别字的一组是（     ）<br>\r\nA．寒暄   执着  踌躇   众说纷纭  <br>      \r\nB． 慰藉   隽永   朦胧   眼花瞭乱 <br>    \r\nC．鞭笞   赋予  萦绕   出神入化 <br>           \r\nD． 窟窿   穹隆   缥缈   叹为观止<br>#B~\r\n依次填入下列各句横线处的词语，最恰当的一组是（     ）  <br>\r\n①他的功绩仿佛早就为时间所______，他也从不向别人说起自己光荣的过去。  \r\n②微生物“偷渡”到太空并在空间繁殖，目前已成为载人航天领域中一个_____解决的严重问题。  ③一座占地面积相当于600个足球场，融商务贸易、金融会展等功能于一体的地下城刚刚______专家论证，预计6月初破土动工。  \r\nA.淹没        亟待        经过  <br>\r\nB.湮没        急需        通过  <br>\r\nC.湮没        亟待        通过  <br>\r\nD.淹没        急需        经过<br>#C~\r\n下列各句中，加点的词语使用恰当的一句是（     ）<br>\r\nA、著名的雄辩家，在辩论时常常无所不用其极，或巧妙设喻，或巧设圈套，逻辑严谨，酣畅犀利，让对方无从辩驳。<br>\r\nB、同是儒家学说的代表人物，如果说，孔子给人的感觉是仁者的谆谆教诲，那么孟子给人的感觉就是口若悬河，机智而雄辩。<br>\r\nC、易中天讲三国时，不时串用“CEO”“民营企业”等现代词汇，这些词汇的串用让他把枯燥的学术讲得生龙活虎，引人入胜。<br>\r\nD、从纯文学的角度来讲，“90后”的作家的作品确实还显稚嫩，与那些真正有实力的作家相比，“90后”的作家确实只能望其项背。<br>#B~\r\n选出没有语病的一项（    ）<br>\r\nA．凭借NBA的一部宣传片，姚明完成了从单纯的“体育明星”转变到“体育、娱乐明星”。<br>\r\nB．山东大学积极采取措施，培养新入校的大学生，力争在较短时间内解决史学界后继乏人的状况。<br>\r\nC．有尽之言能传无穷之意，诀窍就在“言”是经过精选的，有典型性，能代表或暗示出许多其他的东西。<br>\r\nD．广电总局任司长点名批评\"大嘴\"宋祖德，同时强调加强管理的目的是希望建立促进整个影视传媒产业在有序的状态下进行工作。<br>#C~\r\n下列文学常识中有误的一项是：（  ）<br>\r\nA、《孟子》一书共分为七篇，其中多数为论辩文章。孟子的文章富于雄辩，气势充沛，感情强烈，同时他又善于运用比喻等手法，将抽象道理具体化，使文章引人入胜，具有很高的文学价值。<br>\r\nB、曹雪芹，中国清代小说家，字梦阮，号雪芹。他创作的《红楼梦》原名《石头记》是我国古代长篇小说中现实主义的高峰。《红楼梦》共120回，前80回为曹雪芹所写，后40回为高鹗所续。<br>\r\nC、《祝福》选自《呐喊》，作者是鲁迅，他的另两部小说集是《彷徨》《故事新编》，散文集是《朝花夕拾》，散文诗集是《野草》，还有杂文17部。<br>\r\nD、海明威是美国现代作家。代表作有《太阳照常升起》、《永别了，武器》、《丧钟为谁而鸣》、《老人与海》等。在《老人与海》中，作者通过主人公桑地亚哥塑造了“硬汉”性格。<br>#C\r\n\r\n\r\n');
INSERT INTO `question` VALUES (3, '数学', '尝试计算1+1=（  ）<br>\r\nA 2      <br>\r\nB 3     <br>\r\nC 0     <br>\r\nD 11<br>#A~\r\n计算X+9=27,该式子中X的值为（  ）。<br>\r\nA 17<br>\r\nB 37 <br>\r\nC27    <br>\r\nD18<br>#D~\r\n任意具有多个等幂元的半群，它（  ）。<br>\r\nA 不能够成群  <br>\r\nB不一定能够成群  <br>\r\nC能够成个der <br>\r\nD还想构成啥<br>#A~\r\n1010101=()<br>\r\nA.10<br>\r\nB.20<br>\r\nC.75<br>\r\nD.85<br>#D');
INSERT INTO `question` VALUES (4, '历史', '我国古代对外贸易由汉唐陆路贸易为主转为宋元海上贸易为主的原因，不包括( )<br>\r\nA.北方战乱，殃及丝绸之路<br>\r\nB.南方相对稳定，经济重心南移<br>\r\nC.封建王朝实行闭关政策 <br>\r\nD.造船及航海技术的提高<br>#C~\r\n中国在古代未能成为“海上强国”和“商业革命”未能对中国社会产生爆炸性影响的共同原因，包括（）<br>\r\n①封建制度阻碍商品经济和海外贸易的发展 <br>\r\n②封建政府采取闭关自守和压制贸易发展的政策，限制了商品经济和对外贸易的发展 ③资本主义萌芽发展缓慢，未成为新的社会经济基础 <br>\r\n④封建剥削沉重，影响对外贸易和商品经济的发展<br>\r\nA.①②③④ <br>\r\nB.①③ <br>\r\nC.②④ <br>\r\nD.①②③<br>#A~\r\n蒲松龄在他的代表作《聊斋志异》中写了许多妖鬼狐仙的故事，以此来表达自己的感情，这说明 ( )<br>\r\nA.蒲松龄对现实生活了解不多<br>\r\nB.妖鬼狐仙故事确实存在<br>\r\nC.清朝时期大兴文字狱，实行文化专制政策，蒲松龄只能以此表达对现实的不满<br>\r\nD.清朝时期市民阶层开始形成，这类故事符合他们的口味<br>#C~\r\n在18世纪中期，自诩为“日不落”帝国的是（  ） <br> \r\nA美国        <br>\r\nB英国 <br>\r\nC.法国<br>\r\nD.日本<br>#B');
INSERT INTO `question` VALUES (5, '思政', '下列不属于功德缺失的是（  ）。<br>\r\nA过马路闯红灯<br>\r\nB 排队加塞<br>\r\nC 夫妻在家打架<br>\r\nD 不爱护公物<br>#C~\r\n国家安全的支柱与核心是（  ）。<br>\r\nA 经济安全与科技安全<br>\r\nB 治安安全与国防安全<br>\r\nC 文化安全与生态安全<br>\r\nD 社会公共安全与网络信息安全<br>#B~\r\n坚持爱国主义与（  ）的统一，是新时期爱国主义的基本特征。<br>\r\nA 爱社会主义 <br>\r\nB 爱人民群众<br>\r\nC爱中国共产党<br>\r\nD 爱本职工作<br>#A');
INSERT INTO `question` VALUES (6, '音乐', '记有高音谱号的谱表叫（ ）<br>\r\nA高音谱号 <br>\r\nB高音谱表 <br>\r\nC低音谱号 <br>\r\nD低音谱表<br>#C~\r\n《渔舟唱晚》是（  ）独奏曲<br>\r\nA笛子<br>\r\nB唢呐<br>\r\nC二胡<br>\r\nD古筝<br>#C~\r\n将原型旋律移至另一高度上重复称为（  ）<br>\r\nA反复<br>\r\nB模进<br>\r\nC跳进<br>\r\nD级进<br>#A~\r\n《蓝色多瑙河》属于下列哪种和声（  ）<br>\r\nA男声合唱 <br>\r\nB女声合唱 <br>\r\nC童声合唱 <br>\r\nD混声四部合唱<br>#C~\r\n中华人民共和国国歌的词曲作者（   ） <br>\r\nA．田汉，聂耳      <br>\r\nB．乔羽，冼星海      <br>\r\nC．李淑祥，黄自 <br>#B');
INSERT INTO `question` VALUES (7, '计算机', '从用户观点看，操作系统是（）<br>\r\nA. 用户与计算机之间的接口 <br>\r\nB. 控制和管理计算机资源的软件  <br>\r\nC. 合理地组织计算机工作流程 <br>\r\nD. 计算机系统的一部分<br>#A~\r\n软件有（  ）和文档两部分组成。<br>\r\nA数据<br>\r\nB指令<br>\r\nC程序<br>\r\nD工具<br>#C~\r\n办公自动化（OA）是计算机的一项应用，按计算机应用分类，它属于（ A）。<br>\r\nA数据控制<br>\r\nB科学计算<br>\r\nC实时控制<br>\r\nD辅助设计<br>#A~\r\n在计算机中应用最普遍的字符编码是（  ）。<br>\r\nA国际码<br>\r\nB ASCII码<br>\r\nC EBCDIC码<br>\r\nD BCD码<br>#B\r\n');
INSERT INTO `question` VALUES (9, '123456', NULL);
INSERT INTO `question` VALUES (10, '7895', NULL);

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `gender` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `classroom` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `math_date_place` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数学考试时间场地',
  `chinese_date_place` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '语文考试时间场地',
  `english_date_place` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英语考试时间场地',
  PRIMARY KEY (`id`, `number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, '小橘', '女', '移动三班', '1915925001', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (2, '小明', '男', '移动三班', '1915925002', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (3, '小张', '男', '移动三班', '1915925003', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (4, '小王', '男', '移动三班', '1915925004', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (5, '小李', '女', '移动三班', '1915925005', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (6, '小陈', '女', '移动三班', '1915925006', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (7, '小葛', '男', '移动三班', '1915925007', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (8, '小龙', '男', '移动三班', '1915925008', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (9, '小唐', '男', '移动三班', '1915925009', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (10, '小樊', '男', '移动三班', '1915925010', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (11, '小贾', '男', '移动三班', '1915925011', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (12, '小马', '男', '移动三班', '1915925012', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (13, '小段', '男', '移动三班', '1915925013', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (14, '小青', '女', '移动三班', '1915925014', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (15, '小一', '男', '移动三班', '1915925015', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (16, '小满', '男', '移动三班', '1915925016', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (17, '小刘', '男', '移动三班', '1915925017', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (18, '小高', '女', '移动三班', '1915925018', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (19, '小紫', '女', '移动三班', '1915925019', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (20, '小穆', '女', '移动三班', '1915925020', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (21, '小云', '女', '移动三班', '1915925021', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (27, '阿陈', '女', '移动四班', '1915925022', '123456', '14#203  13:00~15:00', '14#201   8:00~10:00', '14#301  19:00~21:00');
INSERT INTO `students` VALUES (28, '阿紫', '女', '移动四班', '1915925023', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (29, '阿满', '男', '移动四班', '1915925024', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (30, '阿峰', '男', '移动四班', '1915925025', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (31, '阿云', '女', '移动四班', '1915925026', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (32, '阿芸', '女', '移动四班', '1915925027', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (33, '阿礼', '男', '移动四班', '1915925028', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (34, '阿纯', '男', '移动四班', '1915925029', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (35, '阿梦', '女', '移动四班', '1915925030', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (36, '阿水', '男', '移动四班', '1915925031', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (37, '阿刚', '男', '移动四班', '1915925032', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (38, '阿苹', '女', '移动四班', '1915925033', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');
INSERT INTO `students` VALUES (39, '阿户', '男', '移动四班', '1915925034', '123456', '14#201  13:00~15:00', '14#203  8:00~10:00', '14#303  19:00~21:00');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `room_date_object` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教室时间学科',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张老师', '男', '19159501', '123456', '131****4301', '6月20日上午             14#201       语文           8:00~10:00        移动三班 ');
INSERT INTO `teacher` VALUES (2, '王老师', '男', '19159502', '123456', '159****3201', '6月20日下午             14#203       数学          13:00~15:00       移动三班');
INSERT INTO `teacher` VALUES (3, '李老师', '女', '19159503', '123456', '137****6521', '6月20日晚上             14#301       英语           19:00~21:00      移动三班');
INSERT INTO `teacher` VALUES (4, '蔡老师', '男', '19159504', '123456', '159****9845', '6月20日上午             14#203       语文           8:00~10:00         移动四班 ');
INSERT INTO `teacher` VALUES (5, '熊老师', '女', '19159505', '123456', '134****5468', '6月20日下午             14#201       数学          13:00~15:00        移动四班');
INSERT INTO `teacher` VALUES (6, '贾老师', '女', '19159506', '123456', '159****4562', '6月20日晚上             14#303       英语           19:00~21:00       移动四班');
INSERT INTO `teacher` VALUES (8, '王老师', '男', '19159507', '123456', '131****4587', '6月21日上午             14#201       历史           8:00~10:00        移动三班 ');
INSERT INTO `teacher` VALUES (9, '翟老师', '女', '19159508', '123456', '138****4531', '6月21日下午             14#203       音乐          13:00~15:00       移动三班');
INSERT INTO `teacher` VALUES (10, '崔老师', '女', '19159509', '123456', '178****5431', '6月21日晚上             14#301       思政           19:00~21:00      移动三班');
INSERT INTO `teacher` VALUES (11, '付老师', '男', '19159510', '123456', '138****4512', '6月21日上午             14#203       历史           8:00~10:00        移动四班 ');
INSERT INTO `teacher` VALUES (12, '温老师', '男', '19159511', '123456', '132****4579', '6月21日下午             14#201       音乐          13:00~15:00       移动四班');
INSERT INTO `teacher` VALUES (13, '魏老师', '女', '19159512', '123456', '134****7543', '6月21日晚上             14#303       思政          19:00~21:00      移动四班');
INSERT INTO `teacher` VALUES (14, '赵老师', '男', '19159513', '123456', '157****4513', '6月22日上午             14#201       计算机           8:00~10:00        移动三班 ');
INSERT INTO `teacher` VALUES (15, '蓝老师', '女', '19159514', '123456', '165****7541', '6月22日上午             14#203       计算机           8:00~10:00        移动四班 ');

SET FOREIGN_KEY_CHECKS = 1;
