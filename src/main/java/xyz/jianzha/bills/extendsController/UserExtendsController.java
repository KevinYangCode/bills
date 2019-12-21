package xyz.jianzha.bills.extendsController;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import xyz.jianzha.bills.common.ResultObj;
import xyz.jianzha.bills.entity.User;
import xyz.jianzha.bills.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * (User)表控制层
 *
 * @author Kevin
 * @since 2019-12-21 16:53:21
 */
@Controller
@RequestMapping("/user")
public class UserExtendsController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultObj login(String loginname, String pwd, String code, HttpSession session) {
        Object codeSession = session.getAttribute("code");
        if (code != null && code.equals(codeSession)) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("loginname", loginname);
            queryWrapper.eq("pwd", pwd);
            User user = userService.getOne(queryWrapper);
            if (user != null) {
                session.setAttribute("user", user);
                return new ResultObj(200, "登陆成功！");
            } else {
                return new ResultObj(-1, "密码错误！");
            }
        } else {
            return new ResultObj(-1, "验证码错误！");
        }
    }

    @RequestMapping("getCode")
    public void getCode(HttpServletResponse resp, HttpSession session) throws IOException {
        //定义图形验证码的长和宽
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(136, 36, 4, 10);
        // 得到code
        String code = captcha.getCode();
        System.out.println("code:" + code);
        // 放到session
        session.setAttribute("code", code);
        ServletOutputStream outputStream = resp.getOutputStream();
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write(outputStream);
        outputStream.close();
//        captcha.write("d:/line.png");
    }

}