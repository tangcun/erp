package com.weiwo.erp.util;

import com.alibaba.fastjson.JSONObject;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.persistence.Transient;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bean copy 工具类
 * 主要是针对Spring BeanUtils的使用简化封装
 * 使用bean的默认构造方法实例化对象
 *      显式申明构造方法时需提供无参构造
 * @author zxia
 * @date 2017/12/22 15:22
 */
public class SuppBeanUtils {


    /**
     * 实体转Mao
     * @param object
     * @return
     */
    public static Map toMap(Object object){
        Map map=JSONObject.parseObject(JSONObject.toJSONString(object),Map.class);
        return map;
    }

    /**
     * list数组转List Map
     * @param objects
     * @return
     */
    public static List<Map> toListMap(List<Object> objects){
        List<Map> maps=new ArrayList<>();
        for (Object object:objects){
            maps.add(toMap(object));
        }
        return maps;
    }

    /**
     * Map 转实体
     * @param map
     * @param <T>
     * @return<T>
     */
    public static <T>T mapToEntity(Map map,T a){
        return JSONObject.parseObject(JSONObject.toJSONString(map), (Class<T>)a.getClass());
    }

    /**
     * ListMap 转 List转实体
     * @param maps
     * @param <T>
     * @return<T>
     */
    public static <T> List<T> listMapToEntity(List<Map> maps,T a){
        List<T> list=new ArrayList<>();
        for(Map map:maps){
            list.add(mapToEntity(map,a));
        }
        return list;
    }




    public static <T> T copy (Object source , Class clazz){

        if(source == null) {
            return null;
        }

        T o = (T) BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(source, o);
        return o;
    }

    public static <T> List<T> copyList (List<? extends Object> source , Class clazz){

        if(source == null) {
            return null;
        }

        List<T> voList=new ArrayList<T>();

        for(Object o:source){
            voList.add((T) copy(o, clazz));
        }
        return voList;
    }


    /**
     * 实例类下Duble 取俩位
     * @param thisClass
     * @return
     * @throws Exception
     */
    public static  Object  reflect(Object thisClass) throws Exception{
        Class cls = thisClass.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            Field f = fields[i];
            f.setAccessible(true);
           // System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(thisClass)+"属性类型:"+f.getType().getCanonicalName());
            if("java.lang.Double".equals(f.getType().getCanonicalName())){
                if(f.get(thisClass)==null){
                    f.set(thisClass,0.0);
                }else {
                    BigDecimal b   =   new   BigDecimal((double) f.get(thisClass));
                    double   fdouble   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
                    f.set(thisClass,fdouble);
                }
            }
        }
        return cls;
    }

    public static Field[] getBeanFields(Class cls,Field[] fs){
        fs = (Field[]) ArrayUtils.addAll(fs, cls.getDeclaredFields());
        if(cls.getSuperclass()!=null){
            Class clsSup = cls.getSuperclass();
            fs = getBeanFields(clsSup,fs);

        }
        return fs;
    }



    /**
     * mybaties 查询example 公共方法，查询条件
     * @param thisClass
     * @return
     */
    public static Example example(Object thisClass) {
        // 创建Example
        Example example = new Example(thisClass.getClass());
        // 创建Criteria
        Example.Criteria criteria = example.createCriteria();

        Class cls = thisClass.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            Field f = fields[i];
            f.setAccessible(true);
            Transient trans=f.getAnnotation(Transient.class);
            if(trans!=null){
                continue;
            }
            try {
                if(f.get(thisClass)!=null&& !org.springframework.util.StringUtils.isEmpty(f.get(thisClass))) {
    //                System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(thisClass)+"属性类型:"+f.getType().getCanonicalName());
                    if("java.lang.String".equals(f.getType().getCanonicalName())){
                        criteria.andLike(f.getName(),"%"+f.get(thisClass)+"%");
                    }else {
                        criteria.andEqualTo(f.getName(),f.get(thisClass));
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return example;
    }

    /**
     * 只能传实体或者Map
     * @param object
     */
    public static void page(Object object){
        Integer page=null;
        Integer length=null;
        String orderBy = "";
        Class cls = object.getClass();
        if("java.util.HashMap".equals(cls.getName())){
            Map obj=(Map) object;
            page= (Integer) obj.get("pageNo");
            length= (Integer) obj.get("length");
            orderBy= (String) obj.get("orderBy");
        }else {
            Field[] fields = null;
            fields = getBeanFields(cls, fields);
            for(int i=0; i<fields.length; i++){

                Field f = fields[i];
                f.setAccessible(true);
                try {
                    if(f.get(object)!=null) {
                        if("pageNo".equals(f.getName())){
                            page=(Integer) f.get(object);
                        }
                        if("length".equals(f.getName())){
                            length=(Integer) f.get(object);
                        }
                        if("orderBy".equals(f.getName())){
                            orderBy=(String) f.get(object);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        page(page,length,orderBy);
    }


    public static void page(Integer pageNo,Integer length,String orderBy){
        if(null==pageNo ||pageNo==0){
            pageNo=1;
        }else {
            pageNo+=1;
        }
        if(null==length || length==0){
            length=10;
        }
        PageHelper.startPage(pageNo,length,orderBy);
    }




        private static final char UNDERLINE ='_';

    /**
     * 驼峰转换 加 “-”
     * @param param
     * @return
     */
        public static String camelToUnderline(String param) {
            if (StringUtils.isEmpty(param)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int len = param.length();
            for (int i = 0; i < len; i++) {
                char c = param.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append(UNDERLINE);
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

    /**
     * 驼峰转换 去 “-”
     * @param param
     * @return
     */
        public static String underlineToCamel(String param){
            if (StringUtils.isEmpty(param)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int len = param.length();
            for (int i = 0; i < len; i++) {
                char c = param.charAt(i);
                if (c==UNDERLINE) {
                    if(++i<len){
                        sb.append(Character.toUpperCase(param.charAt(i)));
                    }
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }


    /**
     * 复制list
     * @param srcList
     * @param <T>
     * @return
     */
    public static <T> List<T> depCopy(List<T> srcList) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try {
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(srcList);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream inStream = new ObjectInputStream(byteIn);
            List<T> destList = (List<T>) inStream.readObject();
            return destList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }




}
