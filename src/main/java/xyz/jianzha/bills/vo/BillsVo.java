package xyz.jianzha.bills.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import xyz.jianzha.bills.entity.Bills;

import java.util.Date;

/**
 * @author Y_Kevin
 * @date 2019/12/21 - 18:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BillsVo extends Bills {
    private static final long serialVersionUID = 1L;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Integer page = 1;
    private Integer limit = 10;
}
