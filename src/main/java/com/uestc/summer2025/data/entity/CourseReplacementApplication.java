package com.uestc.summer2025.data.entity;

import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 课程替换申请表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("CourseReplacementApplication")
public class CourseReplacementApplication extends CommonBaseEntity<CourseReplacementApplication> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 申请ID（主键）
    private Long applicationId;

    // 申请考生ID（外键）
    @NonNull
    private String studentId;

    // 被替换的旧课程代码（外键）
    @NonNull
    private String oldCourseCode;

    // 替代的新课程代码（外键）
    @NonNull
    private String newCourseCode;

    // 替换申请理由
    private String reason;

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