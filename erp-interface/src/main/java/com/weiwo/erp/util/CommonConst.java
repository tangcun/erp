/*
package com.weiwo.erp.util;

public class CommonConst {

	*/
/**************************数据库连接常量**********************************//*

	public static final String COMMON = "HBJY_COMMON";
	
	public static final String FLOW = "HBJY_FLOW";
	
	public static final String AUTH = "HBSB_AUTH";
	
	public static final String XFZX = "HBJY_XFZX";
	
	public static final String ZFXX = "HBJY_ZFXX";
	*/
/**
	 * 日期和字符串之间的转换格式：年月日
	 *//*

	public static final String PATTERN_DATE = "yyyy-MM-dd";
	
	*/
/************************** 组织类型常量 START ****************************//*

	*/
/**局类型*//*

	public static final String JLX = "JLX"; 
	*/
/**局类型_局领导*//*

	public static final String JLX_JLD = "JLX_JLD"; 
	
	*/
/**局类型_分局*//*

	public static final String JLX_FJ = "JLX_FJ"; 
	
	*/
/**局类型_处室*//*

	public static final String JLX_CS = "JLX_CS"; 
	
	*/
/**局类型_监狱*//*

	public static final String FJLX_JY = "FJLX_JY"; 
	
	*/
/**分局类型*//*

	public static final String FJLX = "FJLX";
	
	*/
/**分局处室类型*//*

	public static final String FJLX_CS = "FJLX_CS";
	
	*/
/**分局处室类型*//*

	public static final String FJLX_LD = "FJLX_LD";
	
	*/
/**监狱类型*//*

	public static final String JYLX = "JYLX";
	
	*/
/**监狱领导类型*//*

	public static final String JYLX_JYLD = "JYLX_JYLD";
	
	*/
/**监狱科室类型*//*

	public static final String JYLX_JYKS = "JYLX_JYKS";
	
	*/
/**监狱类型_监区*//*

	public static final String JYLX_JQ = "JYLX_JQ";
	
	*/
/**监狱类型_分监区*//*

	public static final String JYLX_FJQ = "JYLX_FJQ";
	
	
	*/
/*************************** 组织类型常量 END *******************************//*

	
	*/
/*************************** 用户级别-查询权限常量 START *******************************//*

	*/
/**局级别-查所有*//*

	public static final String CSY = "CSY";
	
	*/
/**分局局级别-查所有*//*

	public static final String CFJ = "CFJ";
	
	*/
/**监狱、科级别-查本单位*//*

	public static final String CBDW = "CBDW";
	
	*/
/**监区，分监区级别-查所属本部门*//*

	public static final String CSSBBM = "CSSBBM";
	
	*/
/**分监区级别-仅查本部门（此处分监区级别，查询权限并不需要依据此级别判断，预留给流程审批判断流转节点使用）*//*

	public static final String CBBM = "CBBM";
	
	*/
/**分局级别-仅查本局*//*

	public static final String CBBJ = "CBBJ";
	
	*/
/************************** 用户级别-查询权限常量 END *******************************//*

	

	*/
/************************** 编码 START *******************************//*

	
	*/
/** 籍贯 *//*
public static final String GROUP_KEY_JG="4.2.2";
	
	*/
/** 国籍籍贯 *//*
public static final String GROUP_KEY_GJJG="4.2.0";
	*/
/** 世界各国和地区名称代码 *//*
public static final String GROUP_KEY_GJDQ="4.2.1";
	*/
/** 中华人民共和国行政区划代码 *//*
public static final String GROUP_KEY_XZQH="4.2.0";
	*/
/** 人的性别代码 *//*
public static final String GROUP_KEY_RDXB="4.2.3";
	*/
/** 婚姻状况代码 *//*
public static final String GROUP_KEY_HYZK="4.2.4";
	*/
/** 政治面貌 *//*
public static final String GROUP_KEY_ZZMM="4.2.8";
	*/
/** 健康状况代码 *//*
public static final String GROUP_KEY_JKZT="4.2.5";
	*/
/** 中国各民族名称罗马字母拼写法和代码 *//*
public static final String GROUP_KEY_ZGGMZMCLMZMPXF="4.2.6";
	*/
/** 文化程度代码 *//*
public static final String GROUP_KEY_WHCD="4.2.7";
	*/
/** 专业技术职务代码 *//*
public static final String GROUP_KEY_ZYJSZW="4.2.9";
	*/
