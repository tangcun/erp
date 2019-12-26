/*
package com.weiwo.erp.code.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weiwo.erp.code.CodeServer;
import com.weiwo.erp.entity.CodeEntity;
import com.weiwo.erp.util.JsonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.pro.common.utils.JdbcUtil;
import com.pro.common.utils.JsonUtil;
import com.pro.common.utils.PinYin4jUtil;

public class CodeServerImpl implements CodeServer {


	String codeTableName = "HBJY_COMMON.CODE";

	*/
/**
	 * 根据编码组 KEY 获取编码组对象
	 * 
	 * @param groupKey
	 * @return
	 *//*

	*/
/*private CodeEntity loadGroupCode(String groupKey) {
		CodeEntity code = null;
		if (groupKey != null && !groupKey.equals("")) {
			String sql = "select ID , PARENT_ID , NAME , KEY , ORDER_NUMBER , IS_VALID , IS_GROUP , GROUP_KEY, PINYIN,TYPE from "
					+ codeTableName + " where KEY='" + groupKey + "'";
			Connection con = null;
			Statement statement = null;
			ResultSet rs = null;
			try {
				con = JdbcUtil.getConnection();
				statement = con.createStatement();
				rs = statement.executeQuery(sql);
				while (rs.next()) {
					code = new CodeEntity(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getInt(6), rs.getInt(7), rs.getString(8),rs.getString(9),rs.getString(10));
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (statement != null)
						statement.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return code;
	}*//*


	*/
/**
	 * 根据编码组 KEY 和当前编码KEY 获取当前编码组对象
	 * 
	 * @param groupKey
	 * @return
	 *//*

	*/
/*private CodeEntity loadCodeSelf(String groupKey, String currentKey) {
		CodeEntity code = null;
		if (groupKey != null && !groupKey.equals("") && currentKey != null
				&& !currentKey.equals("")) {
			String sql = "select ID , PARENT_ID , NAME , KEY , ORDER_NUMBER , IS_VALID , IS_GROUP ,  GROUP_KEY, PINYIN,TYPE from "
					+ codeTableName
					+ " where KEY='"
					+ currentKey
					+ "' and  GROUP_KEY='" + groupKey + "'";
			Connection con = null;
			Statement statement = null;
			ResultSet rs = null;
			try {
				con = JdbcUtil.getConnection();
				statement = con.createStatement();
				rs = statement.executeQuery(sql);
				while (rs.next()) {
					code = new CodeEntity(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getInt(6), rs.getInt(7), rs.getString(8),rs.getString(9),rs.getString(10));
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (statement != null)
						statement.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return code;
	}*//*


	*/
/**
	 * 将当前的currentCode 添加到 groupCode对象中
	 *
	 * @param currentCode
	 *            当前需要处理的编码对象
	 *//*

	private void addCode(CodeEntity groupCode, CodeEntity currentCode) {
		if (currentCode.getParentKey().equals(groupCode.getId())) {
			groupCode.setCodeList(currentCode);
		}
	}

	*/
/**
	 * 根据当前编码对象 和 保留的层级 ，对对象进行过滤
	 * 
	 * @param code
	 *            当前编码对象
	 * @param level
	 *            需要保留几层
	 *//*

	private void filterCodeBylevel(CodeEntity code, int level) {
		filterCodeBylevel(code, level, 0);
	}

	private void filterCodeBylevel(CodeEntity code, int level, int current) {
		if (code.getCodeList() != null) {
			for (CodeEntity code_ : code.getCodeList()) {
				if (current < level) {
					filterCodeBylevel(code_, level, current + 1);
				} else {
					code.codeList = null;
				}
			}
		}
	}

	*/
/**
	 * 根据编码组 和 该编码组下的所有编码Map ，组装Code 树
	 * 
	 * @param superCode
	 * @param codeMap
	 *//*

	private void addCode(CodeEntity superCode, Map<String, List<CodeEntity>> codeMap) {
		if (codeMap.containsKey(superCode.getId())) {
			List<CodeEntity> codeList = codeMap.get(superCode.getId());
			if (codeList != null) {
				superCode.setCodeList(codeList);
				for (CodeEntity code_ : codeList) {
					addCode(code_, codeMap);
				}
			}
		}

	}

	*/
/**
	 * 根据编码组编码获取 其孩子节点编码集合，默认返回一层,深度=1(level = 1) currentCode =null
	 *
	 * @return
	 *//*

	@Override
	public CodeEntity loadCode(String groupKey, boolean showValid) {
		return loadCode(groupKey, null, 1,showValid);

	}
	
	*/
