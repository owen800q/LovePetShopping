package cn.lovepet.shops.bean;

import java.util.List;

import cn.lovepet.shops.net.basequick.MultipleItem;

/**
 * @author JSYL-DCL
 * @date 2018/10/30 11:08
 * @des  狗狗主粮
 */
public class PetDogTabMajorFoodPlateBean extends MultipleItem {
    private List<Menu_1> menu_1;
    private List<Menu_2> menu_2;

    /**
     * Menu_1
     */
    public static class Menu_1 {

        private String name;
        private String dis_order;
        private int menu_column;
        private List<Menus_content> menus_content;

        /**
         * Menus_content
         */
        public static class Menus_content {
            private String image;
            private String img_size;
            private String name;
            private String mode;
            private String param;
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

            public void setName(String name) {
                this.name = name;
            }
            public String getName() {
                return name;
            }

            public void setMode(String mode) {
                this.mode = mode;
            }
            public String getMode() {
                return mode;
            }

            public void setParam(String param) {
                this.param = param;
            }
            public String getParam() {
                return param;
            }
        }


        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setDis_order(String dis_order) {
            this.dis_order = dis_order;
        }
        public String getDis_order() {
            return dis_order;
        }

        public void setMenu_column(int menu_column) {
            this.menu_column = menu_column;
        }
        public int getMenu_column() {
            return menu_column;
        }

        public void setMenus_content(List<Menus_content> menus_content) {
            this.menus_content = menus_content;
        }
        public List<Menus_content> getMenus_content() {
            return menus_content;
        }

    }

    /**
     * Menu_2
     */
    public static class Menu_2 {

        private String type_name;
        private String name;
        private int order;
        private int content_num;
        private List<Content_list> content_list;

        /**
         * Content_list
         */
        public static class Content_list {
            private boolean activityIcons;
            private boolean activityLabels;
            private String image;
            private String img_size;
            private int asks;
            private int brandid;
            private int cateid;
            private String comments;
            private String country_photo;
            private String dprice;
            private String extend_pam;
            private long fm_shareid;
            private String formats;
            private String formats_values;
            private long gid;
            private String goods_icon;
            private int goods_sign;
            private long gspid;
            private int isBest;
            private String market_price;
            private String order;
            private String photo;
            private String presubject;
            private int real_wid;
            private int replys;
            private String sale_price;
            private String send_ware;
            private int site;
            private String sold;
            private int stock;
            private int stock_now;
            private int stockmode;
            private String subject;
            private String subject_tip;
            private String unit;
            private int virtual_wid;
            private String with_me;
            private double youhui_price;
            public void setActivityIcons(boolean activityIcons) {
                this.activityIcons = activityIcons;
            }
            public boolean getActivityIcons() {
                return activityIcons;
            }

            public void setActivityLabels(boolean activityLabels) {
                this.activityLabels = activityLabels;
            }
            public boolean getActivityLabels() {
                return activityLabels;
            }

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

            public void setAsks(int asks) {
                this.asks = asks;
            }
            public int getAsks() {
                return asks;
            }

            public void setBrandid(int brandid) {
                this.brandid = brandid;
            }
            public int getBrandid() {
                return brandid;
            }

            public void setCateid(int cateid) {
                this.cateid = cateid;
            }
            public int getCateid() {
                return cateid;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }
            public String getComments() {
                return comments;
            }

            public void setCountry_photo(String country_photo) {
                this.country_photo = country_photo;
            }
            public String getCountry_photo() {
                return country_photo;
            }

            public void setDprice(String dprice) {
                this.dprice = dprice;
            }
            public String getDprice() {
                return dprice;
            }

            public void setExtend_pam(String extend_pam) {
                this.extend_pam = extend_pam;
            }
            public String getExtend_pam() {
                return extend_pam;
            }

            public void setFm_shareid(long fm_shareid) {
                this.fm_shareid = fm_shareid;
            }
            public long getFm_shareid() {
                return fm_shareid;
            }

