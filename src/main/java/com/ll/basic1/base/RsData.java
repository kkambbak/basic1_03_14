package com.ll.basic1.base;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RsData {
    private final String resultCode;
    private final String msg;
    private final Object data;

    public static RsData of(String resultCode, String msg) {
        return new RsData(resultCode, msg, null);
    }
    public static RsData of(String resultCode, String msg, Object data) {
        return new RsData(resultCode, msg, data);
    }

    public boolean isSuccess() {
        return this.getResultCode().startsWith("S-");
    }
}
