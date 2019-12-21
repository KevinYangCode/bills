package xyz.jianzha.bills.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.jianzha.bills.mapper.UserMapper;
import xyz.jianzha.bills.entity.User;
import xyz.jianzha.bills.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author Kevin
 * @since 2019-12-21 16:53:21
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}