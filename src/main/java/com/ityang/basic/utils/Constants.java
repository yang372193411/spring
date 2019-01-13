package com.ityang.basic.utils;

/**
 * @author szx
 *
 */
/**
 * @author Administrator
 *
 */
public interface Constants {

	String BLANK = "";

	/**
	 */
	String TIMEFORMAT = "yyyy-MM-dd HH:mm:ss";
	/** 鉴权使用的静态常量 */
	String VISI_SERVICE_DATAVIEW = "VISI_SERVICE_DATAVIEW";
	String IP = "IP";
	String DSID = "DSID";
	String DBPID = "DBPID";
	String DBNAME = "DBNAME";
	String APPIP = "APPIP";
	String APPPID = "APPPID";
	String USERPID = "USERPID";
	String DATANUM = "DATANUM";
	String FIELD = "FIELD";
	String CONFIG = "CONFIG";
	String TABLENAME = "TABLENAME";
	String SERVICEPID = "SERVICEPID";
	String REQUESTPORT = "REQUESTPORT";
	String SERVICECODE = "SERVICECODE";
	String SERVICESIGN = "SERVICESIGN";
	String VISITFREQUENCY = "VISITFREQUENCY";
	String RESTEXCEPTIONINFO = "RESTEXCEPTIONINFO";
	String RESTEXCEPTIONCODE = "RESTEXCEPTIONCODE";
	String CONDITION_VALUE = "CONDITION_VALUE";
	String FIELD_TYPE = "FIELD_TYPE";
	String FIELD_NAME = "FIELD_NAME";
	String JOINER = "JOINER";
	String DEPTCODE = "DEPTCODE";
	String STARTTIME = "STARTTIME";
	String CALLTIME = "CALLTIME";
	String ENDTIME = "ENDTIME";
	String PARAM = "PARAM";
	String RESOURCETABLETYPE = "RESOURCETABLETYPE";

	String REQUESTMODE = "REQUESTMODE";
	String REQUESTURL = "REQUESTURL";
	
	String ISONLINESIGN ="ISONLINESIGN";//在线的servicesign（资产下线过滤）

	/** ES分区表 */
	String RESOURCETABLETYPEVALUE = "25";
	String PARTITIONITEM = "PARTITIONITEM";
	String PARTITIONCYCLE = "PARTITIONCYCLE";
	String PARTITIONYEAR = "year";
	String PARTITIONMONTH = "month";
	String DATEFORMAT = "DATEFORMAT";
	String ROUTING_COLUMN = "ROUTING";
	/** 是否开启时间格式化：1=开启，0=关闭*/
	String DATEFORMAT_ON = "1";
	String DATEFORMAT_OFF = "0";

	/**
	 *  应用服务常量字段
	 */
	// 消费者传参的账户
	String ACCOUNT = "ACCOUNT";
	// 消费者传参的姓名
	String NAME = "NAME";
	// 根据消费码获取的接入方ID
	String CONSUMER_ID = "CONSUMER_ID";
	// 根据TOKEN获取的接入方ID
	String TOKEN_CONSUMER_ID = "TOKEN_CONSUMER_ID";
	// 消费者传入的消费码
	String CONSUMER_CODE = "CONSUMER_CODE";
	// 服务编码
	String SERVICE_ID = "SERVICE_ID";
	// 当天允许访问次数
	String ALLOW_VISIT = "ALLOW_VISIT";
	// 第几次访问
	String CUR_VISIT = "CUR_VISIT";

	/** 1是正常，0是异常，-1是错误 */
	String CALLSTATUS = "CALLSTATUS";
	String STACKINFO = "STACKINFO";
	String RESOURCECODE = "RESOURCECODE";
	String RELEASETIME = "RELEASETIME";
	String CONDITION_TYPE = "CONDITION_TYPE";
	/** 鉴权，打印日志  0.否，1.是 */
	String ISAUTHENTICATE = "ISAUTHENTICATE";
	String ISPRINTLOG = "ISPRINTLOG";
	/**
	 * 存放在redis上数据库类型字段名
	 */
	String DSTYPE = "dsType";
	String DBTYPE = "dbType";

