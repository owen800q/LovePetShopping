package cn.lovepet.shops.bean;

import com.github.library.entity.MultiItemEntity;

import java.util.List;

/**
 * @author JSYL-DCL
 * @date 2018/11/7 11:24
 * @des 分类-首页-右侧列表
 */
public class PetCategoryMainRightList {
    private Category_main category_main;
    private String code;
    private String epet_site;
    private String hash;
    private int login_status;
    private String mall_uid;
    private String mall_user;
    private String msg;
    private int show_history;
    private long sys_time;

    /**
     * Category_main
     */
    public static class Category_main {
        //为您推荐
        private List<Tuijian> tuijian;
        //E宠国际
        private List<Tuijian> epet_guoji;
        //狗狗服饰
        private List<Tuijian> dog_clothes;
        //狗狗窝垫
        private List<Tuijian> dog_wodian;
        //狗狗主粮
        private List<Tuijian> dog_zhuliang;
        //狗狗零食
        private List<Tuijian> dog_lingshi;
        //狗狗玩具
        private List<Tuijian> dog_wanju;
        //狗狗清洁
        private List<Tuijian> dog_qingjie;
        //狗狗保健
        private List<Tuijian> dog_baojian;
        //狗狗护理
        private List<Tuijian> dog_huli;
        //狗狗生活
        private List<Tuijian> dog_shenghuo;
        //狗狗牵引
        private List<Tuijian> dog_qianyin;
        //狗狗美容
        private List<Tuijian> dog_meirong;
        //狗狗出游洗澡
        private List<Tuijian> dog_chuyouxizao;

        /**
         * Tuijian
         */
        public static class Tuijian implements MultiItemEntity {
            //图片
            public static final int CATEGORY_MAIN_SINGLE_IMAGE = 0;
            //普通商品
            public static final int CATEGORY_MAIN_GOODS_LIST = 1;
            //热门推荐
            public static final int CATEGORY_MAIN_HOT_RECOMMEND= 2;

            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;



            @Override
            public int getItemType() {
                return type;
            }


            /**
             * Menulist
             */
            public static class Menulist {
                private String id_param;
                private String name;
                private String photo;
                private String logo;
                private int recommend;
                private int tagongyi;
                private String mode;
                private String param;

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public int getRecommend() {
                    return recommend;
                }

                public void setRecommend(int recommend) {
                    this.recommend = recommend;
                }

                public int getTagongyi() {
                    return tagongyi;
                }

                public void setTagongyi(int tagongyi) {
                    this.tagongyi = tagongyi;
                }

                public String getMode() {
                    return mode;
                }

                public void setMode(String mode) {
                    this.mode = mode;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }

                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public static class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }
        }

        /**
         * Epet_guoji
         */
        public static class Epet_guoji {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }
        }

        /**
         * Dog_clothes
         */
        public static class Dog_clothes {

            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Dog_lingshi.Menulist> menulist;
            private Dog_lingshi.Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Dog_lingshi.Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Dog_lingshi.Menulist> menulist) {
                this.menulist = menulist;
            }

