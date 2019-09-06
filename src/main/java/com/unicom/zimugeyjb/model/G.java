package com.unicom.zimugeyjb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/6 19:05 <br/>
 * @Author: yangjiabin
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class G {


    /**
     * mainImageUrl : 1.jpg
     * recipeDtailItemVoList : [{"fridayDishName":"2","fridayDishPrice":3,"mondayDishName":"4","mondayDishPrice":5,"recipeCategoryName":"早餐","saturdayDishName":"6","saturdayDishPrice":7,"sundayDishName":"8","sundayDishPrice":9,"thursdayDishName":"10","thursdayDishPrice":11,"tuesdayDishName":"12","tuesdayDishPrice":13,"wednesdayDishName":"14","wednesdayDishPrice":15},{"fridayDishName":"16","fridayDishPrice":17,"mondayDishName":"18","mondayDishPrice":19,"recipeCategoryName":"早餐","saturdayDishName":"20","saturdayDishPrice":21,"sundayDishName":"22","sundayDishPrice":23,"thursdayDishName":"24","thursdayDishPrice":25,"tuesdayDishName":"26","tuesdayDishPrice":27,"wednesdayDishName":"28","wednesdayDishPrice":29}]
     * title : 标题30
     */

    private String mainImageUrl;
    private String title;
    private List<RecipeDtailItemVoListBean> recipeDtailItemVoList;


    public G() {
    }

    @Data
    @AllArgsConstructor
//@NoArgsConstructor
//    @Builder
    public static class RecipeDtailItemVoListBean {
        /**
         * fridayDishName : 2
         * fridayDishPrice : 3
         * mondayDishName : 4
         * mondayDishPrice : 5
         * recipeCategoryName : 早餐
         * saturdayDishName : 6
         * saturdayDishPrice : 7
         * sundayDishName : 8
         * sundayDishPrice : 9
         * thursdayDishName : 10
         * thursdayDishPrice : 11
         * tuesdayDishName : 12
         * tuesdayDishPrice : 13
         * wednesdayDishName : 14
         * wednesdayDishPrice : 15
         */

        private String fridayDishName;
        private int fridayDishPrice;
        private String mondayDishName;
        private int mondayDishPrice;
        private String recipeCategoryName;
        private String saturdayDishName;
        private int saturdayDishPrice;
        private String sundayDishName;
        private int sundayDishPrice;
        private String thursdayDishName;
        private int thursdayDishPrice;
        private String tuesdayDishName;
        private int tuesdayDishPrice;
        private String wednesdayDishName;
        private int wednesdayDishPrice;

        public RecipeDtailItemVoListBean() {
        }

        public String getFridayDishName() {
            return fridayDishName;
        }

        public void setFridayDishName(String fridayDishName) {
            this.fridayDishName = fridayDishName;
        }

        public int getFridayDishPrice() {
            return fridayDishPrice;
        }

        public void setFridayDishPrice(int fridayDishPrice) {
            this.fridayDishPrice = fridayDishPrice;
        }

        public String getMondayDishName() {
            return mondayDishName;
        }

        public void setMondayDishName(String mondayDishName) {
            this.mondayDishName = mondayDishName;
        }

        public int getMondayDishPrice() {
            return mondayDishPrice;
        }

        public void setMondayDishPrice(int mondayDishPrice) {
            this.mondayDishPrice = mondayDishPrice;
        }

        public String getRecipeCategoryName() {
            return recipeCategoryName;
        }

        public void setRecipeCategoryName(String recipeCategoryName) {
            this.recipeCategoryName = recipeCategoryName;
        }

        public String getSaturdayDishName() {
            return saturdayDishName;
        }

        public void setSaturdayDishName(String saturdayDishName) {
            this.saturdayDishName = saturdayDishName;
        }

        public int getSaturdayDishPrice() {
            return saturdayDishPrice;
        }

        public void setSaturdayDishPrice(int saturdayDishPrice) {
            this.saturdayDishPrice = saturdayDishPrice;
        }

        public String getSundayDishName() {
            return sundayDishName;
        }

        public void setSundayDishName(String sundayDishName) {
            this.sundayDishName = sundayDishName;
        }

        public int getSundayDishPrice() {
            return sundayDishPrice;
        }

        public void setSundayDishPrice(int sundayDishPrice) {
            this.sundayDishPrice = sundayDishPrice;
        }

        public String getThursdayDishName() {
            return thursdayDishName;
        }

        public void setThursdayDishName(String thursdayDishName) {
            this.thursdayDishName = thursdayDishName;
        }

        public int getThursdayDishPrice() {
            return thursdayDishPrice;
        }

        public void setThursdayDishPrice(int thursdayDishPrice) {
            this.thursdayDishPrice = thursdayDishPrice;
        }

        public String getTuesdayDishName() {
            return tuesdayDishName;
        }

        public void setTuesdayDishName(String tuesdayDishName) {
            this.tuesdayDishName = tuesdayDishName;
        }

        public int getTuesdayDishPrice() {
            return tuesdayDishPrice;
        }

        public void setTuesdayDishPrice(int tuesdayDishPrice) {
            this.tuesdayDishPrice = tuesdayDishPrice;
        }

        public String getWednesdayDishName() {
            return wednesdayDishName;
        }

        public void setWednesdayDishName(String wednesdayDishName) {
            this.wednesdayDishName = wednesdayDishName;
        }

        public int getWednesdayDishPrice() {
            return wednesdayDishPrice;
        }

        public void setWednesdayDishPrice(int wednesdayDishPrice) {
            this.wednesdayDishPrice = wednesdayDishPrice;
        }
    }
}
