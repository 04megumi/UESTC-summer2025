-- 考生信息表
CREATE TABLE IF NOT EXISTS StudentInfo (
    student_id CHAR(36) PRIMARY KEY COMMENT '考籍号（主键，UUID）',
    name VARCHAR(50) NOT NULL COMMENT '姓名',
    id_number CHAR(18) UNIQUE NOT NULL COMMENT '身份证号（唯一）',
    password VARCHAR(255) NOT NULL COMMENT '加密后的密码',
    major_code VARCHAR(20) NOT NULL COMMENT '报考专业代码（外键）',
    exam_center_id CHAR(36) COMMENT '州级考试院ID（外键）',
    gender ENUM('男','女') DEFAULT '男' COMMENT '性别',
    birth_date DATE COMMENT '出生日期',
    phone VARCHAR(20) COMMENT '联系电话',
    address VARCHAR(200) COMMENT '通讯地址',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    CONSTRAINT fk_student_major FOREIGN KEY (major_code) REFERENCES MajorInfo(code),
    CONSTRAINT fk_student_exam_center FOREIGN KEY (exam_center_id) REFERENCES ExamCenter(exam_center_id)
) COMMENT='考生信息表';

-- 索引
CREATE INDEX idx_student_id_number ON StudentInfo(id_number);
CREATE INDEX idx_student_major ON StudentInfo(major_code);
CREATE INDEX idx_student_exam_center ON StudentInfo(exam_center_id);