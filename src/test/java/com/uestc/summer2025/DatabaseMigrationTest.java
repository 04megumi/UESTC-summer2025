package com.uestc.summer2025;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 测试 Flyway
 * 检查是否有 summer2025_dev 数据库和 test 表
 * 验证 Flyway 是否正确执行数据库迁移
 *
 * author: 魏子越
 * date: 2025/07/11
 */

@SpringBootTest
class DatabaseMigrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 测试数据库和表的创建，并检查数据是否正确插入
     */
    @Test
    void testDatabaseAndTableCreation() {
        // 确认连接的数据库为 summer2025_dev
        String dbCheckSql = "SELECT DATABASE()";
        String currentDb = jdbcTemplate.queryForObject(dbCheckSql, String.class);
        assertEquals("summer2025_dev", currentDb, "数据库应该是 summer2025_dev");

        // 检查插入的第一条数据
        String selectDataSql = "SELECT name FROM test WHERE id = 1";
        String name = jdbcTemplate.queryForObject(selectDataSql, String.class);
        assertEquals("Alice", name, "第一条数据的 name 应该是 Alice");
    }
}