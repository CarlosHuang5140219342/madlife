package com.thesisdesign.madlife.contract.vo;

import java.io.Serializable;

public class EmailWithTagVO implements Serializable {
    private String id;
    private String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public EmailWithTagVO() {
    }

    public EmailWithTagVO(String id, String tag) {
        this.id = id;
        this.tag = tag;
    }
}
