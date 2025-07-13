-- 课程信息表
CREATE TABLE IF NOT EXISTS CourseInfo (
    course_code VARCHAR(20) PRIMARY KEY COMMENT '课程代码（主键）',
    name VARCHAR(100) NOT NULL COMMENT '课程名称',
    type ENUM('必修','选修') NOT NULL DEFAULT '必修' COMMENT '课程类型',
    credit DECIMAL(3,1) NOT NULL DEFAULT 0.0 COMMENT '课程学分',
    is_practical TINYINT(1) DEFAULT 0 COMMENT '是否实践课（1是，0否）',
    description TEXT COMMENT '课程简介',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者'
) COMMENT='课程信息表';

-- 推荐索引
CREATE INDEX idx_course_name ON CourseInfo(name);

-- 预设课程数据
INSERT INTO CourseInfo (course_code, name, type, credit, is_practical, created_by, updated_by)
VALUES
    ('CS101', '程序设计基础', '必修', 4.0, 0, 'root', 'root'),
    ('CS102', '数据结构', '必修', 3.0, 0, 'root', 'root'),
    ('CS103', '计算机网络', '必修', 3.0, 0, 'root', 'root'),
    ('CS104', '操作系统', '必修', 3.0, 0, 'root', 'root'),
    ('CS105', '数据库系统', '必修', 3.0, 0, 'root', 'root'),
    ('CS106', '算法分析与设计', '必修', 3.0, 0, 'root', 'root'),
    ('CS107', '计算机组成原理', '必修', 3.0, 0, 'root', 'root'),
    ('CS108', '人工智能基础', '必修', 3.0, 0, 'root', 'root'),
    ('CS109', '软件工程', '必修', 3.0, 0, 'root', 'root'),
    ('CS110', '数字逻辑', '必修', 2.0, 0, 'root', 'root'),
    ('CS201', '嵌入式系统', '选修', 3.0, 1, 'root', 'root'),
    ('CS202', '机器学习', '选修', 3.0, 0, 'root', 'root'),
    ('CS203', '自然语言处理', '选修', 3.0, 0, 'root', 'root'),
    ('CS204', '数据分析与挖掘', '选修', 3.0, 0, 'root', 'root'),
    ('CS205', '区块链技术', '选修', 3.0, 0, 'root', 'root'),
    ('CS206', '深度学习', '选修', 3.0, 0, 'root', 'root'),
    ('EE101', '电路原理', '必修', 4.0, 0, 'root', 'root'),
    ('EE102', '信号与系统', '必修', 3.0, 0, 'root', 'root'),
    ('EE103', '数字电路', '必修', 3.0, 0, 'root', 'root'),
    ('EE104', '微机原理与接口技术', '必修', 3.0, 0, 'root', 'root'),
    ('EE105', '通信原理', '必修', 3.0, 0, 'root', 'root'),
    ('EE106', '电子电路基础', '必修', 3.0, 0, 'root', 'root'),
    ('EE107', '无线通信技术', '选修', 3.0, 0, 'root', 'root'),
    ('EE108', '光纤通信', '选修', 3.0, 0, 'root', 'root'),
    ('ME101', '机械制图', '必修', 3.0, 0, 'root', 'root'),
    ('ME102', '材料力学', '必修', 3.0, 0, 'root', 'root'),
    ('ME103', '机械原理', '必修', 3.0, 0, 'root', 'root'),
    ('ME104', '机械设计基础', '必修', 3.0, 0, 'root', 'root'),
    ('ME105', '制造工艺学', '必修', 3.0, 0, 'root', 'root'),
    ('ME106', '自动化生产线设计', '选修', 3.0, 0, 'root', 'root'),
    ('AC101', '会计学原理', '必修', 3.0, 0, 'root', 'root'),
    ('AC102', '财务管理', '必修', 3.0, 0, 'root', 'root'),
    ('AC103', '成本会计', '必修', 3.0, 0, 'root', 'root'),
    ('BA101', '管理学原理', '必修', 3.0, 0, 'root', 'root'),
    ('BA102', '经济学基础', '必修', 3.0, 0, 'root', 'root'),
    ('LA101', '法理学', '必修', 3.0, 0, 'root', 'root'),
    ('LA102', '宪法学', '必修', 3.0, 0, 'root', 'root'),
    ('PSY101', '心理学基础', '必修', 3.0, 0, 'root', 'root'),
    ('PSY102', '社会心理学', '选修', 3.0, 0, 'root', 'root'),
    ('PSY103', '应用心理学', '选修', 3.0, 0, 'root', 'root');