/**
	 * 根据编码组编码 + 当前编码KEY 获取 其孩子节点编码集合，默认返回一层,深度=1(level = 1)
	 * 
	 * @param groupKey
	 *            编码组 编码KEY名称[ 键(key) ]
	 * @param currentCodeKey
	 *            当前编码 编码KEY名称[ 键(key) ]
	 * @return
	 *//*

	@Override
	public CodeEntity loadCode(String groupKey, String currentCodeKey, boolean showValid) {
		return loadCode(groupKey, currentCodeKey, 1,showValid);
	}
	*/
/**
	 * 根据编码组编码 + 当前编码KEY + 编码获取深度 获取 其孩子节点编码集合
	 *
	 * @param level
	 *            需要获取编码的 深度
	 * @return
	 *//*

	@Override
	public CodeEntity loadCode(String groupKey, String currentCodeKey, int level, boolean showValid) {
		// 编码组下的所有编码值
		Map<String, List<CodeEntity>> codeMap = new HashMap<String, List<CodeEntity>>();
		String sql = "select ID , PARENT_ID , NAME , KEY , ORDER_NUMBER , IS_VALID , IS_GROUP , GROUP_KEY, PINYIN,TYPE from "
				+ codeTableName;
		String where = " where 1=1 ";
		CodeEntity code = null;
		*/
/*if(showValid){
			where += " and IS_VALID='1'";
		}
		if (currentCodeKey == null || currentCodeKey.equals("")) {// 如果当前currentCodeKey为空
			if (level == 1) {// 如果默认只查子节点
				where += " and PARENT_ID =(select ID from " + codeTableName
						+ " where KEY='" + groupKey + "' )";
			} else {// 查询当前编码组下全部编码 子孙万代
				where += " and IS_GROUP=0 and  GROUP_KEY='" + groupKey + "' ";
			}
			// code = new Code(groupKey);
			code = loadGroupCode(groupKey);
		} else {
			if (level == 1) {// 如果默认只查子节点
				where += " and IS_GROUP=0 and PARENT_ID =(select id from "
						+ codeTableName + " where KEY='" + currentCodeKey
						+ "' and group_Key='" + groupKey + "') ";
			} else {// 根据当前编码和编码所在组，查询其下所有编码 子孙万代
				where += " start with PARENT_ID = (select id from "
						+ codeTableName + " where KEY='" + currentCodeKey
						+ "' and group_Key='" + groupKey
						+ "' ) connect by prior id = parent_id ";
			}
			// code = new Code(currentCodeKey);
			code = loadCodeSelf(groupKey, currentCodeKey);
		}
		sql += where + " order by ORDER_NUMBER";
		Connection con = null;
		Statement statement = null;
		try {
			con = JdbcUtil.getConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String id_ = rs.getString(1);
				String parentId_ = rs.getString(2);

				if (level == 1) {// 如果只获取一层，则直接返回code对象
					addCode(code,
							new CodeEntity(id_, parentId_, rs.getString(3), rs
									.getString(4), rs.getInt(5), rs.getInt(6),
									rs.getInt(7), rs.getString(8),rs.getString(9),rs.getString(10)));
				} else {// 如果多层，则需要进行计算得出
					if (codeMap.get(parentId_) == null) {
						codeMap.put(parentId_, new ArrayList<CodeEntity>());
					}
					codeMap.get(parentId_).add(
							new CodeEntity(id_, parentId_, rs.getString(3), rs
									.getString(4), rs.getInt(5), rs.getInt(6),
									rs.getInt(7), rs.getString(8), rs.getString(9),rs.getString(10)));
				}
			}
			if (level != 1) {

				addCode(code, codeMap);// 组装全部编码，得到一颗编码树
				if(level !=0 ){  //如果level等于0，不需要层过滤全部取出，否则根据需要的层级进行过滤
					filterCodeBylevel(code, level);// 根据给定的深度 ，过滤编码树的层级
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*//*

		return code;
	} 
	
	
	*/
/**
	 * 根据编码组编码 + 当前编码KEY + 编码获取深度 获取 其孩子节点编码集合JSON
	 *
	 * @param level
	 *            需要获取编码的 深度
	 * @return
	 *//*

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String loadCode2Json(String groupKey, String currentCodeKey,int level,boolean showValid) {
		// -------------需要根据组件库的要求进行递归遍历，后期需要完善
		CodeEntity code = null;
		if(showValid){
			code = loadCode(groupKey, currentCodeKey, level,true);
		}else{
			code = loadCode(groupKey, currentCodeKey, level,false);
		}
		List list = new ArrayList();
		*/