	String[] DBKEYS = new String[] { DBPID, DBNAME, DSTYPE, TABLENAME, RESOURCETABLETYPE, PARTITIONITEM, PARTITIONCYCLE,
			DATEFORMAT };
	String[] PERMISSIONKEYS = new String[] { USERPID, DEPTCODE, RESOURCECODE, REQUESTPORT, SERVICEPID, APPPID,
			VISITFREQUENCY, DATANUM, SERVICECODE, RELEASETIME, ISPRINTLOG, ISAUTHENTICATE };

	/** 参数key静态变量 */
	String PID = "PID";
	String DEPTPID = "DEPTPID";
	String AVAILABLEDAPT = "AVAILABLEDAPT";
	String USERNAME = "USERNAME";
	String PASSWORD = "PASSWORD";
	String IPADDRESS = "IPADDRESS";
	String PORT = "PORT";
	String CONNDRIVER = "CONNDRIVER";
	String URL = "URL";
	String HDFSURL = "HDFSURL";
	String CLUSTERNAME = "CLUSTERNAME";
	String DSTYPECODE = "DSTYPECODE";
	String DBTYPECODE = "DBTYPECODE";
	String APPSECRETKEY = "APPSECRETKEY";

	/**
	 * 存放在redis上秘钥的字段名
	 */
	String REDISSECRETKEY = "redis_SecretKey";
	/**
	 * 存放在redis上authKey的字段名
	 */
	String REDISAUTHKEY = "redis_AuthKey";
	/**
	 * 存放在redis上主键key的前缀
	 */
	String PREKEY_OAUTH2FORAPP = "Oauth2ForApp#";

	/**
	 * 存放在redis上访问次数计数的字段名
	 */
	String AUTHTOKEN = "AUTHTOKEN";
	/*******************************************************************
	 * 数据源类型
	 ******************************************************************/

	/** 关系型数据库 */
	String DS_TYPE_RDBMS = "01";

	/** 键值数据库 */
	String DS_TYPE_KEYVLAUE = "02";

	/** 面向文档数据库 */
	String DS_TYPE_DOC = "03";

	/** 列存储数据库 */
	String DS_TYPE_COLUMN = "04";

	/** 图数据库 */
	String DS_TYPE_Graph = "05";

	/** 空间数据库 */
	String DS_TYPE_PGIS = "06";

	/** impala CDH5版本的类型 */
	String DB_TYPE_IMPALA_CDH5 = "Impala_CDH5";

	/**
	 * Es 数据库
	 */
	String DB_TYPE_ES = "Elasticsearch";

	/**
	 * solr 数据库
	 */
	String DB_TYPE_SOLR = "Solr";

	/**
	 * HBASE 数据库
	 */
	String DB_TYPE_HBASE = "Hbase";

	/** 全文数据库 */
	String DS_TYPE_INDEX = "07";

	/** 字段转码标记 */
	String ISDICVALUE = "_DICTVAL";

	public class conditionType {
		/**
		 * 参数条件 等于
		 */
		public static final String CONDITION_equal = "=";
		/**
		 * 参数条件 不等于
		 */
		public static final String CONDITION_no_equal = "!=";
		/**
		 * 参数条件 大于
		 */
		public static final String CONDITION_greater_than = ">";
		/**
		 * 参数条件 小于
		 */
		public static final String CONDITION_less_than = "<";
		/**
		 * 参数条件 大于等于
		 */
		public static final String CONDITION_equal_greater = ">=";
		/**
		 * 参数条件 小于等于
		 */
		public static final String CONDITION_equal_less = "<=";
		/**
		 * 参数条件 not like(不包含)
		 */
		public static final String CONDITION_not_like = "not like";
		/**
		 * 参数条件 不为null
		 */
		public static final String CONDITION_no_null = "is not null";
		/**
		 * 参数条件 为null
		 */
		public static final String CONDITION_is_null = "is null";
		/**
		 * 参数条件 like(包含)
		 */
		public static final String CONDITION_like = "like";
		/**
		 * 参数条件 llike(开头是)
		 */
		public static final String CONDITION_llike = "llike";
		/**
		 * 参数条件 rlike(结尾是)
		 */
		public static final String CONDITION_rlike = "rlike";
		/**
		 * 参数条件 长度
		 */
		public static final String CONDITION_length = "length";
		/**
		 * 参数条件 介于之间
		 */
		public static final String CONDITION_between = "between";
	}

