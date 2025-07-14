INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000001,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'LIT101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '优异成绩免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000002,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'CS302',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学分互认免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000003,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'LIT104',
    (SELECT rule_id FROM ExemptionRule WHERE name = '基础课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000004,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'CS305',
    (SELECT rule_id FROM ExemptionRule WHERE name = '前置课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000005,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'LIT106',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程免考标准' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000006,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'CS307',
    (SELECT rule_id FROM ExemptionRule WHERE name = '国际学分认证' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000007,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'PRAC103',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学术考试免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000008,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'CS308',
    (SELECT rule_id FROM ExemptionRule WHERE name = '项目完成免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000009,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'PE101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '成绩优异免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000010,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'LIT109',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程转换免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000011,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'LIT101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '优异成绩免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000012,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'CS302',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学分互认免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000013,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'LIT104',
    (SELECT rule_id FROM ExemptionRule WHERE name = '基础课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000014,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'CS305',
    (SELECT rule_id FROM ExemptionRule WHERE name = '前置课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000015,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'LIT106',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程免考标准' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000016,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'CS307',
    (SELECT rule_id FROM ExemptionRule WHERE name = '国际学分认证' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000017,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'PRAC103',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学术考试免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000018,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'CS308',
    (SELECT rule_id FROM ExemptionRule WHERE name = '项目完成免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000019,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'PE101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '成绩优异免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000020,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'LIT109',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程转换免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000021,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'LIT101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '优异成绩免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000022,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'CS302',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学分互认免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000023,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'LIT104',
    (SELECT rule_id FROM ExemptionRule WHERE name = '基础课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000024,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'CS305',
    (SELECT rule_id FROM ExemptionRule WHERE name = '前置课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000025,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'LIT106',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程免考标准' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000026,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'CS307',
    (SELECT rule_id FROM ExemptionRule WHERE name = '国际学分认证' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000027,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'PRAC103',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学术考试免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000028,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'CS308',
    (SELECT rule_id FROM ExemptionRule WHERE name = '项目完成免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000029,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'PE101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '成绩优异免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000030,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'LIT109',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程转换免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000031,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'LIT101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '优异成绩免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000032,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'CS302',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学分互认免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000033,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'LIT104',
    (SELECT rule_id FROM ExemptionRule WHERE name = '基础课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000034,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'CS305',
    (SELECT rule_id FROM ExemptionRule WHERE name = '前置课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000035,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'LIT106',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程免考标准' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000036,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'CS307',
    (SELECT rule_id FROM ExemptionRule WHERE name = '国际学分认证' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000037,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'PRAC103',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学术考试免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000038,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'CS308',
    (SELECT rule_id FROM ExemptionRule WHERE name = '项目完成免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000039,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'PE101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '成绩优异免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000040,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'LIT109',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程转换免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000041,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'LIT101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '优异成绩免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000042,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'CS302',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学分互认免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000043,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'LIT104',
    (SELECT rule_id FROM ExemptionRule WHERE name = '基础课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000044,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'CS305',
    (SELECT rule_id FROM ExemptionRule WHERE name = '前置课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000045,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'LIT106',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程免考标准' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000046,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'CS307',
    (SELECT rule_id FROM ExemptionRule WHERE name = '国际学分认证' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000047,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'PRAC103',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学术考试免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000048,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'CS308',
    (SELECT rule_id FROM ExemptionRule WHERE name = '项目完成免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000049,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'PE101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '成绩优异免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000050,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'LIT109',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程转换免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000051,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'LIT101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '优异成绩免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000052,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'CS302',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学分互认免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000053,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'LIT104',
    (SELECT rule_id FROM ExemptionRule WHERE name = '基础课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000054,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'CS305',
    (SELECT rule_id FROM ExemptionRule WHERE name = '前置课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000055,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'LIT106',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程免考标准' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000056,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'CS307',
    (SELECT rule_id FROM ExemptionRule WHERE name = '国际学分认证' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000057,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'PRAC103',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学术考试免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000058,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'CS308',
    (SELECT rule_id FROM ExemptionRule WHERE name = '项目完成免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000059,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'PE101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '成绩优异免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000060,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'LIT109',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程转换免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000061,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'LIT101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '优异成绩免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000062,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'CS302',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学分互认免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000063,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'LIT104',
    (SELECT rule_id FROM ExemptionRule WHERE name = '基础课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000064,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'CS305',
    (SELECT rule_id FROM ExemptionRule WHERE name = '前置课程免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000065,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'LIT106',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程免考标准' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000066,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'CS307',
    (SELECT rule_id FROM ExemptionRule WHERE name = '国际学分认证' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000067,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'PRAC103',
    (SELECT rule_id FROM ExemptionRule WHERE name = '学术考试免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000068,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'CS308',
    (SELECT rule_id FROM ExemptionRule WHERE name = '项目完成免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000069,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'PE101',
    (SELECT rule_id FROM ExemptionRule WHERE name = '成绩优异免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO ExemptionApplication (
    application_id, student_id, course_code, rule_id, status, apply_time,
    admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    1000000000070,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'LIT109',
    (SELECT rule_id FROM ExemptionRule WHERE name = '课程转换免考' LIMIT 1),
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);