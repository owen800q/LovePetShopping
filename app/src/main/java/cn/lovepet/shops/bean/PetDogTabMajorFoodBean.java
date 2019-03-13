package cn.lovepet.shops.bean;


import java.util.List;

import cn.lovepet.shops.helper.basequickadapter.entity.MultiItemEntity;
import cn.lovepet.shops.net.basequick.MultipleItem;

/**
 * @author JSYL-DCL
 * @date 2018/10/30 11:08
 * @des  狗狗主粮
 */
public class PetDogTabMajorFoodBean extends MultipleItem {
    private List<Datas> datas;
    private String epet_site;
    private String hash;
    private String is_dynamic;
    private int login_status;
    private String mall_uid;
    private String mall_user;
    private String msg;
    private int real_page_id;
    private long sys_time;

    /**
     * Datas
     */
    public static class Datas implements MultiItemEntity {
        //轮播图
        public static final int BANNER = 101;
        //板块导航
        public static final int PlATE_NAVIGATION = 102;
        //分类导航
//        public static final int CLASSFICATION_NAVIGATION = 103;

        private String background_color;
        private int margin_bottom;
        private String index;
        private String is_dynamic;
        private int is_first;
        private int is_show;
        private int type;
        private String type_name;
        private String title_image;
        private String img_size;
        private String title_height;
        private List<Value_list> value_list;

        @Override
        public int getItemType() {
            return type;
        }

        /**
         * Value_list
         */
        public static class Value_list {
            private String advid;
            private String atid;
            private String image;
            private String img_size;
            private String mode;
            private String param;
            private String menu_name;
            private String image_choose;

            public String getMenu_name() {
                return menu_name;
            }

            public void setMenu_name(String menu_name) {
                this.menu_name = menu_name;
            }

            public String getImage_choose() {
                return image_choose;
            }

            public void setImage_choose(String image_choose) {
                this.image_choose = image_choose;
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

        public String getTitle_image() {
            return title_image;
        }

        public void setTitle_image(String title_image) {
            this.title_image = title_image;
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

        public void setBackground_color(String background_color) {
            this.background_color = background_color;
        }
        public String getBackground_color() {
            return background_color;
        }

        public void setMargin_bottom(int margin_bottom) {
            this.margin_bottom = margin_bottom;
        }
        public int getMargin_bottom() {
            return margin_bottom;
        }

        public void setIndex(String index) {
            this.index = index;
        }
        public String getIndex() {
            return index;
        }

        public void setIs_dynamic(String is_dynamic) {
            this.is_dynamic = is_dynamic;
        }
        public String getIs_dynamic() {
            return is_dynamic;
        }

        public void setIs_first(int is_first) {
            this.is_first = is_first;
        }
        public int getIs_first() {
            return is_first;
        }

        public void setIs_show(int is_show) {
            this.is_show = is_show;
        }
        public int getIs_show() {
            return is_show;
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

        public void setValue_list(List<Value_list> value_list) {
            this.value_list = value_list;
        }
        public List<Value_list> getValue_list() {
            return value_list;
        }
    }




    public void setDatas(List<Datas> datas) {
        this.datas = datas;
    }
    public List<Datas> getDatas() {
        return datas;
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

    public void setIs_dynamic(String is_dynamic) {
        this.is_dynamic = is_dynamic;
    }
    public String getIs_dynamic() {
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