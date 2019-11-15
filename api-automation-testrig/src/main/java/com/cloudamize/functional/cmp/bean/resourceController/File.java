
package com.cloudamize.functional.cmp.bean.resourceController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class File {

    @SerializedName("absolute")
    @Expose
    private Boolean absolute;
    @SerializedName("absolutePath")
    @Expose
    private String absolutePath;
    @SerializedName("canonicalPath")
    @Expose
    private String canonicalPath;
    @SerializedName("directory")
    @Expose
    private Boolean directory;
    @SerializedName("file")
    @Expose
    private Boolean file;
    @SerializedName("freeSpace")
    @Expose
    private Integer freeSpace;
    @SerializedName("hidden")
    @Expose
    private Boolean hidden;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("parent")
    @Expose
    private String parent;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("totalSpace")
    @Expose
    private Integer totalSpace;
    @SerializedName("usableSpace")
    @Expose
    private Integer usableSpace;

    public Boolean getAbsolute() {
        return absolute;
    }

    public void setAbsolute(Boolean absolute) {
        this.absolute = absolute;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getCanonicalPath() {
        return canonicalPath;
    }

    public void setCanonicalPath(String canonicalPath) {
        this.canonicalPath = canonicalPath;
    }

    public Boolean getDirectory() {
        return directory;
    }

    public void setDirectory(Boolean directory) {
        this.directory = directory;
    }

    public Boolean getFile() {
        return file;
    }

    public void setFile(Boolean file) {
        this.file = file;
    }

    public Integer getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Integer freeSpace) {
        this.freeSpace = freeSpace;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(Integer totalSpace) {
        this.totalSpace = totalSpace;
    }

    public Integer getUsableSpace() {
        return usableSpace;
    }

    public void setUsableSpace(Integer usableSpace) {
        this.usableSpace = usableSpace;
    }

}
