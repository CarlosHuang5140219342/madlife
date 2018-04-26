package com.thesisdesign.madlife.contract.result;

import com.thesisdesign.madlife.contract.vo.ExtractInfoVO;

import java.io.Serializable;
import java.util.List;

public class TextExtractionResult implements Serializable {
    List<ExtractInfoVO> extractInfoVOList;

    public List<ExtractInfoVO> getExtractInfoVOList() {
        return extractInfoVOList;
    }

    public void setExtractInfoVOList(List<ExtractInfoVO> extractInfoVOList) {
        this.extractInfoVOList = extractInfoVOList;
    }
}
