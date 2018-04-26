package com.thesisdesign.madlife.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thesisdesign.madlife.contract.result.TextExtractionResult;
import com.thesisdesign.madlife.contract.service.TestService;
import com.thesisdesign.madlife.contract.service.TextExtractionService;
import com.thesisdesign.madlife.contract.vo.ExtractInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/madlife/test")
public class TestConrtroller {

    @Autowired
    private TestService testService;

    @Autowired
    private TextExtractionService textExtractionService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String getHello(){
        return testService.getDubboCall();
    }

    @RequestMapping("/call_python")
    @ResponseBody
    public String getPython(){
        return testService.javaCallPython("/home/carloshuang/IdeaProjects/Demo.py");
    }

    @RequestMapping("/json_object")
    @ResponseBody
    public TextExtractionResult getTestExtract(){
        String str = testService.javaCallPython("/home/carloshuang/IdeaProjects/Demo2.py");
        System.out.println(str);
        List<ExtractInfoVO> extractInfoVOList = new ArrayList<>();
        try{
            extractInfoVOList = objectMapper.readValue(str, new TypeReference<List<ExtractInfoVO>>(){});
        }  catch (IOException e1) {
            System.out.println("fail to decode json, error: " + e1.getMessage());
        }
        TextExtractionResult result = new TextExtractionResult();
        result.setExtractInfoVOList(extractInfoVOList);
        return result;
    }

    @RequestMapping("/read/json")
    @ResponseBody
    public ExtractInfoVO getExtract(){
        String str = "{\"type\":\"A\",\"content\":\"1\"}";

        ExtractInfoVO vo = new ExtractInfoVO();
        try{
            vo = objectMapper.readValue(str, ExtractInfoVO.class);
        }  catch (IOException e1) {
            System.out.println("fail to decode json, error: " + e1.getMessage());
        }
        return vo;
    }

    @RequestMapping("/read/json_list")
    @ResponseBody
    public TextExtractionResult getExtractList(){
        TextExtractionResult result = new TextExtractionResult();
        List<ExtractInfoVO> voList = new ArrayList<>();
        String str = "[{\"type\":\"A\",\"content\":\"1\"},{\"type\":\"B\",\"content\":\"2\"}]";

        try{
            voList = objectMapper.readValue(str, new TypeReference<List<ExtractInfoVO>>(){});
        }  catch (IOException e1) {
            System.out.println("fail to decode json, error: " + e1.getMessage());
        }

        result.setExtractInfoVOList(voList);
        return result;
    }

    @RequestMapping("/write/json")
    @ResponseBody
    public String toJson(){
        ExtractInfoVO vo = new ExtractInfoVO();
        vo.setType("A");
        vo.setContent("1");
        String str = "";
        try{
            str = objectMapper.writeValueAsString(vo);
        }  catch (IOException e1) {
            System.out.println("fail to decode json, error: " + e1.getMessage());
        }
        return str;
    }

    @RequestMapping("/write/json_list")
    @ResponseBody
    public String toJsonList(){
        List<ExtractInfoVO> voList = new ArrayList<>();
        for(int i = 0;i < 2;i++ ) {
            ExtractInfoVO vo = new ExtractInfoVO();
            vo.setType("A"+i);
            vo.setContent("B"+i);
            voList.add(vo);
        }
        String str = "ListStr : ";
        try{
            str += objectMapper.writeValueAsString(voList);
        }  catch (IOException e1) {
            System.out.println("fail to decode json, error: " + e1.getMessage());
        }
        str += " ;ResultStr : ";
        try{
            TextExtractionResult result = new TextExtractionResult();
            result.setExtractInfoVOList(voList);
            str += objectMapper.writeValueAsString(result);
        }  catch (IOException e1) {
            System.out.println("fail to decode json, error: " + e1.getMessage());
        }
        return str;
    }
}