/*if (code.getCodeList() != null) {
			List<CodeEntity> codeList = code.getCodeList();
			for (int i = 0; i < codeList.size(); i++) {
				CodeEntity childCode = codeList.get(i);
				Map map = Maps.newHashMap();
//				map.put("hidden", childCode.getIsValid()==1?false:true);
				map.put("text", childCode.getName());
				map.put("id", childCode.getKey());
				map.put("jianpinLower", PinYin4jUtil.getHanyuPinyinOfHanzi(childCode.getName().replaceAll(" ", ""), true, true));
				map.put("jianpinUpper", StringUtils.upperCase(String.valueOf(map.get("jianpinLower"))));
				//提供是否有效状态位
				map.put("isValid",childCode.getIsValid());
				
				list.add(map);
			}
		}*//*

		return JsonUtil.objectToJsonStr(list);
	}
	*/
/**
	 * 
	 * 根据编码组编码获取 其孩子节点编码集合JSON，默认返回一层,深度=1(level = 1) currentCode =null
	 *
	 * @return
	 *//*

	@Override
    public String loadCode2Json(String groupKey, boolean showValid) {
		return loadCode2Json(groupKey, null, 1, showValid);
	}
	
	*/
/**
	 * 根据编码组编码 + 当前编码KEY 获取 其孩子节点编码集合JSON，默认返回一层,深度=1(level = 1)
	 * 
	 * @param groupKey
	 *            编码组 编码KEY名称[ 键(key) ]
	 * @param currentCodeKey
	 *            当前编码 编码KEY名称[ 键(key) ]
	 * @return
	 *//*

	@Override
    public String loadCode2Json(String groupKey, String currentCodeKey, boolean showValid) {
		return loadCode2Json(groupKey, currentCodeKey, 1, showValid);
	}
	
	*/
/**
	 *.
	 * @param groupKey
	 * @param currentCodeKey
	 * @param level
	 * @param showValid
	 * @return
	 *//*

	@Override
    public String loadCode2SimpleTreeJson(String groupKey, String currentCodeKey, int level, boolean showValid) {
		List<?> list = Lists.newArrayList();
		CodeEntity groupCode = null;
		if(showValid){
			groupCode = this.loadCode(groupKey, currentCodeKey, level,true);
		}else{
			groupCode = this.loadCode(groupKey, currentCodeKey, level, false);
		}
		List<CodeEntity> childList=groupCode.getCodeList();
		recursive(childList,list);
		return JsonUtil.objectToJsonStr(list);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void recursive(List<CodeEntity> codeList,List list){
		if(CollectionUtils.isNotEmpty(codeList)){
			for(Object obj : codeList){
				CodeEntity code = (CodeEntity)obj;
				Map map = new HashMap();
				map.put("pId", code.getParentKey());
				map.put("id", code.getKey());
				map.put("text", code.getName());
//				map.put("hidden", code.getIsValid()==1?false:true);
//				map.put("jianpinLower", PinYin4jUtil.getHanyuPinyinOfHanzi(code.getName().replaceAll(" ", ""), true, true));
//				map.put("jianpinUpper", StringUtils.upperCase(String.valueOf(map.get("jianpinLower"))));
				list.add(map);
				List<CodeEntity> childList = code.getCodeList();
				if (childList != null && !childList.isEmpty()) {
					recursive(childList,list);
				}
			}
		}
	}
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String loadCode4CombotreeJson(String groupKey,String currentCodeKey,int level,boolean showValid){
		CodeEntity groupCode = null;
		if(showValid){
			groupCode = this.loadCode(groupKey, currentCodeKey, level,true);
		}else{
			groupCode = this.loadCode(groupKey, currentCodeKey, level, false);
		}
		Map map = new HashMap();
		if(groupCode!=null){
			map.put("id", groupCode.getKey());
			map.put("text", groupCode.getName());
//			map.put("hidden", groupCode.getIsValid()==1?false:true);
			List<CodeEntity> childList = groupCode.getCodeList();
			if (childList != null && !childList.isEmpty()) {
				List child = recursive(childList);
				if (child != null && !child.isEmpty()) {
					map.put("children", child);
				}
			}
		}
		return JsonUtil.objectToJsonStr(map);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List recursive(List list){
		List recList = Lists.newArrayList();
		if(CollectionUtils.isNotEmpty(list)){
			for(Object obj : list){
				CodeEntity code = (CodeEntity)obj;
				Map map = Maps.newHashMap();
				map.put("id", code.getKey());
				map.put("text", code.getName());
//				map.put("hidden", code.getIsValid()==1?false:true);
				if(CollectionUtils.isEmpty(code.getCodeList())){
					map.put("open", "false");
				}
				List childList = code.getCodeList();
				if (childList != null && !childList.isEmpty()) {
					List child = recursive(childList);
					if (child != null && !child.isEmpty()) {
						map.put("children", child);
					}
				}
				if(map != null && !map.isEmpty()){
					recList.add(map);
				}
			}
		}
		return recList;
	}
	

	*/