-- 素养课程
INSERT INTO CourseInfo (course_code, name, type, credit, is_practical, created_by, updated_by)
VALUES
    ('CS301', '人文与社会', '必修', 3.0, 0, 'root', 'root'),
    ('CS302', '科学思维与创新', '必修', 3.0, 0, 'root', 'root'),
    ('CS303', '数据分析基础', '必修', 3.0, 0, 'root', 'root'),
    ('CS304', '人类与环境', '必修', 3.0, 0, 'root', 'root'),
    ('CS305', '跨文化沟通', '必修', 3.0, 0, 'root', 'root'),
    ('CS306', '现代社会与道德', '必修', 3.0, 0, 'root', 'root'),
    ('CS307', '逻辑思维训练', '必修', 3.0, 0, 'root', 'root'),
    ('CS308', '团队协作与领导力', '必修', 3.0, 0, 'root', 'root'),
    ('CS309', '创新与创业', '必修', 3.0, 0, 'root', 'root'),
    ('CS310', '信息技术与社会', '必修', 3.0, 0, 'root', 'root'),
    ('CS311', '公共管理与公共服务', '必修', 3.0, 0, 'root', 'root'),
    ('CS312', '艺术审美与鉴赏', '必修', 3.0, 0, 'root', 'root'),
    ('CS313', '教育心理学', '必修', 3.0, 0, 'root', 'root'),
    ('CS314', '健康与心理', '必修', 3.0, 0, 'root', 'root'),
    ('CS315', '公民意识与责任', '必修', 3.0, 0, 'root', 'root'),
    ('CS316', '领导力与管理', '必修', 3.0, 0, 'root', 'root'),
    ('CS317', '历史文化与思想', '必修', 3.0, 0, 'root', 'root'),
    ('CS318', '科技与社会伦理', '必修', 3.0, 0, 'root', 'root'),
    ('CS319', '经济学原理', '必修', 3.0, 0, 'root', 'root'),
    ('CS320', '文化差异与全球化', '必修', 3.0, 0, 'root', 'root'),
    ('CS321', '信息伦理与社会责任', '必修', 3.0, 0, 'root', 'root'),
    ('CS322', '未来工作与社会变革', '必修', 3.0, 0, 'root', 'root'),
    ('CS323', '公关与沟通技巧', '必修', 3.0, 0, 'root', 'root'),
    ('CS324', '环境与可持续发展', '必修', 3.0, 0, 'root', 'root'),
    ('CS325', '金融基础与应用', '必修', 3.0, 0, 'root', 'root'),
    ('CS326', '全球化视野下的文化', '必修', 3.0, 0, 'root', 'root'),
    ('CS327', '数据伦理与隐私保护', '必修', 3.0, 0, 'root', 'root'),
    ('CS328', '社会心理学', '必修', 3.0, 0, 'root', 'root'),
    ('CS329', '文化遗产与保护', '必修', 3.0, 0, 'root', 'root'),
    ('CS330', '全球与区域经济', '必修', 3.0, 0, 'root', 'root');

-- 体育课程
INSERT INTO CourseInfo (course_code, name, type, credit, is_practical, created_by, updated_by)
VALUES
    ('PE101', '篮球', '必修', 2.0, 1, 'root', 'root'),
    ('PE102', '足球', '必修', 2.0, 1, 'root', 'root'),
    ('PE103', '羽毛球', '必修', 2.0, 1, 'root', 'root'),
    ('PE104', '乒乓球', '必修', 2.0, 1, 'root', 'root'),
    ('PE105', '排球', '必修', 2.0, 1, 'root', 'root'),
    ('PE106', '游泳', '必修', 2.0, 1, 'root', 'root'),
    ('PE107', '健身与体能训练', '必修', 2.0, 1, 'root', 'root'),
    ('PE108', '田径', '必修', 2.0, 1, 'root', 'root'),
    ('PE109', '武术', '必修', 2.0, 1, 'root', 'root'),
    ('PE110', '瑜伽', '必修', 2.0, 1, 'root', 'root');

-- 文学课程
INSERT INTO CourseInfo (course_code, name, type, credit, is_practical, created_by, updated_by)
VALUES
    ('LIT101', '中国古代文学', '必修', 3.0, 0, 'root', 'root'),
    ('LIT102', '外国文学', '必修', 3.0, 0, 'root', 'root'),
    ('LIT103', '现代汉语', '必修', 3.0, 0, 'root', 'root'),
    ('LIT104', '古代汉语', '必修', 3.0, 0, 'root', 'root'),
    ('LIT105', '文学理论', '必修', 3.0, 0, 'root', 'root'),
    ('LIT106', '诗歌鉴赏', '必修', 3.0, 0, 'root', 'root'),
    ('LIT107', '小说写作', '选修', 3.0, 0, 'root', 'root'),
    ('LIT108', '戏剧文学', '选修', 3.0, 0, 'root', 'root'),
    ('LIT109', '散文与随笔', '选修', 3.0, 0, 'root', 'root'),
    ('LIT110', '文学创作', '选修', 3.0, 0, 'root', 'root'),
    ('LIT111', '古代文化与思想', '选修', 3.0, 0, 'root', 'root'),
    ('LIT112', '民间文学', '选修', 3.0, 0, 'root', 'root'),
    ('LIT113', '比较文学', '选修', 3.0, 0, 'root', 'root'),
    ('LIT114', '中国现代文学', '选修', 3.0, 0, 'root', 'root'),
    ('LIT115', '英美文学', '选修', 3.0, 0, 'root', 'root'),
    ('LIT116', '翻译理论与实践', '选修', 3.0, 0, 'root', 'root'),
    ('LIT117', '电影文学', '选修', 3.0, 0, 'root', 'root'),
    ('LIT118', '儿童文学', '选修', 3.0, 0, 'root', 'root'),
    ('LIT119', '女性文学', '选修', 3.0, 0, 'root', 'root'),
    ('LIT120', '现代小说', '选修', 3.0, 0, 'root', 'root');

-- 实践课程
INSERT INTO CourseInfo (course_code, name, type, credit, is_practical, created_by, updated_by)
VALUES
    ('PRAC101', '工程实践', '必修', 4.0, 1, 'root', 'root'),
    ('PRAC102', '科研训练', '必修', 3.0, 1, 'root', 'root'),
    ('PRAC103', '计算机实验', '必修', 3.0, 1, 'root', 'root'),
    ('PRAC104', '机器人实验', '必修', 3.0, 1, 'root', 'root');