-- 州级考试院信息
CREATE TABLE IF NOT EXISTS ExamCenter (
    exam_center_id CHAR(36) PRIMARY KEY COMMENT '考试院ID（UUID，主键）',
    exam_center_name VARCHAR(100) NOT NULL COMMENT '考试院名称',
    state_code VARCHAR(20) NOT NULL COMMENT '所属省的代码',
    state_name VARCHAR(50) NOT NULL COMMENT '所属省的名称',
    address VARCHAR(200) COMMENT '考试院地址',
    phone VARCHAR(20) COMMENT '联系电话',
    email VARCHAR(100) COMMENT '电子邮箱',
    -- 通用基类字段
    version INT DEFAULT 0 COMMENT '乐观锁版本号',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被逻辑删除',
    frozened TINYINT(1) DEFAULT 0 COMMENT '是否被冻结',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    created_by VARCHAR(50) COMMENT '创建者',
    updated_by VARCHAR(50) COMMENT '更新者',
    -- 联合唯一索引：考试院名称，所属省代码，所属省名称
    UNIQUE KEY unique_exam_center (exam_center_name, state_code, state_name),
    INDEX idx_exam_center_name (exam_center_name),
    INDEX idx_state_code (state_code)
) COMMENT='州级考试院信息表';


-- 插入全国各省考试院信息
INSERT INTO ExamCenter (exam_center_id, exam_center_name, state_code, state_name, address, phone, email, created_by, updated_by)
VALUES
    (UUID(), '北京考试院', 'BJ', '北京市', '北京市海淀区中关村大街27号', '010-12345678', 'contact@bjexamcenter.com', 'root', 'root'),
    (UUID(), '天津考试院', 'TJ', '天津市', '天津市和平区南京路150号', '022-23456789', 'contact@tjexamcenter.com', 'root', 'root'),
    (UUID(), '河北考试院', 'HE', '河北省', '河北省石家庄市长安区建设北大街123号', '0311-34567890', 'contact@hebeiexamcenter.com', 'root', 'root'),
    (UUID(), '山西考试院', 'SX', '山西省', '山西省太原市迎泽大街456号', '0351-45678901', 'contact@shanxiexamcenter.com', 'root', 'root'),
    (UUID(), '内蒙古考试院', 'NM', '内蒙古自治区', '内蒙古呼和浩特市新华大街789号', '0471-56789012', 'contact@neimengguexamcenter.com', 'root', 'root'),
    (UUID(), '辽宁考试院', 'LN', '辽宁省', '辽宁省沈阳市沈河区文化路101号', '024-67890123', 'contact@liaoningexamcenter.com', 'root', 'root'),
    (UUID(), '吉林考试院', 'JL', '吉林省', '吉林省长春市朝阳区南昌路202号', '0431-78901234', 'contact@jilinexamcenter.com', 'root', 'root'),
    (UUID(), '黑龙江考试院', 'HL', '黑龙江省', '黑龙江省哈尔滨市南岗区红旗大街303号', '0451-89012345', 'contact@heilongjiangexamcenter.com', 'root', 'root'),
    (UUID(), '上海考试院', 'SH', '上海市', '上海市浦东新区世博大道404号', '021-90123456', 'contact@shanghaiexamcenter.com', 'root', 'root'),
    (UUID(), '江苏考试院', 'JS', '江苏省', '江苏省南京市建邺路505号', '025-12345678', 'contact@jiangsuexamcenter.com', 'root', 'root'),
    (UUID(), '浙江考试院', 'ZJ', '浙江省', '浙江省杭州市西湖区灵隐路606号', '0571-23456789', 'contact@zhejiangexamcenter.com', 'root', 'root'),
    (UUID(), '安徽考试院', 'AH', '安徽省', '安徽省合肥市庐阳区寿春路707号', '0551-34567890', 'contact@anhuiexamcenter.com', 'root', 'root'),
    (UUID(), '福建考试院', 'FJ', '福建省', '福建省福州市鼓楼区东街口808号', '0591-45678901', 'contact@fujianexamcenter.com', 'root', 'root'),
    (UUID(), '江西考试院', 'JX', '江西省', '江西省南昌市东湖区八一大道909号', '0791-56789012', 'contact@jiangxiexamcenter.com', 'root', 'root'),
    (UUID(), '山东考试院', 'SD', '山东省', '山东省济南市历下区泉城路1010号', '0531-67890123', 'contact@shandongexamcenter.com', 'root', 'root'),
    (UUID(), '河南考试院', 'HA', '河南省', '河南省郑州市金水区花园路1111号', '0371-78901234', 'contact@henanexamcenter.com', 'root', 'root'),
    (UUID(), '湖北考试院', 'HB', '湖北省', '湖北省武汉市武昌区中南路1212号', '027-89012345', 'contact@hubeiexamcenter.com', 'root', 'root'),
    (UUID(), '湖南考试院', 'HN', '湖南省', '湖南省长沙市岳麓区潇湘路1313号', '0731-90123456', 'contact@hunaneexamcenter.com', 'root', 'root'),
    (UUID(), '广东考试院', 'GD', '广东省', '广东省广州市天河路1414号', '020-12345678', 'contact@guangdongexamcenter.com', 'root', 'root'),
    (UUID(), '广西考试院', 'GX', '广西自治区', '广西南宁市青秀区民族大道1515号', '0771-23456789', 'contact@guangxiexamcenter.com', 'root', 'root'),
    (UUID(), '海南考试院', 'HI', '海南省', '海南省海口市秀英区海府路1616号', '0898-34567890', 'contact@hainanexamcenter.com', 'root', 'root'),
    (UUID(), '重庆考试院', 'CQ', '重庆市', '重庆市渝中区大坪路1717号', '023-45678901', 'contact@chongqingexamcenter.com', 'root', 'root'),
    (UUID(), '四川考试院', 'SC', '四川省', '四川省成都市锦江区春熙路1818号', '028-56789012', 'contact@scsexeamcenter.com', 'root', 'root'),
    (UUID(), '贵州考试院', 'GZ', '贵州省', '贵州省贵阳市南明区中华路1919号', '0851-67890123', 'contact@guizhouexamcenter.com', 'root', 'root'),
    (UUID(), '云南考试院', 'YN', '云南省', '云南省昆明市官渡区滇池路2020号', '0871-78901234', 'contact@yunnanexamcenter.com', 'root', 'root'),
    (UUID(), '西藏考试院', 'XZ', '西藏自治区', '西藏拉萨市城关区北京中路2121号', '0891-89012345', 'contact@xizangexamcenter.com', 'root', 'root'),
    (UUID(), '陕西考试院', 'SN', '陕西省', '陕西省西安市碑林区南大街2222号', '029-90123456', 'contact@shanxiexamcenter.com', 'root', 'root'),
    (UUID(), '甘肃考试院', 'GS', '甘肃省', '甘肃省兰州市城关区和平街2323号', '0931-23456789', 'contact@gansuexamcenter.com', 'root', 'root'),
    (UUID(), '青海考试院', 'QH', '青海省', '青海省西宁市城东区五四大街2424号', '0971-56789012', 'contact@qinghaiexamcenter.com', 'root', 'root'),
    (UUID(), '宁夏考试院', 'NX', '宁夏自治区', '宁夏银川市兴庆区金凤街2525号', '0951-67890123', 'contact@ningxiaexamcenter.com', 'root', 'root'),
    (UUID(), '新疆考试院', 'XJ', '新疆自治区', '新疆乌鲁木齐市天山区友好路2626号', '0991-78901234', 'contact@xinjiangexamcenter.com', 'root', 'root'),
    (UUID(), '全国考试院', 'CN', '全国', '全国考试中心总部地址', '010-00000000', 'contact@nationalexamcenter.com', 'root', 'root');