/**
	 * 
	 * @param groupKey
	 * @param loadType
	 * @param regex
	 * @return
	 *//*

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String loadCode4ComboJson(String groupKey, int loadType, String regex,boolean showValid) {
		CodeEntity code = null;
		if(showValid){
			code = this.loadCode(groupKey,true);
		}else{
			code = this.loadCode(groupKey, false);
		}
		List list = this.loadCode4Regex(code, loadType, regex);
		return JsonUtil.objectToJsonStr(list);
	}

	*/
/**
	 *.
	 * @param groupKey
	 * @param loadType
	 * @param regex
	 * @param codes
	 * @return
	 *//*

	@Override
	@SuppressWarnings("rawtypes")
	public String loadCode4ComboJson(String groupKey, int loadType,String regex, String codes) {
		CodeEntity code = this.loadCode(groupKey, false);
		List<Map> list = this.loadCode4Regex(code, loadType, regex);
		if(CollectionUtils.isNotEmpty(list)&&StringUtils.isNotBlank(codes)){
			List _codes = Arrays.asList(codes.split(","));
			for (int i=list.size()-1;i>=0;i--) {
				Map map = list.get(i);
				String codeKey = String.valueOf(map.get("value"));
				if(_codes.contains(codeKey)){
					list.remove(map);
				}
			}
		}
		return JsonUtil.objectToJsonStr(list);
	}

	@SuppressWarnings({"rawtypes", "unchecked" })
	private List<Map> loadCode4Regex(CodeEntity code,int loadType,String regex){
		List list = Lists.newArrayList();
		if (code != null && CollectionUtils.isNotEmpty(code.getCodeList())) {
			if(loadType == 1){
				for (CodeEntity child : code.getCodeList()) {
					if(child.getKey().endsWith(regex)){
						Map map = Maps.newHashMap();
						map.put("id", child.getKey());
						map.put("text", child.getName());
//						map.put("hidden", child.getIsValid()==1?false:true);
//						map.put("jianpinLower", PinYin4jUtil.getHanyuPinyinOfHanzi(child.getName().replaceAll(" ", ""), true, true));
//						map.put("jianpinUpper", StringUtils.upperCase(String.valueOf(map.get("jianpinLower"))));
						list.add(map);
					}
				}
			}else if(loadType == 2){
				for (CodeEntity child : code.getCodeList()) {
					if(child.getKey().startsWith(regex)){
						Map map = Maps.newHashMap();
						map.put("id", child.getKey());
						map.put("text", child.getName());
//						map.put("hidden", child.getIsValid()==1?false:true);
//						map.put("jianpinLower", PinYin4jUtil.getHanyuPinyinOfHanzi(child.getName().replaceAll(" ", ""), true, true));
//						map.put("jianpinUpper", StringUtils.upperCase(String.valueOf(map.get("jianpinLower"))));
						list.add(map);
					}
				}
			}else if(loadType == 3){
				for(CodeEntity child : code.getCodeList()){
					if(!(","+regex+",").contains(","+child.getKey()+",")){
						Map map = Maps.newHashMap();
						map.put("id", child.getKey());
						map.put("text", child.getName());
//						map.put("hidden", child.getIsValid()==1?false:true);
//						map.put("jianpinLower", PinYin4jUtil.getHanyuPinyinOfHanzi(child.getName().replaceAll(" ", ""), true, true));
//						map.put("jianpinUpper", StringUtils.upperCase(String.valueOf(map.get("jianpinLower"))));
						list.add(map);
					}
				}
			}else if(loadType == 4){
				for(CodeEntity child : code.getCodeList()){
					if((","+regex+",").contains(","+child.getKey()+",")){
						Map map = Maps.newHashMap();
						map.put("id", child.getKey());
						map.put("text", child.getName());
//						map.put("hidden", child.getIsValid()==1?false:true);
//						map.put("jianpinLower", PinYin4jUtil.getHanyuPinyinOfHanzi(child.getName().replaceAll(" ", ""), true, true));
//						map.put("jianpinUpper", StringUtils.upperCase(String.valueOf(map.get("jianpinLower"))));
						list.add(map);
					}
				}
			}else if(loadType == 5){
				for(CodeEntity child : code.getCodeList()){
					if(!(","+regex+",").contains(","+child.getType()+",")){
						Map map = Maps.newHashMap();
						map.put("id", child.getKey());
						map.put("text", child.getName());
//						map.put("hidden", child.getIsValid()==1?false:true);
//						map.put("jianpinLower", PinYin4jUtil.getHanyuPinyinOfHanzi(child.getName().replaceAll(" ", ""), true, true));
//						map.put("jianpinUpper", StringUtils.upperCase(String.valueOf(map.get("jianpinLower"))));
						list.add(map);
					}
				}
			}else if(loadType == 6){
				for(CodeEntity child : code.getCodeList()){
					if((","+regex+",").contains(","+child.getType()+",")){
						Map map = Maps.newHashMap();
						map.put("id", child.getKey());
						map.put("text", child.getName());
//						map.put("hidden", child.getIsValid()==1?false:true);
//						map.put("jianpinLower", PinYin4jUtil.getHanyuPinyinOfHanzi(child.getName().replaceAll(" ", ""), true, true));
//						map.put("jianpinUpper", StringUtils.upperCase(String.valueOf(map.get("jianpinLower"))));
						list.add(map);
					}
				}
			}else{
				for(CodeEntity child : code.getCodeList()){
					Map map = Maps.newHashMap();
					map.put("id", child.getKey());
					map.put("text", child.getName());
//					map.put("hidden", child.getIsValid()==1?false:true);
//					map.put("jianpinLower", PinYin4jUtil.getHanyuPinyinOfHanzi(child.getName().replaceAll(" ", ""), true, true));
//					map.put("jianpinUpper", StringUtils.upperCase(String.valueOf(map.get("jianpinLower"))));
					list.add(map);
				}
			}
		}
		return list;
	}
	
	
	
	*/
