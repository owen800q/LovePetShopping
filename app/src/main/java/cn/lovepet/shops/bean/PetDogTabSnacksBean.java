package cn.lovepet.shops.bean;

import java.util.List;
import cn.lovepet.shops.helper.basequickadapter.entity.MultiItemEntity;
import cn.lovepet.shops.net.basequick.MultipleItem;

/**
 * @author JSYL-DCL
 * @date 2018/10/30 11:08
 * @des  狗狗零食
 */
public class PetDogTabSnacksBean extends MultipleItem {
    private List<Top_datas> top_datas;
    private List<Bottom_datas> bottom_datas;
    private String epet_site;
    private String hash;
    private int is_dynamic;
    private int login_status;
    private String mall_uid;
    private String mall_user;
    private String msg;
    private int real_page_id;
    private long sys_time;

    /**
     * Top_datas
     */
    public static class Top_datas implements MultiItemEntity {
        //轮播图
        public static final int BANNER1 = 1;
        //二级可切换菜单
        public static final int MENU_SECOND_LEVEL = 2;
        //图片导航-通用广告模板
        public static final int DOUBLE_IMAGE = 3;
        //板块导航
        public static final int PlATE_SNAP_LINE = 4;
        //自定义Title模板
        public static final int PLATE_TITLE = 5;
        //单视频模板
        public static final int PLATE_VIDEO = 6;
        //单广告+商品列表
        public static final int SINGLE_PLATE = 7;
        //通用广告模板-品牌
        public static final int PLATE_BRAND = 8;
        //图片轮播广告2
        public static final int BANNER2 = 11;
        //图片轮播广告3
        public static final int BANNER3 = 12;


        private int type;
        private String type_name;
        private int is_show;
        private String image;
        private String img_size;
        private String title_height;
        private List<Datalist> datalist;
        private First_img first_img;


        @Override
        public int getItemType() {
            return type;
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

        public String getTitle_height() {
            return title_height;
        }

        public void setTitle_height(String title_height) {
            this.title_height = title_height;
        }

        public First_img getFirst_img() {
            return first_img;
        }

        public void setFirst_img(First_img first_img) {
            this.first_img = first_img;
        }


        /**
         * First_img
         */
        public class First_img {
            private String image;
            private String img_size;
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

        }

        /**
         * Datalist
         */
        public static class Datalist {

            private String advid;
            private String atid;
            private String image;
            private String img_size;
            private Target target;

            private String dis_order;
            private String image_choose;
            private String image_choose_size;
            private String name;
            private String url;
            private String video_size;
            private String video_name;

            public String getVideo_name() {
                return video_name;
            }

            public void setVideo_name(String video_name) {
                this.video_name = video_name;
            }

            private List<Menu_detail_list> menu_detail_list;

            public List<Menu_detail_list> getMenu_detail_list() {
                return menu_detail_list;
            }

            public void setMenu_detail_list(List<Menu_detail_list> menu_detail_list) {
                this.menu_detail_list = menu_detail_list;
            }

            /**
             * Menu_detail_list
             */
            public static class Menu_detail_list {
                private String image;
                private String img_size;
                private String name;
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
            }
            public String getDis_order() {
                return dis_order;
            }

            public void setDis_order(String dis_order) {
                this.dis_order = dis_order;
            }

            public String getImage_choose() {
                return image_choose;
            }

            public void setImage_choose(String image_choose) {
                this.image_choose = image_choose;
            }

            public String getImage_choose_size() {
                return image_choose_size;
            }

            public void setImage_choose_size(String image_choose_size) {
                this.image_choose_size = image_choose_size;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVideo_size() {
                return video_size;
            }

            public void setVideo_size(String video_size) {
                this.video_size = video_size;
            }

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


            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
            }

            public void setAtid(String atid) {
                this.atid = atid;
            }
            public String getAtid() {
                return atid;
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

            public void setTarget(Target target) {
                this.target = target;
            }
            public Target getTarget() {
                return target;
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

    /**
     * Bottom_datas
     */
    public static class Bottom_datas {
        private int type;
        private int is_show;
        private String type_name;
        private String image;
        private String img_size;
        private List<Datalist> datalist;
        /**
         * Datalist
         */
        public static class Datalist {
            private boolean activityIcons;
            private boolean activityLabels;
            private String icon_char;
            private String image;
            private int asks;
            private int brandid;
            private int cateid;
            private String comments;
            private String country_photo;
            private String dprice;
            private String extend_pam;
            private int fm_shareid;
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
            private int youhui_price;

            public class Gtype_icon{

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

            public void setImage(String image) {
                this.image = image;
            }
            public String getImage() {
                return image;
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

            public void setFm_shareid(int fm_shareid) {
                this.fm_shareid = fm_shareid;
            }
            public int getFm_shareid() {
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

        public List<Datalist> getDatalist() {
            return datalist;
        }

        public void setDatalist(List<Datalist> datalist) {
            this.datalist = datalist;
        }

        public void setType(int type) {
            this.type = type;
        }
        public int getType() {
            return type;
        }

        public void setIs_show(int is_show) {
            this.is_show = is_show;
        }
        public int getIs_show() {
            return is_show;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }
        public String getType_name() {
            return type_name;
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

    }

    public void setTop_datas(List<Top_datas> top_datas) {
        this.top_datas = top_datas;
    }
    public List<Top_datas> getTop_datas() {
        return top_datas;
    }

    public void setBottom_datas(List<Bottom_datas> bottom_datas) {
        this.bottom_datas = bottom_datas;
    }
    public List<Bottom_datas> getBottom_datas() {
        return bottom_datas;
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

    public void setIs_dynamic(int is_dynamic) {
        this.is_dynamic = is_dynamic;
    }
    public int getIs_dynamic() {
        return is_dynamic;
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

    public void setReal_page_id(int real_page_id) {
        this.real_page_id = real_page_id;
    }
    public int getReal_page_id() {
        return real_page_id;
    }

    public void setSys_time(long sys_time) {
        this.sys_time = sys_time;
    }
    public long getSys_time() {
        return sys_time;
    }
}