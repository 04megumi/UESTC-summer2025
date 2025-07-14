package com.uestc.summer2025.data.repository;

import com.uestc.summer2025.data.entity.CourseReplacement;

import java.util.List;

/**
 * 课程替换相关数据访问接口
 *
 * 该接口定义了对 CourseReplacement 实体的基本 CRUD 操作及分页查询。
 * 负责操作数据库中课程替换相关的数据记录，包括添加、删除和查询课程替换记录。
 *
 * author: 魏子越
 * date: 2025/07/13
 */
public interface CourseReplacementRepository {

    /**
     * 新增课程替换记录
     *
     * @param courseReplacement 课程替换实体，包含旧课程代码、新课程代码、专业代码等信息
     * @return 操作是否成功，true 表示新增成功，false 表示失败
     */
    boolean addCourseReplacement(CourseReplacement courseReplacement);

    /**
     * 删除课程替换记录
     *
     * @param courseReplacement 课程替换实体，作为删除条件使用（根据旧课程代码、新课程代码以及专业代码）
     * @return 操作是否成功，true 表示删除成功，false 表示失败
     */
    boolean deleteCourseReplacement(CourseReplacement courseReplacement);

    /**
     * 查询所有课程替换记录（无分页）
     *
     * @return 返回所有课程替换的列表
     */
    List<CourseReplacement> loadAllCourseReplacement();

    /**
     * 分页查询课程替换记录
     *
     * @param pageNum 当前页码，从1开始
     * @param pageSize 每页记录数
     * @return 返回指定页的课程替换记录列表
     */
    List<CourseReplacement> loadCourseReplacementByPage(int pageNum, int pageSize);

    CourseReplacement findByCourseCodesAndMajor(String oldCourseCode, String newCourseCode, String major);

    boolean activateCourseReplacement(String oldCourseCode, String newCourseCode, String major);
}
