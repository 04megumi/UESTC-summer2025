package com.uestc.summer2025.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uestc.summer2025.data.entity.CourseReplacement;
import org.apache.ibatis.annotations.*;

/**
 * 课程替换表 Mapper 接口
 * 提供 CourseReplacement 实体的基本 CRUD 操作
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Mapper
public interface CourseReplacementMapper extends BaseMapper<CourseReplacement> {

    @Select("SELECT old_course_code, new_course_code, major_code, is_deleted FROM CourseReplacement WHERE old_course_code = #{oldCourseCode} " +
            "AND new_course_code = #{newCourseCode} AND major_code = #{majorCode}")
    @Results({
            @Result(property = "oldCourseCode", column = "old_course_code"),
            @Result(property = "newCourseCode", column = "new_course_code"),
            @Result(property = "majorCode", column = "major_code"),
            @Result(property = "isDeleted", column = "is_deleted")
    })
    CourseReplacement findByCourseCodesAndMajor(@Param("oldCourseCode") String oldCourseCode,
                                                @Param("newCourseCode") String newCourseCode,
                                                @Param("majorCode") String majorCode);


    @Update("UPDATE CourseReplacement " +
            "SET is_deleted = 0 " +  // 设置 is_deleted 为 0，表示激活或恢复记录
            "WHERE old_course_code = #{oldCourseCode} " +
            "AND new_course_code = #{newCourseCode} " +
            "AND major_code = #{majorCode} " +
            "AND is_deleted = 1")  // 确保只更新软删除的记录
    int activateCourseReplacement(@Param("oldCourseCode") String oldCourseCode,
                                  @Param("newCourseCode") String newCourseCode,
                                  @Param("majorCode") String majorCode);
}