            public void setFormats(String formats) {
                this.formats = formats;
            }
            public String getFormats() {
                return formats;
            }

            public void setFormats_values(String formats_values) {
                this.formats_values = formats_values;
            }
            public String getFormats_values() {
                return formats_values;
            }

            public void setGid(long gid) {
                this.gid = gid;
            }
            public long getGid() {
                return gid;
            }

            public void setGoods_icon(String goods_icon) {
                this.goods_icon = goods_icon;
            }
            public String getGoods_icon() {
                return goods_icon;
            }

            public void setGoods_sign(int goods_sign) {
                this.goods_sign = goods_sign;
            }
            public int getGoods_sign() {
                return goods_sign;
            }

            public void setGspid(long gspid) {
                this.gspid = gspid;
            }
            public long getGspid() {
                return gspid;
            }

            public void setIsBest(int isBest) {
                this.isBest = isBest;
            }
            public int getIsBest() {
                return isBest;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }
            public String getMarket_price() {
                return market_price;
            }

            public void setOrder(String order) {
                this.order = order;
            }
            public String getOrder() {
                return order;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
            public String getPhoto() {
                return photo;
            }

            public void setPresubject(String presubject) {
                this.presubject = presubject;
            }
            public String getPresubject() {
                return presubject;
            }

            public void setReal_wid(int real_wid) {
                this.real_wid = real_wid;
            }
            public int getReal_wid() {
                return real_wid;
            }

            public void setReplys(int replys) {
                this.replys = replys;
            }
            public int getReplys() {
                return replys;
            }

            public void setSale_price(String sale_price) {
                this.sale_price = sale_price;
            }
            public String getSale_price() {
                return sale_price;
            }

            public void setSend_ware(String send_ware) {
                this.send_ware = send_ware;
            }
            public String getSend_ware() {
                return send_ware;
            }

            public void setSite(int site) {
                this.site = site;
            }
            public int getSite() {
                return site;
            }

            public void setSold(String sold) {
                this.sold = sold;
            }
            public String getSold() {
                return sold;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }
            public int getStock() {
                return stock;
            }

            public void setStock_now(int stock_now) {
                this.stock_now = stock_now;
            }
            public int getStock_now() {
                return stock_now;
            }

            public void setStockmode(int stockmode) {
                this.stockmode = stockmode;
            }
            public int getStockmode() {
                return stockmode;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }
            public String getSubject() {
                return subject;
            }

            public void setSubject_tip(String subject_tip) {
                this.subject_tip = subject_tip;
            }
            public String getSubject_tip() {
                return subject_tip;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }
            public String getUnit() {
                return unit;
            }

            public void setVirtual_wid(int virtual_wid) {
                this.virtual_wid = virtual_wid;
            }
            public int getVirtual_wid() {
                return virtual_wid;
            }

            public void setWith_me(String with_me) {
                this.with_me = with_me;
            }
            public String getWith_me() {
                return with_me;
            }

            public void setYouhui_price(double youhui_price) {
                this.youhui_price = youhui_price;
            }
            public double getYouhui_price() {
                return youhui_price;
            }
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }
        public String getType_name() {
            return type_name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setOrder(int order) {
            this.order = order;
        }
        public int getOrder() {
            return order;
        }

        public void setContent_num(int content_num) {
            this.content_num = content_num;
        }
        public int getContent_num() {
            return content_num;
        }

        public void setContent_list(List<Content_list> content_list) {
            this.content_list = content_list;
        }
        public List<Content_list> getContent_list() {
            return content_list;
        }
    }


    public void setMenu_1(List<Menu_1> menu_1) {
        this.menu_1 = menu_1;
    }
    public List<Menu_1> getMenu_1() {
        return menu_1;
    }

    public void setMenu_2(List<Menu_2> menu_2) {
        this.menu_2 = menu_2;
    }
    public List<Menu_2> getMenu_2() {
        return menu_2;
    }
}