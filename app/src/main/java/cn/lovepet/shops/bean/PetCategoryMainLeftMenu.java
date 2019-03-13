package cn.lovepet.shops.bean;

import java.util.List;

/**
 * @author JSYL-DCL
 * @date 2018/11/7 11:24
 * @des 分类-首页-左侧菜单
 */
public class PetCategoryMainLeftMenu {
    private List<Alert_target> alert_target;
    private List<Categorys> categorys;
    private String code;
    private String epet_site;
    private String hash;
    private int login_status;
    private String mall_uid;
    private String mall_user;
    private String msg;
    private long sys_time;

    /**
     * Alert_target
     */
    public class Alert_target {
        private String target;
        private String text;
        public void setTarget(String target) {
            this.target = target;
        }
        public String getTarget() {
            return target;
        }

        public void setText(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }

    }

    /**
     * Categorys
     */
    public class Categorys {
        private long cateid;
        private String name;
        public void setCateid(long cateid) {
            this.cateid = cateid;
        }
        public long getCateid() {
            return cateid;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    public void setAlert_target(List<Alert_target> alert_target) {
        this.alert_target = alert_target;
    }
    public List<Alert_target> getAlert_target() {
        return alert_target;
    }

    public void setCategorys(List<Categorys> categorys) {
        this.categorys = categorys;
    }
    public List<Categorys> getCategorys() {
        return categorys;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
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