package com.uestc.summer2025.data.entity;

import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import java.io.Serial;


/**
 * 免考规则表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ExemptionRule")
public class ExemptionRule extends CommonBaseEntity<ExemptionRule> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 免考规则ID（主键）
    private Long ruleId;

    // 规则名称
    @NonNull
    private String name;

    // 规则详细介绍
    private String description;

    // 可免考的课程代码（外键）
    @NonNull
    private String courseCode;

}