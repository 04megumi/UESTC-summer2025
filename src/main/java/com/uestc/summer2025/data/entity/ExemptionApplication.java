package com.uestc.summer2025.data.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 免考申请表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ExemptionApplication")
public class ExemptionApplication extends CommonBaseEntity<ExemptionApplication> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 申请ID（主键）
    @TableId
    private Long applicationId;

    // 申请考生ID（外键）
    @NonNull
    private String studentId;

    // 申请免考课程（外键）
    @NonNull
    private String courseCode;

    // 关联免考规则ID（外键）
    @NonNull
    private Long ruleId;

    // 审核状态，默认待审核 ('待审核','通过','驳回')
    private String status;

    // 申请时间
    private LocalDateTime applyTime;

    // 审核时间
    private LocalDateTime reviewTime;

    // 审核意见或驳回原因
    private String reviewReason;

    // 管理员ID（外键）
    private String adminId;

}