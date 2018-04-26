package com.thesisdesign.madlife.query.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thesisdesign.madlife.contract.request.TextExtractPythonRequest;
import com.thesisdesign.madlife.contract.request.TextExtractionRequest;
import com.thesisdesign.madlife.contract.result.TextExtractPytonResult;
import com.thesisdesign.madlife.contract.result.TextExtractionResult;
import com.thesisdesign.madlife.contract.service.TextExtractionService;
import com.thesisdesign.madlife.contract.vo.ExtractInfoVO;
import com.thesisdesign.madlife.query.service.Java2PythonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TextExtractionServiceImpl implements TextExtractionService {

    @Autowired
    private Java2PythonService java2PythonService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public TextExtractionResult getTextInformation(TextExtractionRequest request) {
        TextExtractionResult result = new TextExtractionResult();
        Integer id = (request.getId() == null) ? 1 : request.getId();
        TextExtractPythonRequest pythonRequest = new TextExtractPythonRequest(id, request.getContent());
        String param = "";
        try{
            param = objectMapper.writeValueAsString(pythonRequest);
        } catch (IOException e1) {
            System.out.println("fail to encode json, error: " + e1.getMessage());
        }
        String pythonResultString = java2PythonService.httpPostMethod("http://202.120.40.69:12346/infoextract", param);
        TextExtractPytonResult pythonResult = new TextExtractPytonResult();
        if (pythonResultString == null)
            return result;
        try {
            pythonResult = objectMapper.readValue(pythonResultString, TextExtractPytonResult.class);
        }  catch (IOException e1) {
            System.out.println("fail to decode json, error: " + e1.getMessage());
        }

        List<ExtractInfoVO> extractInfoVOList = buildVOList(pythonResult);
        result.setExtractInfoVOList(extractInfoVOList);
        return result;
    }

    private List<ExtractInfoVO> buildVOList(TextExtractPytonResult pythonResult){
        List<ExtractInfoVO> extractInfoVOList = new ArrayList<>();
        extractInfoVOList.add(new ExtractInfoVO("names", pythonResult.getNames()));
        extractInfoVOList.add(new ExtractInfoVO("phone", pythonResult.getPhone()));
        extractInfoVOList.add(new ExtractInfoVO("places", pythonResult.getPlaces()));
        extractInfoVOList.add(new ExtractInfoVO("e_mail", pythonResult.getE_mail()));
        extractInfoVOList.add(new ExtractInfoVO("id", pythonResult.getId()));
        extractInfoVOList.add(new ExtractInfoVO("passport", pythonResult.getPassport()));
        extractInfoVOList.add(new ExtractInfoVO("car", pythonResult.getCar()));
        extractInfoVOList.add(new ExtractInfoVO("date", pythonResult.getDate()));
        return extractInfoVOList;
    }
}