/** 从业状况（个人身份）代码 *//*
public static final String GROUP_KEY_CYZKDM="4.2.17";
	*/
/** 户口类型代码 *//*
public static final String GROUP_KEY_HKLX="4.2.10";
	*/
/** 体貌特征分类代码 *//*
public static final String GROUP_KEY_TMTZ="4.2.19";
	*/
/** 通缉级别代码 *//*
public static final String GROUP_KEY_TJJBDM="4.2.12";
	*/
/** 血型代码 *//*
public static final String GROUP_KEY_XX="4.2.14";
	*/
/** 语种名称代码 *//*
public static final String GROUP_KEY_YZMC="4.2.15";
	*/
/** 宗教信仰代码 *//*
public static final String GROUP_KEY_ZJXY="4.2.16";
	*/
/** 国民经济行业分类 *//*
public static final String GROUP_KEY_GMJJXYFL="4.2.13";
	*/
/** 单位隶属关系代码 *//*
public static final String GROUP_KEY_DWLSGXDM="6.1.1";
	*/
/** 学科分类与代码 *//*
public static final String GROUP_KEY_XKFLYDM="6.1.2";
	*/
/** 个人关系代码表 *//*
public static final String GROUP_KEY_GX="10.1.13";
	*/
/** 刑法罪名分类代码 *//*
public static final String GROUP_KEY_ZMFL="4.3.1";
	*/
/** 刑罚变动分类代码 *//*
public static final String GROUP_KEY_XFBDFL="4.4.17";
	*/
/** 判决类别代码 *//*
public static final String GROUP_KEY_PJLB="6.1.3";
	*/
/** 罪犯其它称呼类别代码 *//*
public static final String GROUP_KEY_ZFQTCHLB="4.4.2";
	*/
/** 职业分类代码 *//*
public static final String GROUP_KEY_ZYFL="6.1.4";
	*/
/** 干部职务代码 *//*
public static final String GROUP_KEY_ZW="10.1.5";
	*/
/** 职级代码 *//*
public static final String GROUP_KEY_ZWF="10.1.11";
	*/
/** 证件类型代码 *//*
public static final String GROUP_KEY_SFZMMC="4.2.11";
	*/
/** 共同犯罪参与类型代码 *//*
public static final String GROUP_KEY_GTZFCYLX="4.4.3";
	*/
/** 媒体内容分类代码 *//*
public static final String GROUP_KEY_MTNRFL="4.4.6";
	*/
/** 入境方式代码 *//*
public static final String GROUP_KEY_RJFS="4.4.51";
	*/
/** 非法组织分类代码 *//*
public static final String GROUP_KEY_FFZZFLDM="4.4.24";
	*/
/** 在非法组织中的作用代码 *//*
public static final String GROUP_KEY_ZFFZZZDZYDM="4.4.25";
	*/
/** 刑事处罚类别代码 *//*
public static final String GROUP_KEY_QKLB="4.4.10";
	*/
/** 治安处罚类别代码 *//*
public static final String GROUP_KEY_ZACFLBDM="4.4.11";
	*/
/** 捕前技能/特长代码 *//*
public static final String GROUP_KEY_JNBM="10.1.10";
	*/
/** 收押类别代码 *//*
public static final String GROUP_KEY_SYLBDM="4.4.13";
	*/
/** 罪犯在册/离监代码 *//*
public static final String GROUP_KEY_ZFZCLJDM="6.1.44";
	*/
/** 释放类别代码 *//*
public static final String GROUP_KEY_SFLBDM="4.8.1";
	*/
/** 特别关注分类代码 *//*
public static final String GROUP_KEY_TBGZXXFL="4.4.12";
	*/
/** 案犯类别代码 *//*
public static final String GROUP_KEY_AFLB="4.4.18";
	*/
/** 分押类型代码 *//*
public static final String GROUP_KEY_FYLX="4.4.23";
	*/
/** 分管等级代码 *//*
public static final String GROUP_KEY_ZFFGDJ="4.4.16";
	*/
/** 未成年犯家庭状况代码 *//*
public static final String GROUP_KEY_WCNFJTZK="6.1.5";
	*/
/** 顽危及重点罪犯分类代码 *//*
public static final String GROUP_KEY_WWJZDZFFLDM="4.4.20";
	*/
