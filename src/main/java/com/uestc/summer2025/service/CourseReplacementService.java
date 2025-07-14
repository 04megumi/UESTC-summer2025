package com.uestc.summer2025.service;

import com.uestc.summer2025.data.entity.CourseReplacement;
import com.uestc.summer2025.data.repository.CourseReplacementRepository;
import com.uestc.summer2025.web.dto.CourseReplacementDTO;
import com.uestc.summer2025.web.vo.CourseReplacementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseReplacementService {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private CourseReplacementRepository courseReplacementRepository;

    @Autowired
    private TransformService transformService;

    public boolean addCourseReplacement(CourseReplacementDTO dto) {
        // 从缓存获取旧课程代码和新课程代码
        String oldCourseCode = cacheService.getCourseCodeFromCache(dto.getOldCourseName());
        String newCourseCode = cacheService.getCourseCodeFromCache(dto.getNewCourseName());
        String majorCode = cacheService.getMajorCodeFromCache(dto.getMajorName());
        // 缓存可能没有数据，做个判空处理
        if (oldCourseCode == null || newCourseCode == null) {
            // 可以抛出异常或者返回失败
            oldCourseCode = transformService.courseNameToId(dto.getOldCourseName());
            newCourseCode = transformService.courseNameToId(dto.getNewCourseName());
            majorCode = transformService.majorNameToId(dto.getMajorName());
        }
        // 创建 CourseReplacement 实体
        System.out.println(oldCourseCode+"  "+newCourseCode+"  "+majorCode);
        CourseReplacement courseReplacement = courseReplacementRepository.findByCourseCodesAndMajor(
                oldCourseCode, newCourseCode, majorCode
        );
        System.out.println(courseReplacement);
        if (courseReplacement == null) {
            System.out.println(1);
            // 使用 LocalDate.parse 来解析日期字符串
            LocalDate effectiveFrom = LocalDate.parse("2025-01-01");
            LocalDate effectiveTo = LocalDate.parse("2027-01-01");
            // 创建新的 CourseReplacement 记录
            courseReplacement = new CourseReplacement(
                    oldCourseCode,
                    newCourseCode,
                    majorCode,
                    effectiveFrom,
                    effectiveTo
            );
            return courseReplacementRepository.addCourseReplacement(courseReplacement);
        } else if (!courseReplacement.isActivate()) {
            System.out.println(2);
            return courseReplacementRepository.activateCourseReplacement(oldCourseCode, newCourseCode, majorCode);
        } else {
            throw new IllegalArgumentException("该记录已经存在");
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
            oldCourseCode = transformService.courseNameToId(dto.getOldCourseName());
            newCourseCode = transformService.courseNameToId(dto.getNewCourseName());
            majorCode = transformService.majorNameToId(dto.getMajorName());
        }
        // 查询是否存在该记录
        CourseReplacement courseReplacement = courseReplacementRepository.findByCourseCodesAndMajor(
                oldCourseCode, newCourseCode, majorCode);
        if (courseReplacement != null && courseReplacement.isActivate()) {
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
