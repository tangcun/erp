package com.weiwo.erp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultUtil<E> implements Serializable {
    private long iTotalRecords;
    private long iTotalDisplayRecords;
    private List<E> data;

}
