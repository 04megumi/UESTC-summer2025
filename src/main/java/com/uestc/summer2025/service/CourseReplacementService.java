package com.uestc.summer2025.service;

import com.uestc.summer2025.data.entity.CourseReplacement;
import com.uestc.summer2025.data.repository.CourseReplacementRepository;
import com.uestc.summer2025.web.dto.CourseReplacementDTO;
import com.uestc.summer2025.web.vo.CourseReplacementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseReplacementService {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private CourseReplacementRepository courseReplacementRepository;

    public boolean addCourseReplacement(CourseReplacementDTO dto) {
        // 从缓存获取旧课程代码和新课程代码
        String oldCourseCode = cacheService.getCourseCodeFromCache(dto.getOldCourseName());
        String newCourseCode = cacheService.getCourseCodeFromCache(dto.getNewCourseName());
        String majorCode = cacheService.getMajorCodeFromCache(dto.getMajorName());
        // 缓存可能没有数据，做个判空处理
        if (oldCourseCode == null || newCourseCode == null) {
            // 可以抛出异常或者返回失败
            throw new IllegalArgumentException("Invalid course code from cache.");
        }
        // 创建 CourseReplacement 实体
        CourseReplacement courseReplacement = courseReplacementRepository.findByCourseCodesAndMajor(
                oldCourseCode, newCourseCode, majorCode
        );
        if (courseReplacement != null && courseReplacement.isActivate()) {
            return courseReplacementRepository.addCourseReplacement(courseReplacement);
        } else {
            throw new IllegalArgumentException("Invalid course code from cache.");
        }
    }


    public boolean deleteCourseReplacement(CourseReplacementDTO dto) {
        // 从缓存获取旧课程代码和新课程代码
        String oldCourseCode = cacheService.getCourseCodeFromCache(dto.getOldCourseName());
        String newCourseCode = cacheService.getCourseCodeFromCache(dto.getNewCourseName());
        String majorCode = cacheService.getMajorCodeFromCache(dto.getMajorName());
        // 缓存可能没有数据，做个判空处理
        if (oldCourseCode == null || newCourseCode == null) {
            // 可以抛出异常或者返回失败
            throw new IllegalArgumentException("Invalid course code from cache.");
        }
        // 查询是否存在该记录
        CourseReplacement courseReplacement = courseReplacementRepository.findByCourseCodesAndMajor(
                oldCourseCode, newCourseCode, majorCode);
        if (courseReplacement != null) {
            // 删除该记录
            return courseReplacementRepository.deleteCourseReplacement(courseReplacement);
        } else {
            // 如果没有找到记录，可以抛出异常或者返回失败
            throw new IllegalArgumentException("Course replacement record not found.");
        }
    }


    public List<CourseReplacementVO> loadAllCourseReplacementVO() {
        return null;
    }

    public List<CourseReplacementVO> loadAllCourseReplacementVOByPage(int pageNum, int pageSize) {
        return null;
    }

    private CourseReplacementVO toCourseReplacementVO(CourseReplacement courseReplacement) {
        return null;
    }
}
