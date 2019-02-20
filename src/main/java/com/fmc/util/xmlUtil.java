package com.fmc.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;

/**
 * Created by ycw on 2017/10/9 0009.
 */
public  class xmlUtil {
    private final static Logger logger = LoggerFactory.getLogger(xmlUtil.class);

    /**
     * 修改生成代码xml文件
     * @param tableName
     * @param moduleName
     * @param className
     */
    public static void modifyMybaitsAutoXml(String tableName,String moduleName,String className){
        try {
            logger.info("开始修改mybatis-generator配置文件");
            ClassLoader classLoader = xmlUtil.class.getClassLoader();
            URL resource = classLoader.getResource("/mybatis-generator/generatorConfig.xml");
            String xmlPath = resource.getPath();
            System.out.println(xmlPath);
            //String xmlPath=".\\src\\main\\resources\\mybatis-generator\\generatorConfig.xml";
            Document doc=new SAXReader().read(xmlPath);
            Element context=doc.getRootElement().element("context");
            String javaModelString="com.fmc.model.";
            String sqlMapString="mapper.";
            String javaClientString="com.fmc.dao.";
            //获取节点
            //Model节点
            Element javaModelGenerator= context.element("javaModelGenerator");
            javaModelGenerator.addAttribute("targetPackage", javaModelString+moduleName);
            //sqlMap节点
            Element sqlMapGenerator= context.element("sqlMapGenerator");
            sqlMapGenerator.addAttribute("targetPackage", sqlMapString+moduleName);
            //javaClient节点
            Element javaClientGenerator= context.element("javaClientGenerator");
            //javaClientGenerator.addAttribute("targetPackage", javaClientGenerator.attributeValue("targetPackage")+moduleName);
            javaClientGenerator.addAttribute("targetPackage", javaClientString+moduleName);
            //table节点
            Element table= context.element("table");
            table.addAttribute("tableName", tableName);
            table.addAttribute("domainObjectName", className);
            //修改文件
            writeXml(doc,xmlPath);
            logger.info("完成修改mybatis-generator配置文件");
        } catch (Exception e) {
            logger.error("修改mybatis-generator配置文件异常，请核对代码");
            e.printStackTrace();
        }
    }

    //public static void main(String[] args) {
        //modifyMybaitsAutoXml("SYS_DEPT","dept","Dept");
    //}

    /**
     * 输出xml文件
     *
     * @param document
     * @param filePath
     * @throws IOException
     */
    public static void writeXml(Document document, String filePath) throws IOException {
        File xmlFile = new File(filePath);
        XMLWriter writer = null;
        try {
            if (xmlFile.exists())
                xmlFile.delete();
            writer = new XMLWriter(new FileOutputStream(xmlFile), OutputFormat.createPrettyPrint());
            writer.write(document);
            writer.flush();
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
