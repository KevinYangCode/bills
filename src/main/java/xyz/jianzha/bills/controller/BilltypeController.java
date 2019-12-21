package xyz.jianzha.bills.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.jianzha.bills.entity.Billtype;
import xyz.jianzha.bills.service.BilltypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Billtype)表控制层
 *
 * @author Kevin
 * @since 2019-12-21 16:53:14
 */
@RestController
@RequestMapping("restBillType")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class BilltypeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BilltypeService billtypeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param billtype 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Billtype> page, Billtype billtype) {
        return success(this.billtypeService.page(page, new QueryWrapper<>(billtype)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.billtypeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param billtype 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Billtype billtype) {
        return success(this.billtypeService.save(billtype));
    }

    /**
     * 修改数据
     *
     * @param billtype 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Billtype billtype) {
        return success(this.billtypeService.updateById(billtype));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.billtypeService.removeByIds(idList));
    }
}