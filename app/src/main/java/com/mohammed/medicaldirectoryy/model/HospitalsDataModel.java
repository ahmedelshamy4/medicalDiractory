package com.mohammed.medicaldirectoryy.model;

import java.util.List;

/**
 * Created by mohammed on 5/10/17.
 */

public class HospitalsDataModel {


    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * objectId : UzhzycPJ3S
         * name : El Ismaileya General Hospital
         * createdAt : 2017-05-03T00:40:57.542Z
         * updatedAt : 2017-05-10T18:24:51.439Z
         * telephone :  0643213902
         * address :  Sabry Magdy St , In Front Of Health Insurance Complex, Ring Road, Ismaileya
         Ring Road, Ismailia
         * lat : 30.620969
         * lang : 32.28747
         * image : {"__type":"File","name":"248e2c52801256539e563f7037dc4e55_1.jpg","url":"https://parsefiles.back4app.com/986hZ4VqtAEXSwJpcn9MjK1U4YbTR1z2MKW6ZZGz/248e2c52801256539e563f7037dc4e55_1.jpg"}
         */

        private String objectId;
        private String name;
        private String createdAt;
        private String updatedAt;
        private String telephone;
        private String address;
        private double lat;
        private double lang;
        private ImageBean image;

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

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public ImageBean getImage() {
            return image;
        }

        public void setImage(ImageBean image) {
            this.image = image;
        }

        public static class ImageBean {
            /**
             * __type : File
             * name : 248e2c52801256539e563f7037dc4e55_1.jpg
             * url : https://parsefiles.back4app.com/986hZ4VqtAEXSwJpcn9MjK1U4YbTR1z2MKW6ZZGz/248e2c52801256539e563f7037dc4e55_1.jpg
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
