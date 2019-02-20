package com.fmc.controller.bulidCode;

import com.fmc.util.xmlUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ycw on 2017/10/9 0009.
 */
@Controller
@RequestMapping("/autoCode")
public class BulidCodeController {
    @RequestMapping(value = "/bulid.do", method = RequestMethod.POST)
    public String bulid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //根据传递的配置信息生成代码
        request.setCharacterEncoding("UTF-8");
        String tableName=request.getParameter("tableName");
        String moduleName=request.getParameter("moduleName");
        String className=request.getParameter("className");
        ClassLoader classLoader = BulidCodeController.class.getClassLoader();
        URL resource = classLoader.getResource("/mybatis-generator/generatorConfig.xml");
        String path = resource.getPath();
        System.out.println(path);
        xmlUtil.modifyMybaitsAutoXml(tableName,moduleName,className);
        //生成代码
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File(path);  //输入绝对路径
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config=null;
        config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        return "";
    }
}

