
package com.cloudamize.functional.cmp.bean.resourceController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("file")
    @Expose
    private File file;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("inputStream")
    @Expose
    private InputStream inputStream;
    @SerializedName("open")
    @Expose
    private Boolean open;
    @SerializedName("readable")
    @Expose
    private Boolean readable;
    @SerializedName("uri")
    @Expose
    private Uri uri;
    @SerializedName("url")
    @Expose
    private Url url;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

}
