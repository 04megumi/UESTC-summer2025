-- 课程替换表
CREATE TABLE IF NOT EXISTS CourseReplacement (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    old_course_code VARCHAR(20) NOT NULL COMMENT '被替换的旧课程代码',
    new_course_code VARCHAR(20) NOT NULL COMMENT '替代的新课程代码',
    major_code VARCHAR(20) DEFAULT NULL COMMENT '适用专业代码（可为空，通用替换）',
    effective_from DATE NOT NULL COMMENT '生效起始日期',
    effective_to DATE DEFAULT NULL COMMENT '生效截止日期',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    -- 外键约束
    CONSTRAINT fk_cr_old_course FOREIGN KEY (old_course_code) REFERENCES CourseInfo(course_code),
    CONSTRAINT fk_cr_new_course FOREIGN KEY (new_course_code) REFERENCES CourseInfo(course_code),
    CONSTRAINT fk_cr_major FOREIGN KEY (major_code) REFERENCES MajorInfo(code),
    UNIQUE KEY uq_old_new_major (old_course_code, new_course_code, major_code)
) COMMENT='课程替换表（旧课程顶替新课程）';

-- 索引推荐
CREATE INDEX idx_cr_old_course ON CourseReplacement(old_course_code);
CREATE INDEX idx_cr_new_course ON CourseReplacement(new_course_code);
CREATE INDEX idx_cr_major_code ON CourseReplacement(major_code);
