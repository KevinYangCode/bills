package xyz.jianzha.bills.extendsController;

import xyz.jianzha.bills.service.BilltypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Billtype)表控制层
 *
 * @author Kevin
 * @since 2019-12-21 16:53:14
 */
@RestController
@RequestMapping("billType")
public class BilltypeExtendsController{
    /**
     * 服务对象
     */
    @Resource
    private BilltypeService billtypeService;

    
}