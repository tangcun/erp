package com.weiwo.erp.actable.table;

/**
 * 通用字段接口类
 *
 * @author starmark
 * @create 2018-04-07 12:37
 **/
public interface ICommonColumn {

    public String getName();

    public String getType();

    public int getLength();

    public int getDecimalLength();

    public boolean isNullValue();

    public boolean isKey();


    public boolean isAutoIncrement();

    public String getDefaultValue();


}
