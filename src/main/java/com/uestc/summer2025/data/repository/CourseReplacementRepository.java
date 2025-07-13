package com.uestc.summer2025.data.repository;

import com.uestc.summer2025.data.web.dto.CourseReplacementDTO;
import com.uestc.summer2025.data.web.vo.CourseReplacementVO;

import java.util.List;

/**
 * 课程替换相关数据访问接口
 *
 * author: 魏子越
 * date: 2025/07/13
 */
public interface CourseReplacementRepository {

    /**
     * 新增课程替换记录
     * @param dto 课程替换DTO对象，包含必要信息（旧课程名、新课程名、专业名等）
     * @return 操作是否成功，true 表示新增成功，false 表示失败
     */
    boolean addCourseReplacement(CourseReplacementDTO dto);

    /**
     * 删除课程替换记录
     * @param dto 课程替换DTO对象，根据具体字段进行删除条件匹配
     * @return 操作是否成功，true 表示删除成功，false 表示失败
     */
    boolean deleteCourseReplacement(CourseReplacementDTO dto);

    /**
     * 查询所有课程替换记录（无分页）
     * @return 课程替换VO列表
     */
    List<CourseReplacementVO> loadAllCourseReplacement();

    /**
     * 分页查询课程替换记录
     * @param pageNum 当前页码，从1开始
     * @param pageSize 每页记录数
     * @return 课程替换VO列表，分页结果
     */
    List<CourseReplacementVO> loadCourseReplacementByPage(int pageNum, int pageSize);
}