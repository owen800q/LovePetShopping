package cn.lovepet.shops.bean;

import java.util.List;

import cn.lovepet.shops.net.basequick.MultipleItem;

/**
 * @author JSYL-DCL
 * @date 2018/10/30 11:08
 * @des
 */
public class PetDogTabHomeBean0 extends MultipleItem {
        private Data data;
        private Tabdata tabdata;
        private String message;
        private int status;
        private boolean gos;
        public void setData(Data data) {
            this.data = data;
        }
        public Data getData() {
            return data;
        }

        public void setTabdata(Tabdata tabdata) {
            this.tabdata = tabdata;
        }
        public Tabdata getTabdata() {
            return tabdata;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }

        public void setStatus(int status) {
            this.status = status;
        }
        public int getStatus() {
            return status;
        }

        public void setGos(boolean gos) {
            this.gos = gos;
        }
        public boolean getGos() {
            return gos;
        }
    public static class Data {
        private Banner1 banner1;
        private Menu1 menu1;
        private Menu2 menu2;
        private Newperson newperson;
        private Dayfq dayfq;
        private Xpg xpg;
        private Banner2 banner2;
        private Pztmtitle pztmtitle;
        private Pztmimage1 pztmimage1;
        private Pztmimage2 pztmimage2;
        private Pztmimage3 pztmimage3;
        private Pztmimage4 pztmimage4;
        private Pztmimage5 pztmimage5;
        private Pztmimage6 pztmimage6;
        private Viptitle viptitle;
        private Vipbanner1 vipbanner1;
        private Mzlmtitle mzlmtitle;
        private Mzlmbanner mzlmbanner;
        private Xjctitle xjctitle;
        private Xjcbanner xjcbanner;


        //图片轮播广告
        public static class Banner1 {
                private int code;
                private String type_name;
                private String type_title;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }

            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        // //九宫格按钮（MENU）//2
        public static class Menu1 {
                private int code;
                private String type_name;
                private String type_title;
                private String rush_endTime;
                private String time;
                private String title;
                private String more_icon;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setRush_endTime(String rush_endTime) {
                    this.rush_endTime = rush_endTime;
                }
                public String getRush_endTime() {
                    return rush_endTime;
                }

