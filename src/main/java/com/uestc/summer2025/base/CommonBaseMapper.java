package com.uestc.summer2025.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 扩展 Mapper 接口
 * 所有实体类的 Mapper 都应该继承此接口
 *
 * author: 魏子越
 * date: 2025/07/11
 */

public interface CommonBaseMapper<T extends CommonBaseEntity<?>> extends BaseMapper<T> {
    // 批量插入
    int insertBatch(List<T> list);

    // 批量删除（逻辑删除）
    int deleteBatch(List<Long> ids);

    // 分页查询
    Page<T> selectPage(Page<T> page, T entity);

    // 自定义查询，按条件查询
    List<T> selectListByCondition(T entity);
}
