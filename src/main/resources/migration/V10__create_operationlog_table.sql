CREATE TABLE IF NOT EXISTS OperationLog (
    log_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '日志ID',
    operator_id CHAR(36) NOT NULL COMMENT '操作人ID',
    operator_type ENUM('学生','管理员') NOT NULL COMMENT '操作人类型',
    result ENUM('成功','失败') NOT NULL COMMENT '操作结果',
    description TEXT COMMENT '操作描述',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者'
    ) COMMENT='系统操作日志表';

-- 创建索引
CREATE INDEX idx_operator_id ON OperationLog(operator_id);
CREATE INDEX idx_operation_time ON OperationLog(create_time);