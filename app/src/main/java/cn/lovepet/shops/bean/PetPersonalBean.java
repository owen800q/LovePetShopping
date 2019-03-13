package cn.lovepet.shops.bean;

import java.util.List;
import cn.lovepet.shops.helper.basequickadapter.entity.MultiItemEntity;

/**
 * @author JSYL-DCL
 * @date 2018/11/7 11:24
 * @des 我的E宠
 */
public class PetPersonalBean {
    private List<Data> data;
    private int login_status;
    private String mall_uid;
    private String mall_user;
    private String msg;
    private String push_alias;
    private String push_tags;
    private Service_info service_info;
    private Sign_pam sign_pam;
    private long sys_time;
    private Userinfo userinfo;


    /**
     * Data
     */
    public static class Data implements MultiItemEntity {
        public static final int MENU_IMAGE = 0;
        public static final int MENU_SINGLE = 1;
        public static final int MENU_LIST = 2;

        private int typeInt;
        private String type_name;
        private boolean hasLine;
        private boolean hasdash;
        private int num;
        private List<Datas> datas;

        public boolean isHasdash() {
            return hasdash;
        }

        public void setHasdash(boolean hasdash) {
            this.hasdash = hasdash;
        }

        @Override
        public int getItemType() {
            return typeInt;
        }

        /**
         * Datas
         */
        public static class Datas {
            private String badge;
            private String bottom;
            private String first_img;
            private String mode;
            private String param;
            private String epet_site;
            private String top;
            private boolean hassubtitle;
            private boolean hasdash;
            private boolean hastoptext;
            private int type;
            private Img_model img_model;
            private Target target;

            public static class Img_model {
                private String image;
                private String img_size;

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
            public static class Target {
                private String epet_site;
                private String mode;
                private String param;

                public String getEpet_site() {
                    return epet_site;
                }

                public void setEpet_site(String epet_site) {
                    this.epet_site = epet_site;
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
            }

            public Img_model getImg_model() {
                return img_model;
            }

            public void setImg_model(Img_model img_model) {
                this.img_model = img_model;
            }

            public Target getTarget() {
                return target;
            }

            public void setTarget(Target target) {
                this.target = target;
            }



            public void setHastoptext(boolean hastoptext) {
                this.hastoptext = hastoptext;
            }

            public boolean getHastoptext() {
                return hastoptext;
            }

            public boolean getHassubtitle() {
                return hassubtitle;
            }

            public void setHassubtitle(boolean hassubtitle) {
                this.hassubtitle = hassubtitle;
            }

            public boolean getHasdash() {
                return hasdash;
            }

            public void setHasdash(boolean hasdash) {
                this.hasdash = hasdash;
            }

            public void setBadge(String badge) {
                this.badge = badge;
            }
            public String getBadge() {
                return badge;
            }

            public void setBottom(String bottom) {
                this.bottom = bottom;
            }
            public String getBottom() {
                return bottom;
            }

            public void setFirst_img(String first_img) {
                this.first_img = first_img;
            }
            public String getFirst_img() {
                return first_img;
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

            public void setEpet_site(String epet_site) {
                this.epet_site = epet_site;
            }
            public String getEpet_site() {
                return epet_site;
            }

            public void setTop(String top) {
                this.top = top;
            }
            public String getTop() {
                return top;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

        }

        public void setTypeInt(int typeInt) {
            this.typeInt = typeInt;
        }
        public int getTypeInt() {
            return typeInt;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }
        public String getType_name() {
            return type_name;
        }

        public void setHasLine(boolean hasLine) {
            this.hasLine = hasLine;
        }
        public boolean getHasLine() {
            return hasLine;
        }

        public void setNum(int num) {
            this.num = num;
        }
        public int getNum() {
            return num;
        }

        public void setDatas(List<Datas> datas) {
            this.datas = datas;
        }
        public List<Datas> getDatas() {
            return datas;
        }
    }


    /**
     * Service_info
     */
    public static class Service_info {

        private List<Content> content;
        private Online_service online_service;
        private String phone;
        private String title;

        /**
         * Content
         */
        public static class Content {

            private String label;
            private String value;
            public void setLabel(String label) {
                this.label = label;
            }
            public String getLabel() {
                return label;
            }

