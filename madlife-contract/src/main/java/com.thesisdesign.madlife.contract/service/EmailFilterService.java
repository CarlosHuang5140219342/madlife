package com.thesisdesign.madlife.contract.service;

import com.thesisdesign.madlife.contract.vo.EmailWithTagVO;
import com.thesisdesign.madlife.contract.vo.SingleEmailVO;

import java.util.List;

public interface EmailFilterService {
    List<EmailWithTagVO> addTag(List<SingleEmailVO> emailWithContentVOList);
}
