package xyz.jianzha.bills.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (Bills)表实体类
 *
 * @author Kevin
 * @since 2019-12-21 16:53:02
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
public class Bills extends Model<Bills> {
    /**
     * 账单id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 账单标题
     */
    private String title;

    /**
     * 记账时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date billtime;

    /**
     * 账单类别
     */
    private Integer typeid;

    /**
     * 账单金额
     */
    private Double price;

    /**
     * 账单说明
     */
    private String remark;

    @TableField(exist = false)
    private String typeName;
}