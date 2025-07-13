-- 学生修课程表
CREATE TABLE IF NOT EXISTS StudentCourse (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    student_id CHAR(36) NOT NULL COMMENT '学生ID（外键）',
    course_code VARCHAR(20) NOT NULL COMMENT '课程代码（外键）',
    score DECIMAL(5,2) COMMENT '成绩',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    -- 外键约束
    CONSTRAINT fk_student_course_student FOREIGN KEY (student_id) REFERENCES StudentInfo(student_id),
    CONSTRAINT fk_student_course_course FOREIGN KEY (course_code) REFERENCES CourseInfo(course_code)
) COMMENT='学生修课程表';