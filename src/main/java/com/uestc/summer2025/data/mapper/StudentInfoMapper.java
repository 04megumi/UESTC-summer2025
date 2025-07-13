package com.uestc.summer2025.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uestc.summer2025.data.entity.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 考生信息表 Mapper 接口
 * 提供 StudentInfo 实体的 CRUD 操作
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {
    // 可以添加自定义查询方法
}