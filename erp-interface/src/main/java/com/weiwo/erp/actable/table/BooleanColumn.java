package com.weiwo.erp.actable.table;

import lombok.Data;

/**
 * 布尔
 *
 **/
@Data
public class BooleanColumn extends CommonColumn {


    public BooleanColumn(){
        this.setType("bit");
        this.setLength(1);
    }



}
