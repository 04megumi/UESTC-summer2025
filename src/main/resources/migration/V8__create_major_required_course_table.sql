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


-- 插入匹配到的课程到 MajorRequiredCourse 表
-- 1. 获取专业代码，2. 根据专业代码前两位匹配课程，3. 插入到 MajorRequiredCourse 表

-- 获取与专业代码匹配的课程并插入
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
SELECT
    mi.code AS major_code,
    ci.course_code,
    1 AS required_to_graduate,  -- 假设所有匹配课程都是必修课程
    'root' AS created_by,
    'root' AS updated_by
FROM
    MajorInfo mi
        JOIN
    CourseInfo ci
    ON
        ci.course_code LIKE CONCAT(SUBSTRING(mi.code, 1, 2), '%')  -- 课程代码前两位与专业代码匹配
WHERE
    ci.course_code REGEXP '^[A-Z]{2}[0-9]{3}$';  -- 只匹配前两位字母+三位数字的课程

-- 2. 插入 PE（体育课程）课程到 MajorRequiredCourse 表
-- 假设 PE 课程代码以 "PE" 开头
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
SELECT
    mi.code AS major_code,
    'PE101' AS course_code,  -- 假设 PE 课程代码为 PE101
    1 AS required_to_graduate,
    'root' AS created_by,
    'root' AS updated_by
FROM
    MajorInfo mi;

-- 3. 插入 PARC（某些课程）到 MajorRequiredCourse 表
-- 假设 PARC 课程代码以 "PARC" 开头
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
SELECT
    mi.code AS major_code,
    'PRAC101' AS course_code,  -- 假设 PARC 课程代码为 PARC101
    1 AS required_to_graduate,
    'root' AS created_by,
    'root' AS updated_by
FROM
    MajorInfo mi;

-- 4. 插入 LIT（文学课程）到 MajorRequiredCourse 表
-- 假设 LIT 课程代码以 "LIT" 开头
INSERT INTO MajorRequiredCourse (major_code, course_code, required_to_graduate, created_by, updated_by)
SELECT
    mi.code AS major_code,
    'LIT101' AS course_code,  -- 假设 LIT 课程代码为 LIT101
    1 AS required_to_graduate,
    'root' AS created_by,
    'root' AS updated_by
FROM
    MajorInfo mi;
