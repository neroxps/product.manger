package com.phicomm.product.manger.model.firmware;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FirmwareInfo {

    private Long id;

    private String appPlatform;

    private Integer appVersionCode;

    private String firmwareType;

    private String version;

    private float versionCode;

    private String environment;

    private String gnssVersion;

    private String hardwareCode;

    private String md5;

    private Integer enable;

    private Float size;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String url;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppPlatform() {
        return appPlatform;
    }

    public void setAppPlatform(String appPlatform) {
        this.appPlatform = appPlatform;
    }

    public Integer getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(Integer appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public String getFirmwareType() {
        return firmwareType;
    }

    public void setFirmwareType(String firmwareType) {
        this.firmwareType = firmwareType == null ? null : firmwareType.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public float getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(float versionCode) {
        this.versionCode = versionCode;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment == null ? null : environment.trim();
    }

    public String getHardwareCode() {
        return hardwareCode;
    }

    public void setHardwareCode(String hardwareCode) {
        this.hardwareCode = hardwareCode == null ? null : hardwareCode.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGnssVersion() {
        return gnssVersion;
    }

    public void setGnssVersion(String gnssVersion) {
        this.gnssVersion = gnssVersion;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "FirmwareInfo{" +
                "id=" + id +
                ", appPlatform='" + appPlatform + '\'' +
                ", appVersionCode=" + appVersionCode +
                ", firmwareType='" + firmwareType + '\'' +
                ", version='" + version + '\'' +
                ", versionCode=" + versionCode +
                ", environment='" + environment + '\'' +
                ", gnssVersion='" + gnssVersion + '\'' +
                ", hardwareCode='" + hardwareCode + '\'' +
                ", md5='" + md5 + '\'' +
                ", enable=" + enable +
                ", size=" + size +
                ", createTime=" + createTime +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}