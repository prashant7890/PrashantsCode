
package com.cloudamize.functional.cmp.bean.resourceController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Url {

    @SerializedName("authority")
    @Expose
    private String authority;
    @SerializedName("content")
    @Expose
    private Content content;
    @SerializedName("defaultPort")
    @Expose
    private Integer defaultPort;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("port")
    @Expose
    private Integer port;
    @SerializedName("protocol")
    @Expose
    private String protocol;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("ref")
    @Expose
    private String ref;
    @SerializedName("userInfo")
    @Expose
    private String userInfo;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Integer getDefaultPort() {
        return defaultPort;
    }

    public void setDefaultPort(Integer defaultPort) {
        this.defaultPort = defaultPort;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

}
