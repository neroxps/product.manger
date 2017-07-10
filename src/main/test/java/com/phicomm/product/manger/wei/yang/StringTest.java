package com.phicomm.product.manger.wei.yang;

import com.google.common.base.Strings;
import com.phicomm.product.manger.model.statistic.BalanceLocationBean;
import org.junit.Test;

/**
 * test
 * Created by wei.yang on 2017/7/4.
 */
public class StringTest {

    @Test
    public void test(){
        System.out.println("5c:cf:7f:41:77:cf".length());
        System.out.println("A020A6351AD5".length());
    }

    @Test
    public void test1(){
        System.out.println(formatMac("A020A6351AD5"));
    }

    private String formatMac(String mac){
        int len=mac.length();
        StringBuilder builder=new StringBuilder();
        if (mac.length()==17){
            return mac.toLowerCase();
        }else {
            for (int i=0;i<len/2;i++){
                builder.append(mac.subSequence(2*i,2*i+2));
                if (!(i==len/2-1)){
                    builder.append(":");
                }
            }
            return builder.toString().toLowerCase();
        }
    }

    @Test
    public void test2(){
        BalanceLocationBean locationBean=new BalanceLocationBean();
        locationBean.setActiveCity("市");
        locationBean.setActiveCountry("国家");
        locationBean.setActiveCounty("县");
        locationBean.setActiveProvince("省");
        System.out.println(formatLocation(locationBean));
    }

    private String formatLocation(BalanceLocationBean locationBean) {
        if (locationBean == null) {
            return "未知地点";
        }
        StringBuilder builder = new StringBuilder();
        String country = locationBean.getActiveCountry();
        String province = locationBean.getActiveProvince();
        String city = locationBean.getActiveCity();
        String county = locationBean.getActiveCounty();
        if (!Strings.isNullOrEmpty(country)) {
            builder.append(country);
            if (!Strings.isNullOrEmpty(province)) {
                builder.append("、").append(province);
                if (!Strings.isNullOrEmpty(city)) {
                    builder.append("、").append(city);
                    if (!Strings.isNullOrEmpty(county)) {
                        builder.append("、").append(county);
                    }
                }
            }
        } else {
            return "未知地点";
        }
        return builder.toString();
    }
}