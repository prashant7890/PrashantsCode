
package com.cloudamize.functional.cmp.bean.resourceController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uri {

    @SerializedName("absolute")
    @Expose
    private Boolean absolute;
    @SerializedName("authority")
    @Expose
    private String authority;
    @SerializedName("fragment")
    @Expose
    private String fragment;
    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("opaque")
    @Expose
    private Boolean opaque;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("port")
    @Expose
    private Integer port;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("rawAuthority")
    @Expose
    private String rawAuthority;
    @SerializedName("rawFragment")
    @Expose
    private String rawFragment;
    @SerializedName("rawPath")
    @Expose
    private String rawPath;
    @SerializedName("rawQuery")
    @Expose
    private String rawQuery;
    @SerializedName("rawSchemeSpecificPart")
    @Expose
    private String rawSchemeSpecificPart;
    @SerializedName("rawUserInfo")
    @Expose
    private String rawUserInfo;
    @SerializedName("scheme")
    @Expose
    private String scheme;
    @SerializedName("schemeSpecificPart")
    @Expose
    private String schemeSpecificPart;
    @SerializedName("userInfo")
    @Expose
    private String userInfo;

    public Boolean getAbsolute() {
        return absolute;
    }

    public void setAbsolute(Boolean absolute) {
        this.absolute = absolute;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Boolean getOpaque() {
        return opaque;
    }

    public void setOpaque(Boolean opaque) {
        this.opaque = opaque;
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

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRawAuthority() {
        return rawAuthority;
    }

    public void setRawAuthority(String rawAuthority) {
        this.rawAuthority = rawAuthority;
    }

    public String getRawFragment() {
        return rawFragment;
    }

    public void setRawFragment(String rawFragment) {
        this.rawFragment = rawFragment;
    }

    public String getRawPath() {
        return rawPath;
    }

    public void setRawPath(String rawPath) {
        this.rawPath = rawPath;
    }

    public String getRawQuery() {
        return rawQuery;
    }

    public void setRawQuery(String rawQuery) {
        this.rawQuery = rawQuery;
    }

    public String getRawSchemeSpecificPart() {
        return rawSchemeSpecificPart;
    }

    public void setRawSchemeSpecificPart(String rawSchemeSpecificPart) {
        this.rawSchemeSpecificPart = rawSchemeSpecificPart;
    }

    public String getRawUserInfo() {
        return rawUserInfo;
    }

    public void setRawUserInfo(String rawUserInfo) {
        this.rawUserInfo = rawUserInfo;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getSchemeSpecificPart() {
        return schemeSpecificPart;
    }

    public void setSchemeSpecificPart(String schemeSpecificPart) {
        this.schemeSpecificPart = schemeSpecificPart;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

}
