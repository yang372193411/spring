package com.ityang.basic.utils;

import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 * @author tangxr
 * @since  2014-6-28
 */
public class StringTool {
	
	/** 
     * 单位缩进字符串。 
     */  
    private static String SPACE = "   ";
    
	private static org.slf4j.Logger logger  = LoggerFactory.getLogger(StringTool.class);

	private final static Pattern wipeExtraSpacesRegex = Pattern.compile("\\s{2,}|\\t|\\n|\\r");
	
	/**YMD格式化方法*/
	private static SimpleDateFormat getYMDFormat(){
		return new SimpleDateFormat("yyyyMMdd");
	}
	
	/** 日期格式2 yyyy-MM-dd HH:mm:ss */
	private static SimpleDateFormat getYMDHMSFormat(){
		return new SimpleDateFormat(Constants.TIMEFORMAT);
	}
	/**
	 * 获取系统当前的时间 格式"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		return getYMDHMSFormat().format(new Date(System.currentTimeMillis()));
	}
	
	/**
	 * 获取系统当前日期 格式“yyyy-MM-dd”
	 * @return
	 */
	public static String getCurrentDate() {
		return getYMDFormat().format(new Date(System.currentTimeMillis()));
	}
	/**
	 * 去除多余的空格，即连续多空格处替换为一个空格,并且去除所有换行或回车或制表符，用空格替换
	 * @param str
	 * @return
	 * @author tangxr
	 * @since  2014-6-28
	 */
	public static String wipeExtraSpaces(String str){
		if(str == null || "".equals(str)){return null;}
		return wipeExtraSpacesRegex.matcher(str).replaceAll(Matcher.quoteReplacement(" "));
	}
	
	/**
	 * 字符串是否为null或空
	 * @param str
	 * @return
	 * @author tangxr
	 * @since  2014-7-2
	 */
	public static boolean isBlank(String str){
		return str == null || str.trim().equals("") || str.trim().equals(" ");
	}
	
	/**
	 * 字符串是否为非null且非空
	 * @param str
	 * @return
	 * @author tangxr
	 * @since  2014-7-2
	 */
	public static boolean isNotBlank(String str){
		
		return !isBlank(str);
	}
	
	

	
	/**
	 * 得到一个唯一的标示符
	 * @return
	 */
	 public synchronized static String getUUID() {  
	        return UUID.randomUUID().toString().replace("-", "");  
	 }  
	 
	 /**
	  * 得到一个唯一的标示符数组
	  * @param number
	  * @return
	  */
	 public static String[] getUUID(int number) {  
	        if (number < 1) {  
	            return null;  
	        }  
	        String[] uList = new String[number];  
	        for (int i = 0; i < number; i++) {  
	        	uList[i] = getUUID();  
	        }  
	        return uList;  
	    }   
	 
	 /**
	  * 去掉数组里为null的值
	  * @param
	  * @return
	  */
	 public static String[] removeNull(String[] str) {
		ArrayList<String> list = new ArrayList<String>();
		for(String s:str){
			if(s != null){
				list.add(s);
			}
		}
		 return list.toArray(new String[list.size()]);  
	    }   
	 
