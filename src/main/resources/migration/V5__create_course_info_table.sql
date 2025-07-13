-- 课程信息表
CREATE TABLE IF NOT EXISTS CourseInfo (
    course_code VARCHAR(20) PRIMARY KEY COMMENT '课程代码（主键）',
    name VARCHAR(100) NOT NULL COMMENT '课程名称',
    type ENUM('必修','选修') NOT NULL DEFAULT '必修' COMMENT '课程类型',
    credit DECIMAL(3,1) NOT NULL DEFAULT 0.0 COMMENT '课程学分',
    is_practical TINYINT(1) DEFAULT 0 COMMENT '是否实践课（1是，0否）',
    description TEXT COMMENT '课程简介',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者'
) COMMENT='课程信息表';

-- 推荐索引
CREATE INDEX idx_course_name ON CourseInfo(name);