/**
	 *.根据编码KEY获取编码名称
	 * @param groupKey 编码组KEY
	 * @param codeKeys 编码KEY，多个用“,”分开
	 * @return
	 *//*

	@Override
		public String getCodeNameByCodeKey(String groupKey, String codeKeys) {
		String codeName = "";
		if(StringUtils.isNotBlank(codeKeys)){
			String[] codes = StringUtils.split(codeKeys, ",");
			for (int i = 0; i < codes.length; i++) {
				CodeEntity code = this.loadCode(groupKey, codes[i].trim(),false);
				if(code!=null)
				codeName += "，"+code.getName();
			}
			if(!"".equals(codeName))
			codeName = codeName.substring(1);
		}
		return codeName;
	}

	@Override
	public List<CodeEntity> loadAllGroupKey() {
		List<CodeEntity> list = new ArrayList<CodeEntity>();
			String sql = "select DISTINCT(GROUP_KEY) from "
					+ codeTableName + " where IS_GROUP='1' ";
			Connection con = null;
			Statement statement = null;
			ResultSet rs = null;
			try {
				con = JdbcUtil.getConnection();
				statement = con.createStatement();
				rs = statement.executeQuery(sql);
				while (rs.next()) {
					CodeEntity code = new CodeEntity();
					code.setGroupKey(rs.getString(1));
					list.add(code);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return list;
	}

	*/
/**
	 * 获取省外的监狱管理局
	 *//*

	@Override
	public String loadJyhljGroupCode() {
		List list = new ArrayList();
		String sql = "select ID , PARENT_ID , NAME , KEY , ORDER_NUMBER , IS_VALID , IS_GROUP , GROUP_KEY, PINYIN,TYPE from "
				+ codeTableName + " where group_key = '4.5.1' and key <>'1300' and key like '%00' ";
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Map map = new HashMap();
				map.put("id", rs.getString(4));
				map.put("text", rs.getString(3));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	return JsonUtil.objectToJsonStr(list);
	}
	
	
	*/
/**
	 * 加载外省监狱管理局
	 * @return
	 *//*

	
}
*/
