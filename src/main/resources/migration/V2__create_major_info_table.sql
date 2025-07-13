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

-- 插入30个预设专业
INSERT INTO MajorInfo (code, name, graduate_credit, created_by, updated_by)
VALUES
    ('CS001', '计算机科学与技术', 180.0, 'root', 'root'),
    ('CS002', '软件工程', 180.0, 'root', 'root'),
    ('CS003', '网络工程', 180.0, 'root', 'root'),
    ('CS004', '人工智能', 180.0, 'root', 'root'),
    ('CS005', '数据科学与大数据技术', 180.0, 'root', 'root'),
    ('EE001', '电子信息工程', 180.0, 'root', 'root'),
    ('EE002', '通信工程', 180.0, 'root', 'root'),
    ('EE003', '光电信息科学与工程', 180.0, 'root', 'root'),
    ('ME001', '机械工程', 180.0, 'root', 'root'),
    ('ME002', '自动化', 180.0, 'root', 'root'),
    ('ME003', '能源与动力工程', 180.0, 'root', 'root'),
    ('CE001', '土木工程', 180.0, 'root', 'root'),
    ('CE002', '交通工程', 180.0, 'root', 'root'),
    ('CE003', '环境工程', 180.0, 'root', 'root'),
    ('AC001', '会计学', 180.0, 'root', 'root'),
    ('AC002', '财务管理', 180.0, 'root', 'root'),
    ('AC003', '审计学', 180.0, 'root', 'root'),
    ('BA001', '工商管理', 180.0, 'root', 'root'),
    ('BA002', '市场营销', 180.0, 'root', 'root'),
    ('BA003', '人力资源管理', 180.0, 'root', 'root'),
    ('LA001', '法学', 180.0, 'root', 'root'),
    ('LA002', '国际法', 180.0, 'root', 'root'),
    ('LA003', '经济法', 180.0, 'root', 'root'),
    ('EDU001', '教育学', 180.0, 'root', 'root'),
    ('EDU002', '学前教育', 180.0, 'root', 'root'),
    ('EDU003', '特殊教育', 180.0, 'root', 'root'),
    ('PSY001', '心理学', 180.0, 'root', 'root'),
    ('PSY002', '应用心理学', 180.0, 'root', 'root'),
    ('ART001', '艺术设计', 180.0, 'root', 'root'),
    ('ART002', '视觉传达设计', 180.0, 'root', 'root');

-- 更新专业信息表，将毕业学分要求调整为150
UPDATE MajorInfo
SET graduate_credit = 150.0
WHERE graduate_credit = 180.0;