-- 免考规则表
CREATE TABLE IF NOT EXISTS ExemptionRule (
    rule_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '免考规则ID',
    name VARCHAR(100) NOT NULL COMMENT '规则名称',
    description TEXT COMMENT '规则详细介绍',
    course_code VARCHAR(20) NOT NULL COMMENT '可免考的课程代码',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    -- 外键约束
    CONSTRAINT fk_rule_course FOREIGN KEY (course_code) REFERENCES CourseInfo(course_code)
) COMMENT='免考规则表';

-- 推荐索引
CREATE INDEX idx_rule_name ON ExemptionRule(name);
CREATE INDEX idx_rule_course_code ON ExemptionRule(course_code);

-- 免考申请表
CREATE TABLE IF NOT EXISTS ExemptionApplication (
    application_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '申请ID',
    student_id CHAR(36) NOT NULL COMMENT '申请考生ID',
    course_code VARCHAR(20) NOT NULL COMMENT '申请免考课程',
    rule_id BIGINT NOT NULL COMMENT '关联免考规则ID',
    status ENUM('待审核','通过','驳回') DEFAULT '待审核' COMMENT '审核状态',
    apply_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
    review_time DATETIME COMMENT '审核时间',
    review_reason TEXT COMMENT '审核意见或驳回原因',
    admin_id CHAR(36) COMMENT '管理员ID（外键）',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    -- 外键约束
    CONSTRAINT fk_exemption_student FOREIGN KEY (student_id) REFERENCES StudentInfo(student_id),
    CONSTRAINT fk_exemption_course FOREIGN KEY (course_code) REFERENCES CourseInfo(course_code),
    CONSTRAINT fk_exemption_rule FOREIGN KEY (rule_id) REFERENCES ExemptionRule(rule_id),
    CONSTRAINT fk_exemption_admin FOREIGN KEY (admin_id) REFERENCES AdminInfo(admin_id),
    UNIQUE KEY uq_student_course_rule (student_id, course_code, rule_id)
) COMMENT='免考申请表';

-- 插入免考规则数据
INSERT INTO ExemptionRule (name, description, course_code, created_by, updated_by)
VALUES
    ('优异成绩免考', '对于成绩达到85分以上的学生，可申请免考该课程', 'LIT101', 'root', 'root'),
    ('学分互认免考', '与其他学校达成学分互认协议的课程可免考', 'CS302', 'root', 'root'),
    ('基础课程免考', '已通过基础课程或同等课程，可免考该课程', 'LIT104', 'root', 'root'),
    ('前置课程免考', '完成相关的前置课程后，可以申请免考该课程', 'CS305', 'root', 'root'),
    ('课程免考标准', '依据课程标准和成绩要求，可申请免考该课程', 'LIT106', 'root', 'root'),
    ('国际学分认证', '国际认证的课程学分可免考', 'CS307', 'root', 'root'),
    ('学术考试免考', '通过学术考试，符合要求的可免考该课程', 'PRAC103', 'root', 'root'),
    ('项目完成免考', '完成项目相关课程或实践经验后可免考', 'CS308', 'root', 'root'),
    ('成绩优异免考', '成绩优异者可免考，具体要求依照每门课程定义', 'PE101', 'root', 'root'),
    ('课程转换免考', '从相关领域的其他课程转换过来的学生可免考该课程', 'LIT109', 'root', 'root');