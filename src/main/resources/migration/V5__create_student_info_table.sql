-- 考生信息表
CREATE TABLE IF NOT EXISTS StudentInfo (
    student_id CHAR(36) PRIMARY KEY COMMENT '考籍号（主键，UUID）',
    name VARCHAR(50) UNIQUE KEY NOT NULL COMMENT '姓名',
    id_number CHAR(18) UNIQUE NOT NULL COMMENT '身份证号（唯一）',
    password VARCHAR(255) NOT NULL COMMENT '加密后的密码',
    major_code VARCHAR(20) NOT NULL COMMENT '报考专业代码（外键）',
    exam_center_name CHAR(36) COMMENT '州级考试院名称（外键）',
    gender ENUM('男','女') DEFAULT '男' COMMENT '性别',
    birth_date DATE COMMENT '出生日期',
    phone VARCHAR(20) COMMENT '联系电话',
    address VARCHAR(200) COMMENT '通讯地址',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    CONSTRAINT fk_student_major FOREIGN KEY (major_code) REFERENCES MajorInfo(code),
    CONSTRAINT fk_student_exam_center FOREIGN KEY (exam_center_name) REFERENCES ExamCenter(exam_center_name)
) COMMENT='考生信息表';

-- 索引
CREATE INDEX idx_student_id_number ON StudentInfo(id_number);
CREATE INDEX idx_student_major ON StudentInfo(major_code);
CREATE INDEX idx_student_exam_name ON StudentInfo(exam_center_name);

