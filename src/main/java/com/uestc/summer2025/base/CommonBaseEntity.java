package com.uestc.summer2025.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 基础实体类
 * 所有实体类继承此类可以自动获得常用的字段
 *
 * author: 魏子越
 * date: 2025/07/11
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class CommonBaseEntity<T extends CommonBaseEntity<?>> extends Model<T> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 乐观锁字段
    @Version
    private Integer version;

    // 逻辑删除标志字段
    @TableLogic
    private Boolean isDeleted;

    // 创建时间
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 最后更新时间
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 创建者
    private String createdBy;

    // 最后更新者
    private String updatedBy;

    // 是否被删除
    public boolean isDeleted() {
        return isDeleted;
    }

    // 是否存续
    public boolean isActivate() {
        return !isDeleted;
    }
}