/** 顽危及重点罪犯重控性质分类代码 *//*
public static final String GROUP_KEY_WWJZDZFZKXZFLDM="10.5.55";
	*/
/** 狱政奖励代码 *//*
public static final String GROUP_KEY_YZJL="4.4.21";
	*/
/** 狱政奖励是否用于减刑分类代码 *//*
public static final String GROUP_KEY_YZJLSFYYJXFL="6.1.6";
	*/
/** 狱政惩处代码 *//*
public static final String GROUP_KEY_YZCC="4.4.22";
	*/
/** 亲情电话监听情况分类代码 *//*
public static final String GROUP_KEY_QQDHJTQKFL="6.1.45";
	*/
/** 离监探亲及特许离监类别代码 *//*
public static final String GROUP_KEY_LJTQJTXLJLB="6.1.7";
	*/
/** 离监探亲及特许离监归监类别代码 *//*
public static final String GROUP_KEY_LJTQJTXLJGJLB="6.1.8";
	*/
/** 会见类别代码 *//*
public static final String GROUP_KEY_HJLB="6.1.9";
	*/
/** 会见方式代码 *//*
public static final String GROUP_KEY_HJFS="6.1.10";
	*/
/** 会见情况分类代码 *//*
public static final String GROUP_KEY_HJQKFL="6.1.11";
	*/
/** 解回再审终止类别代码 *//*
public static final String GROUP_KEY_JHZSZZLBDM="6.1.12";
	*/
/** 邮件收发类别代码 *//*
public static final String GROUP_KEY_YJSFFL="6.1.13";
	*/
/** 检举类别代码 *//*
public static final String GROUP_KEY_JJLBDM="6.1.14";
	*/
/** 执行机关所属省份或部门分类代码 *//*
public static final String GROUP_KEY_ZXJGSSSFHBMFL="4.4.50";
	*/
/** 执行机关类别代码 *//*
public static final String GROUP_KEY_ZXJGLB="4.4.52";
	*/
/** 在押状态代码 *//*
public static final String GROUP_KEY_ZYZT="6.1.43";
	*/
/** 减刑尺度代码 *//*
public static final String GROUP_KEY_JXCDDM="6.1.15";
	*/
/** 暂予监外执行类别代码 *//*
public static final String GROUP_KEY_ZYJWZXLB="4.4.26";
	*/
/** 暂予监外执行终止类别代码 *//*
public static final String GROUP_KEY_ZYJWZXZZLBDM="4.4.27";
	*/
/** 限制减刑原因代码 *//*
public static final String GROUP_KEY_XZJXYYDM="6.1.42";
	*/
/** 认罪服判类别代码 *//*
public static final String GROUP_KEY_RZFPLB="6.1.16";
	*/
/** 个别教育谈话类别代码 *//*
public static final String GROUP_KEY_GBJYTH="6.1.17";
	*/
/** 基础教育等级代码 *//*
public static final String GROUP_KEY_JCJYDJ="4.4.34";
	*/
/** 学历教育类别代码 *//*
public static final String GROUP_KEY_XLJYLB="4.4.35";
	*/
/** 职业技能教育等级代码 *//*
public static final String GROUP_KEY_ZYJNJYDJ="4.4.36";
	*/
/** 狱内体检类别代码 *//*
public static final String GROUP_KEY_YNTJLB="4.4.28";
	*/
/** 狱内体检结果分类代码 *//*
public static final String GROUP_KEY_YNTJJGFL="4.4.29";
	*/
/** 就诊住院分类代码 *//*
public static final String GROUP_KEY_JZZYFL="11.2.4";
	*/
/** 疾病治疗结果分类代码 *//*
public static final String GROUP_KEY_JBZLJGFL="6.1.18";
	*/
/** 疾病类别代码 *//*
public static final String GROUP_KEY_JBLB="4.4.30";
	*/
/** 病犯撤销类别代码 *//*
public static final String GROUP_KEY_BFCXLB="4.4.31";
	*/
/** 残疾类别代码 *//*
public static final String GROUP_KEY_CJLB="4.4.32";
	*/
/** 致残原因分类代码 *//*
public static final String GROUP_KEY_ZCYYFL="4.4.33";
	*/
/** 狱内因工伤残等级代码 *//*
public static final String GROUP_KEY_YNYGSCDJDM="4.4.40";
	*/
/** 囚被服类别代码 *//*
public static final String GROUP_KEY_QBFLBDM="6.1.19";
	*/
