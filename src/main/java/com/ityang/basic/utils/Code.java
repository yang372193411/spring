package com.ityang.basic.utils;

/**
 * 返回编码信息
 * @author kecoo
 * @see: Code
 * @since: [相关类/方法]
 */
public enum Code {
	//数据服务异常定义前四位3160**
	/**自增计数出错*/
	DATASERVICE_INCY_ERROR("316001","自增计数出错,请联系管理员！"),
	/*******传入的服务密钥有误********/
	DATASERVICE_INCY_VALIDATE_SIGN("316002", "传入的服务密钥有误或服务已下架！"),
	
	//获取参数错误 前四位定义3100**
	/**获取请求参数为null*/
	SYS_REQUEST_NULL("310001","获取请求参数为null！"),
	/**传入的秘钥和访问url类型不匹配*/
	SYS_URL_SID("310002","传入的秘钥和访问url类型不匹配！"),
	/**构建数据源异常*/
	SYS_DATASOURCE_ERROR("310003","构建数据源异常！"),
	
	//权限校验定义前四位3110**
	/*******   没有权限访问其要访问的服务，需通过服务管理平台申请并通过审批后方能按照说明文档访问   ********/
	PERMISSION_VALIDATE_SERVICE("311020", "尚未有权限访问该服务，请申请通过后再试！"),
	/**返回数据页数必须大于零*/
	PERMISSION_RETURN_PAGENUM("311021","返回页数必须大于零！"),
	/*******   访问IP非法，请使用申请时填写的ip机器访问该服务     ********/
	PERMISSION_AUTHEN_IP("311022", "访问IP非法，请使用申请时填写的ip机器访问该服务"),
	/*******   当次访问记录数，超过每次访问上限   ********/
	PERMISSION_MAX_VISIT("311023", "访问次数超过每日访问上限"),
	/*******   当次访问记录数，超过每次访问下限 100 ********/
	PERMISSION_MIN_PAGESIZE("311024", "当次访问记录数，超过每次访问下限"),
	/*******   当次访问记录数，超过每次访问上限     ********/
	PERMISSION_MAX_PAGESIZE("311025", "当次访问记录数，超过每次访问上限"),
	/******* 超过Es返回数据上限！  ********/
	PERMISSION_MAX_ESSIZE("311026", "超过Es返回数据上限！"),
	
	/******* 超过Es返回数据上限！  ********/
	
	PERMISSION_SERVICE_NOT_FIND("311027","找不到要调用的服务！"),
	
	PERMISSION_SERVICE_RE_APPLY("311028","该接口已重新发布，需要重新申请！"),
	//接入方登陆异常定义前四位 3120**
	/*******   该情况是登录认证时，发生未知异常导致的，可先检查是否按规范进行认证或者联系相关系统管理员    ********/
	LOGIN_ERROR("312001", "访问认证异常，请稍后再试！"),
	/*******   该情况是登录认证时，token失效或者过期不存在    ********/
	TOKEN_FAILURE("312002", "访问认证异常，该token已被使用或者该token已过期，失效！"),
	/*******   该情况是登录认证时，token失效或者过期不存在    ********/
	TOKEN_APPPID("312003", "访问认证异常，该token与接入方Pid不匹配！"),
	/*******接入方没有此服务的访问权限！ ********/
	APP_SERVICE_NO_BIND("312005", "该接入方没有此服务的访问权限！"),
	
	APP_SERVICE_IS_OFFLINE("312006", "该资源服务已经下线，不可访问！"),
	
	/*******   数据转码出错    ********/
	TRANSCODING_ERROR("312004", "数据转码出错！"),


	/*******   访问异常，这时候是报出未知异常的时候，需根据异常日志分析    ********/
	ERROR("311000", "访问异常，请稍后再试！"),
	/*******   访问成功    ********/
	SECCESS("999999", "访问成功！"),

	
	/*******   该情况是未通过登录认证，认证不通过或访问未带访问权限token导致的    ********/
	LOGIN_UNPASS("311003", "未能通过访问认证，请按规范进行认证！"),
	
	/*******   统一参数校验位通过，是由于相关访问参数没有按要求输入，请参照对应服务访问说明   ********/
	VALIDATE_PARM("311006", "传入参数校验失败，请参照服务访问说明！"),
	/**构建数据源异常*/
	VALIDATE_ES_INDEX_PARM("311002","您访问的es的index已经不存在，请联系管理员！"),
	VALIDATE_ES_PARTITION_PARM("311019","您访问的es的alias已经不存在，请联系管理员！"),
	
	/*******  SOLR 配置  411***   **********/
	VALIDATE_SOLR_INDEX_PARM("411000","您访问的solr的collection不存在，请联系管理员！"),
	
	
	/*******   数据源异常，暂时无法访问   ********/
	DATABASE_ERROR("311011", "数据源异常，暂时无法访问！"),
	/*******  全国人口库调用异常，暂时无法访问   ********/
	QRKQ_ERROR("311012", "全国人口库调用异常，暂时无法访问！"),
	/*******  全国人口库返回数据为空  ********/
	QGRKXX_ERROR("100007", "全国人口库返回数据异常！"),
	/******* 初始化Redis信息异常  ********/
	INIT_REDIS_ERROR("311013", "初始化Redis信息异常！"),
	/******* 返回的字段配置异常，请按规范访问！  ********/
	FIELD_ERROR("311014", "返回的字段配置异常，请按规范访问！"),
	FIELD_BLANK("311016", "没有设置可返回的字段！"),
	/******* 查询数据异常！  ********/
	QUERYDATA_ERROR("311015", "查询数据异常！"),
	/*******获取数据服务的数据库信息异常********/
	VALIDATE_DATABASEINFO("311018", "无法获取数据库链接信息，请联系管理员！"),
	/****深圳市公安局行政代码****/
	SZGAJ_CODE("440300", "市局"),
	/**应用服务鉴权通过*/
	APP_STATUS_SUCCESS("0", "应用服务鉴权通过"),
	/**应用服务传参校验失败*/
	APP_STATUS_ILLEGAL("1", "应用服务传参校验不通过"),
	APP_STATUS_DENIED("2", "应用服务鉴权不通过"),
	
	TOKEN_NULL("313002", "访问认证异常，token参数不能为空！"),
	INTERFACE_STATUS_ILLEGAL("3", "接口服务传参校验不通过"),
	INTERFACE_STATUS_DENIED("4", "接口服务鉴权不通过");
	/**
	 * 编码
	 */
	private String code;

	/**
	 * 提示描述
	 */
	private String describe;

	/**
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return String
	 */
	public String getDescribe() {
		return describe;
	}

	Code(String code, String describe) {
		this.code = code;
		this.describe = describe;
	}
}
