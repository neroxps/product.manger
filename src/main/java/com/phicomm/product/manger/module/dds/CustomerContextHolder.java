package com.phicomm.product.manger.module.dds;

import com.google.common.base.Strings;

public class CustomerContextHolder {

    /**
     *  {product_manager库} 主要的数据源
     */
    private static final String MAIN_DATA_SOURCE = "localDataSource";

    /**
     * {smart_hardware库} 测试环境数据库
     */
    private static final String TEST_DATA_SOURCE = "testDataSource";

    /**
     * {smart_hardware库} 线上的数据库
     */
    private static final String PROD_DATA_SOURCE = "prodDataSource";

    /**
     * {smart_hardware_oversea库} 海外测试环境的数据库
     */
    private static final String TEST_OVERSEA_DATA_SOURCE = "testOverseaDataSource";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 如果没有设置，那就取默认的数据源maxscale，否则选择该数据源
     */
    public static String getCustomerType() {
        String datasource = contextHolder.get();
        if (Strings.isNullOrEmpty(datasource)) {
            return MAIN_DATA_SOURCE;
        }
        return datasource;
    }

    /**
     *  {smart_hardware库} 选择线上的数据源
     */
    public static void selectProdDataSource() {
        contextHolder.set(PROD_DATA_SOURCE);
    }

    /**
     * {product_manager库} 选择本地的数据源
     */
    public static void selectLocalDataSource() {
        contextHolder.set(MAIN_DATA_SOURCE);
    }

    /**
     * {smart_hardware库} 选择测试环境数据源
     */
    public static void selectTestDataSource() {
        contextHolder.set(TEST_DATA_SOURCE);
    }

    /**
     * {smart_hardware_oversea库} 海外版测试环境数据源
     */
    public static void selectTestOverseaDataSource() {
        contextHolder.set(TEST_OVERSEA_DATA_SOURCE);
    }

    /**
     * 清除数据源选择项
     */
    public static void clearDataSource() {
        contextHolder.set(MAIN_DATA_SOURCE);
    }
}  