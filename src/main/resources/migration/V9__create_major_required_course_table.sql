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

-- 计算机科学与技术必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('CS001', 'CS001-101', 1, 'root', 'root'),
    ('CS001', 'CS001-102', 1, 'root', 'root'),
    ('CS001', 'CS001-103', 1, 'root', 'root'),
    ('CS001', 'CS001-104', 1, 'root', 'root'),
    ('CS001', 'CS001-105', 1, 'root', 'root'),
    ('CS001', 'CS001-106', 1, 'root', 'root');

-- 软件工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('CS002', 'CS002-101', 1, 'root', 'root'),
    ('CS002', 'CS002-102', 1, 'root', 'root'),
    ('CS002', 'CS002-103', 1, 'root', 'root'),
    ('CS002', 'CS002-104', 1, 'root', 'root'),
    ('CS002', 'CS002-105', 1, 'root', 'root');

-- 网络工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('CS003', 'CS003-101', 1, 'root', 'root'),
    ('CS003', 'CS003-102', 1, 'root', 'root'),
    ('CS003', 'CS003-103', 1, 'root', 'root'),
    ('CS003', 'CS003-104', 1, 'root', 'root'),
    ('CS003', 'CS003-105', 1, 'root', 'root');

-- 人工智能必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('CS004', 'CS004-101', 1, 'root', 'root'),
    ('CS004', 'CS004-102', 1, 'root', 'root'),
    ('CS004', 'CS004-103', 1, 'root', 'root'),
    ('CS004', 'CS004-104', 1, 'root', 'root'),
    ('CS004', 'CS004-105', 1, 'root', 'root');

-- 数据科学与大数据技术必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('CS005', 'CS005-101', 1, 'root', 'root'),
    ('CS005', 'CS005-102', 1, 'root', 'root'),
    ('CS005', 'CS005-103', 1, 'root', 'root'),
    ('CS005', 'CS005-104', 1, 'root', 'root'),
    ('CS005', 'CS005-105', 1, 'root', 'root');

-- 电子信息工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('EE001', 'EE001-101', 1, 'root', 'root'),
    ('EE001', 'EE001-102', 1, 'root', 'root'),
    ('EE001', 'EE001-103', 1, 'root', 'root'),
    ('EE001', 'EE001-104', 1, 'root', 'root'),
    ('EE001', 'EE001-105', 1, 'root', 'root');

-- 通信工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('EE002', 'EE002-101', 1, 'root', 'root'),
    ('EE002', 'EE002-102', 1, 'root', 'root'),
    ('EE002', 'EE002-103', 1, 'root', 'root'),
    ('EE002', 'EE002-104', 1, 'root', 'root'),
    ('EE002', 'EE002-105', 1, 'root', 'root');

-- 光电信息科学与工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('EE003', 'EE003-101', 1, 'root', 'root'),
    ('EE003', 'EE003-102', 1, 'root', 'root'),
    ('EE003', 'EE003-103', 1, 'root', 'root'),
    ('EE003', 'EE003-104', 1, 'root', 'root'),
    ('EE003', 'EE003-105', 1, 'root', 'root');

-- 机械工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('ME001', 'ME001-101', 1, 'root', 'root'),
    ('ME001', 'ME001-102', 1, 'root', 'root'),
    ('ME001', 'ME001-103', 1, 'root', 'root'),
    ('ME001', 'ME001-104', 1, 'root', 'root'),
    ('ME001', 'ME001-105', 1, 'root', 'root');

-- 自动化必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('ME002', 'ME002-101', 1, 'root', 'root'),
    ('ME002', 'ME002-102', 1, 'root', 'root'),
    ('ME002', 'ME002-103', 1, 'root', 'root'),
    ('ME002', 'ME002-104', 1, 'root', 'root'),
    ('ME002', 'ME002-105', 1, 'root', 'root');

-- 能源与动力工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('ME003', 'ME003-101', 1, 'root', 'root'),
    ('ME003', 'ME003-102', 1, 'root', 'root'),
    ('ME003', 'ME003-103', 1, 'root', 'root'),
    ('ME003', 'ME003-104', 1, 'root', 'root'),
    ('ME003', 'ME003-105', 1, 'root', 'root');

-- 土木工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('CE001', 'CE001-101', 1, 'root', 'root'),
    ('CE001', 'CE001-102', 1, 'root', 'root'),
    ('CE001', 'CE001-103', 1, 'root', 'root'),
    ('CE001', 'CE001-104', 1, 'root', 'root'),
    ('CE001', 'CE001-105', 1, 'root', 'root');