/** 囚被服发放类别 *//*
public static final String GROUP_KEY_QBFFFLB="6.1.20";
	*/
/** 就诊科室 *//*
public static final String GROUP_KEY_JZKS="6.1.21";
	*/
/** 劳动能力状况代码 *//*
public static final String GROUP_KEY_LDNLZK="4.4.7";
	*/
/** 劳动岗位类别代码 *//*
public static final String GROUP_KEY_NDGWLB="4.4.38";
	*/
/** 劳动技术等级代码 *//*
public static final String GROUP_KEY_NDJSDJ="4.4.39";
	*/
/** 工种代码 *//*
public static final String GROUP_KEY_GZBM="4.4.37";
	*/
/** 劳动定额完成情况代码 *//*
public static final String GROUP_KEY_LDDEWCQKDM="6.1.22";
	*/
/** 违纪违规处理情况 *//*
public static final String GROUP_KEY_WJWGCLQK="6.1.23";
	*/
/** 岗位技能培训类型代码 *//*
public static final String GROUP_KEY_GWJNPXLXDM="6.1.24";
	*/
/** 培训成绩代码 *//*
public static final String GROUP_KEY_PXCJDM="6.1.25";
	*/
/** 安全生产培训类型代码 *//*
public static final String GROUP_KEY_AQSCPXLXDM="6.1.26";
	*/
/** QC类型代码 *//*
public static final String GROUP_KEY_QCLXDM="6.1.27";
	*/
/** 获奖情况代码 *//*
public static final String GROUP_KEY_HJQKDM="6.1.28";
	*/
/** 发明创造类型代码 *//*
public static final String GROUP_KEY_FMCZLXDM="6.1.29";
	*/
/** 就业指导类型代码 *//*
public static final String GROUP_KEY_JYZDLXDM="6.1.30";
	*/
/** 隐患类型代码 *//*
public static final String GROUP_KEY_YHLXDM="6.1.31";
	*/
/** 整改情况代码 *//*
public static final String GROUP_KEY_ZGQKDM="6.1.32";
	*/
/** 安全员岗位类型代码 *//*
public static final String GROUP_KEY_AQYGWLX="6.1.33";
	*/
/** 劳动防护用品分类代码 *//*
public static final String GROUP_KEY_LDFHYPFL="6.1.34";
	*/
/** 监狱代码 *//*
public static final String GROUP_KEY_JYBM="4.5.1";
	*/
/** 监狱戒备等级代码 *//*
public static final String GROUP_KEY_JYJBDJDM="4.5.2";
	*/
/** 监狱关押类型代码 *//*
public static final String GROUP_KEY_JYGYLXDM="4.5.3";
	*/
/** 监狱单位隶属级别代码 *//*
public static final String GROUP_KEY_JYDWLSJBDM="4.5.4";
	*/
/** 是否 *//*
public static final String GROUP_KEY_SF="10.5.17";
	*/
/** 信息收发类型 *//*
public static final String GROUP_KEY_XXSFLX="6.1.36";
	*/
/** 信息审核状态 *//*
public static final String GROUP_KEY_XXSHZT="6.1.37";
	*/
/** 资源类型 *//*
public static final String GROUP_KEY_ZYLX="6.1.38";
	*/
/** 模块类型 *//*
public static final String GROUP_KEY_MKLX="6.1.39";
	*/
/** 教育类型 *//*
public static final String GROUP_KEY_JYLB="6.1.40";
	*/
/** 入监教育表现 *//*
public static final String GROUP_KEY_RJJYBX="6.1.41";
	*/
/** 有无 *//*
public static final String GROUP_KEY_YW="6.1.35";
	*/
/** 关押方式 *//*
public static final String GROUP_KEY_GYFS="7.1.1";
	*/
/** 不予收监类别 *//*
public static final String GROUP_KEY_BYSJLB="7.1.2";
	*/
/** 重控级别 *//*
public static final String GROUP_KEY_ZKJB="7.1.3";
	*/
/** 脱逃方式 *//*
public static final String GROUP_KEY_TTFS="7.1.4";
	*/
/** 捕回方式 *//*
public static final String GROUP_KEY_BHFS="7.1.5";
	*/
/** 密级 *//*
public static final String GROUP_KEY_MJ="7.1.6";
	*/
