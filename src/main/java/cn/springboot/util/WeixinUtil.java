package cn.springboot.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;


import cn.springboot.domain.AccessToken;

/**
 * 公众平台通用接口工具类
 * 
 */
public class WeixinUtil {

	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?" + "grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?" + "access_token=ACCESS_TOKEN";
	public static String link_create_url = "https://api.weixin.qq.com/cgi-bin/shorturl?" + "access_token=ACCESS_TOKEN";
	
	private static Logger logger = LoggerFactory.getLogger(WeixinUtil.class);  

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl  请求地址
	 * @param requestMethod  请求方式（GET、POST）
	 * @param outputStr  提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 * @throws IOException 
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr)   {
		HttpsURLConnection httpUrlConn = null;
		OutputStream outputStream = null ;
		InputStream inputStream = null;
		
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new MyX509TrustManager() };
		try{
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();

		URL url = new URL(requestUrl);
		 httpUrlConn = (HttpsURLConnection) url.openConnection();
		httpUrlConn.setSSLSocketFactory(ssf);
		httpUrlConn.setDoOutput(true);
		httpUrlConn.setDoInput(true);
		httpUrlConn.setUseCaches(false);
		// 设置请求方式（GET/POST）
		httpUrlConn.setRequestMethod(requestMethod);

			httpUrlConn.connect();

		// 当有数据需要提交时
		if (null != outputStr) {
			 outputStream = httpUrlConn.getOutputStream();
			// 注意编码格式，防止中文乱码
			outputStream.write(outputStr.getBytes("UTF-8"));
			outputStream.close();
		}

		// 将返回的输入流转换成字符串
		 inputStream = httpUrlConn.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str);
		}
		bufferedReader.close();
		inputStreamReader.close();
		jsonObject = JSONObject.fromObject(buffer.toString());
		}catch(Exception e){
			logger.error("网络请求错误  class-httpRequest-error={}",e);
			e.printStackTrace();
		}finally{
			// 释放资源
			try {
				if(inputStream != null){
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			inputStream = null;
			if (httpUrlConn != null ){
				httpUrlConn.disconnect();
			}
		}
		return jsonObject;
	}
public static String Long2Short(String longurl, String token){
		
		String sUrl ="https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
		try {
			sUrl = sUrl.replace("ACCESS_TOKEN", token);
			String param = "{\"action\":\"long2short\","
					+ "\"long_url\":\""+longurl+"\"}";
			JSONObject jsonObject = httpRequest(sUrl, "POST", param);
			System.err.println("jsonObject:"+jsonObject);
			boolean containsValue = jsonObject.containsKey("errcode");
			if(containsValue){
				String errcode = jsonObject.getString("errcode");
				String short_url = jsonObject.getString("short_url");
				System.err.println("errcode"+errcode);
				return short_url;
			}else{
				String errcode = jsonObject.getString("errcode");
				return errcode;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 * @throws Exception 
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) throws Exception {
		AccessToken accessToken = null;
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		System.out.println(jsonObject);
		// 如果请求成功
		if (null != jsonObject) {
			accessToken = new AccessToken();
			accessToken.setToken(jsonObject.getString("access_token"));
			accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return accessToken;
	}
	/**
	 * 长链接转短链接
	 * @param accessToken
	 * @param long_url
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> getLink(String accessToken,String long_url) throws Exception {
		Map<String,Object> returnBack = new HashMap<>();
		// 拼装创建菜单的url
		String url = link_create_url.replace("ACCESS_TOKEN", accessToken);
		String param = "{\"action\":\"long2short\","
				+ "\"long_url\":\""+long_url+"\"}";
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", param);
		System.out.println(jsonObject);
		if (null != jsonObject) {
			returnBack.put("returnCode", jsonObject.getInt("errcode"));
			returnBack.put("short_url", jsonObject.getString("short_url"));
			return returnBack;
		}else{
			return null;
		}
	}

	
	
	/**
     * 连接请求微信后台接口
     * @param action 接口url
     * @param json  请求接口传送的json字符串
     **/
    public static int connectWeiXinInterface(String action,String json){
       URL url;
       try {
           url = new URL(action);
           HttpURLConnection http = (HttpURLConnection) url.openConnection();
           http.setRequestMethod("POST");
           http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
           http.setDoOutput(true);
           http.setDoInput(true);
           System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
           System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
           http.connect();
           OutputStream os = http.getOutputStream();
           os.write(json.getBytes("UTF-8"));// 传入参数
           InputStream is = http.getInputStream();
           int size = is.available();
           byte[] jsonBytes = new byte[size];
           is.read(jsonBytes);
           String result = new String(jsonBytes, "UTF-8");
           JSONObject object = JSONObject.fromObject(result);
           if(object.get("errcode").toString().equals("0")){
        	   return 1;
           }
           os.flush();
           os.close();
       } catch (Exception e) {
    	   logger.error("网络请求错误  class-connectWeiXinInterface-error={}",e);
           e.printStackTrace();
       }
       return 0;
    }
    
    
    
}
