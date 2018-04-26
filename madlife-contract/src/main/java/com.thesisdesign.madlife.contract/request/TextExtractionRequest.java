package com.thesisdesign.madlife.contract.request;

import java.io.Serializable;

public class TextExtractionRequest implements Serializable {

    private Integer id;
    private String filename;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextExtractionRequest{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
