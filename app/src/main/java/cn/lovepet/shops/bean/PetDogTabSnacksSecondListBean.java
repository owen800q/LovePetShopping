package cn.lovepet.shops.bean;


import java.util.List;

/**
 * @author JSYL-DCL
 * @date 2018/10/30 11:08
 * @des  狗狗零食-详情列表
 */
public class PetDogTabSnacksSecondListBean{
    private List<Menu1> menu1;
    private List<Bottom_menu_list> bottom_menu_list;
    private Bottom_Title bottom_Title;
    private List<Bottom_goods_list> bottom_goods_list;

    /**
     * Menu1
     */
    public static class Menu1 {

        private String name;
        private int menu_column;
        private List<Menus_content> menus_content;
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
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

        /**
         * Menus_content
         */
        public static class Menus_content {

            private String image;
            private String img_size;
            private String name;
            private Target target;

            /**
             * Target
             */
            public static class Target {

                private String mode;
                private String param;
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

            public void setTarget(Target target) {
                this.target = target;
            }
            public Target getTarget() {
                return target;
            }

        }

    }

    /**
     * Bottom_menu_list
     */
    public static class Bottom_menu_list {
        private String menu_font_color;
        private String menu_menu_line_colorname;
        private String menu_name;
        private int menu_param;
        private String menu_param_key;
        public void setMenu_font_color(String menu_font_color) {
            this.menu_font_color = menu_font_color;
        }
        public String getMenu_font_color() {
            return menu_font_color;
        }

        public void setMenu_menu_line_colorname(String menu_menu_line_colorname) {
            this.menu_menu_line_colorname = menu_menu_line_colorname;
        }
        public String getMenu_menu_line_colorname() {
            return menu_menu_line_colorname;
        }

        public void setMenu_name(String menu_name) {
            this.menu_name = menu_name;
        }
        public String getMenu_name() {
            return menu_name;
        }

        public void setMenu_param(int menu_param) {
            this.menu_param = menu_param;
        }
        public int getMenu_param() {
            return menu_param;
        }

        public void setMenu_param_key(String menu_param_key) {
            this.menu_param_key = menu_param_key;
        }
        public String getMenu_param_key() {
            return menu_param_key;
        }
    }

    public static class Bottom_Title{
        private int type;
        private int is_show;
        private String type_name;
        private String image;
        private String img_size;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIs_show() {
            return is_show;
        }

        public void setIs_show(int is_show) {
            this.is_show = is_show;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImg_size() {
            return img_size;
        }

        public void setImg_size(String img_size) {
            this.img_size = img_size;
        }
    }

    /**
     * Bottom_goods_list
     */
    public static class Bottom_goods_list {

        private int type;
        private String type_name;
        private int is_show;
        private List<Datalist> datalist;

        /**
         * Datalist
         */
        public static class Datalist {

            private boolean activityIcons;
            private boolean activityLabels;
            private String icon_char;
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
            private Gtype_icon gtype_icon;
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
            private String image;
            private int youhui_price;

            public boolean isActivityIcons() {
                return activityIcons;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public boolean isActivityLabels() {
                return activityLabels;
            }

            /**
             * Gtype_icon
             */
            public static class Gtype_icon {

            }

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

            public void setIcon_char(String icon_char) {
                this.icon_char = icon_char;
            }
            public String getIcon_char() {
                return icon_char;
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

            public void setGtype_icon(Gtype_icon gtype_icon) {
                this.gtype_icon = gtype_icon;
            }
            public Gtype_icon getGtype_icon() {
                return gtype_icon;
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

            public void setYouhui_price(int youhui_price) {
                this.youhui_price = youhui_price;
            }
            public int getYouhui_price() {
                return youhui_price;
            }

        }


        public void setType(int type) {
            this.type = type;
        }
        public int getType() {
            return type;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }
        public String getType_name() {
            return type_name;
        }

        public void setIs_show(int is_show) {
            this.is_show = is_show;
        }
        public int getIs_show() {
            return is_show;
        }

        public void setDatalist(List<Datalist> datalist) {
            this.datalist = datalist;
        }
        public List<Datalist> getDatalist() {
            return datalist;
        }
    }


    public List<Bottom_goods_list> getBottom_goods_list() {
        return bottom_goods_list;
    }

    public void setBottom_goods_list(List<Bottom_goods_list> bottom_goods_list) {
        this.bottom_goods_list = bottom_goods_list;
    }

    public void setMenu1(List<Menu1> menu1) {
        this.menu1 = menu1;
    }
    public List<Menu1> getMenu1() {
        return menu1;
    }

    public List<Bottom_menu_list> getBottom_menu_list() {
        return bottom_menu_list;
    }

    public void setBottom_menu_list(List<Bottom_menu_list> bottom_menu_list) {
        this.bottom_menu_list = bottom_menu_list;
    }

    public Bottom_Title getBottom_Title() {
        return bottom_Title;
    }

    public void setBottom_Title(Bottom_Title bottom_Title) {
        this.bottom_Title = bottom_Title;
    }
}