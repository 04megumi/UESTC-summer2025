-- 创建数据库，如果不存在的话
CREATE DATABASE IF NOT EXISTS summer2025_dev;

USE summer2025_dev;

-- 创建测试表 test
CREATE TABLE IF NOT EXISTS test (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- 主键
    name VARCHAR(255) NOT NULL,              -- 姓名字段
    age INT NOT NULL,                        -- 年龄字段
    version INT DEFAULT 0,                   -- 乐观锁字段，默认值为 0
    is_deleted BOOLEAN DEFAULT FALSE,        -- 逻辑删除字段，默认值为 FALSE
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 创建时间，默认当前时间
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- 更新时间，默认当前时间，并在每次更新时自动更新
    created_by VARCHAR(255),                 -- 创建者字段
    updated_by VARCHAR(255)                  -- 更新者字段
);

-- 插入一些数据
INSERT INTO test (name, age) VALUES
('Alice', 30),
('Bob', 25),
('Charlie', 28);