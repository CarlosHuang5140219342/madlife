package com.thesisdesign.madlife.contract.vo;

import java.io.Serializable;

public class SingleEmailVO implements Serializable {
    private String id;
    private String content;

    public SingleEmailVO() {
    }

    public SingleEmailVO(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
