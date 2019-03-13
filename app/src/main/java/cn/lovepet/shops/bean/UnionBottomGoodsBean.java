package cn.lovepet.shops.bean;

import java.util.List;

/**
 * @author JSYL-DCL
 * @date 2018/12/13 15:48
 * @des 联盟-底部分类列表
 */
public class UnionBottomGoodsBean {
    private String code;
    private List<Dog2catgoods> dog2catgoods;
    private String epet_site;
    private String hash;
    private int login_status;
    private String mall_uid;
    private String mall_user;
    private String msg;
    private long sys_time;

    /**
     * Doggoods
     */
    public class Dog2catgoods {
        private String name;
        private String type;
        private int pos;
        private List<Listgoods> listgoods;

        /**
         * Listgoods
         */
        public class Listgoods {
            private String comment_K;
            private List<Cover> cover;
            private int is_zan;
            private String showtime;
            private String taid;
            private Target target;
            private String title;
            private String trid;
            private int type;
            private String uid;
            private User user;
            private String view_K;
            private String zan;
            private String zan_K;
            /**
             * Cover
             */
            public class Cover {

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

            /**
             * User
             */
            public class User {
                private Avatar avatar;
                private String petmsg;
                private List<Role> role;
                private String username;

                /**
                 * Avatar
                 */
                public class Avatar {

                    private String image;
                    private String img_size;
                    private Target target;
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
                 * Role
                 */
                public class Role {

                    private String background;
                    private String color;
                    private String title;
                    public void setBackground(String background) {
                        this.background = background;
                    }
                    public String getBackground() {
                        return background;
                    }

                    public void setColor(String color) {
                        this.color = color;
                    }
                    public String getColor() {
                        return color;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                    public String getTitle() {
                        return title;
                    }

                }


                public void setAvatar(Avatar avatar) {
                    this.avatar = avatar;
                }
                public Avatar getAvatar() {
                    return avatar;
                }

                public void setPetmsg(String petmsg) {
                    this.petmsg = petmsg;
                }
                public String getPetmsg() {
                    return petmsg;
                }

                public void setRole(List<Role> role) {
                    this.role = role;
                }
                public List<Role> getRole() {
                    return role;
                }

                public void setUsername(String username) {
                    this.username = username;
                }
                public String getUsername() {
                    return username;
                }

            }



            public void setComment_K(String comment_K) {
                this.comment_K = comment_K;
            }
            public String getComment_K() {
                return comment_K;
            }

            public void setCover(List<Cover> cover) {
                this.cover = cover;
            }
            public List<Cover> getCover() {
                return cover;
            }

            public void setIs_zan(int is_zan) {
                this.is_zan = is_zan;
            }
            public int getIs_zan() {
                return is_zan;
            }

            public void setShowtime(String showtime) {
                this.showtime = showtime;
            }
            public String getShowtime() {
                return showtime;
            }

            public void setTaid(String taid) {
                this.taid = taid;
            }
            public String getTaid() {
                return taid;
            }

            public void setTarget(Target target) {
                this.target = target;
            }
            public Target getTarget() {
                return target;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setTrid(String trid) {
                this.trid = trid;
            }
            public String getTrid() {
                return trid;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
            public String getUid() {
                return uid;
            }

            public void setUser(User user) {
                this.user = user;
            }
            public User getUser() {
                return user;
            }

            public void setView_K(String view_K) {
                this.view_K = view_K;
            }
            public String getView_K() {
                return view_K;
            }

            public void setZan(String zan) {
                this.zan = zan;
            }
            public String getZan() {
                return zan;
            }

            public void setZan_K(String zan_K) {
                this.zan_K = zan_K;
            }
            public String getZan_K() {
                return zan_K;
            }

        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
        public int getPos() {
            return pos;
        }

        public void setListgoods(List<Listgoods> listgoods) {
            this.listgoods = listgoods;
        }
        public List<Listgoods> getListgoods() {
            return listgoods;
        }
    }

    /**
     * Doggoods
     */
    public class Catgoods {
        private String name;
        private String type;
        private int pos;
        private List<Listgoods> listgoods;

        /**
         * Listgoods
         */
        public class Listgoods {
            private String comment_K;
            private List<Cover> cover;
            private int is_zan;
            private String showtime;
            private String taid;
            private Target target;
            private String title;
            private String trid;
            private int type;
            private String uid;
            private User user;
            private String view_K;
            private String zan;
            private String zan_K;
            /**
             * Cover
             */
            public class Cover {

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

            /**
             * User
             */
            public class User {
                private Avatar avatar;
                private String petmsg;
                private List<Role> role;
                private String username;

                /**
                 * Avatar
                 */
                public class Avatar {

                    private String image;
                    private String img_size;
                    private Target target;
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
                 * Role
                 */
                public class Role {

                    private String background;
                    private String color;
                    private String title;
                    public void setBackground(String background) {
                        this.background = background;
                    }
                    public String getBackground() {
                        return background;
                    }

                    public void setColor(String color) {
                        this.color = color;
                    }
                    public String getColor() {
                        return color;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                    public String getTitle() {
                        return title;
                    }

                }


                public void setAvatar(Avatar avatar) {
                    this.avatar = avatar;
                }
                public Avatar getAvatar() {
                    return avatar;
                }

                public void setPetmsg(String petmsg) {
                    this.petmsg = petmsg;
                }
                public String getPetmsg() {
                    return petmsg;
                }

                public void setRole(List<Role> role) {
                    this.role = role;
                }
                public List<Role> getRole() {
                    return role;
                }

                public void setUsername(String username) {
                    this.username = username;
                }
                public String getUsername() {
                    return username;
                }

            }



            public void setComment_K(String comment_K) {
                this.comment_K = comment_K;
            }
            public String getComment_K() {
                return comment_K;
            }

            public void setCover(List<Cover> cover) {
                this.cover = cover;
            }
            public List<Cover> getCover() {
                return cover;
            }

            public void setIs_zan(int is_zan) {
                this.is_zan = is_zan;
            }
            public int getIs_zan() {
                return is_zan;
            }

            public void setShowtime(String showtime) {
                this.showtime = showtime;
            }
            public String getShowtime() {
                return showtime;
            }

            public void setTaid(String taid) {
                this.taid = taid;
            }
            public String getTaid() {
                return taid;
            }

            public void setTarget(Target target) {
                this.target = target;
            }
            public Target getTarget() {
                return target;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            public String getTitle() {
                return title;
            }

            public void setTrid(String trid) {
                this.trid = trid;
            }
            public String getTrid() {
                return trid;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
            public String getUid() {
                return uid;
            }

            public void setUser(User user) {
                this.user = user;
            }
            public User getUser() {
                return user;
            }

            public void setView_K(String view_K) {
                this.view_K = view_K;
            }
            public String getView_K() {
                return view_K;
            }

            public void setZan(String zan) {
                this.zan = zan;
            }
            public String getZan() {
                return zan;
            }

            public void setZan_K(String zan_K) {
                this.zan_K = zan_K;
            }
            public String getZan_K() {
                return zan_K;
            }

        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
        public int getPos() {
            return pos;
        }

        public void setListgoods(List<Listgoods> listgoods) {
            this.listgoods = listgoods;
        }
        public List<Listgoods> getListgoods() {
            return listgoods;
        }
    }


    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public List<Dog2catgoods> getDog2catgoods() {
        return dog2catgoods;
    }

    public void setDog2catgoods(List<Dog2catgoods> dog2catgoods) {
        this.dog2catgoods = dog2catgoods;
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
