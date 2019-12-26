package com.weiwo.erp.util;

import com.weiwo.erp.entity.LoginUser;
import org.apache.commons.lang.ArrayUtils;

import javax.persistence.Table;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/***
 * 通过java Class 创建 建表语句
 */
public class CreateTable {
    public static Map<String, String> javaProperty2SqlColumnMap = new HashMap<>();

    static {
        javaProperty2SqlColumnMap.put("Integer", "INTEGER");
        javaProperty2SqlColumnMap.put("Short", "tinyint");
        javaProperty2SqlColumnMap.put("Long", "bigint");
        javaProperty2SqlColumnMap.put("BigDecimal", "decimal(19,2)");
        javaProperty2SqlColumnMap.put("Double", "double precision not null");
        javaProperty2SqlColumnMap.put("Float", "float");
        javaProperty2SqlColumnMap.put("Boolean", "bit");
        javaProperty2SqlColumnMap.put("Timestamp", "datetime");
        javaProperty2SqlColumnMap.put("Date", "datetime");
        javaProperty2SqlColumnMap.put("String", "VARCHAR(255)");
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        createTable(LoginUser.class);
// createTable(Book.class, null);
    }

    public static Field[] getBeanFields(Class cls,Field[] fs){

        fs = (Field[]) ArrayUtils.addAll(fs, cls.getDeclaredFields());

        if(cls.getSuperclass()!=null){

            Class clsSup = cls.getSuperclass();

            fs = getBeanFields(clsSup,fs);

        }
        return fs;
    }

    public static String createTable(Class obj) throws IOException {
        Table somtAnnotation = (Table) obj.getAnnotation(Table.class);
        String tableName="";
        if(somtAnnotation!=null){
             tableName=somtAnnotation.name();
        }
        Field[] fields = null;
        fields = getBeanFields(obj, fields);
//        Class annotationType = null;
        String param = null;
        String column = null;
//        XmlElement xmlElement = null;
        StringBuilder sb = null;
        sb = new StringBuilder(50);
        if (tableName == null || tableName.equals("")) {
//未传表明默认用类名
            tableName = obj.getName();
            tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
        }
//        sb.append("\r\ndrop table if exists  ").append(tableName).append(";\r\n");
        sb.append("create table ").append(tableName).append(" ( \r\n");
        System.out.println(tableName);
        boolean firstId = true;
        File file = null;
        for (Field f : fields) {
            column = SuppBeanUtils.camelToUnderline(f.getName());
            if (column.equals("serialVersionUID")) {
                continue;
            }
//            sb.append(column).append(" ");
//            System.out.println(column + "," + f.getType());
            param = f.getType().getSimpleName();
            sb.append(column);//一般第一个是主键
            sb.append(" ").append(javaProperty2SqlColumnMap.get(param)).append(" ");
            /*if (param instanceof Integer) {
                sb.append(" INTEGER ");
            } else if (param instanceof Short) {
                sb.append(" tinyint ");
            } else if (param instanceof Long) {
                sb.append(" bigint ");
            } else if (param instanceof BigDecimal) {
                sb.append(" decimal(19,2) ");
            } else if (param instanceof Double) {
                sb.append(" double precision not null ");
            } else if (param instanceof Float) {
                sb.append(" float ");
            } else if (param instanceof Boolean) {
                sb.append(" bit ");
            } else if (param instanceof Timestamp) {
                sb.append(" datetime ");
            } else {
                sb.append("  ");//根据需要自行修改
            }*/
            if (firstId) {//类型转换
                sb.append(" PRIMARY KEY ");
                firstId = false;
            }
            //获取字段中包含fieldMeta的注解
            //2、获取属性上的所有注释
            Annotation[] allAnnotations = f.getAnnotations();
            /*for(Annotation an : allAnnotations){
                sb.append(" COMMIT '");
                xmlElement = (XmlElement)an;
                annotationType = an.annotationType();
                param = ((XmlElement) an).name();
                System.out.println("属性【"+f.getName()+"-----的注释类型有: " + param);
                sb.append(param).append("'");
            }*/
            sb.append(",\n ");
        }
        String sql = null;
        sql = sb.toString();
        //去掉最后一个逗号
        int lastIndex = sql.lastIndexOf(",");
        sql = sql.substring(0, lastIndex) + sql.substring(lastIndex + 1);

        sql = sql.substring(0, sql.length() - 1) + " )ENGINE =INNODB DEFAULT  CHARSET= utf8;\r\n";
        System.out.println("sql :" + sql);



        return sql;


    }
}
