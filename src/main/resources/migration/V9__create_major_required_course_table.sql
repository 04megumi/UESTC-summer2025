-- 专业所需课程关联表
CREATE TABLE IF NOT EXISTS MajorRequiredCourse (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    major_code VARCHAR(20) NOT NULL COMMENT '专业代码（外键）',
    course_code VARCHAR(20) NOT NULL COMMENT '课程代码（外键）',
    required_to_graduate TINYINT(1) DEFAULT 1 COMMENT '是否为毕业必修课程（1 是，0 否）',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    -- 外键约束
    CONSTRAINT fk_mrc_major FOREIGN KEY (major_code) REFERENCES MajorInfo(code),
    CONSTRAINT fk_mrc_course FOREIGN KEY (course_code) REFERENCES CourseInfo(course_code),
    UNIQUE KEY uq_major_course (major_code, course_code)
) COMMENT='专业毕业所需课程表';

CREATE INDEX idx_mrc_major_code ON MajorRequiredCourse(major_code);
CREATE INDEX idx_mrc_course_code ON MajorRequiredCourse(course_code);