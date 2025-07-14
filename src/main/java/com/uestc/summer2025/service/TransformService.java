package com.uestc.summer2025.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uestc.summer2025.data.mapper.CourseInfoMapper;
import com.uestc.summer2025.data.mapper.MajorInfoMapper;
import com.uestc.summer2025.data.entity.CourseInfo;
import com.uestc.summer2025.data.entity.MajorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformService {

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Autowired
    private MajorInfoMapper majorInfoMapper;

    /**
     * 根据课程名称获取课程ID（考虑软删除字段）。
     *
     * @param courseName 课程名称
     * @return 课程ID，如果找不到对应课程，返回 null。
     */
    public String courseNameToId(String courseName) {
        // 使用 QueryWrapper 构建查询条件
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", courseName)  // 根据课程名称查询
                .eq("is_deleted", 0);  // 仅查询未删除的记录
        // 执行查询
        CourseInfo courseInfo = courseInfoMapper.selectOne(queryWrapper);
        // 如果找到了对应的课程信息，返回课程ID，否则返回 null
        return (courseInfo != null) ? courseInfo.getCourseCode() : null;
    }

    /**
     * 根据课程ID获取课程名称（考虑软删除字段）。
     *
     * @param courseId 课程ID
     * @return 课程名称，如果找不到对应课程，返回 null。
     */
    public String courseIdToName(String courseId) {
        // 使用 QueryWrapper 构建查询条件
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_code", courseId)  // 根据课程ID查询
                .eq("is_deleted", 0);  // 仅查询未删除的记录
        // 执行查询
        CourseInfo courseInfo = courseInfoMapper.selectOne(queryWrapper);
        // 如果找到了对应的课程信息，返回课程名称，否则返回 null
        return (courseInfo != null) ? courseInfo.getName() : null;
    }

    /**
     * 根据专业ID获取专业名称（考虑软删除字段）。
     *
     * @param majorId 专业ID
     * @return 专业名称，如果找不到对应专业，返回 null。
     */
    public String majorIdToName(String majorId) {
        // 使用 QueryWrapper 构建查询条件
        QueryWrapper<MajorInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", majorId)  // 根据专业ID查询
                .eq("is_deleted", 0);  // 仅查询未删除的记录
        // 执行查询
        MajorInfo majorInfo = majorInfoMapper.selectOne(queryWrapper);
        // 如果找到了对应的专业信息，返回专业名称，否则返回 null
        return (majorInfo != null) ? majorInfo.getName() : null;
    }

    /**
     * 根据专业名称获取专业ID（考虑软删除字段）。
     *
     * @param majorName 专业名称
     * @return 专业ID，如果找不到对应专业，返回 null。
     */
    public String majorNameToId(String majorName) {
        // 使用 QueryWrapper 构建查询条件
        QueryWrapper<MajorInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", majorName)  // 根据专业名称查询
                .eq("is_deleted", 0);  // 仅查询未删除的记录
        // 执行查询
        MajorInfo majorInfo = majorInfoMapper.selectOne(queryWrapper);
        // 如果找到了对应的专业信息，返回专业ID，否则返回 null
        return (majorInfo != null) ? majorInfo.getCode() : null;
    }
}
