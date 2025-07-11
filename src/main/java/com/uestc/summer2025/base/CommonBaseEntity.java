package com.uestc.summer2025.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类
 * 所有实体类继承此类可以自动获得常用的字段
 *
 * author: 魏子越
 * date: 2025/07/11
 */

@Data
public class CommonBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 乐观锁字段
    @Version
    private Integer version;

    // 逻辑删除标志字段
    @TableLogic
    private Boolean isDeleted;

    // 创建时间
    private LocalDateTime createTime;

    // 最后更新时间
    private LocalDateTime updateTime;

    // 创建者
    private String createdBy;

    // 最后更新者
    private String updatedBy;

    public CommonBaseEntity() {
        // 初始化删除标志位
        this.isDeleted = false;  // 默认不删除
    }
}