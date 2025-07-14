package com.uestc.summer2025.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDto;
import com.uestc.summer2025.data.entity.*;
import com.uestc.summer2025.data.mapper.*;
import com.uestc.summer2025.service.TransformService;
import com.uestc.summer2025.util.R;
import com.uestc.summer2025.web.dto.*;
import com.uestc.summer2025.web.vo.CourseReplacementApplicationVO;
import com.uestc.summer2025.web.vo.ExemptionApplicationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 免考申请控制器
 * 包含学生提交免考申请、管理员审批免考申请两个接口
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ExemptionApplicationMapper exemptionApplicationMapper;

    @Autowired
    CourseInfoMapper courseInfoMapper;

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Autowired
    ExemptionRuleMapper exemptionRuleMapper;

    @Autowired
    AdminInfoMapper adminInfoMapper;

    @Autowired
    TransformService transformService;

    @Autowired
    CourseReplacementMapper courseReplacementMapper;

    @Autowired
    CourseReplacementApplicationMapper courseReplacementApplicationMapper;

    /**
     * 学生提交免考申请接口
     *
     * 请求方式：POST
     * 请求路径：/application/student-apply
     * 请求体参数：ExemptionApplication1DTO { studentName, courseName, ruleName }
     * 返回值：是否提交成功
     */
    @PostMapping("/student-apply")
    public R<String> studentApply(@RequestBody ExemptionApplication1DTO exemptionApplication1DTO) {
        try {
            // 1. 根据学生姓名查出 studentId
            QueryWrapper<StudentInfo> studentWrapper = new QueryWrapper<>();
            studentWrapper.eq("name", exemptionApplication1DTO.getStudentName()).eq("is_deleted", 0);
            StudentInfo student = studentInfoMapper.selectOne(studentWrapper);
            if (student == null) return R.failed("学生不存在");
            // 2. 根据课程名称查出 courseCode
            QueryWrapper<CourseInfo> courseWrapper = new QueryWrapper<>();
            courseWrapper.eq("name", exemptionApplication1DTO.getCourseName()).eq("is_deleted", 0);
            CourseInfo course = courseInfoMapper.selectOne(courseWrapper);
            if (course == null) return R.failed("课程不存在");
            // 3. 根据免考规则名查出 ruleId
            QueryWrapper<ExemptionRule> ruleWrapper = new QueryWrapper<>();
            ruleWrapper.eq("name", exemptionApplication1DTO.getRuleName()).eq("is_deleted", 0);
            ExemptionRule rule = exemptionRuleMapper.selectOne(ruleWrapper);
            if (rule == null) return R.failed("免考规则不存在");
            // 4. 构造免考申请实体
            // 查询考试中心管理员
            String examCenterName = student.getExamCenterName();
            QueryWrapper<AdminInfo> adminInfoQueryWrapper = new QueryWrapper<>();
            adminInfoQueryWrapper.eq("exam_center_name", examCenterName).eq("is_deleted", 0);
            AdminInfo adminInfo = adminInfoMapper.selectOne(adminInfoQueryWrapper);
            if (adminInfo == null) {
                return R.failed("考试中心不存在或管理员不存在");
            }
            ExemptionApplication application = new ExemptionApplication();
            application.setApplicationId(System.currentTimeMillis()); // 简单生成唯一ID
            application.setStudentId(student.getStudentId());
            application.setCourseCode(course.getCourseCode());
            application.setRuleId(rule.getRuleId());
            application.setStatus("待审核");
            application.setAdminId(adminInfo.getAdminId());
            application.setApplyTime(LocalDateTime.now());
            // 5. 插入数据库
            int result = exemptionApplicationMapper.insert(application);
            return result > 0 ? R.success("免考申请提交成功") : R.failed("免考申请提交失败");
        } catch (Exception e) {
            return R.failed("免考申请异常：" + e.getMessage());
        }
    }

    /**
     * 管理员审批免考申请接口
     *
     * 请求方式：POST
     * 请求路径：/application/admin-apply
     * 请求体参数：ExemptionApplication2DTO { applicationId, status, reviewReason }
     * 返回值：是否审批成功
     */
    @PostMapping("/admin-apply")
    public R<String> adminApply(@RequestBody ExemptionApplication2DTO exemptionApplication2DTO) {
        try {
            // 1. 查询申请记录
            ExemptionApplication application = exemptionApplicationMapper.selectById(exemptionApplication2DTO.getApplicationId());
            if (application == null || Boolean.TRUE.equals(application.getIsDeleted())) {
                return R.failed("未找到对应免考申请记录");
            }
            // 2. 更新审批状态
            application.setStatus(exemptionApplication2DTO.getStatus());
            application.setReviewTime(LocalDateTime.now());
            application.setReviewReason(exemptionApplication2DTO.getReviewReason());
            // 3. 执行更新
            int result = exemptionApplicationMapper.updateById(application);
            return result > 0 ? R.success("审批更新成功") : R.failed("审批更新失败");

        } catch (Exception e) {
            return R.failed("审批失败：" + e.getMessage());
        }
    }

    /**
     * 根据学生姓名查询其所有免考申请记录
     *
     * 请求方式：POST
     * 请求路径：/application/student-load
     *
     * 请求参数：
     * {
     *     "name": "学生姓名"
     * }
     *
     * 返回值：
     * 所有对应学生的免考申请记录列表（封装为 ExemptionApplicationVO）
     */
    @PostMapping("/student-load")
    public R<List<ExemptionApplicationVO>> studentLoad(@RequestBody NameDTO nameDTO) {
        try {
            // 1. 根据学生姓名查 studentId
            QueryWrapper<StudentInfo> studentWrapper = new QueryWrapper<>();
            studentWrapper.eq("name", nameDTO.getName()).eq("is_deleted", 0);
            StudentInfo student = studentInfoMapper.selectOne(studentWrapper);
            if (student == null) return R.failed("学生不存在");
            String studentId = student.getStudentId();
            // 2. 查询该学生所有未删除的免考申请记录
            QueryWrapper<ExemptionApplication> exemptionApplicationQueryWrapper = new QueryWrapper<>();
            exemptionApplicationQueryWrapper.eq("student_id", studentId).eq("is_deleted", 0);
            List<ExemptionApplication> exemptionApplications = exemptionApplicationMapper.selectList(exemptionApplicationQueryWrapper);
            // 3. 转换为 VO 列表
            List<ExemptionApplicationVO> exemptionApplicationVOS = new ArrayList<>();
            exemptionApplications.forEach(app -> exemptionApplicationVOS.add(toVO(app)));
            return R.success(exemptionApplicationVOS);
        } catch (Exception e) {
            return R.failed("加载学生申请记录失败：" + e.getMessage());
        }
    }

    /**
     * 根据管理员姓名分页加载其管理的免考申请记录
     *
     * 请求方式：POST
     * 请求路径：/application/admin-load
     *
     * 请求参数（JSON）：
     * {
     *     "key": "管理员姓名",   // 管理员姓名，用于查询对应管理员
     *     "pageNum": 1,         // 当前页码，默认1
     *     "pageSize": 10        // 每页大小，默认10
     * }
     *
     * 返回值：
     * 该管理员所负责审批的免考申请记录分页列表（封装为 ExemptionApplicationVO 列表）
     *
     * 注意：
     * - 仅查询未逻辑删除的管理员和免考申请记录
     * - 若管理员不存在则返回失败信息
     */
    @PostMapping("/admin-load")
    public R<List<ExemptionApplicationVO>> adminLoad(@RequestBody StudentPageDTO pageDTO) {
        try {
            // 1. 根据管理员姓名查 admin_id
            QueryWrapper<AdminInfo> adminWrapper = new QueryWrapper<>();
            adminWrapper.eq("full_name", pageDTO.getKey()).eq("is_deleted", 0);
            AdminInfo admin = adminInfoMapper.selectOne(adminWrapper);
            if (admin == null) return R.failed("管理员不存在");
            String adminId = admin.getAdminId();

            // 2. 构造分页对象
            int currentPage = pageDTO.getPageNum() == null ? 1 : pageDTO.getPageNum();
            int pageSize = pageDTO.getPageSize() == null ? 10 : pageDTO.getPageSize();
            Page<ExemptionApplication> page = new Page<>(currentPage, pageSize);

            // 3. 查询该管理员所管理的所有免考申请记录（分页）
            QueryWrapper<ExemptionApplication> applicationWrapper = new QueryWrapper<>();
            applicationWrapper.eq("admin_id", adminId).eq("is_deleted", 0);

            Page<ExemptionApplication> applicationPage = exemptionApplicationMapper.selectPage(page, applicationWrapper);

            // 4. 转换为 VO 列表
            List<ExemptionApplicationVO> voList = new ArrayList<>();
            for (ExemptionApplication app : applicationPage.getRecords()) {
                voList.add(toVO(app));
            }

            return R.success(voList);
        } catch (Exception e) {
            return R.failed("加载管理员审批记录失败：" + e.getMessage());
        }
    }

    private ExemptionApplicationVO toVO(ExemptionApplication exemptionApplication) {
        ExemptionApplicationVO exemptionApplicationVO = new ExemptionApplicationVO();
        exemptionApplicationVO.setApplicationId(exemptionApplication.getApplicationId());
        exemptionApplicationVO.setStudentId(exemptionApplication.getStudentId());
        exemptionApplicationVO.setCourseCode(exemptionApplication.getCourseCode());
        exemptionApplicationVO.setRuleId(exemptionApplication.getRuleId());
        exemptionApplicationVO.setStatus(exemptionApplication.getStatus());
        exemptionApplicationVO.setReviewReason(exemptionApplication.getReviewReason());
        exemptionApplicationVO.setAdminId(exemptionApplication.getAdminId());
        exemptionApplicationVO.setUpdateTime(exemptionApplication.getUpdateTime());
        exemptionApplicationVO.setCourseName(transformService.courseIdToName(exemptionApplication.getCourseCode()));
        return exemptionApplicationVO;
    }

    private CourseReplacementApplicationVO toVO(CourseReplacementApplication application) {
        CourseReplacementApplicationVO vo = new CourseReplacementApplicationVO();
        vo.setApplicationId(application.getApplicationId());
        vo.setStudentId(application.getStudentId());
        vo.setOldCourseCode(application.getOldCourseCode());
        vo.setNewCourseCode(application.getNewCourseCode());
        vo.setReason(application.getReason());
        vo.setStatus(application.getStatus());
        vo.setReviewReason(application.getReviewReason());
        vo.setAdminId(application.getAdminId());
        vo.setUpdateTime(application.getUpdateTime());
        vo.setNewCourseName(transformService.courseIdToName(vo.getNewCourseCode()));
        vo.setOldCourseName(transformService.courseIdToName(vo.getOldCourseCode()));
        return vo;
    }

    /**
     * 学生提交课程替换申请接口
     *
     * 请求方式：POST
     * 请求路径：/application/course/student-apply
     *
     * 请求体参数（JSON）：CourseReplacementApplication1DTO
     * {
     *     "studentName": "张三",         // 学生姓名，用于查询 studentId
     *     "oldCourseName": "大学英语",    // 被替换的旧课程名称（将转为 courseCode）
     *     "newCourseName": "英语（二）",  // 替代的新课程名称（将转为 courseCode）
     *     "reason": "课程内容重复"        // 替换理由（可选）
     * }
     *
     * 返回值：R<String>
     * 成功：{ "code": 200, "msg": "课程替换申请提交成功", "data": null }
     * 失败：{ "code": 100000, "msg": "错误信息", "data": null }
     *
     * 逻辑说明：
     * - 自动查找学生所属考试院的管理员
     * - 校验课程名称有效性（转换为 courseCode）
     * - 自动生成申请记录并保存到数据库
     */
    @PostMapping("/course/student-apply")
    public R<String> studentCourseApply(@RequestBody CourseReplacementApplication1DTO dto) {
        try {
            // 1. 根据学生姓名查出 studentId
            QueryWrapper<StudentInfo> studentWrapper = new QueryWrapper<>();
            studentWrapper.eq("name", dto.getStudentName()).eq("is_deleted", 0);
            StudentInfo student = studentInfoMapper.selectOne(studentWrapper);
            if (student == null) return R.failed("学生不存在");
            // 2. 检查旧课程是否存在（course_code是否有效）
            QueryWrapper<CourseInfo> oldCourseWrapper = new QueryWrapper<>();
            oldCourseWrapper.eq("course_code", transformService.courseNameToId(dto.getOldCourseName())).eq("is_deleted", 0);
            CourseInfo oldCourse = courseInfoMapper.selectOne(oldCourseWrapper);
            if (oldCourse == null) return R.failed("被替换的旧课程不存在");
            // 3. 检查新课程是否存在
            QueryWrapper<CourseInfo> newCourseWrapper = new QueryWrapper<>();
            newCourseWrapper.eq("course_code", transformService.courseNameToId(dto.getNewCourseName())).eq("is_deleted", 0);
            CourseInfo newCourse = courseInfoMapper.selectOne(newCourseWrapper);
            if (newCourse == null) return R.failed("替代的新课程不存在");
            // 4. 查询考试中心管理员
            String examCenterName = student.getExamCenterName();
            QueryWrapper<AdminInfo> adminWrapper = new QueryWrapper<>();
            adminWrapper.eq("exam_center_name", examCenterName).eq("is_deleted", 0);
            AdminInfo adminInfo = adminInfoMapper.selectOne(adminWrapper);
            if (adminInfo == null) return R.failed("考试中心不存在或管理员不存在");
            // 5. 构造课程替换申请实体
            CourseReplacementApplication application = new CourseReplacementApplication();
            application.setApplicationId(System.currentTimeMillis()); // 简单生成唯一ID
            application.setStudentId(student.getStudentId());
            application.setOldCourseCode(transformService.courseNameToId(dto.getOldCourseName()));
            application.setNewCourseCode(transformService.courseNameToId(dto.getNewCourseName()));
            application.setReason(dto.getReason());
            application.setStatus("待审核");
            application.setAdminId(adminInfo.getAdminId());
            application.setApplyTime(LocalDateTime.now());
            // 6. 插入数据库
            int result = courseReplacementApplicationMapper.insert(application);
            return result > 0 ? R.success("课程替换申请提交成功") : R.failed("课程替换申请提交失败");
        } catch (Exception e) {
            return R.failed("课程替换申请异常：" + e.getMessage());
        }
    }

    /**
     * 管理员审批课程替换申请接口
     *
     * 请求方式：POST
     * 请求路径：/application/course/admin-apply
     *
     * 请求体参数（JSON）：CourseReplacementApplication2DTO
     * {
     *     "applicationId": 100000000001,   // 申请记录ID
     *     "status": "通过",                 // 审批状态（必须是 "通过"、"驳回"、"待审核"）
     *     "reviewReason": "材料齐全",       // 审核意见或驳回原因（可选）
     *     "adminName": "王管理员"           // 审批人姓名（可选，更新管理员ID）
     * }
     *
     * 返回值：R<String>
     * 成功：{ "code": 200, "msg": "课程替换审批更新成功", "data": null }
     * 失败：{ "code": 100000, "msg": "错误信息", "data": null }
     *
     * 逻辑说明：
     * - 通过申请ID查找记录，更新审批状态、审核时间、审核意见
     * - 如传入管理员姓名，自动查找并更新 adminId
     * - 所有操作仅针对未逻辑删除的数据
     */
    @PostMapping("/course/admin-apply")
    public R<String> studentAdminApply(@RequestBody CourseReplacementApplication2DTO dto) {
        try {
            // 1. 根据申请ID查询申请记录
            CourseReplacementApplication application = courseReplacementApplicationMapper.selectById(dto.getApplicationId());
            if (application == null || Boolean.TRUE.equals(application.getIsDeleted())) {
                return R.failed("未找到对应课程替换申请记录");
            }
            // 2. 更新审批状态及相关信息
            application.setStatus(dto.getStatus());
            application.setReviewReason(dto.getReviewReason());
            application.setReviewTime(LocalDateTime.now());
            // 如果传了管理员姓名，查询管理员ID并更新
            if (dto.getAdminName() != null && !dto.getAdminName().trim().isEmpty()) {
                QueryWrapper<AdminInfo> adminWrapper = new QueryWrapper<>();
                adminWrapper.eq("full_name", dto.getAdminName()).eq("is_deleted", 0);
                AdminInfo adminInfo = adminInfoMapper.selectOne(adminWrapper);
                if (adminInfo != null) {
                    application.setAdminId(adminInfo.getAdminId());
                }
            }
            // 3. 执行更新
            int result = courseReplacementApplicationMapper.updateById(application);
            return result > 0 ? R.success("课程替换审批更新成功") : R.failed("课程替换审批更新失败");
        } catch (Exception e) {
            return R.failed("课程替换审批异常：" + e.getMessage());
        }
    }

    /**
     * 根据学生姓名查询其所有课程替换申请记录
     *
     * 请求方式：POST
     * 请求路径：/application/course/student-load
     *
     * 请求参数（JSON）：
     * {
     *     "name": "学生姓名"
     * }
     *
     * 返回值：
     * 所有对应学生的课程替换申请记录列表（封装为 CourseReplacementApplicationVO 列表）
     *
     * 注意：
     * - 仅查询未逻辑删除的学生及其申请记录
     * - 若学生不存在则返回失败信息
     */
    @PostMapping("/course/student-load")
    public R<List<CourseReplacementApplicationVO>> courseStudentLoad(@RequestBody NameDTO nameDTO) {
        try {
            // 1. 根据学生姓名查 studentId
            QueryWrapper<StudentInfo> studentWrapper = new QueryWrapper<>();
            studentWrapper.eq("name", nameDTO.getName()).eq("is_deleted", 0);
            StudentInfo student = studentInfoMapper.selectOne(studentWrapper);
            if (student == null) return R.failed("学生不存在");
            String studentId = student.getStudentId();
            // 2. 查询学生所有未逻辑删除的课程替换申请记录
            QueryWrapper<CourseReplacementApplication> wrapper = new QueryWrapper<>();
            wrapper.eq("student_id", studentId).eq("is_deleted", 0);
            List<CourseReplacementApplication> applications = courseReplacementApplicationMapper.selectList(wrapper);
            // 3. 转为 VO 列表
            List<CourseReplacementApplicationVO> voList = new ArrayList<>();
            for (CourseReplacementApplication app : applications) {
                voList.add(toVO(app));
            }
            return R.success(voList);
        } catch (Exception e) {
            return R.failed("加载学生课程替换记录失败：" + e.getMessage());
        }
    }

    /**
     * 根据管理员姓名分页查询其审批的课程替换申请记录
     *
     * 请求方式：POST
     * 请求路径：/application/course/admin-load
     *
     * 请求参数（JSON）：
     * {
     *     "key": "管理员姓名",   // 管理员姓名，用于查找 admin_id
     *     "pageNum": 1,         // 当前页码（可选，默认1）
     *     "pageSize": 10        // 每页记录数（可选，默认10）
     * }
     *
     * 返回值：
     * 当前管理员审批的课程替换申请分页记录（封装为 CourseReplacementApplicationVO 列表）
     *
     * 返回格式（示例）：
     * {
     *     "code": 200,
     *     "msg": "success",
     *     "data": [
     *         {
     *             "applicationId": 10000000001,
     *             "studentId": "abc-123",
     *             "oldCourseCode": "MATH101",
     *             "newCourseCode": "MATH201",
     *             "reason": "原课程内容重复",
     *             "status": "待审核",
     *             "reviewReason": null,
     *             "adminId": "admin-uuid",
     *             "updateTime": "2025-07-15T10:00:00"
     *         },
     *         ...
     *     ]
     * }
     *
     * 注意事项：
     * - 仅查询未逻辑删除的管理员及其申请记录
     * - 若管理员不存在则返回失败信息
     */
    @PostMapping("/course/admin-load")
    public R<List<CourseReplacementApplicationVO>> courseAdminLoad(@RequestBody StudentPageDTO pageDTO) {
        try {
            // 1. 根据管理员姓名查询 admin_id
            QueryWrapper<AdminInfo> adminWrapper = new QueryWrapper<>();
            adminWrapper.eq("full_name", pageDTO.getKey()).eq("is_deleted", 0);
            AdminInfo admin = adminInfoMapper.selectOne(adminWrapper);
            if (admin == null) return R.failed("管理员不存在");
            String adminId = admin.getAdminId();
            // 2. 构造分页参数
            int currentPage = pageDTO.getPageNum() == null ? 1 : pageDTO.getPageNum();
            int pageSize = pageDTO.getPageSize() == null ? 10 : pageDTO.getPageSize();
            Page<CourseReplacementApplication> page = new Page<>(currentPage, pageSize);
            // 3. 构造查询条件，筛选该管理员审批的申请记录
            QueryWrapper<CourseReplacementApplication> wrapper = new QueryWrapper<>();
            wrapper.eq("admin_id", adminId).eq("is_deleted", 0);
            // 4. 执行分页查询
            Page<CourseReplacementApplication> applicationPage = courseReplacementApplicationMapper.selectPage(page, wrapper);
            // 5. 转换为 VO 列表
            List<CourseReplacementApplicationVO> voList = new ArrayList<>();
            for (CourseReplacementApplication application : applicationPage.getRecords()) {
                voList.add(toVO(application));
            }
            return R.success(voList);
        } catch (Exception e) {
            return R.failed("加载管理员课程替换记录失败：" + e.getMessage());
        }
    }
}
