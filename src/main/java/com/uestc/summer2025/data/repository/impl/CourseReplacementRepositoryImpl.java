package com.uestc.summer2025.data.repository.impl;

import com.uestc.summer2025.data.entity.CourseReplacement;
import com.uestc.summer2025.data.mapper.CourseInfoMapper;
import com.uestc.summer2025.data.mapper.CourseReplacementMapper;
import com.uestc.summer2025.data.mapper.MajorInfoMapper;
import com.uestc.summer2025.data.repository.CourseReplacementRepository;
import com.uestc.summer2025.web.vo.CourseReplacementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseReplacementRepositoryImpl implements CourseReplacementRepository {

    @Autowired
    private CourseReplacementMapper courseReplacementMapper;

    @Autowired
    private MajorInfoMapper majorInfoMapper;

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Override
    public boolean addCourseReplacement(CourseReplacement courseReplacement) {
        return  true;
    }

    @Override
    public boolean deleteCourseReplacement(CourseReplacement courseReplacement) {
        return false;
    }

    @Override
    public List<CourseReplacementVO> loadAllCourseReplacement() {
        return null;
    }

    @Override
    public List<CourseReplacementVO> loadCourseReplacementByPage(int pageNum, int pageSize) {
        return new ArrayList<>();
    }

    /**
     * 通过实体转换成VO，并做名字映射
     */
    @Override
    public CourseReplacementVO toVO(CourseReplacement entity) {
        return new CourseReplacementVO();
    }
}