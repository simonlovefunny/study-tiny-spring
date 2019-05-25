package com.simon;

import com.simon.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.Map;

/**
 * xml格式BeanDefinitionReader实现
 *
 * @Author: wuzhaoyi
 * @version: $id:XmlBeanDefinitionReader.java,v0.1  2019/5/25 9:16 PM wuzhaoyi Exp$
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {

        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception{

        //创建xml解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(inputStream);

        registerBeanDefinitions(doc);

        inputStream.close();
    }

    public void registerBeanDefinitions(Document doc){
        Element root = doc.getDocumentElement();
        parseDeanDefinitions(root);

    }

    protected void parseDeanDefinitions(Element root){
        NodeList nl = root.getChildNodes();
        for(int i= 0;i<nl.getLength();i++){
            Node node = nl.item(i);
            if(node instanceof Element){
                Element ele = (Element)node;
                processBeanDefinition(ele);
            }
        }
    }

    protected void processBeanDefinition(Element ele){
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");

        //创建BeanDefinition对象
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele,beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name,beanDefinition);
    }

    protected void processProperty(Element ele,BeanDefinition beanDefinition){
        NodeList propertyNode = ele.getElementsByTagName("property");
        for(int i=0;i<propertyNode.getLength();i++){
            Node node = propertyNode.item(i);
            if(node instanceof  Element){
               Element propertyEle = (Element)node;
               String name = propertyEle.getAttribute("name");
               String value = propertyEle.getAttribute("value");
               beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
            }
        }
    }


}