/** 申诉类别 *//*
public static final String GROUP_KEY_SSLB="7.1.7";
	*/
/** 属实程度 *//*
public static final String GROUP_KEY_SSCD="7.1.8";
	*/
/** 病残程度 *//*
public static final String GROUP_KEY_BCCD="7.1.9";
	*/
/** 新案件来源 *//*
public static final String GROUP_KEY_XAJLY="7.1.10";
	*/
/** 减刑类型 *//*
public static final String GROUP_KEY_JXLX="7.1.11";
	*/
/** 假释类型 *//*
public static final String GROUP_KEY_JSLX="7.1.12";
	*/
/** 报请理由 *//*
public static final String GROUP_KEY_BQLY="7.1.13";
	*/
/** 从严情况 *//*
public static final String GROUP_KEY_CYQK="7.1.14";
	*/
/** 从宽情况 *//*
public static final String GROUP_KEY_CKQK="7.1.15";
	*/
/** 流窜类型 *//*
public static final String GROUP_KEY_LCLX="7.1.16";
	*/
/** 上（抗）诉类型 *//*
public static final String GROUP_KEY_SSLX="7.1.17";
	*/
/** 悔改表现 *//*
public static final String GROUP_KEY_HGBX="7.1.18";
	*/
/** 立功表现 *//*
public static final String GROUP_KEY_LGBX="7.1.19";
	*/
/** 重大立功表现 *//*
public static final String GROUP_KEY_ZDLGBX="7.1.20";
	*/
/** 立案审查意见 *//*
public static final String GROUP_KEY_LASCYJ="7.1.21";
	*/
/** 结案方式 *//*
public static final String GROUP_KEY_JAFS="7.1.22";
	*/
/** 录入状态*//*
public static final String GROUP_KEY_LRZT="7.1.23";
	*/
/** 季数*//*
public static final String GROUP_KEY_JIDU="10.1.14";
	*/
/** 行政级别*//*
public static final String GROUP_KEY_XZJB="10.1.15";
	*/
/** 职务级别*//*
public static final String GROUP_KEY_ZWJB="10.1.16";
	*/
/** 入监状态*//*
public static final String GROUP_KEY_RJZT="10.6.2";
	*/
/** 耳目类型*//*
public static final String GROUP_KEY_EMLX="11.1.1";
	*/
/** 适用事项大概*//*
public static final String GROUP_KEY_SYSXDG="11.1.2";
	*/
/** 看守所编码*//*
public static final String GROUP_KEY_KSSBM="7.1.31";
	*/
/** 判裁法院*//*
public static final String GROUP_KEY_PCFY="7.1.29";
	*/
/** 是否同意*//*
public static final String GROUP_KEY_SFTY="10.5.16";
	*/
/** 物品类型*//*
public static final String GROUP_KEY_WPLX="10.5.18";
	*/
/** 物品处理方式*//*
public static final String GROUP_KEY_WPCLFS="10.5.19";
	*/
/** 材料归档状态*//*
public static final String GROUP_KEY_CLGDZT="10.5.20";
	*/
/**办理紧急程度*//*
public static final String GROUP_KEY_BLJJCD="10.5.23";
	*/
/**办理单位*//*
public static final String GROUP_KEY_BLDW="10.5.24";
	*/
/**暂外状态*//*
public static final String GROUP_KEY_ZWZT="10.5.25";
	*/
/**文书送达状态*//*
public static final String GROUP_KEY_WSSDZT="10.5.27";
	
	*/
/** 释放类别*//*
public static final String GROUP_KEY_SFLB="11.2.5";
	*/
/** 释放状态*//*
public static final String GROUP_KEY_SFZT="11.2.6";
	*/
/** 使用状态*//*
public static final String GROUP_KEY_SYZT="100.4.2";
	
	*/
/** 所属案卷*//*
public static final String GROUP_KEY_SSAJ="10.5.22";
	*/
/** 材料类型*//*
public static final String GROUP_KEY_CLLX="10.5.21";
	
	*/
/** 刑种编码*//*
public static final String GROUP_KEY_XZBM="7.1.25";
	*/
/** 逮捕机关称谓*//*
public static final String GROUP_KEY_DBJGCW="7.1.30";

	*/
/** 减刑假释控制方式*//*
public static final String GROUP_KEY_JXJS_KZFS="100.4.3";
	*/
