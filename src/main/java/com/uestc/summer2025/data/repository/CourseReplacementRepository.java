package com.uestc.summer2025.data.repository;

import com.uestc.summer2025.data.entity.CourseReplacement;
import java.util.List;

/**
 * 课程替换类接口
 *
 * author: 魏子越
 * date: 2025/07/13
 */
public interface CourseReplacementRepository {

    public List<CourseReplacement> getAllCourseReplacements();

}
