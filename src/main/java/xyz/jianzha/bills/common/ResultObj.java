package xyz.jianzha.bills.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Y_Kevin
 * @date 2019/12/21 - 17:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
    /**
     * 业务响应码
     */
    private int code;

    /**
     * 业务信息
     */
    private String msg;

}
