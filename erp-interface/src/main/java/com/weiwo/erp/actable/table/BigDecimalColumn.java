package com.weiwo.erp.actable.table;

public class BigDecimalColumn extends CommonColumn {
    public BigDecimalColumn(){
        this.setType("decimal");
        this.setLength(20);
        this.setDecimalLength(2);
    }
}
