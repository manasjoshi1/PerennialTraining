import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ExpectionHandle{
	
	public static void exceptionHandler(String projectName,String moduleName,Exception exp) {
	try {
		
		Map<String, String> map = new HashMap<>();
		Properties props=new Properties();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();		
		DocumentBuilder builder= factory.newDocumentBuilder();
		Document doc = builder.parse("E:/Projects/ExpectionHandlingLib/src/config.xml");
		try {
		FileReader fh =new FileReader("E:/Projects/ExpectionHandlingLib/src/actions.property");
		props.load(fh);
		}
		catch(Exception e) {
			
		}
		Element rootElement=doc.getDocumentElement();
		NodeList moduleNodes=rootElement.getChildNodes();
		
		for(int i=0;i<moduleNodes.getLength();i++) {
			Node moduleNode= moduleNodes.item(i);
			if(moduleNode.getNodeType()==Node.ELEMENT_NODE) {
				
				NodeList exceptionNodes=moduleNode.getChildNodes();//module children
				for(int j=0;j<exceptionNodes.getLength();j++) {
	
					Node exceptionNode=exceptionNodes.item(j);//exception recd
					if(exceptionNode.getNodeType()==Node.ELEMENT_NODE) {
						
						String exceptionName=((Element)exceptionNode).getNodeName();
						if(exceptionName.equalsIgnoreCase(exp.getClass().getSimpleName())) {
							
							NodeList actionNodes=exceptionNode.getChildNodes();
							for(int k=0;k<actionNodes.getLength();k++) {	
								Node actionNode=actionNodes.item(k);
								if(actionNode.getNodeType()==Node.ELEMENT_NODE) {
									String actionName=	((Element)actionNode).getAttribute("name");

									
											
											NamedNodeMap actionNodeListmap = ((Element)actionNode).getAttributes();
											
											for (int m = 0; m < actionNodeListmap.getLength(); ++m)
											 {
												 Node attr = actionNodeListmap.item(m);
												 if(attr!=null) {
													 String attrName=attr.getNodeName();
													 String attrValue=attr.getNodeValue();
													 if(!attrName.equals("name")) {
														 map.put(attrName,attrValue);
													 	map.put("exception", exp.getClass().toString());
													 	}
													 	
											 }	
											 }
											
										
								String className =props.getProperty(actionName);
								Action action=(Action)Class.forName(className).newInstance();
								action.takeAction(map);
							}
										
							}
							}
						}
					}
				}
			}
		
	}
	catch(Throwable t) {
		t.printStackTrace();
	}
		
	}
}

 interface Action{
	 void takeAction(Map<String,String> map);
}

 

 
