package com.thesisdesign.madlife.query.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thesisdesign.madlife.contract.service.EmailFilterService;
import com.thesisdesign.madlife.contract.vo.EmailWithTagVO;
import com.thesisdesign.madlife.contract.vo.SingleEmailVO;
import com.thesisdesign.madlife.query.service.Java2PythonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmailFilterServiceImpl implements EmailFilterService {
    @Autowired
    private Java2PythonService java2PythonService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<EmailWithTagVO> addTag(List<SingleEmailVO> emailWithContentVOList) {
        String param = "";
        try{
            param = objectMapper.writeValueAsString(emailWithContentVOList);
        } catch (IOException e1) {
            System.out.println("fail to encode json, error: " + e1.getMessage());
        }
        String pythonResultString = java2PythonService.httpPostMethod("http://202.120.40.69:12346/sendjson", param);
        List<EmailWithTagVO> emailWithTagVOList = new ArrayList<>();
        if (pythonResultString == null)
            return emailWithTagVOList;
        try {
            emailWithTagVOList = objectMapper.readValue(pythonResultString, new TypeReference<List<EmailWithTagVO>>(){});
        }  catch (IOException e1) {
            System.out.println("fail to decode json, error: " + e1.getMessage());
        }
        return emailWithTagVOList;
    }
}
