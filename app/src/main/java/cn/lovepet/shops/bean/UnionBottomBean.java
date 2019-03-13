package cn.lovepet.shops.bean;

import java.util.List;

/**
 * @author JSYL-DCL
 * @date 2018/12/13 9:43
 * @des 联盟底部
 */
public class UnionBottomBean {
    private String code;
    private Bottomdata bottomdata;
    private String epet_site;
    private String hash;
    private int login_status;
    private String mall_uid;
    private String mall_user;
    private String msg;
    private long sys_time;

    /**
     * Bottomdata
     */
    public class Bottomdata {

        private List<Cate> cate;
        private String cate_color;

        /**
         * Cate
         */
        public class Cate {

            private String image;
            private String img_size;
            private String tag_name;
            private String tid;
            public void setImage(String image) {
                this.image = image;
            }
            public String getImage() {
                return image;
            }

            public void setImg_size(String img_size) {
                this.img_size = img_size;
            }
            public String getImg_size() {
                return img_size;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }
            public String getTag_name() {
                return tag_name;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }
            public String getTid() {
                return tid;
            }

        }

        public void setCate(List<Cate> cate) {
            this.cate = cate;
        }
        public List<Cate> getCate() {
            return cate;
        }

        public void setCate_color(String cate_color) {
            this.cate_color = cate_color;
        }
        public String getCate_color() {
            return cate_color;
        }
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setBottomdata(Bottomdata bottomdata) {
        this.bottomdata = bottomdata;
    }
    public Bottomdata getBottomdata() {
        return bottomdata;
    }

    public void setEpet_site(String epet_site) {
        this.epet_site = epet_site;
    }
    public String getEpet_site() {
        return epet_site;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getHash() {
        return hash;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }
    public int getLogin_status() {
        return login_status;
    }

    public void setMall_uid(String mall_uid) {
        this.mall_uid = mall_uid;
    }
    public String getMall_uid() {
        return mall_uid;
    }

    public void setMall_user(String mall_user) {
        this.mall_user = mall_user;
    }
    public String getMall_user() {
        return mall_user;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setSys_time(long sys_time) {
        this.sys_time = sys_time;
    }
    public long getSys_time() {
        return sys_time;
    }
}