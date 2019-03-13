package cn.lovepet.shops.bean;

import java.util.List;

import cn.lovepet.shops.helper.basequickadapter.entity.MultiItemEntity;
import cn.lovepet.shops.net.basequick.MultipleItem;

/**
 * @author JSYL-DCL
 * @date 2018/10/30 11:08
 * @des
 */
public class PetDogTabHomeBean extends MultipleItem {
        private List<DogListData> data;
        private Tabdata tabdata;
        private String message;
        private int status;
        private boolean gos;

    public static class Tabdata {

    }
    public static class DogListData implements MultiItemEntity {
        public static final int MULTISIZEIMAGE = 0;
        public static final int BANNER = 1;
        public static final int TITLE = 2;
        public static final int MENU = 3;
        public static final int MENU2 = 4;
        public static final int HORIZONTAL_SCOROLL = 5;
        public static final int IMG = 6;
        public static final int VIDEO = 7;
        public static final int FOOTER = 13;

        private int code;
        private String type_name;
        private String type_title;
        private String rush_endTime;
        private String time;
        private String title;
        private String type;
        private int typeInt;
        private String more_icon;
        private int num;
        private String image;
        private String leftimage;
        private String rightimage;
        private List<Value> value;

        public String getLeftimage() {
            return leftimage;
        }

        public void setLeftimage(String leftimage) {
            this.leftimage = leftimage;
        }

        public String getRightimage() {
            return rightimage;
        }

        public void setRightimage(String rightimage) {
            this.rightimage = rightimage;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getTypeInt() {
            return typeInt;
        }

        public void setTypeInt(int typeInt) {
            this.typeInt = typeInt;
        }

        public void setCode(int code) {
            this.code = code;
        }

        @Override
        public int getItemType() {
            return typeInt;
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
                private String title_image;
                private String link;
                private String content;
                private String types;
                private String url;
                private String type;
                private String orientation;
                private String web;
                private String advid;
                private String atid;


                private int watchnum;//播放量
                private String totaltime;//总时长

            public int getWatchnum() {
                return watchnum;
            }

            public void setWatchnum(int watchnum) {
                this.watchnum = watchnum;
            }

            public String getTotaltime() {
                return totaltime;
            }

            public void setTotaltime(String totaltime) {
                this.totaltime = totaltime;
            }

            public String getTitle_image() {
                return title_image;
            }

            public void setTitle_image(String title_image) {
                this.title_image = title_image;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getTypes() {
                return types;
            }

            public void setTypes(String types) {
                this.types = types;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getOrientation() {
                return orientation;
            }

            public void setOrientation(String orientation) {
                this.orientation = orientation;
            }

            public String getWeb() {
                return web;
            }

            public void setWeb(String web) {
                this.web = web;
            }

            public String getAdvid() {
                return advid;
            }

            public void setAdvid(String advid) {
                this.advid = advid;
            }

            public String getAtid() {
                return atid;
            }

            public void setAtid(String atid) {
                this.atid = atid;
            }

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
    }


    /**
     * 1
     */
        public void setData(List<DogListData> data) {
            this.data = data;
        }
        public List<DogListData> getData() {
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
}