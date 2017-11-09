package com.phicomm.product.manger.model.feedback;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 用户基本信息及反馈意见基本信息
 *
 * @author wei.yang on 2017/10/30
 */
public class FeedbackWithUserInfo extends BasicDeviceBean {

    private int id;

    private String appId;

    private String userId;

    private String username;

    private String imageUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String sessionId;

    private String deviceType;

    private String feedbackStatus;

    private List<DialogWithSessionId> dialogBeans;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String getDeviceType() {
        return deviceType;
    }

    @Override
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(String feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    public List<DialogWithSessionId> getDialogBeans() {
        return dialogBeans;
    }

    public void setDialogBeans(List<DialogWithSessionId> dialogBeans) {
        this.dialogBeans = dialogBeans;
    }

    @Override
    public String toString() {
        return "FeedbackWithUserInfo{" +
                "id=" + id +
                ", appId='" + appId + '\'' +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createTime=" + createTime +
                ", sessionId='" + sessionId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", feedbackStatus='" + feedbackStatus + '\'' +
                ", dialogBeans=" + dialogBeans +
                '}';
    }
}
