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

-- 插入管理员信息表
INSERT INTO AdminInfo (admin_id, password, full_name, phone, email, exam_center_id, created_by, updated_by)
VALUES
    (UUID(), 'admin_password_hash1', '张三', '010-11112222', 'admin_bj@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '北京考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash2', '李四', '022-33334444', 'admin_tj@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '天津考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash3', '王五', '0311-55556666', 'admin_hebei@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '河北考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash4', '赵六', '0351-77778888', 'admin_shanxi@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '山西考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash5', '钱七', '0471-99990000', 'admin_neimenggu@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '内蒙古考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash6', '孙八', '024-22223333', 'admin_liaoning@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '辽宁考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash7', '周九', '0431-44445555', 'admin_jilin@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '吉林考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash8', '吴十', '0451-66667777', 'admin_heilongjiang@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '黑龙江考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash9', '郑十一', '021-88889999', 'admin_shanghai@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '上海考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash10', '冯十二', '025-11112222', 'admin_jiangsu@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '江苏考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash11', '陈十三', '0571-33334444', 'admin_zhejiang@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '浙江考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash12', '褚十四', '0551-55556666', 'admin_anhui@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '安徽考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash13', '卫十五', '0591-77778888', 'admin_fujian@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '福建考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash14', '蒋十六', '0791-99990000', 'admin_jiangxi@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '江西考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash15', '沈十七', '0531-22223333', 'admin_shandong@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '山东考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash16', '韩十八', '0371-44445555', 'admin_henan@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '河南考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash17', '杨十九', '027-66667777', 'admin_hubei@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '湖北考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash18', '朱二十', '0731-88889999', 'admin_hunan@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '湖南考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash19', '秦二十一', '020-11112222', 'admin_guangdong@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '广东考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash20', '尤二十二', '0771-33334444', 'admin_guangxi@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '广西考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash21', '许二十三', '0898-55556666', 'admin_hainan@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '海南考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash22', '何二十四', '023-77778888', 'admin_chongqing@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '重庆考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash23', '吕二十五', '028-99990000', 'admin_sichuan@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '四川考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash24', '施二十六', '0851-11112222', 'admin_guizhou@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '贵州考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash25', '张二十七', '0871-33334444', 'admin_yunnan@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '云南考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash26', '李二十八', '0891-55556666', 'admin_xizang@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '西藏考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash27', '王二十九', '029-77778888', 'admin_shaanxi@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '陕西考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash28', '赵三十', '0931-99990000', 'admin_gansu@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '甘肃考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash29', '钱三十一', '0971-11112222', 'admin_qinghai@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '青海考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash30', '孙三十二', '0951-33334444', 'admin_ningxia@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '宁夏考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash31', '周三十三', '0991-55556666', 'admin_xinjiang@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '新疆考试院'), 'root', 'root'),
    (UUID(), 'admin_password_hash32', '吴三十四', '010-88889999', 'admin_national@example.com', (SELECT exam_center_id FROM ExamCenter WHERE exam_center_name = '全国考试院'), 'root', 'root');