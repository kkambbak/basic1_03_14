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

    public static RsData of(String resultCode, String msg) {
        return new RsData(resultCode, msg);
    }
}
