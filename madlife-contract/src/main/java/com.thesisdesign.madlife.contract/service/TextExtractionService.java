package com.thesisdesign.madlife.contract.service;

import com.thesisdesign.madlife.contract.request.TextExtractionRequest;
import com.thesisdesign.madlife.contract.result.TextExtractionResult;

public interface TextExtractionService {
    TextExtractionResult getTextInformation(TextExtractionRequest request);
}
