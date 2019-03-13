package cn.lovepet.shops.bean;

import java.util.List;

/**
 * @author JSYL-DCL
 * @date 2018/10/30 11:08
 * @des  商品详情列表展示
 */
public class PetDogGoodsListBean {
    private int cateid;
    private String code;
    private List<Default_params> default_params;
    private String epet_site;
    private List<FilterBoxData> filterBoxData;
    private List<String> goodsrank;
    private String hash;
    private String keyword;
    private List<Goodslist> goodslist;
    private int login_status;
    private String mall_uid;
    private String mall_user;
    private String msg;
    private String redword;
    private List<Sort_rank> sort_rank;
    private long sys_time;
    private int total_count;
    private int total_page;
    private String typeid;

    /**
     * Default_params
     */
    public class Default_params {

        private String name;
        private String value;
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

    }

    /**
     * FilterBoxData
     */
    public class FilterBoxData {
        private List<Hot_rows> hot_rows;
        private int is_quick;
        private String name;
        private List<Rows> rows;
        private String varname;
        private int flag;

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        /**
         * Hot_rows
         */
        public class Hot_rows {
            private int type;
            private String title;
            private List<Zimulist> zimulist;
            /**
             * Zimulist
             */
            public class Zimulist {
                private int checked;
                private String name;
                private String id;
                private String letter;
                public void setChecked(int checked) {
                    this.checked = checked;
                }
                public int getChecked() {
                    return checked;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setId(String id) {
                    this.id = id;
                }
                public String getId() {
                    return id;
                }

                public void setLetter(String letter) {
                    this.letter = letter;
                }
                public String getLetter() {
                    return letter;
                }

            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setZimulist(List<Zimulist> zimulist) {
                this.zimulist = zimulist;
            }
            public List<Zimulist> getZimulist() {
                return zimulist;
            }



        }

        /**
         * Rows
         */
        public class Rows {
            private List<Items> items;
            private String letter;
            private int checked;
            private int id;
            private String name;

            public int getChecked() {
                return checked;
            }

            public void setChecked(int checked) {
                this.checked = checked;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setItems(List<Items> items) {
                this.items = items;
            }
            public List<Items> getItems() {
                return items;
            }

            public void setLetter(String letter) {
                this.letter = letter;
            }
            public String getLetter() {
                return letter;
            }

            /**
             * Items
             */
            public class Items {

                private int checked;
                private String id;
                private String name;
                public void setChecked(int checked) {
                    this.checked = checked;
                }
                public int getChecked() {
                    return checked;
                }

                public void setId(String id) {
                    this.id = id;
                }
                public String getId() {
                    return id;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

            }

        }



        public void setHot_rows(List<Hot_rows> hot_rows) {
            this.hot_rows = hot_rows;
        }
        public List<Hot_rows> getHot_rows() {
            return hot_rows;
        }

        public void setIs_quick(int is_quick) {
            this.is_quick = is_quick;
        }
        public int getIs_quick() {
            return is_quick;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setRows(List<Rows> rows) {
            this.rows = rows;
        }
        public List<Rows> getRows() {
            return rows;
        }

        public void setVarname(String varname) {
            this.varname = varname;
        }
        public String getVarname() {
            return varname;
        }

    }

    /**
     * Sort_rank
     */
    public class Sort_rank {
        private List<Sort_rank_list> sort_rank_list;
        private String title;
        private String type;

        /**
         * Sort_rank_list
         */
        public class Sort_rank_list {
            private int checked;
            private String item;
            private String short_name;
            private String value;
            public void setChecked(int checked) {
                this.checked = checked;
            }
            public int getChecked() {
                return checked;
            }

            public void setItem(String item) {
                this.item = item;
            }
            public String getItem() {
                return item;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }
            public String getShort_name() {
                return short_name;
            }

            public void setValue(String value) {
                this.value = value;
            }
            public String getValue() {
                return value;
            }

        }

        public List<Sort_rank_list> getSort_rank_list() {
            return sort_rank_list;
        }

        public void setSort_rank_list(List<Sort_rank_list> sort_rank_list) {
            this.sort_rank_list = sort_rank_list;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

    }

    /**
     * Goodslist
     */
    public class Goodslist {
        private List<String> activityIcons;
        private List<ActivityLabels> activityLabels;
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
        private int youhui_price;

        /**
         * ActivityLabels
         */
        public class ActivityLabels {
            private String image;
            private String img_size;
            private Target target;

            public class Target {

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

        /**
         * Gtype_icon
         */
        public class Gtype_icon{

        }


        public void setActivityIcons(List<String> activityIcons) {
            this.activityIcons = activityIcons;
        }
        public List<String> getActivityIcons() {
            return activityIcons;
        }

        public void setActivityLabels(List<ActivityLabels> activityLabels) {
            this.activityLabels = activityLabels;
        }
        public List<ActivityLabels> getActivityLabels() {
            return activityLabels;
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



    public void setCateid(int cateid) {
        this.cateid = cateid;
    }
    public int getCateid() {
        return cateid;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setDefault_params(List<Default_params> default_params) {
        this.default_params = default_params;
    }
    public List<Default_params> getDefault_params() {
        return default_params;
    }

    public void setEpet_site(String epet_site) {
        this.epet_site = epet_site;
    }
    public String getEpet_site() {
        return epet_site;
    }

    public void setFilterBoxData(List<FilterBoxData> filterBoxData) {
        this.filterBoxData = filterBoxData;
    }
    public List<FilterBoxData> getFilterBoxData() {
        return filterBoxData;
    }

    public void setGoodsrank(List<String> goodsrank) {
        this.goodsrank = goodsrank;
    }
    public List<String> getGoodsrank() {
        return goodsrank;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getHash() {
        return hash;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public String getKeyword() {
        return keyword;
    }


    public List<Goodslist> getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(List<Goodslist> goodslist) {
        this.goodslist = goodslist;
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

    public void setRedword(String redword) {
        this.redword = redword;
    }
    public String getRedword() {
        return redword;
    }

    public void setSort_rank(List<Sort_rank> sort_rank) {
        this.sort_rank = sort_rank;
    }
    public List<Sort_rank> getSort_rank() {
        return sort_rank;
    }

    public void setSys_time(long sys_time) {
        this.sys_time = sys_time;
    }
    public long getSys_time() {
        return sys_time;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }
    public int getTotal_page() {
        return total_page;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }
    public String getTypeid() {
        return typeid;
    }

}