package com.lirui.Pojo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private String name;
    private LocalDate begin;
    private LocalDate end;
    private Integer page;
    private Integer pageSize;
}
