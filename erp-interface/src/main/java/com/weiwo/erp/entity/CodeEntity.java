package com.weiwo.erp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 编码类
 * <p>描述:</p>
 */
@Entity
@Data
//@Table(name = "biz_dictionary")
public class CodeEntity {
	@Id
	@GeneratedValue
	private String id;//code主键[ ID(id) ]asdasdasd
	private String parentKey;//父编码ID[ 父编码ID(parentId) ]
	private String key;//编码KEY名称[ 键(key) ]
	private String valueCn;//编码值[ 名称(name) ]
	private String valueEn;//编码值[ 名称(name) ]
	private int orderNum;//排序号(orderNumber)
	private String groupKey;//编码组 编码KEY名称

/*	public int group;//组(isGroup)
	public int isValid;//是否有效(isValid)
	private String pingyin;//拼音
	private String type;//类型，可扩展为根据类型过滤功能*/

	@Transient
	private List<CodeEntity> codeList;//子类编码集合
	private boolean runFlag = true;//遍历标志
	
	


	/**
	 * 复写了默认SET 方法
	 * @param code
	 */
	public void setCodeList(CodeEntity code) {
		if(this.getCodeList()==null){
			this.codeList = new ArrayList<CodeEntity>();
		}
		if(code != null){
			this.codeList.add(code);
		}
	}
	
	
	/**
	 * 复写了默认SET 方法
	 * @param codeList
	 */
	public void setCodeList(List<CodeEntity> codeList) {
		if(this.getCodeList()==null) {
			this.codeList = new ArrayList<CodeEntity>();
		}
		if(codeList != null){
			this.codeList.addAll(codeList);
		}
	}

}
