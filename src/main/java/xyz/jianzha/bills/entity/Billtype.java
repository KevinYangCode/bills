package xyz.jianzha.bills.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (Billtype)表实体类
 *
 * @author Kevin
 * @since 2019-12-21 16:53:14
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Billtype extends Model<Billtype> {
    /**
     * 类型id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 类型名称
     */
    private String name;
}