package com.uestc.summer2025.data.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uestc.summer2025.data.entity.CourseReplacement;
import com.uestc.summer2025.data.mapper.CourseReplacementMapper;
import com.uestc.summer2025.data.repository.CourseReplacementRepository;
import com.uestc.summer2025.web.vo.CourseReplacementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
            queryWrapper.eq("major_code", courseReplacement.getMajorCode());
        }
        // 执行删除操作，返回是否成功
        int result = courseReplacementMapper.delete(queryWrapper);
        return result > 0;
    }


    @Override
    public List<CourseReplacementVO> loadAllCourseReplacement() {
        // 查询所有 CourseReplacement 数据
        List<CourseReplacement> courseReplacementList = courseReplacementMapper.selectList(null);
        // 将 CourseReplacement 转换成 CourseReplacementVO 并返回
        return courseReplacementList.stream()
                .map(this::toVO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseReplacementVO> loadCourseReplacementByPage(int pageNum, int pageSize) {
        // 使用 Page 对象进行分页查询
        Page<CourseReplacement> page = new Page<>(pageNum, pageSize);
        // 查询分页数据
        IPage<CourseReplacement> courseReplacementPage = courseReplacementMapper.selectPage(page, null);
        // 将 CourseReplacement 转换成 CourseReplacementVO 并返回
        return courseReplacementPage.getRecords().stream()
                .map(this::toVO)
                .collect(Collectors.toList());
    }


    /**
     * 通过实体转换成VO，并做名字映射
     */
    @Override
    public CourseReplacementVO toVO(CourseReplacement entity) {
        return new CourseReplacementVO();
    }
}