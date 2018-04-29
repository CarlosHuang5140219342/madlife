package com.thesisdesign.madlife.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.thesisdesign.madlife.contract.result.TextExtractionResult;
import com.thesisdesign.madlife.contract.service.EmailFilterService;
import com.thesisdesign.madlife.contract.vo.EmailWithTagVO;
import com.thesisdesign.madlife.contract.vo.ExtractInfoVO;
import com.thesisdesign.madlife.contract.vo.SingleEmailVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/madlife/email_test")
public class EmailTestController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmailFilterService emailFilterService;

    @RequestMapping("/add_tag")
    @ResponseBody
    public List<EmailWithTagVO> addTagTest(){
        logger.info("local add tag test");
        List<SingleEmailVO> emailWithContentVOList = new ArrayList<>();
        emailWithContentVOList.add(new SingleEmailVO("id13","contentsadsda"));
        return emailFilterService.addTag(emailWithContentVOList);
    }
}
