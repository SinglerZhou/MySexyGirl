
package com.zxg.hasee.mysexygirl;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.Volley;

/**
 * ClassName:NetWorkManager <br/>
 * Function: 全局请求队列的抽取 <br/>
 * Date: 2016年9月5日 下午11:39:22 <br/>
 * 
 * @author hasee
 * @version
 */
public class NetWorkManager {
    // 虚拟机缓存的大小的四分之一
    private static final int CACHE_SIZE = (int) (Runtime.getRuntime().freeMemory() / 4);
    // 一个app只维护一个请求队列
    private static RequestQueue mRequestQueue;
    // 一个app只维护一个ImageLoader
    private static ImageLoader mImageLoader;

    public static void init(Context context) {
        // 新建请求队列
        mRequestQueue = Volley.newRequestQueue(context);
        // 图片加载器
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLurCache(CACHE_SIZE));
    }

    // 暴露给外界发送请求的方法
    public static void sendRequest(Request<?> request) {
        // 将请求加入全局的请求队列
        mRequestQueue.add(request);
    }

    // 暴露给外界外界获取图片加载器的方法
    public static ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public static class ImageLurCache extends LruCache<String, Bitmap> implements ImageCache {

        /**
         * 
         * @param maxSize 缓存的最大大小
         */
        public ImageLurCache(int maxSize) {
            super(maxSize);
        }

        /**
         * 返回缓存图片数据的大小
         */
        @Override
        protected int sizeOf(String key, Bitmap value) {

//            return super.sizeOf(key, value);
            return value.getRowBytes()*value.getHeight();
        }

        /**
         * 从lru缓存中获取url对应的图片
         */
        @Override
        public Bitmap getBitmap(String url) {
            return get(url);
        }

        /**
         * 把图片存入缓存
         */
        @Override
            public void putBitmap(String url, Bitmap bitmap) {
                put(url, bitmap);
            }

    }
}
