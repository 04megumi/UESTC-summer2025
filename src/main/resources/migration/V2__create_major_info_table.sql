-- 专业信息表
CREATE TABLE IF NOT EXISTS MajorInfo (
    code VARCHAR(20) PRIMARY KEY COMMENT '专业代码（主键）',
    name VARCHAR(100) NOT NULL COMMENT '专业名称',
    graduate_credit DECIMAL(4,1) NOT NULL DEFAULT 0.0 COMMENT '毕业所需学分',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者'
) COMMENT='专业信息表';

CREATE INDEX idx_major_name ON MajorInfo(name);