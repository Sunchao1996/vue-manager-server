package com.sc.core.pub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 全局参数配置，用于在后端获取参数
 *
 * @author 王晓安
 */
@Component
public class PubConfig {

    /**
     * 图片显示服务器地址
     */
    @Value("${imageServer}")
    private String imageServer;

    /**
     * 图片路径
     */
    @Value("${imageUploadPath}")
    private String imageUploadPath;

    /**
     * 静态地址
     */
    private String staticServer;

    /**
     * 动态地址
     */
    private String dynamicServer;

    /**
     * 网站title
     */
    private String webTitle;

    @Override
    public String toString() {
        return "PubConfig{" +
                "imageServer='" + imageServer + '\'' +
                ", imageUploadPath='" + imageUploadPath + '\'' +
                ", staticServer='" + staticServer + '\'' +
                ", dynamicServer='" + dynamicServer + '\'' +
                ", webTitle='" + webTitle + '\'' +
                '}';
    }

    public String getImageServer() {
        return imageServer;
    }

    public void setImageServer(String imageServer) {
        this.imageServer = imageServer;
    }

    public String getImageUploadPath() {
        return imageUploadPath;
    }

    public void setImageUploadPath(String imageUploadPath) {
        this.imageUploadPath = imageUploadPath;
    }

    public String getStaticServer() {
        return staticServer;
    }

    public void setStaticServer(String staticServer) {
        this.staticServer = staticServer;
    }

    public String getDynamicServer() {
        return dynamicServer;
    }

    public void setDynamicServer(String dynamicServer) {
        this.dynamicServer = dynamicServer;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }
}
