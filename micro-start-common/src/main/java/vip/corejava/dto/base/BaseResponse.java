package vip.corejava.dto.base;

import lombok.Data;

/**
 * @version 2020/11/22
 */

@Data
public class BaseResponse {
    private int code;
    private String message;
}