            public void setValue(String value) {
                this.value = value;
            }
            public String getValue() {
                return value;
            }

        }

        /**
         * Online_service
         */
        public static class Online_service {

            private String label;
            private String value;
            public void setLabel(String label) {
                this.label = label;
            }
            public String getLabel() {
                return label;
            }

            public void setValue(String value) {
                this.value = value;
            }
            public String getValue() {
                return value;
            }
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }
        public List<Content> getContent() {
            return content;
        }

        public void setOnline_service(Online_service online_service) {
            this.online_service = online_service;
        }
        public Online_service getOnline_service() {
            return online_service;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
        public String getPhone() {
            return phone;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

    }

    /**
     * Sign_pam
     */
    public static class Sign_pam {

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

    /**
     * Userinfo
     */
    public static class Userinfo {

        private String avatar;
        private String bdmobilephone;
        private int cart_num;
        private String credits;
        private String email;
        private String emoney;
        private String group_icon;
        private String grouptitle;
        private String leftmoney;
        private String pettype;
        private int show_sign;
        private int signed;
        private String top_img;
        private String unred_msg;
        private String username;
        private Vip vip;

        /**
         * Vip
         */
        public static class Vip {

            private String image;
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

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
        public String getAvatar() {
            return avatar;
        }

        public void setBdmobilephone(String bdmobilephone) {
            this.bdmobilephone = bdmobilephone;
        }
        public String getBdmobilephone() {
            return bdmobilephone;
        }

        public void setCart_num(int cart_num) {
            this.cart_num = cart_num;
        }
        public int getCart_num() {
            return cart_num;
        }

        public void setCredits(String credits) {
            this.credits = credits;
        }
        public String getCredits() {
            return credits;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public String getEmail() {
            return email;
        }

        public void setEmoney(String emoney) {
            this.emoney = emoney;
        }
        public String getEmoney() {
            return emoney;
        }

        public void setGroup_icon(String group_icon) {
            this.group_icon = group_icon;
        }
        public String getGroup_icon() {
            return group_icon;
        }

        public void setGrouptitle(String grouptitle) {
            this.grouptitle = grouptitle;
        }
        public String getGrouptitle() {
            return grouptitle;
        }

        public void setLeftmoney(String leftmoney) {
            this.leftmoney = leftmoney;
        }
        public String getLeftmoney() {
            return leftmoney;
        }

        public void setPettype(String pettype) {
            this.pettype = pettype;
        }
        public String getPettype() {
            return pettype;
        }

        public void setShow_sign(int show_sign) {
            this.show_sign = show_sign;
        }
        public int getShow_sign() {
            return show_sign;
        }

        public void setSigned(int signed) {
            this.signed = signed;
        }
        public int getSigned() {
            return signed;
        }

        public void setTop_img(String top_img) {
            this.top_img = top_img;
        }
        public String getTop_img() {
            return top_img;
        }

        public void setUnred_msg(String unred_msg) {
            this.unred_msg = unred_msg;
        }
        public String getUnred_msg() {
            return unred_msg;
        }

        public void setUsername(String username) {
            this.username = username;
        }
        public String getUsername() {
            return username;
        }

        public void setVip(Vip vip) {
            this.vip = vip;
        }
        public Vip getVip() {
            return vip;
        }
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    public List<Data> getData() {
        return data;
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

    public void setPush_alias(String push_alias) {
        this.push_alias = push_alias;
    }
    public String getPush_alias() {
        return push_alias;
    }

    public void setPush_tags(String push_tags) {
        this.push_tags = push_tags;
    }
    public String getPush_tags() {
        return push_tags;
    }

    public void setService_info(Service_info service_info) {
        this.service_info = service_info;
    }
    public Service_info getService_info() {
        return service_info;
    }

    public void setSign_pam(Sign_pam sign_pam) {
        this.sign_pam = sign_pam;
    }
    public Sign_pam getSign_pam() {
        return sign_pam;
    }

    public void setSys_time(long sys_time) {
        this.sys_time = sys_time;
    }
    public long getSys_time() {
        return sys_time;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }
    public Userinfo getUserinfo() {
        return userinfo;
    }
}