package com.lhc.controller;

import com.lhc.utils.COS;
import com.lhc.utils.Result;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private COS cos;

    @GetMapping("/cos")
    public Result<Response> cosKey() {
        return Result.Success(cos.getAvatarKey());
    }

    @GetMapping("cos/config")
    public Result<Map<String, String>> cosConfig() {
        return Result.Success(cos.getConfig());
    }
}
