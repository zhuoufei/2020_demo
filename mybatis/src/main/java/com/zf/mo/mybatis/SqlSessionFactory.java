package com.zf.mo.mybatis;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.ws.WebServiceException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SqlSessionFactory {

    private final String DB_PROPERTIES = "db.properties";
    private final String MAPPER = "mapper";
    private final Configuation conf = new Configuation();

    public SqlSessionFactory(){
        //加载db.properties
        loadDbInfo();
        //加载mapper.xml
        loadMapper();
    }

    private void loadMapper() {
        URL resource = SqlSessionFactory.class.getClassLoader().getResource(MAPPER);
        //获取指定文件信息
        File mapper = new File(resource.getFile());
        if(mapper.isDirectory()){
            File[] xmlFile = mapper.listFiles();
            for (File file:xmlFile){
                loadMapperXml(file);
            }
        }
    }

    private void loadMapperXml(File file) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element rootElement = document.getRootElement();
            Attribute namespace = rootElement.attribute("namespace");
            String namespaceValue = namespace.getData().toString();
            List<Element> elements = rootElement.elements("select");
            Map<String, MappedStatement> statementHashMap = new HashMap<>();
            for (Element el:elements){
                String id = el.attribute("id").getData().toString();
                String sourceId = namespaceValue + "." + id;
                String resultType = el.attribute("resultType").getData().toString();
                String sql = el.getData().toString();
                MappedStatement mappedStatement = new MappedStatement();
                mappedStatement.setSourceId(sourceId);
                mappedStatement.setNameSpace(namespaceValue);
                mappedStatement.setResultType(resultType);
                mappedStatement.setSql(sql);
                conf.getMappedStatementMap().put(sourceId,mappedStatement);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    private void loadDbInfo() {
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            inputStream  = SqlSessionFactory.class.getClassLoader().getResourceAsStream(DB_PROPERTIES);
            prop.load(inputStream);
            conf.setDriver(prop.getProperty("spring.datasource.url"));
            conf.setPassword(prop.getProperty("spring.datasource.password"));
            conf.setUrl(prop.getProperty("spring.datasource.driver-class-name"));
            conf.setUsername(prop.getProperty("spring.datasource.username"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取db.properties配置文件异常..");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("loadDbInfo() 关闭流异常");
            }
        }
    }

    public SqlSession openSession(){
        return new DefaultSqlSession(conf);
    }

//    public static void main(String[] args) {
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
//    }
}
