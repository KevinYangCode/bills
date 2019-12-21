package xyz.jianzha.bills.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Layui返回的数据类型
 *
 * @author Y_Kevin
 * @date 2019/12/21 - 18:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {
    private Long code = 0L;
    private String msg = "";
    private Long count;
    private Object data;

    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }
}