-- 交通工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('CE002', 'CE002-101', 1, 'root', 'root'),
    ('CE002', 'CE002-102', 1, 'root', 'root'),
    ('CE002', 'CE002-103', 1, 'root', 'root'),
    ('CE002', 'CE002-104', 1, 'root', 'root'),
    ('CE002', 'CE002-105', 1, 'root', 'root');

-- 环境工程必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('CE003', 'CE003-101', 1, 'root', 'root'),
    ('CE003', 'CE003-102', 1, 'root', 'root'),
    ('CE003', 'CE003-103', 1, 'root', 'root'),
    ('CE003', 'CE003-104', 1, 'root', 'root'),
    ('CE003', 'CE003-105', 1, 'root', 'root');

-- 会计学必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('AC001', 'AC001-101', 1, 'root', 'root'),
    ('AC001', 'AC001-102', 1, 'root', 'root'),
    ('AC001', 'AC001-103', 1, 'root', 'root'),
    ('AC001', 'AC001-104', 1, 'root', 'root'),
    ('AC001', 'AC001-105', 1, 'root', 'root');

-- 财务管理必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('AC002', 'AC002-101', 1, 'root', 'root'),
    ('AC002', 'AC002-102', 1, 'root', 'root'),
    ('AC002', 'AC002-103', 1, 'root', 'root'),
    ('AC002', 'AC002-104', 1, 'root', 'root'),
    ('AC002', 'AC002-105', 1, 'root', 'root');

-- 审计学必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('AC003', 'AC003-101', 1, 'root', 'root'),
    ('AC003', 'AC003-102', 1, 'root', 'root'),
    ('AC003', 'AC003-103', 1, 'root', 'root'),
    ('AC003', 'AC003-104', 1, 'root', 'root'),
    ('AC003', 'AC003-105', 1, 'root', 'root');

-- 工商管理必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('BA001', 'BA001-101', 1, 'root', 'root'),
    ('BA001', 'BA001-102', 1, 'root', 'root'),
    ('BA001', 'BA001-103', 1, 'root', 'root'),
    ('BA001', 'BA001-104', 1, 'root', 'root'),
    ('BA001', 'BA001-105', 1, 'root', 'root');

-- 市场营销必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('BA002', 'BA002-101', 1, 'root', 'root'),
    ('BA002', 'BA002-102', 1, 'root', 'root'),
    ('BA002', 'BA002-103', 1, 'root', 'root'),
    ('BA002', 'BA002-104', 1, 'root', 'root'),
    ('BA002', 'BA002-105', 1, 'root', 'root');

-- 人力资源管理必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('BA003', 'BA003-101', 1, 'root', 'root'),
    ('BA003', 'BA003-102', 1, 'root', 'root'),
    ('BA003', 'BA003-103', 1, 'root', 'root'),
    ('BA003', 'BA003-104', 1, 'root', 'root'),
    ('BA003', 'BA003-105', 1, 'root', 'root');

-- 法学必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('LA001', 'LA001-101', 1, 'root', 'root'),
    ('LA001', 'LA001-102', 1, 'root', 'root'),
    ('LA001', 'LA001-103', 1, 'root', 'root'),
    ('LA001', 'LA001-104', 1, 'root', 'root'),
    ('LA001', 'LA001-105', 1, 'root', 'root');

-- 国际法必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('LA002', 'LA002-101', 1, 'root', 'root'),
    ('LA002', 'LA002-102', 1, 'root', 'root'),
    ('LA002', 'LA002-103', 1, 'root', 'root'),
    ('LA002', 'LA002-104', 1, 'root', 'root'),
    ('LA002', 'LA002-105', 1, 'root', 'root');

-- 经济法必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('LA003', 'LA003-101', 1, 'root', 'root'),
    ('LA003', 'LA003-102', 1, 'root', 'root'),
    ('LA003', 'LA003-103', 1, 'root', 'root'),
    ('LA003', 'LA003-104', 1, 'root', 'root'),
    ('LA003', 'LA003-105', 1, 'root', 'root');

-- 教育学必修课程
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
VALUES
    ('EDU001', 'EDU001-101', 1, 'root', 'root'),
    ('EDU001', 'EDU001-102', 1, 'root', 'root'),
    ('EDU001', 'EDU001-103', 1, 'root', 'root'),
    ('EDU001', 'EDU001-104', 1, 'root', 'root'),
    ('EDU001', 'EDU001-105', 1, 'root', 'root');