package xyz.jianzha.bills.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (User)表实体类
 *
 * @author Kevin
 * @since 2019-12-21 16:53:21
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class User extends Model<User> {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 登陆名称
     */
    private String loginname;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 性别
     */
    private String sex;
}