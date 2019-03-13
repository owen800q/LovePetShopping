package cn.lovepet.shops.bean;

import java.util.List;

/**
 * @author JSYL-DCL
 * @date 2018/11/22 10:50
 * @des 地区一级列表
 */
public class PetAreaOneLevel {
        private String default_place_show;
        private String epet_site;
        private List<Places> places;

    /**
     * Places
     */
    public class Places {

        private String name;
        private int placeid;
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setPlaceid(int placeid) {
            this.placeid = placeid;
        }
        public int getPlaceid() {
            return placeid;
        }

    }
        public void setDefault_place_show(String default_place_show) {
            this.default_place_show = default_place_show;
        }
        public String getDefault_place_show() {
            return default_place_show;
        }

        public void setEpet_site(String epet_site) {
            this.epet_site = epet_site;
        }
        public String getEpet_site() {
            return epet_site;
        }

        public void setPlaces(List<Places> places) {
            this.places = places;
        }
        public List<Places> getPlaces() {
            return places;
        }
}