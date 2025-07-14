package com.uestc.summer2025.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uestc.summer2025.data.entity.*;
import com.uestc.summer2025.data.mapper.*;
import com.uestc.summer2025.util.R;
import com.uestc.summer2025.web.dto.ExemptionApplication1DTO;
import com.uestc.summer2025.web.dto.ExemptionApplication2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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
}
