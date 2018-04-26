package com.thesisdesign.madlife.query.service.impl;

import com.thesisdesign.madlife.contract.service.TestService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

@Component
public class TestServiceImpl implements TestService {

    @Override
    public String getDubboCall() {
        return "Dubbo : Hello world!";
    }

    @Override
    public String javaCallPython(String path) {
        String result = "";
        try {
            Process process = Runtime.getRuntime().exec("python " + path);
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
}
