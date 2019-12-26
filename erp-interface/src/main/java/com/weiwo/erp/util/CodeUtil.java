/*
package com.weiwo.erp.util;


import com.weiwo.erp.code.CodeServer;
import com.weiwo.erp.code.impl.CodeServerRedisImpl;

public class CodeUtil {
	private static CodeServer codeServer = new CodeServerRedisImpl();
	
	*/
/**
	 * 通用（二级和多级）下拉框编码组，没有过滤功能
	 * @param groupKey
	 * @return
	 *//*

	public static String  getCodeJson (String groupKey){
		 	return codeServer.loadCode2SimpleTreeJson(groupKey,null, 0, false);
	}
	*/
/**
	 * 通用（二级和多级）下拉框编码组，有过滤功能
	 * @param groupKey
	 * @return
	 *//*

	public static String  getCodeJson (String groupKey,String key){
		return codeServer.loadCode2SimpleTreeJson(groupKey,key, 0, false);
	}
	
	*/
/**
	 *  过滤下拉框编码暂时只支持二级结构
	 * @param groupKey 编码组KEY
	 * @param loadType 加载类型【1：匹配KEY后几位字符；2：匹配KEY前几位字符；3：剔除的KEY，如：1,2,3】
	 * @param regexString 匹配的KEY字符串
	 * @return
	 *//*

	public static String  getCodeJsonRegex (String groupKey, int loadType,String regex){
	 	return codeServer.loadCode4ComboJson(groupKey,loadType, regex, false);
	}
	
	*/
/**
	 *  通过编码租和key获取那么
	 * @param groupKey 编码组KEY
	 * @param loadType 加载类型【1：匹配KEY后几位字符；2：匹配KEY前几位字符；3：剔除的KEY，如：1,2,3】
	 * @param regexString 匹配的KEY字符串
	 * @return
	 *//*

	public static String  getCodeNameByCodeKey (String groupKey, String codeKeys){
		return codeServer.getCodeNameByCodeKey(groupKey, codeKeys);
	}
	
	*/
/**
	 * 根据编码组编码获取 其孩子节点编码集合JSON，默认返回一层,深度=1(level = 1)
	 * @param groupKey
	 * @return
	 *//*

	public static String  loadCode2Json(String groupKey){
		return codeServer.loadCode2Json(groupKey, false);
	}
	
	*/
/**
	 * 获取省外的监狱管理局
	 * @return
	 *//*

	public static String loadJyhljGroupCode(){
		return codeServer.loadJyhljGroupCode();
	};
	public static void main(String[] args) {
//		System.out.println(getPageSqlByOracle("T_USER",1,20));
//		String str = getCodeJsonRegex(CommonConst.GROUP_KEY_SZGL_DZPG,1,"01");
//		System.out.println(str);
	}
	
}
*/