                public void setTime(String time) {
                    this.time = time;
                }
                public String getTime() {
                    return time;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
                public String getTitle() {
                    return title;
                }

                public void setMore_icon(String more_icon) {
                    this.more_icon = more_icon;
                }
                public String getMore_icon() {
                    return more_icon;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }

            public static class Value{
                    private String image;
                    private String img_size;
                    private String name;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        // //栏目菜单二
        public static class Menu2 {
                private int code;
                private String type_name;
                private String type_title;
                private String rush_endTime;
                private String time;
                private String title;
                private String more_icon;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setRush_endTime(String rush_endTime) {
                    this.rush_endTime = rush_endTime;
                }
                public String getRush_endTime() {
                    return rush_endTime;
                }

                public void setTime(String time) {
                    this.time = time;
                }
                public String getTime() {
                    return time;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
                public String getTitle() {
                    return title;
                }

                public void setMore_icon(String more_icon) {
                    this.more_icon = more_icon;
                }
                public String getMore_icon() {
                    return more_icon;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        //新小主专区
        public static class Newperson {
                private int code;
                private String type_name;
                private String type_title;
                private String rush_endTime;
                private String image;
                private String img_size;
                private String web;
                private String time;
                private String title;
                private String more_icon;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setRush_endTime(String rush_endTime) {
                    this.rush_endTime = rush_endTime;
                }
                public String getRush_endTime() {
                    return rush_endTime;
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

                public void setWeb(String web) {
                    this.web = web;
                }
                public String getWeb() {
                    return web;
                }

                public void setTime(String time) {
                    this.time = time;
                }
                public String getTime() {
                    return time;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
                public String getTitle() {
                    return title;
                }

                public void setMore_icon(String more_icon) {
                    this.more_icon = more_icon;
                }
                public String getMore_icon() {
                    return more_icon;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private int size_sm;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setSize_sm(int size_sm) {
                        this.size_sm = size_sm;
                    }
                    public int getSize_sm() {
                        return size_sm;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        //每日疯抢//5
        public static class Dayfq {
                private int code;
                private String type_name;
                private String type_title;
                private String rush_endTime;
                private String time;
                private String title;
                private String more_icon;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setRush_endTime(String rush_endTime) {
                    this.rush_endTime = rush_endTime;
                }
                public String getRush_endTime() {
                    return rush_endTime;
                }

                public void setTime(String time) {
                    this.time = time;
                }
                public String getTime() {
                    return time;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
                public String getTitle() {
                    return title;
                }

                public void setMore_icon(String more_icon) {
                    this.more_icon = more_icon;
                }
                public String getMore_icon() {
                    return more_icon;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String gid;
                    private String image;
                    private String img_size;
                    private String little_price;
                    private String sale_price;
                    private String tid;
                    private String title;
                    private String mode;
                    public void setGid(String gid) {
                        this.gid = gid;
                    }
                    public String getGid() {
                        return gid;
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

                    public void setLittle_price(String little_price) {
                        this.little_price = little_price;
                    }
                    public String getLittle_price() {
                        return little_price;
                    }

                    public void setSale_price(String sale_price) {
                        this.sale_price = sale_price;
                    }
                    public String getSale_price() {
                        return sale_price;
                    }

                    public void setTid(String tid) {
                        this.tid = tid;
                    }
                    public String getTid() {
                        return tid;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                    public String getTitle() {
                        return title;
                    }

                    public void setMode(String mode) {
                        this.mode = mode;
                    }
                    public String getMode() {
                        return mode;
                    }
            }
        }
        //新品馆 6
        public static class Xpg {
                private int code;
                private String type_name;
                private String type_title;
                private String rush_endTime;
                private String time;
                private String title;
                private String more_icon;
                private boolean mode_divide;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setRush_endTime(String rush_endTime) {
                    this.rush_endTime = rush_endTime;
                }
                public String getRush_endTime() {
                    return rush_endTime;
                }

                public void setTime(String time) {
                    this.time = time;
                }
                public String getTime() {
                    return time;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
                public String getTitle() {
                    return title;
                }

                public void setMore_icon(String more_icon) {
                    this.more_icon = more_icon;
                }
                public String getMore_icon() {
                    return more_icon;
                }

                public void setMode_divide(boolean mode_divide) {
                    this.mode_divide = mode_divide;
                }
                public boolean getMode_divide() {
                    return mode_divide;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private boolean long_mode;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setLong_mode(boolean long_mode) {
                        this.long_mode = long_mode;
                    }
                    public boolean getLong_mode() {
                        return long_mode;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        //轮播图（预告）
        public static class Banner2 {
                private int code;
                private String type_name;
                private String type_title;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{

                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        //品质特卖标题
        public static class Pztmtitle {
                private int code;
                private String type_name;
                private String type_title;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String type;
                    private String image;
                    private String img_size;
                    private String orientation;
                    private String web;
                    public void setType(String type) {
                        this.type = type;
                    }
                    public String getType() {
                        return type;
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

                    public void setOrientation(String orientation) {
                        this.orientation = orientation;
                    }
                    public String getOrientation() {
                        return orientation;
                    }

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        //品质特卖
        public static class Pztmimage1 {
                private int code;
                private String type_name;
                private String type_title;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        public static class Pztmimage2 {
                private int code;
                private String type_name;
                private String type_title;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        public static class Pztmimage3 {
                private int code;
                private String type_name;
                private String type_title;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        public static class Pztmimage4 {
                private int code;
                private String type_name;
                private String type_title;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        public static class Pztmimage5 {
                private int code;
                private String type_name;
                private String type_title;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        public static class Pztmimage6 {
                private int code;
                private String type_name;
                private String type_title;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        //VIP俱乐部
        public static class Viptitle {
                private int code;
                private String type_name;
                private String type_title;
                private String type;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setType(String type) {
                    this.type = type;
                }
                public String getType() {
                    return type;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String image;
                    private String img_size;
                    private String type;
                    private String orientation;
                    private String web;
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

                    public void setType(String type) {
                        this.type = type;
                    }
                    public String getType() {
                        return type;
                    }

                    public void setOrientation(String orientation) {
                        this.orientation = orientation;
                    }
                    public String getOrientation() {
                        return orientation;
                    }

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        public static class Vipbanner1 {
                private int code;
                private String type_name;
                private String type_title;
                private String type;
                private String rush_endTime;
                private String time;
                private String title;
                private String more_icon;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setType(String type) {
                    this.type = type;
                }
                public String getType() {
                    return type;
                }

                public void setRush_endTime(String rush_endTime) {
                    this.rush_endTime = rush_endTime;
                }
                public String getRush_endTime() {
                    return rush_endTime;
                }

                public void setTime(String time) {
                    this.time = time;
                }
                public String getTime() {
                    return time;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
                public String getTitle() {
                    return title;
                }

                public void setMore_icon(String more_icon) {
                    this.more_icon = more_icon;
                }
                public String getMore_icon() {
                    return more_icon;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        //萌爪联盟
        public static class Mzlmtitle {
                private int code;
                private String type_name;
                private String type_title;
                private String type;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setType(String type) {
                    this.type = type;
                }
                public String getType() {
                    return type;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String image;
                    private String img_size;
                    private String type;
                    private String orientation;
                    private String web;
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

                    public void setType(String type) {
                        this.type = type;
                    }
                    public String getType() {
                        return type;
                    }

                    public void setOrientation(String orientation) {
                        this.orientation = orientation;
                    }
                    public String getOrientation() {
                        return orientation;
                    }

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        public static class Mzlmbanner {
                private int code;
                private String type_name;
                private String type_title;
                private String type;
                private String rush_endTime;
                private String time;
                private String title;
                private String more_icon;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setType(String type) {
                    this.type = type;
                }
                public String getType() {
                    return type;
                }

                public void setRush_endTime(String rush_endTime) {
                    this.rush_endTime = rush_endTime;
                }
                public String getRush_endTime() {
                    return rush_endTime;
                }

                public void setTime(String time) {
                    this.time = time;
                }
                public String getTime() {
                    return time;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
                public String getTitle() {
                    return title;
                }

                public void setMore_icon(String more_icon) {
                    this.more_icon = more_icon;
                }
                public String getMore_icon() {
                    return more_icon;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String advid;
                    private String atid;
                    private String image;
                    private String img_size;
                    private String web;
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

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        //小剧场
        public static class Xjctitle {
                private int code;
                private String type_name;
                private String type_title;
                private String type;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setType(String type) {
                    this.type = type;
                }
                public String getType() {
                    return type;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String image;
                    private String img_size;
                    private String type;
                    private String orientation;
                    private String web;
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

                    public void setType(String type) {
                        this.type = type;
                    }
                    public String getType() {
                        return type;
                    }

                    public void setOrientation(String orientation) {
                        this.orientation = orientation;
                    }
                    public String getOrientation() {
                        return orientation;
                    }

                    public void setWeb(String web) {
                        this.web = web;
                    }
                    public String getWeb() {
                        return web;
                    }
            }
        }
        public static class Xjcbanner {
                private int code;
                private String type_name;
                private String type_title;
                private String type;
                private String rush_endTime;
                private String time;
                private String title;
                private String more_icon;
                private int num;
                private List<Value> value;
                public void setCode(int code) {
                    this.code = code;
                }
                public int getCode() {
                    return code;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
                public String getType_name() {
                    return type_name;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }
                public String getType_title() {
                    return type_title;
                }

                public void setType(String type) {
                    this.type = type;
                }
                public String getType() {
                    return type;
                }

                public void setRush_endTime(String rush_endTime) {
                    this.rush_endTime = rush_endTime;
                }
                public String getRush_endTime() {
                    return rush_endTime;
                }

                public void setTime(String time) {
                    this.time = time;
                }
                public String getTime() {
                    return time;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
                public String getTitle() {
                    return title;
                }

                public void setMore_icon(String more_icon) {
                    this.more_icon = more_icon;
                }
                public String getMore_icon() {
                    return more_icon;
                }

                public void setNum(int num) {
                    this.num = num;
                }
                public int getNum() {
                    return num;
                }

                public void setValue(List<Value> value) {
                    this.value = value;
                }
                public List<Value> getValue() {
                    return value;
                }
            public static class Value{
                    private String title_image;
                    private String img_size;
                    private String link;
                    private String content;
                    private String image;
                    private String title;
                    private String types;
                    private String url;
                    public void setTitle_image(String title_image) {
                        this.title_image = title_image;
                    }
                    public String getTitle_image() {
                        return title_image;
                    }

                    public void setImg_size(String img_size) {
                        this.img_size = img_size;
                    }
                    public String getImg_size() {
                        return img_size;
                    }

                    public void setLink(String link) {
                        this.link = link;
                    }
                    public String getLink() {
                        return link;
                    }

                    public void setContent(String content) {
                        this.content = content;
                    }
                    public String getContent() {
                        return content;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }
                    public String getImage() {
                        return image;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                    public String getTitle() {
                        return title;
                    }

                    public void setTypes(String types) {
                        this.types = types;
                    }
                    public String getTypes() {
                        return types;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                    public String getUrl() {
                        return url;
                    }
            }
        }
        public void setBanner1(Banner1 banner1) {
            this.banner1 = banner1;
        }

        public Banner1 getBanner1() {
            return banner1;
        }

        public void setMenu1(Menu1 menu1) {
            this.menu1 = menu1;
        }

        public Menu1 getMenu1() {
            return menu1;
        }

        public void setMenu2(Menu2 menu2) {
            this.menu2 = menu2;
        }

        public Menu2 getMenu2() {
            return menu2;
        }

        public void setNewperson(Newperson newperson) {
            this.newperson = newperson;
        }

        public Newperson getNewperson() {
            return newperson;
        }

        public void setDayfq(Dayfq dayfq) {
            this.dayfq = dayfq;
        }

        public Dayfq getDayfq() {
            return dayfq;
        }

        public void setXpg(Xpg xpg) {
            this.xpg = xpg;
        }

        public Xpg getXpg() {
            return xpg;
        }

        public void setBanner2(Banner2 banner2) {
            this.banner2 = banner2;
        }

        public Banner2 getBanner2() {
            return banner2;
        }

        public void setPztmtitle(Pztmtitle pztmtitle) {
            this.pztmtitle = pztmtitle;
        }

        public Pztmtitle getPztmtitle() {
            return pztmtitle;
        }

        public void setPztmimage1(Pztmimage1 pztmimage1) {
            this.pztmimage1 = pztmimage1;
        }

        public Pztmimage1 getPztmimage1() {
            return pztmimage1;
        }

        public void setPztmimage2(Pztmimage2 pztmimage2) {
            this.pztmimage2 = pztmimage2;
        }

        public Pztmimage2 getPztmimage2() {
            return pztmimage2;
        }

        public void setPztmimage3(Pztmimage3 pztmimage3) {
            this.pztmimage3 = pztmimage3;
        }

        public Pztmimage3 getPztmimage3() {
            return pztmimage3;
        }

        public void setPztmimage4(Pztmimage4 pztmimage4) {
            this.pztmimage4 = pztmimage4;
        }

        public Pztmimage4 getPztmimage4() {
            return pztmimage4;
        }

        public void setPztmimage5(Pztmimage5 pztmimage5) {
            this.pztmimage5 = pztmimage5;
        }

        public Pztmimage5 getPztmimage5() {
            return pztmimage5;
        }

        public void setPztmimage6(Pztmimage6 pztmimage6) {
            this.pztmimage6 = pztmimage6;
        }

        public Pztmimage6 getPztmimage6() {
            return pztmimage6;
        }

        public void setViptitle(Viptitle viptitle) {
            this.viptitle = viptitle;
        }

        public Viptitle getViptitle() {
            return viptitle;
        }

        public void setVipbanner1(Vipbanner1 vipbanner1) {
            this.vipbanner1 = vipbanner1;
        }

        public Vipbanner1 getVipbanner1() {
            return vipbanner1;
        }

        public void setMzlmtitle(Mzlmtitle mzlmtitle) {
            this.mzlmtitle = mzlmtitle;
        }

        public Mzlmtitle getMzlmtitle() {
            return mzlmtitle;
        }

        public void setMzlmbanner(Mzlmbanner mzlmbanner) {
            this.mzlmbanner = mzlmbanner;
        }

        public Mzlmbanner getMzlmbanner() {
            return mzlmbanner;
        }

        public void setXjctitle(Xjctitle xjctitle) {
            this.xjctitle = xjctitle;
        }

        public Xjctitle getXjctitle() {
            return xjctitle;
        }

        public void setXjcbanner(Xjcbanner xjcbanner) {
            this.xjcbanner = xjcbanner;
        }

        public Xjcbanner getXjcbanner() {
            return xjcbanner;
        }
    }
    public static class Tabdata{}
}