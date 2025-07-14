package com.uestc.summer2025.service;

import com.uestc.summer2025.data.entity.CourseInfo;
import com.uestc.summer2025.data.entity.ExamCenter;
import com.uestc.summer2025.data.entity.MajorInfo;
import com.uestc.summer2025.data.entity.MajorRequiredCourse;
import com.uestc.summer2025.data.mapper.CourseInfoMapper;
import com.uestc.summer2025.data.mapper.ExamCenterMapper;
import com.uestc.summer2025.data.mapper.MajorInfoMapper;
import com.uestc.summer2025.data.mapper.MajorRequiredCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import com.uestc.summer2025.constant.RedisCacheKeys;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * CachePreheatService
 * <p>
 * 负责应用启动时将重要数据预热到 Redis 缓存中，减少后续数据库访问，提高系统性能和响应速度。
 * <p>
 * 缓存结构设计：
 * - RedisCacheKeys.COURSE_ALL → List&lt;CourseInfo&gt; 所有课程列表
 * - RedisCacheKeys.COURSE_NAME_TO_CODE → Hash(name → courseCode) 课程名映射
 * - RedisCacheKeys.MAJOR_ALL → List&lt;MajorInfo&gt; 所有专业列表
 * - RedisCacheKeys.MAJOR_NAME_TO_CODE → Hash(name → majorCode) 专业名映射
 * - RedisCacheKeys.EXAM_CENTER_ALL → List&lt;ExamCenter&gt; 所有考试院列表
 * - RedisCacheKeys.EXAM_CENTER_NAME_TO_ID → Hash(name → id) 考试院名映射
 * - RedisCacheKeys.getMajorRequiredCourseKey(majorCode) → List&lt;MajorRequiredCourse&gt; 每个专业的课程列表
 * <p>
 * author: 魏子越
 * date: 2025/07/13
 */
@Service
public class CachePreheatService {

    private final CourseInfoMapper courseInfoMapper;
    private final MajorInfoMapper majorInfoMapper;
    private final ExamCenterMapper examCenterMapper;
    private final MajorRequiredCourseMapper majorRequiredCourseMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CachePreheatService(CourseInfoMapper courseInfoMapper,
                               MajorInfoMapper majorInfoMapper,
                               ExamCenterMapper examCenterMapper,
                               MajorRequiredCourseMapper majorRequiredCourseMapper,
                               RedisTemplate<String, Object> redisTemplate) {
        this.courseInfoMapper = courseInfoMapper;
        this.majorInfoMapper = majorInfoMapper;
        this.examCenterMapper = examCenterMapper;
        this.majorRequiredCourseMapper = majorRequiredCourseMapper;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 预热缓存方法
     * <p>
     * 启动时调用，加载各表数据并写入 Redis 缓存。
     * 课程信息、专业信息、考试院信息缓存为整体列表。
     * 专业必修课程按专业代码拆分缓存，便于查询。
     */
    //@PostConstruct
    public void preheatCache() {
        List<CourseInfo> courses = courseInfoMapper.selectList(null);
        redisTemplate.opsForValue().set(RedisCacheKeys.COURSE_ALL, courses);
        // 缓存课程名 → 课程代码
        for (CourseInfo course : courses) {
            redisTemplate.opsForHash().put(RedisCacheKeys.COURSE_NAME_TO_CODE, course.getName(), course.getCourseCode());
        }

        List<MajorInfo> majors = majorInfoMapper.selectList(null);
        redisTemplate.opsForValue().set(RedisCacheKeys.MAJOR_ALL, majors);
        // 缓存专业名 → 专业代码
        for (MajorInfo major : majors) {
            redisTemplate.opsForHash().put(RedisCacheKeys.MAJOR_NAME_TO_CODE, major.getName(), major.getCode());
        }

        List<ExamCenter> examCenters = examCenterMapper.selectList(null);
        redisTemplate.opsForValue().set(RedisCacheKeys.EXAM_CENTER_ALL, examCenters);
        // 缓存考试院名 → ID
        for (ExamCenter center : examCenters) {
            redisTemplate.opsForHash().put(RedisCacheKeys.EXAM_CENTER_NAME_TO_ID, center.getExamCenterName(), center.getExamCenterId());
        }

        List<MajorRequiredCourse> majorRequiredCourses = majorRequiredCourseMapper.selectList(null);
        Map<String, List<MajorRequiredCourse>> map = majorRequiredCourses.stream()
                .collect(Collectors.groupingBy(MajorRequiredCourse::getMajorCode));
        for (Map.Entry<String, List<MajorRequiredCourse>> entry : map.entrySet()) {
            redisTemplate.opsForValue().set(RedisCacheKeys.getMajorRequiredCourseKey(entry.getKey()), entry.getValue());
        }
    }
}