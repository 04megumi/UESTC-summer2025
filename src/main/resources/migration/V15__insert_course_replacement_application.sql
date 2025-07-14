INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000002,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'LIT103',
    'LIT104',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000003,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'LIT105',
    'LIT106',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000004,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'LIT107',
    'LIT108',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000005,
    (SELECT student_id FROM StudentInfo WHERE name = '张三' LIMIT 1),
    'LIT109',
    'LIT110',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000006,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'LIT101',
    'LIT102',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000007,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'LIT103',
    'LIT104',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000008,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'LIT105',
    'LIT106',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000009,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'LIT107',
    'LIT108',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000010,
    (SELECT student_id FROM StudentInfo WHERE name = '李四' LIMIT 1),
    'LIT109',
    'LIT110',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000011,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'LIT101',
    'LIT102',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000012,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'LIT103',
    'LIT104',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000013,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'LIT105',
    'LIT106',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000014,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'LIT107',
    'LIT108',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000015,
    (SELECT student_id FROM StudentInfo WHERE name = '王五' LIMIT 1),
    'LIT109',
    'LIT110',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000016,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'LIT101',
    'LIT102',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000017,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'LIT103',
    'LIT104',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000018,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'LIT105',
    'LIT106',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000019,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'LIT107',
    'LIT108',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000020,
    (SELECT student_id FROM StudentInfo WHERE name = '赵六' LIMIT 1),
    'LIT109',
    'LIT110',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000021,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'LIT101',
    'LIT102',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000022,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'LIT103',
    'LIT104',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000023,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'LIT105',
    'LIT106',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000024,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'LIT107',
    'LIT108',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000025,
    (SELECT student_id FROM StudentInfo WHERE name = '孙七' LIMIT 1),
    'LIT109',
    'LIT110',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000026,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'LIT101',
    'LIT102',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000027,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'LIT103',
    'LIT104',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000028,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'LIT105',
    'LIT106',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000029,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'LIT107',
    'LIT108',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000030,
    (SELECT student_id FROM StudentInfo WHERE name = '周八' LIMIT 1),
    'LIT109',
    'LIT110',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000031,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'LIT101',
    'LIT102',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000032,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'LIT103',
    'LIT104',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000033,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'LIT105',
    'LIT106',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000034,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'LIT107',
    'LIT108',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);

INSERT INTO CourseReplacementApplication (
    application_id, student_id, old_course_code, new_course_code, reason,
    status, apply_time, admin_id, version, is_deleted, frozened, created_by, updated_by
) VALUES (
    2000000000035,
    (SELECT student_id FROM StudentInfo WHERE name = '吴九' LIMIT 1),
    'LIT109',
    'LIT110',
    '课程调整或教学计划变化',
    '待审核',
    NOW(),
    (SELECT admin_id FROM AdminInfo WHERE exam_center_name = '北京考试院' AND is_deleted = 0 LIMIT 1),
    0, 0, 0, 'admin', 'admin'
);