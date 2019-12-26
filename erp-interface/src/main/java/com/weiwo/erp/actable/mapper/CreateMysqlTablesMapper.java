package com.weiwo.erp.actable.mapper;



import com.weiwo.erp.actable.table.TableSql;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 创建更新表结构的Mapper
 *
 */
@Repository
public interface CreateMysqlTablesMapper {

	/**
	 * 根据结构注解解析出来的信息创建表
	 * @param tableSql
	 */
	public void createTable(TableSql tableSql);

	/**
	 * 根据表名查询表在库中是否存在，存在返回1，不存在返回0
	 * @param tableName 表结构的map
	 * @return 存在返回1，不存在返回0
	 */
	public int findTableCountByTableName(@Param("tableName") String tableName);

	/**
	 * 根据表名查询库中该表的字段结构等信息
	 * @param tableName 表结构的map
	 * @return 表的字段结构等信息
	 */
	public List<String> findTableEnsembleByTableName(@Param("tableName") String tableName);

	/**
	 * 增加字段
	 * @param tableSql
	 */
	public void addTableField(TableSql tableSql);

	/**
	 * 根据表名删除表
	 * @param tableName 表结构的map
	 */
	public void dorpTableByName(@Param("tableName") String tableName);
}
