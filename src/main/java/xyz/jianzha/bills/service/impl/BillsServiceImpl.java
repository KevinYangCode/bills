package xyz.jianzha.bills.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.jianzha.bills.mapper.BillsMapper;
import xyz.jianzha.bills.entity.Bills;
import xyz.jianzha.bills.service.BillsService;
import org.springframework.stereotype.Service;

/**
 * (Bills)表服务实现类
 *
 * @author Kevin
 * @since 2019-12-21 16:53:02
 */
@Service("billsService")
public class BillsServiceImpl extends ServiceImpl<BillsMapper, Bills> implements BillsService {

}