package com.uestc.summer2025.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uestc.summer2025.data.entity.CourseReplacementApplication;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程替换申请表 Mapper 接口
 * 提供 CourseReplacementApplication 实体的基本 CRUD 操作
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Mapper
public interface CourseReplacementApplicationMapper extends BaseMapper<CourseReplacementApplication> {

}