/** 减刑假释会议记录类别*//*
public static final String GROUP_KEY_JXJSCB_HYJLLB="100.5.4";
	

	*/
/************************** 编码 END *******************************//*

	
	*/
/************************** 系统管理平台 表常量   START *******************************//*

	*/
/**
	 * 用户角色表
	 *//*

	public static String USER_ROLE_TABLE_NAME = "USER_ROLE";
	*/
/**
	 * 角色资源表
	 *//*

	public static String ROLE_RESOURCE_TABLE_NAME = "ROLE_RESOURCE";
	*/
/**
	 * 资源表
	 *//*

	public static String RESOURCE_TABLE_NAME = "T_RESOURCE";
	*/
/**
	 * 角色表
	 *//*

	public static String ROLE_TABLE_NAME = "ROLE";
	*/
/**
	 * 用户表
	 *//*

	public static String USER_TABLE_NAME = "T_USER";
	*/
/**
	 * 组织表
	 *//*

	public static String ORG_TABLE_NAME = "ORGANIZATION";
	*/
/**
	 * 用户组织表
	 *//*

	public static String ORG_USER_TABLE_NAME = "T_USER_ORGANIZATION";
	*/
/**
	 * 组织类型表
	 *//*

	public static String ORG_TYPE_TABLE_NAME = "ORGANIZATION_TYPE";
	*/
/**
	 * 组织-组织类型关系表
	 *//*

	public static String ORG_ORG_TYPE_TABLE_NAME = "ORG_ORGTYPE";
	
	*/
/************************** 系统管理平台 表常量   END *******************************//*

	
	*/
/************************** PDF模板相关常量配置 START ****************************//*

	*/
/**PDF模板路径*//*

	public static final String PDF_MB_URL =	"D:\\pdfmb\\";
	*/
/**PDF文件路径*//*

	public static final String PDF_WJ_URL = JxjsUtil.filepdf;
	
	*/
/**生成pdf所需的字体*//*

	public static final String FONT = "C:\\Windows\\Fonts\\simsun.ttc";
	public static final String FONT1 = "C:\\Windows\\Fonts\\fangsong_GB2312.ttf";
	public static final String FONT2 = "C:\\Windows\\Fonts\\FZXBSJW.TTF";
	public static final String FONT3 = "C:\\Windows\\Fonts\\simfang.ttf";
	*/
/**PDF模板名称_减刑假释呈报审批表*//*

	
	*/
/**审批表1*//*

	public static final String PDF_JXJSCB_SP = "JXJSCBSPB";
	*/
/**审批表1*//*

	public static final String PDF_JXJSCB_SP_YQ = "jxjscbspbyq.html";//有期
	public static final String PDF_JXJSCB_SP_WQ = "jxjscbspbwq.html";//无期
	public static final String PDF_JXJSCB_SP_JS = "jxjscbspbjs.html";//假释
	*/
/**有期徒刑评议表*//*

	public static final String PDF_JXJSCB_PY1 = "YQTXPYS";
	*/
/**无期死缓评议表*//*

	public static final String PDF_JXJSCB_PY2 = "WQSHPYS";
	*/
/**减刑假释呈报建议书*//*

	public static final String PDF_JXJSCB_JYS = "JXJSCBJYS";
	*/
/**减刑假释承报减刑建议书模板*//*

	public static final String PDF_JXJSCB_JYS1 = "JXJSCBJXJYS";
	*/
/**减刑假释承报假释建议书模板*//*

	public static final String PDF_JXJSCB_JYS2 = "JXJSCBJSJYS";
	
	*/
/**重要罪犯刑罚执行变更审批表*//*

	public static final String PDF_JXJSCB_ZYZFXFZXBGSPB = "ZYZFXFZXBGSPB";
	*/
/**涉金融类罪犯刑罚执行变更审批表*//*

	public static final String PDF_JXJSCB_SJRZFXFZXBGSPB = "SJRZFXFZXBGSPB";
	*/
/**涉黑罪犯刑罚执行变更审批表*//*

	public static final String PDF_JXJSCB_SHFXFZXBGSPB = "SHFXFZXBGSPB";
	*/
/**涉职务犯罪罪犯刑罚执行变更审批表*//*

	public static final String PDF_JXJSCB_SZWZFXFZXBGSPB = "SZWZFXFZXBGSPB";
	*/
