-- 免考规则表
CREATE TABLE IF NOT EXISTS ExemptionRule (
    rule_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '免考规则ID',
    name VARCHAR(100) NOT NULL COMMENT '规则名称',
    description TEXT COMMENT '规则详细介绍',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者'
) COMMENT='免考规则表';

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
    UNIQUE KEY uq_student_course_rule (student_id, course_code, rule_id)
) COMMENT='免考申请表';