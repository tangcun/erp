package com.weiwo.erp.baseService;

import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.weiwo.erp.entity.BaseEntity;
import com.weiwo.erp.util.PageUtil;
import com.weiwo.erp.util.ResultUtil;
import com.weiwo.erp.util.SuppBeanUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseService<T>  {


    @Autowired
    private Mapper mapper;
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory1 ) {
        super.setSqlSessionFactory(sqlSessionFactory1);
    }

    /**
     * 添加
     */
    @Override
    public int save(T t){
        if(null == t.getId() || t.getId() == 0){
            return mapper.insert(t);
        }else{
            return update(t);
        }
    }
    /**
     * 批量添加
     */
    @Override
    public int save(List<T> list){
        int sum = 0;
        for (T t:list){
            sum += save(t);
        }
        return sum;
    }

    /**
     * 物理删除
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id){
        PageUtil select = new PageUtil(id);
        return mapper.deleteByExample(select);
    }

    /**
     * 批量删除
     * @param idList id集合
     * @return 成功删除的总数
     */
    @Override
    public int delete(List<Integer> idList){
        int sum = 0;
        for (Integer id:idList){
            sum += delete(id);
        }
        return sum;
    }

    /**
     * 修改
     */
    @Override
    public int update(T t){
        return mapper.updateByPrimaryKey(t);
    }

    /**
     * 根据条件查找
     * @param object
     * @return
     */
    @Override
    public List<T> findAll(Object object){
        List<T> list=mapper.selectByExample(SuppBeanUtils.example(object));
        return list ;
    }

    /**
     * 无条件查找所有
     * @return
     */
    @Override
    public List<T> findAll(){
        return findAll(null) ;
    }

    /**
     * 根据条件分页查找
     * @param object
     * @return
     */
    @Override
    public ResultUtil<T> findPage(Object object){
        ResultUtil result=new ResultUtil<>();
        SuppBeanUtils.page(object);
        List<T> list=mapper.selectByExample(SuppBeanUtils.example(object));
        result.setData(list);
        result.setITotalRecords(new PageInfo<T>(list).getTotal());
        return result;
    }
    /**
     * 分页查找所有数据
     * @return
     */
    @Override
    public ResultUtil<T> findPage(){
        return findPage(null) ;
    }

    /**
     * 根据ID查找单条数据
     * @param id
     * @return
     */
    @Override
    public T findOne(Integer id){
        PageUtil select = new PageUtil(id);
        return findOne(select);
    }
    /**
     * 根据条件查找单条数据
     * @param t
     * @return
     */
    @Override
    public T findOne(Object t){
        ResultUtil result = findPage(t);
        if(result.getITotalDisplayRecords()>0){
            return (T) result.getData().get(0);
        }else {
            return null;
        }
    }


    /**
     * 自定查找
     * parm传值只接受Map 或实体
     * @param key
     * @param parameter
     * @return
     */
    @Override
    public ResultUtil<T> findCustomMapper(String key, Object parameter){
        SuppBeanUtils.page(parameter);
        ResultUtil result=new ResultUtil<>();
        Page page  =(Page) getSqlSession().selectList(key,parameter);
        List<T> list=page.getResult();
        result.setData(list);
        result.setITotalRecords(page.getTotal());
        return result;
    }

}
