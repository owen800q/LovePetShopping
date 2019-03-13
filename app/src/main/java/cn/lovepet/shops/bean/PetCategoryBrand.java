package cn.lovepet.shops.bean;



import com.github.library.entity.MultiItemEntity;

import java.util.List;

/**
 * @author JSYL-DCL
 * @date 2018/11/7 11:24
 * @des 分类-首页-右侧列表
 */
public class PetCategoryBrand {
        private List<Brand> brand;
        private String code;
        private String epet_site;
        private String hash;
        private int login_status;
        private String mall_uid;
        private String mall_user;
        private String msg;
        private long sys_time;

    /**
     * Brand
     */
    public static class Brand implements MultiItemEntity {
        //图片
        public static final int CATEGORY_BRAND_GRID = 1;

        private List<Blist> blist;
        private String title;
        private int type;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public int getItemType() {
            return type;
        }

        /**
         * Blist
         */
        public static class Blist {

            private String address;
            private String brandid;
            private String logo;
            private String name;
            private int recommend;
            private int tagongyi;
            private Target target;

            /**
             * Target
             */
            public class Target {

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

            public void setAddress(String address) {
                this.address = address;
            }
            public String getAddress() {
                return address;
            }

            public void setBrandid(String brandid) {
                this.brandid = brandid;
            }
            public String getBrandid() {
                return brandid;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }
            public String getLogo() {
                return logo;
            }

            public void setName(String name) {
                this.name = name;
            }
            public String getName() {
                return name;
            }

            public void setRecommend(int recommend) {
                this.recommend = recommend;
            }
            public int getRecommend() {
                return recommend;
            }

            public void setTagongyi(int tagongyi) {
                this.tagongyi = tagongyi;
            }
            public int getTagongyi() {
                return tagongyi;
            }

            public void setTarget(Target target) {
                this.target = target;
            }
            public Target getTarget() {
                return target;
            }
        }


        public void setBlist(List<Blist> blist) {
            this.blist = blist;
        }
        public List<Blist> getBlist() {
            return blist;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

    }


        public void setBrand(List<Brand> brand) {
            this.brand = brand;
        }
        public List<Brand> getBrand() {
            return brand;
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