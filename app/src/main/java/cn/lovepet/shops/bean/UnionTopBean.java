package cn.lovepet.shops.bean;


//import com.github.library.entity.MultiItemEntity;

import java.util.List;

import cn.lovepet.shops.helper.basequickadapter.entity.MultiItemEntity;

/**
 * @author JSYL-DCL
 * @date 2018/11/14 10:09
 * @des 联盟-上部分
 */
public class UnionTopBean {
    private List<Topdatas> topdatas;
    private String message;
    private String status;

    /**
     * Topdatas
     */
    public static class Topdatas implements MultiItemEntity {
        //体验
        public static final int TOPTIYAN = 0;
        //排行榜
        public static final int TOPRANK = 1;

        private int type;
        private List<Rank> rank;
        private Tiyan tiyan;

        @Override
        public int getItemType() {
            return type;
        }

        /**
         * Tiyan
         */
        public class Tiyan {
            private Bg bg;
            private String bgcolor;
            private Left left;
            private Right right;

            /**
             * Right
             */
            public class Right {

                private int content;
                private String image;
                private String img_size;
                public void setContent(int content) {
                    this.content = content;
                }
                public int getContent() {
                    return content;
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
            /**
             * Left
             */
            public class Left {

                private int content;
                private String image;
                private String img_size;
                public void setContent(int content) {
                    this.content = content;
                }
                public int getContent() {
                    return content;
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

            /**
             * Bg
             */
            public class Bg {

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


            public void setBg(Bg bg) {
                this.bg = bg;
            }
            public Bg getBg() {
                return bg;
            }

            public void setBgcolor(String bgcolor) {
                this.bgcolor = bgcolor;
            }
            public String getBgcolor() {
                return bgcolor;
            }

            public void setLeft(Left left) {
                this.left = left;
            }
            public Left getLeft() {
                return left;
            }

            public void setRight(Right right) {
                this.right = right;
            }
            public Right getRight() {
                return right;
            }

        }

        /**
         * Rank
         */
        public class Rank {
            private Avatar avatar;
            private String uid;
            private String username;

            /**
             * Avatar
             */
            public class Avatar {

                private String image;
                private String img_size;
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


            public void setAvatar(Avatar avatar) {
                this.avatar = avatar;
            }
            public Avatar getAvatar() {
                return avatar;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
            public String getUid() {
                return uid;
            }

            public void setUsername(String username) {
                this.username = username;
            }
            public String getUsername() {
                return username;
            }

        }

        public void setType(int type) {
            this.type = type;
        }
        public int getType() {
            return type;
        }

        public void setRank(List<Rank> rank) {
            this.rank = rank;
        }
        public List<Rank> getRank() {
            return rank;
        }

        public Tiyan getTiyan() {
            return tiyan;
        }

        public void setTiyan(Tiyan tiyan) {
            this.tiyan = tiyan;
        }
    }

    public void setTopdatas(List<Topdatas> topdatas) {
        this.topdatas = topdatas;
    }
    public List<Topdatas> getTopdatas() {
        return topdatas;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }


}
