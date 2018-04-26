package com.thesisdesign.madlife.query.service;

public interface Java2PythonService {
    String callPyScript(String scriptName, String jsonString);
    String httpGetMethod(String url, String param);
    String httpPostMethod(String url, String param);
}
