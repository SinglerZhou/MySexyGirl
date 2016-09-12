  
package com.zxg.hasee.mysexygirl;

import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;

/** 
 * ClassName:SmartBeiJingRequest <br/> 
 * Function: json数据的请求类 <br/> 
 * Date:     2016年9月4日 下午3:56:47 <br/> 
 * @author   hasee 
 * @version       
 */
public class SexyGirlRequest<T> extends JsonRequest<T> {

    private Gson gson;
    
    private Class<T> mClass;

    public SexyGirlRequest( String url,Class<T> clazz,Listener<T> listener,
            ErrorListener errorListener) {
        super(Method.GET, url,null, listener, errorListener);
        mClass = clazz;
    }

    //在请求成功后调用，用来解析返回结果，子线程中调用
    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        Log.d("SmartBeiJingRequest", "网络请求成功");
        //将网络请求结果的字节数组转换成字符串
        try {
            String result = new String(response.data, PROTOCOL_CHARSET);
            gson = new Gson();
            T resultBean = gson.fromJson(result, mClass);
            //缓存的相关数据，如果缓存的过期时间
            Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
            return Response.success(resultBean, cacheEntry);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
  