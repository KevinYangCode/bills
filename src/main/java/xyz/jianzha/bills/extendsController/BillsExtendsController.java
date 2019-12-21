package xyz.jianzha.bills.extendsController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import xyz.jianzha.bills.common.DataGridView;
import xyz.jianzha.bills.common.ResultObj;
import xyz.jianzha.bills.entity.Bills;
import xyz.jianzha.bills.entity.Billtype;
import xyz.jianzha.bills.service.BillsService;
import org.springframework.web.bind.annotation.*;
import xyz.jianzha.bills.service.BilltypeService;
import xyz.jianzha.bills.vo.BillsVo;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private BilltypeService billtypeService;


    /**
     * 跳转到系统主页
     *
     * @return
     */
    @RequestMapping("toBillsList")
    public String toBillsList() {
        return "list";
    }

    /**
     * 加载账单列表
     *
     * @param billsVo
     * @return
     */
    @RequestMapping("loadAllBills")
    @ResponseBody
    public DataGridView loadAllBills(BillsVo billsVo) {
        IPage<Bills> page = new Page<>(billsVo.getPage(), billsVo.getLimit());
        QueryWrapper<Bills> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(billsVo.getTypeid() != null && billsVo.getTypeid() != 0, "typeid", billsVo.getTypeid());
        queryWrapper.ge(billsVo.getStartDate() != null, "billtime", billsVo.getStartDate());
        queryWrapper.le(billsVo.getEndDate() != null, "billtime", billsVo.getEndDate());
        queryWrapper.orderByDesc("billtime");
        billsService.page(page, queryWrapper);

        // 处理类型
        List<Bills> records = page.getRecords();
        for (Bills bills : records) {
            Billtype billtype = this.billtypeService.getById(bills.getTypeid());
            bills.setTypeName(billtype.getName());
        }
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    /**
     * 添加账单
     *
     * @param billsVo
     * @return
     */
    @RequestMapping("addBills")
    @ResponseBody
    public ResultObj addBills(BillsVo billsVo) {
        try {
            this.billsService.save(billsVo);
            return new ResultObj(200, "添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultObj(-1, "添加失败！");
        }
    }
}