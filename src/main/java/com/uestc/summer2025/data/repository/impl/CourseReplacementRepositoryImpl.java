package com.uestc.summer2025.data.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uestc.summer2025.data.entity.CourseReplacement;
import com.uestc.summer2025.data.mapper.CourseReplacementMapper;
import com.uestc.summer2025.data.repository.CourseReplacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CourseReplacementRepositoryImpl implements CourseReplacementRepository {

    @Autowired
    private CourseReplacementMapper courseReplacementMapper;

    @Override
    public boolean addCourseReplacement(CourseReplacement courseReplacement) {
        int result = courseReplacementMapper.insert(courseReplacement);
        return result > 0;
    }

    @Override
    public boolean deleteCourseReplacement(CourseReplacement courseReplacement) {
        // 创建条件构造器，构建删除条件
        QueryWrapper<CourseReplacement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("old_course_code", courseReplacement.getOldCourseCode())
                .eq("new_course_code", courseReplacement.getNewCourseCode());
        // 如果专业代码不为空，则添加专业代码的条件
        if (courseReplacement.getMajorCode() != null) {
            queryWrapper.eq("major_code", courseReplacement.getMajorCode()).
                    eq("is_deleted", 0);
        }
        // 执行删除操作，返回是否成功
        int result = courseReplacementMapper.delete(queryWrapper);
        return result > 0;
    }

    @Override
    public List<CourseReplacement> loadAllCourseReplacement() {
        // 查询所有 CourseReplacement 数据
        return courseReplacementMapper.selectList(null);
    }

    @Override
    public List<CourseReplacement> loadCourseReplacementByPage(int pageNum, int pageSize) {
        // 使用 Page 对象进行分页查询
        Page<CourseReplacement> page = new Page<>(pageNum, pageSize);
        // 查询分页数据
        IPage<CourseReplacement> courseReplacementPage = courseReplacementMapper.selectPage(page, null);
        // 返回分页结果
        return courseReplacementPage.getRecords();
    }

    @Override
    public CourseReplacement findByCourseCodesAndMajor(String oldCourseCode, String newCourseCode, String majorCode) {
        return courseReplacementMapper.findByCourseCodesAndMajor(oldCourseCode, newCourseCode, majorCode);
    }

    @Override
    public boolean activateCourseReplacement(String oldCourseCode, String newCourseCode, String major) {
        return courseReplacementMapper.activateCourseReplacement(oldCourseCode, newCourseCode, major) > 0;
    }
}
