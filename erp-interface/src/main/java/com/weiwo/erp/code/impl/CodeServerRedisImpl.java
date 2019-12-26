/*
package com.weiwo.erp.code.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pro.common.cache.RedisPoolClient;
import com.pro.common.utils.JdbcUtil;
import com.weiwo.erp.code.CodeServer;
import com.weiwo.erp.entity.CodeEntity;

public class CodeServerRedisImpl implements CodeServer {
	
	private CodeServer codeServer = new CodeServerImpl();
	private RedisPoolClient redisPoolClient = new RedisPoolClient();

	*/
/**
	 *.
	 * @param groupKey
	 * @return
	 *//*

	@Override
	public CodeEntity loadCode(String groupKey,boolean showValid) {
		return this.codeServer.loadCode(groupKey,showValid);
	}

	*/
/**
	 *.
	 * @return
	 *//*

	@Override
	public List<CodeEntity> loadAllGroupKey() {
		return this.codeServer.loadAllGroupKey();
	}
	
	*/
/**
	 *.
	 * @param groupKey
	 * @param currentCodeKey
	 * @return
	 *//*

	@Override
	public CodeEntity loadCode(String groupKey, String currentCodeKey,boolean showValid) {
		return this.codeServer.loadCode(groupKey, currentCodeKey, showValid);
	}

	*/
/**
	 *.
	 * @param superCode
	 * @param currentCode
	 * @param level
	 * @return
	 *//*

	@Override
	public CodeEntity loadCode(String superCode, String currentCode, int level, boolean showValid) {
		return this.codeServer.loadCode(superCode, currentCode, level, showValid);
	}

	*/
/**
	 *.
	 * @param groupKey
	 * @return
	 *//*

	@Override
	public String loadCode2Json(String groupKey, boolean showValid) {
		return this.loadCode2Json(groupKey, null, 1,showValid);
	}

	*/
/**
	 *.
	 * @param groupKey
	 * @param currentCodeKey
	 * @return
	 *//*

	@Override
	public String loadCode2Json(String groupKey, String currentCodeKey,boolean showValid) {
		return this.loadCode2Json(groupKey, currentCodeKey, 1, showValid);
	}

	*/
/**
	 *.
	 * @param groupKey
	 * @param currentCodeKey
	 * @param level
	 * @return
	 *//*

	@Override
	public String loadCode2Json(String groupKey, String currentCodeKey,int level,boolean showValid) {
		String value = redisPoolClient.hgetCode(groupKey, currentCodeKey+"_"+level+"_"+showValid);
		if(value != null){
			return value;
		}else{
			value = this.codeServer.loadCode2Json(groupKey, currentCodeKey, level, showValid);
			System.out.println("try again , now loading from db code:"+value);
			redisPoolClient.hsetCode(groupKey, currentCodeKey+"_"+level+"_"+showValid, value);
		}
		return value;
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
		String value = redisPoolClient.hgetCode(groupKey, "simple_"+currentCodeKey+"_"+level+"_"+showValid);
		if(value != null){
			return value;
		}else{
			value = this.codeServer.loadCode2SimpleTreeJson(groupKey, currentCodeKey, level, showValid);
//			System.out.println("try again , now loading from db code:"+value);
			redisPoolClient.hsetCode(groupKey, "simple_"+currentCodeKey+"_"+level+"_"+showValid, value);
		}
		return value;
	}

	*/
/**
	 *.
	 * @param groupKey
	 * @param loadType
	 * @param regex
	 * @return
	 *//*

	@Override
	public String loadCode4ComboJson(String groupKey, int loadType, String regex, boolean showValid) {
		String value = redisPoolClient.hgetCode(groupKey, "loadType"+"_"+loadType+"_"+regex+"_"+showValid);
		if(value != null){
			return value;
		}else{
			value = this.codeServer.loadCode4ComboJson(groupKey, loadType, regex, showValid);
			System.out.println("try again , now loading from db code:"+value);
			redisPoolClient.hsetCode(groupKey, "loadType"+"_"+loadType+"_"+regex+"_"+showValid, value);
		}
		return value;
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
	public String loadCode4ComboJson(String groupKey, int loadType, String regex, String codes) {
		String value = this.codeServer.loadCode4ComboJson(groupKey, loadType, regex, codes);
		return value;
	}

	*/
/**
	 *.
	 * @param groupKey
	 * @param currentCodeKey
	 * @param level
	 * @param loadType
	 * @param regex
	 * @return
	 *//*

	@Override
	public String loadCode4CombotreeJson(String groupKey, String currentCodeKey, int level, boolean showValid){
		String value = redisPoolClient.hgetCode(groupKey, "combotree_"+currentCodeKey+"_"+level+"_"+showValid);
		if(value != null){
			return value;
		}else{
			value = this.codeServer.loadCode4CombotreeJson(groupKey, currentCodeKey, level, showValid);
			System.out.println("try again , now loading from db code:"+value);
			redisPoolClient.hsetCode(groupKey, "combotree_"+currentCodeKey+"_"+level+"_"+showValid, value);
		}
		return value;
	}

	*/
/**
	 *.
	 * @param groupKey
	 * @param codeKeys
	 * @return
	 *//*

	@Override
	public String getCodeNameByCodeKey(String groupKey, String codeKeys) {
		String value = redisPoolClient.hgetCode(groupKey, codeKeys);
		if(value != null && !"".equals(value)){
			return value;
		}else{
			value = this.codeServer.getCodeNameByCodeKey(groupKey, codeKeys);
			redisPoolClient.hsetCode(groupKey, codeKeys, value);
		}
		return value;
	}

	*/
/**
	 * 获取省外的监狱管理局
	 *//*

	@Override
	public String loadJyhljGroupCode() {
		String value=this.codeServer.loadJyhljGroupCode();
		return value;
	}

}
*/
