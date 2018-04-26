package com.thesisdesign.madlife.query.service.impl;

import com.thesisdesign.madlife.common.HttpRequest;
import com.thesisdesign.madlife.query.service.Java2PythonService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

@Component
public class Java2PythonServiceImpl implements Java2PythonService {

    @Override
    public String callPyScript(String scriptName, String jsonString) {
        String result = "";
        try {
            Process process = Runtime.getRuntime().exec("python " + scriptName + " " + jsonString);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            result = input.readLine();
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
            ir.close();
        } catch (IOException e) {
            System.out.print("调用python脚本并读取结果时出错：" + e.getMessage());
        }
        return result;
    }

    @Override
    public String httpGetMethod(String url, String param) {
        return HttpRequest.sendGet(url, param);
    }

    @Override
    public String httpPostMethod(String url, String param) {
        return HttpRequest.sendPost(url, param);
    }
}