-- 插入 50 条考生信息数据，专业代码更新为 CS001 - CS005
INSERT INTO StudentInfo (
    student_id, name, id_number, password, major_code, exam_center_name, gender, birth_date, phone, address, created_by, updated_by
) VALUES
      (UUID(), '张三', '110101199001011234', 'hashed_password_1', 'CS001', '北京考试院', '男', '1990-01-01', '13800138001', '北京市朝阳区', 'admin', 'admin'),
      (UUID(), '李四', '110102199202022345', 'hashed_password_2', 'CS002', '北京考试院', '女', '1992-02-02', '13800138002', '北京市海淀区', 'admin', 'admin'),
      (UUID(), '王五', '110103199303033456', 'hashed_password_3', 'CS003', '北京考试院', '男', '1993-03-03', '13800138003', '北京市东城区', 'admin', 'admin'),
      (UUID(), '赵六', '110104199404044567', 'hashed_password_4', 'CS004', '北京考试院', '女', '1994-04-04', '13800138004', '北京市西城区', 'admin', 'admin'),
      (UUID(), '孙七', '110105199505055678', 'hashed_password_5', 'CS005', '北京考试院', '男', '1995-05-05', '13800138005', '北京市丰台区', 'admin', 'admin'),
      (UUID(), '周八', '110106199606066789', 'hashed_password_6', 'CS001', '北京考试院', '女', '1996-06-06', '13800138006', '北京市石景山区', 'admin', 'admin'),
      (UUID(), '吴九', '110107199707077890', 'hashed_password_7', 'CS002', '北京考试院', '男', '1997-07-07', '13800138007', '北京市昌平区', 'admin', 'admin'),
      (UUID(), '郑十', '110108199808088901', 'hashed_password_8', 'CS003', '北京考试院', '女', '1998-08-08', '13800138008', '北京市门头沟区', 'admin', 'admin'),
      (UUID(), '钱十一', '110109199909099012', 'hashed_password_9', 'CS004', '北京考试院', '男', '1999-09-09', '13800138009', '北京市通州区', 'admin', 'admin'),
      (UUID(), '李十二', '110110200010100123', 'hashed_password_10', 'CS005', '北京考试院', '女', '2000-10-10', '13800138010', '北京市顺义区', 'admin', 'admin'),
      (UUID(), '陈十三', '110111200111111234', 'hashed_password_11', 'CS001', '北京考试院', '男', '2001-11-11', '13800138011', '北京市平谷区', 'admin', 'admin'),
      (UUID(), '刘十四', '110112200212122345', 'hashed_password_12', 'CS002', '北京考试院', '女', '2002-12-12', '13800138012', '北京市怀柔区', 'admin', 'admin'),
      (UUID(), '赵十五', '110113200313133456', 'hashed_password_13', 'CS003', '北京考试院', '男', '2003-01-13', '13800138013', '北京市大兴区', 'admin', 'admin'),
      (UUID(), '杨十六', '110114200414144567', 'hashed_password_14', 'CS004', '北京考试院', '女', '2004-02-14', '13800138014', '北京市昌平区', 'admin', 'admin'),
      (UUID(), '黄十七', '110115200515155678', 'hashed_password_15', 'CS005', '北京考试院', '男', '2005-03-15', '13800138015', '北京市东城区', 'admin', 'admin'),
      (UUID(), '周十八', '110116200616166789', 'hashed_password_16', 'CS001', '北京考试院', '女', '2006-04-16', '13800138016', '北京市海淀区', 'admin', 'admin'),
      (UUID(), '吴十九', '110117200717177890', 'hashed_password_17', 'CS002', '北京考试院', '男', '2007-05-17', '13800138017', '北京市丰台区', 'admin', 'admin'),
      (UUID(), '郑二十', '110118200818188901', 'hashed_password_18', 'CS003', '北京考试院', '女', '2008-06-18', '13800138018', '北京市石景山区', 'admin', 'admin'),
      (UUID(), '钱二十一', '110119200919199012', 'hashed_password_19', 'CS004', '北京考试院', '男', '2009-07-19', '13800138019', '北京市昌平区', 'admin', 'admin'),
      (UUID(), '李二十二', '110120201020200123', 'hashed_password_20', 'CS005', '北京考试院', '女', '2010-08-20', '13800138020', '北京市通州区', 'admin', 'admin'),
      (UUID(), '陈二十三', '110121201121211234', 'hashed_password_21', 'CS001', '北京考试院', '男', '2011-09-21', '13800138021', '北京市顺义区', 'admin', 'admin'),
      (UUID(), '刘二十四', '110122201222222345', 'hashed_password_22', 'CS002', '北京考试院', '女', '2012-10-22', '13800138022', '北京市平谷区', 'admin', 'admin'),
      (UUID(), '赵二十五', '110123201323233456', 'hashed_password_23', 'CS003', '北京考试院', '男', '2013-11-23', '13800138023', '北京市怀柔区', 'admin', 'admin'),
      (UUID(), '杨二十六', '110124201424244567', 'hashed_password_24', 'CS004', '北京考试院', '女', '2014-12-24', '13800138024', '北京市大兴区', 'admin', 'admin'),
      (UUID(), '黄二十七', '110125201525255678', 'hashed_password_25', 'CS005', '北京考试院', '男', '2015-01-25', '13800138025', '北京市昌平区', 'admin', 'admin'),
      (UUID(), '周二十八', '110126201626266789', 'hashed_password_26', 'CS001', '北京考试院', '女', '2016-02-26', '13800138026', '北京市东城区', 'admin', 'admin'),
      (UUID(), '吴二十九', '110127201727277890', 'hashed_password_27', 'CS002', '北京考试院', '男', '2017-03-27', '13800138027', '北京市海淀区', 'admin', 'admin'),
      (UUID(), '郑三十', '110128201828288901', 'hashed_password_28', 'CS003', '北京考试院', '女', '2018-04-28', '13800138028', '北京市石景山区', 'admin', 'admin'),
      (UUID(), '钱三十一', '110129201929299012', 'hashed_password_29', 'CS004', '北京考试院', '男', '2019-05-29', '13800138029', '北京市昌平区', 'admin', 'admin'),
      (UUID(), '李三十二', '110130202030300123', 'hashed_password_30', 'CS005', '北京考试院', '女', '2020-06-30', '13800138030', '北京市顺义区', 'admin', 'admin'),
      (UUID(), '陈三十三', '110131202131311234', 'hashed_password_31', 'CS001', '北京考试院', '男', '2021-07-01', '13800138031', '北京市平谷区', 'admin', 'admin'),
      (UUID(), '刘三十四', '110132202232322345', 'hashed_password_32', 'CS002', '北京考试院', '女', '2022-08-02', '13800138032', '北京市怀柔区', 'admin', 'admin');
