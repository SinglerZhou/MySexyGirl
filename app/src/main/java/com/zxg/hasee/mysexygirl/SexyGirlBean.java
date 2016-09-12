package com.zxg.hasee.mysexygirl;

import java.util.List;

/**
 * Created by hasee on 2016/9/12.
 */
public class SexyGirlBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-06 14:11","title":"Beautyleg &#8211; Arvi 私房美腿写真","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/05/m.xxxiao.com_e7e731faf790487ccaf90d11774fae6b-760x500.jpg","url":"http://m.xxxiao.com/1353"},{"ctime":"2016-03-06 14:11","title":"[TGOD推女神] 泳池美人虞 75F乳神于姬Una私房泳装","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_3e6ffd8abf2d3fbd1040b02edb6bcb66-760x500.jpg","url":"http://m.xxxiao.com/370"},{"ctime":"2016-03-06 14:11","title":"AISS爱丝美女 丝袜美腿\u2026小哲女神","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_be45c01a6ad655cf09937e579c486526-760x500.jpg","url":"http://m.xxxiao.com/971"},{"ctime":"2016-03-06 14:11","title":"瑰姿艳逸蕾丝连体衣浴室惊艳欲照","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_596a3d04481816330f07e4f97510c28f9-760x500.jpg","url":"http://m.xxxiao.com/451"},{"ctime":"2016-03-06 14:11","title":"混血美女尽展清新可人靓照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150727/8-150HGG21ME.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/49617.html"},{"ctime":"2016-03-06 14:11","title":"黄衫妩媚睡美人","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_6bb61e3b7bce0931da574d19d1d82c886-760x500.jpg","url":"http://m.xxxiao.com/359"},{"ctime":"2016-03-06 14:11","title":"极品少妇紫色比基尼大秀傲人双乳","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150728/8-150HQ50I4224.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/49938.html"},{"ctime":"2016-03-06 14:11","title":"白皙丰满美女人体艺术照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150729/8-150H9102942291.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/49857.html"},{"ctime":"2016-03-06 14:11","title":"极品御姐性感秀大胸唯美艺术照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150729/8-150H9102I2548.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/51102.html"},{"ctime":"2016-03-06 14:11","title":"性感嫩模邹晶晶爆乳美臀诱惑私房照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/tu/201507/415/slt.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/123120.html"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-03-06 14:11
     * title : Beautyleg &#8211; Arvi 私房美腿写真
     * description : 美女图片
     * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2015/05/m.xxxiao.com_e7e731faf790487ccaf90d11774fae6b-760x500.jpg
     * url : http://m.xxxiao.com/1353
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
