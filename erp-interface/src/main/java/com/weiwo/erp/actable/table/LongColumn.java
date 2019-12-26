package com.weiwo.erp.actable.table;

import lombok.Data;

/**
 * 长整型
 *
 **/
@Data
public class LongColumn extends CommonColumn {


    public LongColumn() {
        this.setType("bigint");
        this.setLength(16);
    }


}