            public Dog_lingshi.Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Dog_lingshi.Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }
        }

        /**
         * Dog_wodian
         */
        public static class Dog_wodian {

            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Dog_lingshi.Menulist> menulist;
            private Dog_lingshi.Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Dog_lingshi.Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Dog_lingshi.Menulist> menulist) {
                this.menulist = menulist;
            }

            public Dog_lingshi.Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Dog_lingshi.Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }
        }

        /**
         * Dog_zhuliang
         */
        public class Dog_zhuliang {

            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Dog_lingshi.Menulist> menulist;
            private Dog_lingshi.Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Dog_lingshi.Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Dog_lingshi.Menulist> menulist) {
                this.menulist = menulist;
            }

            public Dog_lingshi.Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Dog_lingshi.Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        /**
         * Dog_lingshi
         */
        public class Dog_lingshi {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        /**
         * Dog_wanju
         */
        public class Dog_wanju {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        /**
         * Dog_qingjie
         */
        public class Dog_qingjie {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        /**
         * Dog_baojian
         */
        public class Dog_baojian {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        /**
         * Dog_huli
         */
        public class Dog_huli {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        /**
         * Dog_shenghuo
         */
        public class Dog_shenghuo {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        /**
         * Dog_qianyin
         */
        public class Dog_qianyin {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        /**
         * Dog_meirong
         */
        public class Dog_meirong {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        /**
         * Dog_chuyouxizao
         */
        public class Dog_chuyouxizao {
            private String advid;
            private String mode;
            private String param;
            private String src;
            private String flag_icon;
            private List<Menulist> menulist;
            private Rigth_img rigth_img;
            private String title;
            private int type;

            /**
             * Menulist
             */
            public class Menulist {
                private String id_param;
                private String name;
                private String photo;
                public void setId_param(String id_param) {
                    this.id_param = id_param;
                }
                public String getId_param() {
                    return id_param;
                }

                public void setName(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
                public String getPhoto() {
                    return photo;
                }
            }
            /**
             * Rigth_img
             */
            public class Rigth_img {
                private String image;
                private String img_size;
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

            public String getFlag_icon() {
                return flag_icon;
            }

            public void setFlag_icon(String flag_icon) {
                this.flag_icon = flag_icon;
            }

            public List<Menulist> getMenulist() {
                return menulist;
            }

            public void setMenulist(List<Menulist> menulist) {
                this.menulist = menulist;
            }

            public Rigth_img getRigth_img() {
                return rigth_img;
            }

            public void setRigth_img(Rigth_img rigth_img) {
                this.rigth_img = rigth_img;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }
            public String getAdvid() {
                return advid;
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

            public void setSrc(String src) {
                this.src = src;
            }
            public String getSrc() {
                return src;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }



        public void setTuijian(List<Tuijian> tuijian) {
            this.tuijian = tuijian;
        }
        public List<Tuijian> getTuijian() {
            return tuijian;
        }

        public void setEpet_guoji(List<Tuijian> epet_guoji) {
            this.epet_guoji = epet_guoji;
        }
        public List<Tuijian> getEpet_guoji() {
            return epet_guoji;
        }

        public void setDog_clothes(List<Tuijian> dog_clothes) {
            this.dog_clothes = dog_clothes;
        }
        public List<Tuijian> getDog_clothes() {
            return dog_clothes;
        }

        public void setDog_wodian(List<Tuijian> dog_wodian) {
            this.dog_wodian = dog_wodian;
        }
        public List<Tuijian> getDog_wodian() {
            return dog_wodian;
        }

        public void setDog_zhuliang(List<Tuijian> dog_zhuliang) {
            this.dog_zhuliang = dog_zhuliang;
        }
        public List<Tuijian> getDog_zhuliang() {
            return dog_zhuliang;
        }

        public void setDog_lingshi(List<Tuijian> dog_lingshi) {
            this.dog_lingshi = dog_lingshi;
        }
        public List<Tuijian> getDog_lingshi() {
            return dog_lingshi;
        }

        public void setDog_wanju(List<Tuijian> dog_wanju) {
            this.dog_wanju = dog_wanju;
        }
        public List<Tuijian> getDog_wanju() {
            return dog_wanju;
        }

        public void setDog_qingjie(List<Tuijian> dog_qingjie) {
            this.dog_qingjie = dog_qingjie;
        }
        public List<Tuijian> getDog_qingjie() {
            return dog_qingjie;
        }

        public void setDog_baojian(List<Tuijian> dog_baojian) {
            this.dog_baojian = dog_baojian;
        }
        public List<Tuijian> getDog_baojian() {
            return dog_baojian;
        }

        public void setDog_huli(List<Tuijian> dog_huli) {
            this.dog_huli = dog_huli;
        }
        public List<Tuijian> getDog_huli() {
            return dog_huli;
        }

        public void setDog_shenghuo(List<Tuijian> dog_shenghuo) {
            this.dog_shenghuo = dog_shenghuo;
        }
        public List<Tuijian> getDog_shenghuo() {
            return dog_shenghuo;
        }

        public void setDog_qianyin(List<Tuijian> dog_qianyin) {
            this.dog_qianyin = dog_qianyin;
        }
        public List<Tuijian> getDog_qianyin() {
            return dog_qianyin;
        }

        public void setDog_meirong(List<Tuijian> dog_meirong) {
            this.dog_meirong = dog_meirong;
        }
        public List<Tuijian> getDog_meirong() {
            return dog_meirong;
        }

        public void setDog_chuyouxizao(List<Tuijian> dog_chuyouxizao) {
            this.dog_chuyouxizao = dog_chuyouxizao;
        }
        public List<Tuijian> getDog_chuyouxizao() {
            return dog_chuyouxizao;
        }
    }



    public void setCategory_main(Category_main category_main) {
        this.category_main = category_main;
    }
    public Category_main getCategory_main() {
        return category_main;
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

    public void setShow_history(int show_history) {
        this.show_history = show_history;
    }
    public int getShow_history() {
        return show_history;
    }

    public void setSys_time(long sys_time) {
        this.sys_time = sys_time;
    }
    public long getSys_time() {
        return sys_time;
    }
}