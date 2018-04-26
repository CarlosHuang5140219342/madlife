package com.thesisdesign.madlife.contract.vo;

import java.io.Serializable;

public class ExtractInfoVO implements Serializable {
    private String type;
    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ExtractInfoVO() {
    }

    public ExtractInfoVO(String type, String content) {
        this.type = type;
        this.content = content;
    }
}
