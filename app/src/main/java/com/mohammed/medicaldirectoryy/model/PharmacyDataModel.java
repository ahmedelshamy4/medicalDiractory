package com.mohammed.medicaldirectoryy.model;

import java.util.List;

/**
 * Created by mohammed on 5/10/17.
 */

public class PharmacyDataModel {


    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * objectId : odFUqnzmIw
         * name : Derma 360 Clinic
         * createdAt : 2017-05-03T00:14:27.324Z
         * updatedAt : 2017-05-10T18:49:52.959Z
         * address :  141 Ahmed Orabi, Borg El Ezz, Ismailia
         * telephone : 0122 299 1777
         * lat : 30.592129
         * lang : 32.270869
         * images : {"__type":"File","name":"e3c8282b2dd94393ab61fa62a8d807dc_1.JPG","url":"https://parsefiles.back4app.com/986hZ4VqtAEXSwJpcn9MjK1U4YbTR1z2MKW6ZZGz/e3c8282b2dd94393ab61fa62a8d807dc_1.JPG"}
         */

        private String objectId;
        private String name;
        private String createdAt;
        private String updatedAt;
        private String address;
        private String telephone;
        private double lat;
        private double lang;
        private ImagesBean images;

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLang() {
            return lang;
        }

        public void setLang(double lang) {
            this.lang = lang;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public static class ImagesBean {
            /**
             * __type : File
             * name : e3c8282b2dd94393ab61fa62a8d807dc_1.JPG
             * url : https://parsefiles.back4app.com/986hZ4VqtAEXSwJpcn9MjK1U4YbTR1z2MKW6ZZGz/e3c8282b2dd94393ab61fa62a8d807dc_1.JPG
             */

            private String __type;
            private String name;
            private String url;

            public String get__type() {
                return __type;
            }

            public void set__type(String __type) {
                this.__type = __type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
