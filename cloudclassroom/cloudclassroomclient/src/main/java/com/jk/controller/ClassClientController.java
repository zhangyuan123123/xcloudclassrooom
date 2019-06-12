package com.jk.controller;

import com.jk.service.ClassClientService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ClassClientController {
    @Resource
    private ClassClientService classClientService;
}
