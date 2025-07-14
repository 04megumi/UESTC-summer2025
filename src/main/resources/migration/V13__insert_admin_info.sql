INSERT INTO AdminInfo (admin_id, password, full_name, phone, email, exam_center_name, version, is_deleted, frozened, create_time, update_time, created_by, updated_by)
VALUES
    (UUID(), 'admin_password_hash32', '师三十四', '010-10000001', 'admin_tianjin@example.com', '天津考试院', 0, 0, 0, NOW(), NOW(), 'root', 'root'),
    (UUID(), 'admin_password_hash33', '师三十五', '0311-10000002', 'admin_hebei@example.com', '河北考试院', 0, 0, 0, NOW(), NOW(), 'root', 'root'),
    (UUID(), 'admin_password_hash34', '师三十六', '0351-10000003', 'admin_shanxi@example.com', '山西考试院', 0, 0, 0, NOW(), NOW(), 'root', 'root'),
    (UUID(), 'admin_password_hash35', '师三十七', '0471-10000004', 'admin_neimenggu@example.com', '内蒙古考试院', 0, 0, 0, NOW(), NOW(), 'root', 'root'),
    (UUID(), 'admin_password_hash36', '师三十八', '024-10000005', 'admin_liaoning@example.com', '辽宁考试院', 0, 0, 0, NOW(), NOW(), 'root', 'root'),
    (UUID(), 'admin_password_hash37', '师三十九', '0431-10000006', 'admin_jilin@example.com', '吉林考试院', 0, 0, 0, NOW(), NOW(), 'root', 'root'),
    (UUID(), 'admin_password_hash39', '师四十一', '0891-10000008', 'admin_xizang@example.com', '海南考试院', 0, 0, 0, NOW(), NOW(), 'root', 'root'),
    (UUID(), 'admin_password_hash40', '师四十二', '0991-10000009', 'admin_xinjiang@example.com', '北京考试院', 0, 0, 0, NOW(), NOW(), 'root', 'root'),
    (UUID(), 'admin_password_hash41', '师四十三', '010-10000010', 'admin_quanguo@example.com', '全国考试院', 0, 0, 0, NOW(), NOW(), 'root', 'root');