	 /**
	  * 得到一个唯一的标示符数组
	  * @param
	  * @return
	  */
	 public static Integer[] removeNull(Integer[] str) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 for(Integer s:str){
			 if(s != null){
				 list.add(s);
			 }
		 }
		 return list.toArray(new Integer[list.size()]);  
	 } 
	 
	 public static boolean isNot(Object obj){
		return null == obj;
	 }
	 
	 /**
	  * 得到一个唯一的标示符数组
	  * @param
	  * @return
	 * @throws ServiceException 
	  */
	 public static void isNotBlankArr(String... str) throws ServiceException {
		for(String temp : str){
			if(StringTool.isBlank(temp)){
				throw new ServiceException(Code.VALIDATE_PARM.getCode(),Code.VALIDATE_PARM.getDescribe());
			}
		}
	 } 
	 
	 /**
	  * 判断是否为空
	  * @param
	  * @return
	 * @throws ServiceException 
	  */
	 public static void isNotNullArr(Object... str) throws ServiceException {
		for(Object temp : str){
			if(StringTool.isNot(temp)){
				throw new ServiceException(Code.VALIDATE_PARM.getCode(),Code.VALIDATE_PARM.getDescribe());
			}
		}
	 }
	 /**
	  * 结果集取类型为String类型的值没有返回null
	  * @return
	 * @throws ServiceException 
	  */
	 public static String getResultValue(Object str) throws ServiceException {
		if (str != null&&str instanceof String) {
			return (String)str;
		}else{
			return null;
		}
	 }
	 /**
	  * 结果集取类型为String类型的值没有返回null
	  * @return
	 * @throws ServiceException 
	  */
	 public static String getResultValueToStr(Object str) throws ServiceException {
		if (str != null) {
			str = str.toString();
			return (String)str;
		}else{
			return null;
		}
	 }
	 /**
	  * 取堆栈信息的第一行
	  * @return
	 * @throws ServiceException 
	  */
	 public static String getServiceExceptionInfo(Throwable e) throws ServiceException {
		 StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			
			String replaceAll = sw.toString();
			if (replaceAll.contains("\n")) {
				replaceAll = replaceAll.substring(0, replaceAll.indexOf("\n"));
			}
			replaceAll = replaceAll.replaceAll("\n", "\\n").replaceAll("\"", "\\\\\"").replace("\r", "\\r").replace("\t", "\\t");
			return replaceAll;
	 }
	 
	 /** 
     * 返回格式化JSON字符串。 
     *  
     * @param json 未格式化的JSON字符串。 
     * @return 格式化的JSON字符串。 
     */  
    public static String formatJson(String json)  
    {  
        StringBuffer result = new StringBuffer();  
          
        int length = json.length();  
        int number = 0;  
        char key = 0;  
          
        //遍历输入字符串。  
        for (int i = 0; i < length; i++)  
        {  
            //1、获取当前字符。  
            key = json.charAt(i);  
              
            //2、如果当前字符是前方括号、前花括号做如下处理：  
            if((key == '[') || (key == '{') )  
            {  
                //（1）如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。  
                if((i - 1 > 0) && (json.charAt(i - 1) == ':'))  
                {  
                    result.append('\n');  
                    result.append(indent(number));  
                }  
                  
                //（2）打印：当前字符。  
                result.append(key);  
                  
                //（3）前方括号、前花括号，的后面必须换行。打印：换行。  
                result.append('\n');  
                  
                //（4）每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。  
                number++;  
                result.append(indent(number));  
                  
                //（5）进行下一次循环。  
                continue;  
            }  
              
            //3、如果当前字符是后方括号、后花括号做如下处理：  
            if((key == ']') || (key == '}') )  
            {  
                //（1）后方括号、后花括号，的前面必须换行。打印：换行。  
                result.append('\n');  
                  
                //（2）每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。  
                number--;  
                result.append(indent(number));  
                  
                //（3）打印：当前字符。  
                result.append(key);  
                  
                //（4）如果当前字符后面还有字符，并且字符不为“，”，打印：换行。  
                if(((i + 1) < length) && (json.charAt(i + 1) != ','))  
                {  
                    result.append('\n');  
                }  
                  
                //（5）继续下一次循环。  
                continue;  
            }  
              
            //4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。  
            if((key == ','))  
            {  
                result.append(key);  
                result.append('\n');  
                result.append(indent(number));  
                continue;  
            }  
              
            //5、打印：当前字符。  
            result.append(key);  
        }  
          
        return result.toString();  
    }
    
    /** 
     * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。 
     *  
     * @param number 缩进次数。 
     * @return 指定缩进次数的字符串。 
     */  
    private static String indent(int number)  
    {  
        StringBuffer result = new StringBuffer();  
        for(int i = 0; i < number; i++)  
        {  
            result.append(SPACE);  
        }  
        return result.toString();  
    }
}
