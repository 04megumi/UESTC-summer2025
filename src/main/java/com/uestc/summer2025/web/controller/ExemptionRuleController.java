package com.uestc.summer2025.web.controller;

import com.uestc.summer2025.data.entity.ExemptionRule;
import com.uestc.summer2025.data.mapper.ExemptionRuleMapper;
import com.uestc.summer2025.service.TransformService;
import com.uestc.summer2025.util.R;
import com.uestc.summer2025.web.dto.ExemptionRuleDTO;
import com.uestc.summer2025.web.vo.ExemptionRuleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exemption-rule")
public class ExemptionRuleController {

    @Autowired
    private ExemptionRuleMapper exemptionRuleMapper;

    @Autowired
    private TransformService transformService;

    private ExemptionRuleVO toVO(ExemptionRule exemptionRule) {
        ExemptionRuleVO exemptionRuleVO = new ExemptionRuleVO();
        exemptionRuleVO.setCourseCode(exemptionRule.getCourseCode());
        exemptionRuleVO.setDescription(exemptionRule.getDescription());
        exemptionRuleVO.setCourseName(transformService.courseIdToName(exemptionRule.getCourseCode()));
        exemptionRuleVO.setName(exemptionRule.getName());
        exemptionRuleVO.setRuleId(exemptionRule.getRuleId());
        return exemptionRuleVO;
    }

    /**
     * 查询所有免考规则
     *
     * 接口 URL: GET /exemption-rule/all
     * 返回值: 免考规则列表
     */
    @GetMapping("/all")
    public R<List<ExemptionRuleVO>> getAllExemptionRules() {
        try {
            List<ExemptionRule> rules = exemptionRuleMapper.selectList(null);
            List<ExemptionRuleVO> exemptionRuleVO = rules.stream().map(this::toVO).toList();
            return R.success(exemptionRuleVO);
        } catch (Exception e) {
            return R.failed("查询免考规则失败：" + e.getMessage());
        }
    }

    /**
     * 添加免考规则
     *
     * 接口 URL: POST /exemption-rule/add
     * 请求示例:
     * {
     *   "name": "英语专四免考",
     *   "description": "通过大学英语四级考试可免考《大学英语》课程",
     *   "courseName": "大学英语"
     * }
     * 返回: 操作结果
     */
    @PostMapping("/add")
    public R<String> addExemptionRule(@RequestBody ExemptionRuleDTO exemptionRuleDTO) {
        try {
            ExemptionRule exemptionRule = new ExemptionRule();
            exemptionRule.setRuleId(null); // 如果是自增主键，可设为 null
            exemptionRule.setCourseCode(transformService.courseNameToId(exemptionRuleDTO.getCourseName()));
            exemptionRule.setDescription(exemptionRuleDTO.getDescription());
            exemptionRule.setName(exemptionRuleDTO.getName());
            int result = exemptionRuleMapper.insert(exemptionRule);
            return result > 0 ? R.success("添加成功") : R.failed("添加失败");
        } catch (Exception e) {
            return R.failed("添加免考规则失败：" + e.getMessage());
        }
    }

    /**
     * 删除免考规则
     *
     * 接口 URL: POST /exemption-rule/delete
     * 请求体示例：
     * {
     *   "ruleId": 1001
     * }
     *
     * @param exemptionRuleDTO 前端传入 DTO，需包含 ruleId
     * @return 操作结果
     */
    @PostMapping("/delete")
    public R<String> deleteExemptionRule(@RequestBody ExemptionRuleDTO exemptionRuleDTO) {
        try {
            int deleted = exemptionRuleMapper.deleteById(exemptionRuleDTO.getRuleId());
            return deleted > 0 ? R.success("删除成功") : R.failed("未找到对应记录");
        } catch (Exception e) {
            return R.failed("删除失败：" + e.getMessage());
        }
    }
}
