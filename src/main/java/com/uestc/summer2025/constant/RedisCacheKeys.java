package com.uestc.summer2025.constant;

/**
 * Redis 缓存键常量类
 *
 * 定义了 Redis 中使用的所有 key 的命名规范，统一管理便于维护。
 *
 * 缓存结构包括：
 * - 所有课程列表（course:all）
 * - 所有专业列表（major:all）
 * - 所有考试院列表（examCenter:all）
 * - 课程名到课程代码映射（course:name-to-code）
 * - 专业名到专业代码映射（major:name-to-code）
 * - 考试院名到考试院ID映射（examCenter:name-to-id）
 * - 专业代码对应的毕业必修课程列表（majorRequiredCourse:{majorCode}）
 *
 * author: 魏子越
 * date: 2025/07/13
 */
public final class RedisCacheKeys {

    private RedisCacheKeys() {
        // 私有构造防止实例化
    }

    /** 所有课程列表 */
    public static final String COURSE_ALL = "course:all";

    /** 所有专业列表 */
    public static final String MAJOR_ALL = "major:all";

    /** 所有考试院列表 */
    public static final String EXAM_CENTER_ALL = "examCenter:all";

    /** 课程名 -> 课程代码映射 */
    public static final String COURSE_NAME_TO_CODE = "course:name-to-code";

    /** 专业名 -> 专业代码映射 */
    public static final String MAJOR_NAME_TO_CODE = "major:name-to-code";

    /** 考试院名 -> 考试院ID映射 */
    public static final String EXAM_CENTER_NAME_TO_ID = "examCenter:name-to-id";

    /** 专业必修课程列表，key 示例: majorRequiredCourse:CS01 */
    public static final String MAJOR_REQUIRED_COURSE_PREFIX = "majorRequiredCourse:";

    /**
     * 根据专业代码生成专业必修课程缓存key
     * @param majorCode 专业代码
     * @return 缓存Key
     */
    public static String getMajorRequiredCourseKey(String majorCode) {
        return MAJOR_REQUIRED_COURSE_PREFIX + majorCode;
    }
}