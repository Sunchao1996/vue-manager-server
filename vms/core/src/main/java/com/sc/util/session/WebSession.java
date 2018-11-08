package com.sc.util.session;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.Serializable;
import java.util.Arrays;

/**
 * web用户Session信息 该类可以根据实际信息进行修改
 *
 * @author 孔垂云
 * @date 2017-05-23
 */
public class WebSession implements Serializable {
    private String user;
    private String status;
    private String token;
    private String name;
    private String avatar;
    private String introduction;
    private String[] roles;
    private String resources;//用@分隔
    private String ip;
    private Integer userId;
    @JsonIgnore
    private String manageUrl;//用来校验是否允许访问这个请求地址

    @Override
    public String toString() {
        return "WebSession{" +
                "user='" + user + '\'' +
                ", status='" + status + '\'' +
                ", token='" + token + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", introduction='" + introduction + '\'' +
                ", roles=" + Arrays.toString(roles) +
                ", resources='" + resources + '\'' +
                ", ip='" + ip + '\'' +
                ", userId=" + userId +
                ", manageUrl='" + manageUrl + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public WebSession setUser(String user) {
        this.user = user;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public WebSession setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getToken() {
        return token;
    }

    public WebSession setToken(String token) {
        this.token = token;
        return this;
    }

    public String getName() {
        return name;
    }

    public WebSession setName(String name) {
        this.name = name;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public WebSession setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public WebSession setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String[] getRoles() {
        return roles;
    }

    public WebSession setRoles(String[] roles) {
        this.roles = roles;
        return this;
    }

    public String getResources() {
        return resources;
    }

    public WebSession setResources(String resources) {
        this.resources = resources;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public WebSession setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public WebSession setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getManageUrl() {
        return manageUrl;
    }

    public WebSession setManageUrl(String manageUrl) {
        this.manageUrl = manageUrl;
        return this;
    }
}
