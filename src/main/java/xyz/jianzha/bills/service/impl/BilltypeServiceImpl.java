package xyz.jianzha.bills.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.jianzha.bills.mapper.BilltypeMapper;
import xyz.jianzha.bills.entity.Billtype;
import xyz.jianzha.bills.service.BilltypeService;
import org.springframework.stereotype.Service;

/**
 * (Billtype)表服务实现类
 *
 * @author Kevin
 * @since 2019-12-21 16:53:14
 */
@Service("billtypeService")
public class BilltypeServiceImpl extends ServiceImpl<BilltypeMapper, Billtype> implements BilltypeService {

}