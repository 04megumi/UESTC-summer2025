-- 州级考试院信息
CREATE TABLE IF NOT EXISTS ExamCenter (
    exam_center_id CHAR(36) PRIMARY KEY COMMENT '考试院ID（UUID，主键）',
    exam_center_name VARCHAR(100) NOT NULL COMMENT '考试院名称',
    state_code VARCHAR(20) NOT NULL COMMENT '所属省的代码',
    state_name VARCHAR(50) NOT NULL COMMENT '所属省的名称',
    address VARCHAR(200) COMMENT '考试院地址',
    phone VARCHAR(20) COMMENT '联系电话',
    email VARCHAR(100) COMMENT '电子邮箱',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    -- 联合唯一索引：考试院名称，所属省代码，所属省名称
    UNIQUE KEY unique_exam_center (exam_center_name, state_code, state_name),
    INDEX idx_exam_center_name (exam_center_name),
    INDEX idx_state_code (state_code)
) COMMENT='州级考试院信息表';