package xyz.jianzha.bills.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.jianzha.bills.entity.Bills;
import xyz.jianzha.bills.service.BillsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Bills)表控制层
 *
 * @author Kevin
 * @since 2019-12-21 16:53:02
 */
@RestController
@RequestMapping("restBills")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class BillsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BillsService billsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param bills 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Bills> page, Bills bills) {
        return success(this.billsService.page(page, new QueryWrapper<>(bills)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.billsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param bills 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Bills bills) {
        return success(this.billsService.save(bills));
    }

    /**
     * 修改数据
     *
     * @param bills 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Bills bills) {
        return success(this.billsService.updateById(bills));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.billsService.removeByIds(idList));
    }
}