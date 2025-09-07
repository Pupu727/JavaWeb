package com.lirui.Pojo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private Integer page;
    private Integer pageSize;
    private String name;
    private Integer gender;
    private LocalDate begin;
    private LocalDate end;

}
