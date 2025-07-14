package com.uestc.summer2025.service;

import com.uestc.summer2025.constant.RedisCacheKeys;
import com.uestc.summer2025.data.entity.CourseInfo;
import com.uestc.summer2025.data.entity.ExamCenter;
import com.uestc.summer2025.data.entity.MajorInfo;
import com.uestc.summer2025.data.entity.MajorRequiredCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


/**
 * CacheService
 * <p>
 * 负责缓存查询操作，从 Redis 中获取课程、专业、考试院的相关数据。
 * </p>
 */
@Service
public class CacheService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CacheService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 从缓存中获取所有课程信息
     * @return 课程信息列表
     */
    public List<CourseInfo> getAllCourses() {
        Object cachedData = redisTemplate.opsForValue().get(RedisCacheKeys.COURSE_ALL);
        if (cachedData instanceof List<?>) {
            List<?> list = (List<?>) cachedData;
            if (!list.isEmpty() && list.get(0) instanceof CourseInfo) {
                return (List<CourseInfo>) list;
            }
        }
        return Collections.emptyList();
    }

    /**
     * 从缓存中根据课程名获取课程代码
     * @param courseName 课程名称
     * @return 课程代码
     */
    public String getCourseCodeFromCache(String courseName) {
        return (String) redisTemplate.opsForHash().get(RedisCacheKeys.COURSE_NAME_TO_CODE, courseName);
    }

    /**
     * 从缓存中获取所有专业信息
     * @return 专业信息列表
     */
    public List<MajorInfo> getAllMajors() {
        Object cachedData = redisTemplate.opsForValue().get(RedisCacheKeys.MAJOR_ALL);
        if (cachedData instanceof List<?>) {
            List<?> list = (List<?>) cachedData;
            if (!list.isEmpty() && list.get(0) instanceof MajorInfo) {
                return (List<MajorInfo>) list;
            }
        }
        return Collections.emptyList();
    }

    /**
     * 从缓存中根据专业名获取专业代码
     * @param majorName 专业名称
     * @return 专业代码
     */
    public String getMajorCodeFromCache(String majorName) {
        return (String) redisTemplate.opsForHash().get(RedisCacheKeys.MAJOR_NAME_TO_CODE, majorName);
    }

    /**
     * 从缓存中获取所有考试院信息
     * @return 考试院信息列表
     */
    public List<ExamCenter> getAllExamCenters() {
        Object cachedData = redisTemplate.opsForValue().get(RedisCacheKeys.EXAM_CENTER_ALL);
        if (cachedData instanceof List<?>) {
            List<?> list = (List<?>) cachedData;
            if (!list.isEmpty() && list.get(0) instanceof ExamCenter) {
                return (List<ExamCenter>) list;
            }
        }
        return Collections.emptyList();
    }

    /**
     * 从缓存中根据考试院名获取考试院ID
     * @param examCenterName 考试院名称
     * @return 考试院ID
     */
    public String getExamCenterIdFromCache(String examCenterName) {
        return (String) redisTemplate.opsForHash().get(RedisCacheKeys.EXAM_CENTER_NAME_TO_ID, examCenterName);
    }

    /**
     * 从缓存中获取专业的必修课程
     * @param majorCode 专业代码
     * @return 该专业的必修课程列表
     */
    public List<MajorRequiredCourse> getMajorRequiredCoursesFromCache(String majorCode) {
        Object cachedData = redisTemplate.opsForValue().get(RedisCacheKeys.getMajorRequiredCourseKey(majorCode));
        if (cachedData instanceof List<?>) {
            List<?> list = (List<?>) cachedData;
            if (!list.isEmpty() && list.get(0) instanceof MajorRequiredCourse) {
                return (List<MajorRequiredCourse>) list;
            }
        }
        return Collections.emptyList();
    }
}