/**罪犯再犯罪危险评估要素采集表（试行）*//*

	public static final String PDF_JXJSCB_ZFZFZWXPGYSCJB = "ZFZFZWXPGYSCJB";
	
	*/
/**减刑假释承报减刑评议表-有期和假释 模板*//*

	public static final String PDF_JXJSCBPYB1= "jxjspyb1_yq.html";
	*/
/**减刑假释承报减刑评议表-无期死缓   模板*//*

	public static final String PDF_JXJSCBPYB2= "jxjspyb2_wq.html";
	*/
/**减刑假释承报减刑建议书模板*//*

	public static final String PDF_JXJSCBJYS= "jxjsjys.html";
	*/
/**减刑假释承报减刑重点犯模板*//*

	public static final String PDF_JXJSCBZDF= "jxjszdf.ftl";
	*/
/**减刑假释承报减刑建议书生成wps模板*//*

	public static final String WPS_JXJSJYS= "jxjsjys.ftl";
	
	
	*/
/**************************PDF模板名称_暂外文书*******************************//*

	*/
/**拟暂予监外执行罪犯调查评估委托函模板*//*

	public static final String PDF_TQZYJWZXSQ_DCPGWTH = "NZYJWZXZFDCPGWTHMB";
	*/
/**罪犯生活不能自理鉴别书模板*//*

	public static final String PDF_TQZYJWZXSQ_SHBNZLJBS = "ZFSHBNZLJBSMB";
	*/
/**罪犯妊娠检查书模板*//*

	public static final String PDF_TQZYJWZXSQ_ZFRSJCS = "ZFRSJCSMB";
	*/
/**罪犯病情诊断书模板*//*

	public static final String PDF_TQZYJWZXSQ_ZFBQZDS = "ZFBQZDSMB";
	*/
/**提请暂予监外执行罪犯情况公示模板*//*

	public static final String PDF_TQZYJWZXSQ_ZFQKGS = "TQZYJWZXZFQKGSMB";
	*/
/**暂予监外执行决定书模板*//*

	public static final String PDF_TQZYJWZXSQ_JDS = "ZYJWZXJDSMB";
	*/
/**暂予监外执行病情评估意见书模板*//*

	public static final String PDF_TQZYJWZXSQ_BQPGYJS = "ZYJWZXBQPGYJSMB";
	*/
/**提请暂予监外执行意见书模板*//*

	public static final String PDF_TQZYJWZXSQ_TQZXYJS = "TQZYJWZXYJSMB";
	*/
/**暂予监外执行保证书模板*//*

	public static final String PDF_TQZYJWZXSQ_ZYZXBZS = "ZYJWZXBZSMB";
	*/
/**暂予监外执行审批表模板*//*

	public static final String PDF_TQZYJWZXSQ_ZYZXSPB = "ZYJWZXSPBMB";
	*/
/**暂予监外执行告知书模板*//*

	public static final String PDF_TQZYJWZXSQ_ZYZXGZS = "ZYJWZXGZSMB";
	*/
/**暂予监外执行罪犯移交证明书模板*//*

	public static final String PDF_TQZYJWZXSQ_ZYZXYJZMS = "ZYJWZXZFYJZMSMB";
	*/
/**罪犯档案转递函模板*//*

	public static final String PDF_TQZYJWZXSQ_ZFDAZDH = "ZFDAZDHMB";
	*/
/**罪犯暂予监外执行报告（司法部）模板*//*

	public static final String PDF_TQZYJWZXSQ_ZFBGSFB = "zfzyjwzxbgsfb.html";
	*/
/**罪犯暂予监外执行报告（省委政法委）模板*//*

	public static final String PDF_TQZYJWZXSQ_ZFBGSWZFW = "ZFZYJWZXBGSWZFWMB";
	*/
/**暂予监外执行期间不计入执行刑期建议书模板*//*

	public static final String PDF_TQZYJWZXSQ_ZYJWZXQJBJRZXXQJYS = "ZYJWZXQJBJRZXXQJYSMB";
	*/
/**不予批准暂予监外执行决定书模板*//*

	public static final String PDF_TQZYJWZXSQ_BYPZZWJDS = "BYPZZYJWZXJDSMB";
	
	*/
/**暂予监外情况公示书生成wps模板*//*

	public static final String WPS_TQZYJWQKGSS= "tqzyjwqkgss.ftl";
	
	
	
	*/
/************************** PDF模板相关常量配置 END *******************************//*

}
*/