	public class DataType {
		/**
		 * 数据类型 string
		 */
		public static final String data_type_string = "string";
		/**
		 * 数据类型 int
		 */
		public static final String data_type_int = "int";
		/**
		 * 数据类型 date
		 */
		public static final String data_type_date = "date";
		/**
		 * 数据类型 double
		 */
		public static final String data_type_double = "double";
	}

	/**
	 * 
	 * 数字常量
	 * @author edge
	 * @date 2017年1月3日 上午11:59:14
	 */
	public class NumberCons {
		public static final Integer ZERO = 0;
		public static final Integer ONE = 1;
		public static final Integer TWO = 2;
		public static final Integer THREE = 3;
		public static final Integer FOUR = 4;
		public static final Integer FIVE = 5;
		public static final Integer TEN = 10;
		public static final Integer TWENTY = 20;
		public static final Integer FIVE_HUNDRED = 500;
		public static final Integer ONE_THOUSAND = 1000;
		public static final Integer ONE_MILLION = 10000;
	}

	/**
	 * 
	 * 数字字符常量
	 * @author edge
	 * @date 2017年1月3日 上午11:59:14
	 */
	public class NumberConsStr {
		public static final String _ONE = "-1";
		public static final String ZERO = "0";
		public static final String ONE = "1";
		public static final String TWO = "2";
		public static final String THREE = "3";
		public static final String FOUR = "4";
		public static final String FIVE = "5";
		public static final String TEN = "10";
		public static final String TWENTY = "20";
		public static final String FORTY = "40";
		public static final String FIVE_HUNDRED = "500";
		public static final String ONE_THOUSAND = "1000";
	}

	/**
	 * es端口
	 * @author edge
	 * @see: EsPort
	 * @since: jdk 1.8
	 * @date 2017年1月4日 下午5:55:51
	 */
	public class EsPort {
		public static final Integer PORT = 9300;
	}

	public class EsFilterField {
		public static final String _create = "_create";
		public static final String _update = "_update";
		public static final String metadata = "metadata";
	}

	/**
	 * 应用服务redis中的key
	 * @author zucyfranks
	 *
	 */
	public class AppKey {
		public static final String APPTOKEN = "APPTOKEN";
		public static final String APPPID = "APPPID";
		public static final String APPSIGN = "APPSIGN";
		public static final String CONSUMERID = "CONSUMERID";
	}

	String[] APPPERMISSIONKEYS = new String[] { AppKey.APPSIGN, SERVICEPID, DEPTCODE, AppKey.CONSUMERID,
			VISITFREQUENCY };

	/**
	 * 接口服务redis中的key
	 * @author 
	 *
	 */
	public class InterfaceKey {
		public static final String INTERFACETOKEN = "INTERFACETOKEN";
		public static final String INTERFACEPID = "INTERFACEPID";
		public static final String INTERFACESIGN = "INTERFACESIGN";
		public static final String APPPID = "APPPID";
		public static final String AUDIT_STATUS = "auditStatus";
		public static final String REQUEST_MODE = "requestMode";
		public static final String REQUEST_URL = "requestUrl";
	}

	String[] INTERFACEPERMISSIONKEYS = new String[] { InterfaceKey.INTERFACESIGN, SERVICEPID, SERVICECODE, DEPTCODE,
			InterfaceKey.APPPID, VISITFREQUENCY, InterfaceKey.AUDIT_STATUS, InterfaceKey.REQUEST_MODE,
			InterfaceKey.REQUEST_URL };

	// 类型的后缀
	public static final String TYPE_SUFFIX = "_table";
}
