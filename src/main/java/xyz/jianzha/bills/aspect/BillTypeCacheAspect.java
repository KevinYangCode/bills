package xyz.jianzha.bills.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import xyz.jianzha.bills.entity.Billtype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Y_Kevin
 * @date 2019/12/21 - 19:27
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class BillTypeCacheAspect {

    /**
     * 缓存对象
     */
    private Map<String, Object> cache = new HashMap<>();

    /**
     * 缓存前缀
     */
    private static String BILL_TYPE_CACHE_PREFIX = "billtype:";

    @Pointcut("execution(* xyz.jianzha.bills.service.impl.BilltypeServiceImpl.getById(..))")
    public void pc() {
    }

    @Around(value = "pc()")
    public Object cacheBillType(ProceedingJoinPoint point) throws Throwable {
        // 得到目标方法的参数
        Object[] args = point.getArgs();
        // 取出ID
        Integer typeId = (Integer) args[0];
        // 从缓存里面取出对象
        Object obj = cache.get(BILL_TYPE_CACHE_PREFIX + typeId);
        if (obj != null) {
            // 说明缓存里面有数据
            System.out.println("缓存里面有数据");
            return obj;
        } else {
            System.err.println("缓存里面没有数据，执行查询");
            // 说明缓存里面没有   放行目标方法   查询数据库
            Billtype res = (Billtype) point.proceed();
            // 放入缓存
            cache.put(BILL_TYPE_CACHE_PREFIX + res.getId(), res);
            return res;

        }
    }

}
