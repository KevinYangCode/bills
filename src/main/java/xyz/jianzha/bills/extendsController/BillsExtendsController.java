package xyz.jianzha.bills.extendsController;

import org.springframework.stereotype.Controller;
import xyz.jianzha.bills.service.BillsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Bills)表控制层
 *
 * @author Kevin
 * @since 2019-12-21 16:53:02
 */
@Controller
@RequestMapping("/bills")
public class BillsExtendsController {
    /**
     * 服务对象
     */
    @Resource
    private BillsService billsService;


    /**
     * 跳转到系统主页
     *
     * @return
     */
    @RequestMapping("toBillsList")
    public String toBillsList() {
        return "list";
    }

}