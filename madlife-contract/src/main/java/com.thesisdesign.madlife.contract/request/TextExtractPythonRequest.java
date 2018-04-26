package com.thesisdesign.madlife.contract.request;

import java.io.Serializable;

public class TextExtractPythonRequest implements Serializable {
    private Integer Id;
    private String Content;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public TextExtractPythonRequest(Integer id, String content) {
        this.Id = id;
        this.Content = content;
    }
}
