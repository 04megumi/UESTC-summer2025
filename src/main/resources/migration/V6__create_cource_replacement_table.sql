-- 课程替换表
CREATE TABLE IF NOT EXISTS CourseReplacement (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    old_course_code VARCHAR(20) NOT NULL COMMENT '被替换的旧课程代码',
    new_course_code VARCHAR(20) NOT NULL COMMENT '替代的新课程代码',
    major_code VARCHAR(20) DEFAULT NULL COMMENT '适用专业代码（可为空，通用替换）',
    effective_from DATE NOT NULL COMMENT '生效起始日期',
    effective_to DATE DEFAULT NULL COMMENT '生效截止日期',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    -- 外键约束
    CONSTRAINT fk_cr_old_course FOREIGN KEY (old_course_code) REFERENCES CourseInfo(course_code),
    CONSTRAINT fk_cr_new_course FOREIGN KEY (new_course_code) REFERENCES CourseInfo(course_code),
    CONSTRAINT fk_cr_major FOREIGN KEY (major_code) REFERENCES MajorInfo(code),
    UNIQUE KEY uq_old_new_major (old_course_code, new_course_code, major_code)
) COMMENT='课程替换表（旧课程顶替新课程）';

-- 索引推荐
CREATE INDEX idx_cr_old_course ON CourseReplacement(old_course_code);
CREATE INDEX idx_cr_new_course ON CourseReplacement(new_course_code);
CREATE INDEX idx_cr_major_code ON CourseReplacement(major_code);

-- 课程替换申请表
CREATE TABLE IF NOT EXISTS CourseReplacementApplication (
    application_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '申请ID',
    student_id CHAR(36) NOT NULL COMMENT '申请考生ID',
    old_course_code VARCHAR(20) NOT NULL COMMENT '被替换的旧课程代码',
    new_course_code VARCHAR(20) NOT NULL COMMENT '替代的新课程代码',
    reason TEXT COMMENT '替换申请理由',
    status ENUM('待审核','通过','驳回') DEFAULT '待审核' COMMENT '审核状态',
    apply_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
    review_time DATETIME COMMENT '审核时间',
    review_reason TEXT COMMENT '审核意见或驳回原因',
    admin_id CHAR(36) COMMENT '管理员ID（外键）',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    -- 外键约束
    CONSTRAINT fk_course_replacement_student FOREIGN KEY (student_id) REFERENCES StudentInfo(student_id),
    CONSTRAINT fk_course_replacement_old_course FOREIGN KEY (old_course_code) REFERENCES CourseInfo(course_code),
    CONSTRAINT fk_course_replacement_new_course FOREIGN KEY (new_course_code) REFERENCES CourseInfo(course_code),
    CONSTRAINT fk_course_replacement_admin FOREIGN KEY (admin_id) REFERENCES AdminInfo(admin_id),
    UNIQUE KEY uq_student_old_new_course (student_id, old_course_code, new_course_code)
) COMMENT='课程替换申请表';

-- 课程替换记录
INSERT INTO CourseReplacement (old_course_code, new_course_code, major_code, effective_from, effective_to, created_by, updated_by)
VALUES
    ('LIT101', 'LIT102', 'CS001', '2025-09-01', NULL, 'root', 'root'),  -- 中国古代文学替换为外国文学
    ('LIT103', 'LIT104', 'CS002', '2025-09-01', NULL, 'root', 'root'),  -- 现代汉语替换为古代汉语
    ('LIT105', 'LIT106', 'EE001', '2025-09-01', NULL, 'root', 'root'),  -- 文学理论替换为诗歌鉴赏
    ('LIT107', 'LIT108', 'ME001', '2025-09-01', NULL, 'root', 'root'),  -- 小说写作替换为戏剧文学
    ('LIT109', 'LIT110', 'BA001', '2025-09-01', NULL, 'root', 'root');  -- 散文与随笔替换为文学创作
