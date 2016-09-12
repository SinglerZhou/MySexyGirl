  
package com.zxg.hasee.mysexygirl;

import android.app.Application;

/** 
 * ClassName:SmartBeiJingApplication <br/> 
 * Function: 初始化应用层级的类 <br/> 
 * Date:     2016年9月5日 下午11:47:39 <br/> 
 * @author   hasee 
 * @version       
 */
//初始化应用层级的类 
public class SexyGirlApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkManager.init(getApplicationContext());
    }
}
  