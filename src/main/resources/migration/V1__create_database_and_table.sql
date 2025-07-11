-- 创建数据库，如果不存在的话
CREATE DATABASE IF NOT EXISTS summer2025_dev;

USE summer2025_dev;

-- 创建测试表 test
CREATE TABLE IF NOT EXISTS test (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

-- 插入一些数据
INSERT INTO test (name, age) VALUES
('Alice', 30),
('Bob', 25),
('Charlie', 28);