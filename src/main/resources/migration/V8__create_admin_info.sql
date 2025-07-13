-- 管理员信息表
CREATE TABLE IF NOT EXISTS AdminInfo (
    admin_id CHAR(36) PRIMARY KEY COMMENT '管理员ID（UUID）',
    password VARCHAR(255) NOT NULL COMMENT '加密密码',
    full_name VARCHAR(100) NOT NULL COMMENT '管理员真实姓名',
    phone VARCHAR(20) COMMENT '联系电话',
    email VARCHAR(100) COMMENT '邮箱',
    exam_center_id CHAR(36) COMMENT '州级考试院ID（外键）',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    CONSTRAINT fk_admin_exam_center FOREIGN KEY (exam_center_id) REFERENCES ExamCenter(exam_center_id)  -- 添加外键约束
) COMMENT='管理员信息表';

-- 为考试院字段添加索引
CREATE INDEX idx_admin_exam_center ON AdminInfo(exam_center_id);  -- 为考试院ID添加索引