import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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


public class ConvertToMap {
	public static Map<String,Map> exceptionHandler(String projectName,String moduleName,Exception exp) {
		Map<String,String> actionMap=new HashMap<>();
		Map<String,String> map2=new HashMap<>();
		Map<String,Map> map3=new HashMap<>();
		try {
		List<String> listStrings=new ArrayList<String>();
		String concat=projectName+moduleName+exp;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();		
		DocumentBuilder builder= factory.newDocumentBuilder();
		Document doc = builder.parse("E:/Projects/ExpectionHandlingLib/src/config.xml");
		Element rootElement=doc.getDocumentElement();
		System.out.println(rootElement.getNodeName());
		NodeList moduleNodes=rootElement.getChildNodes();
		for(int i=0;i<moduleNodes.getLength();i++) {
			Node moduleNode= moduleNodes.item(i);
			if(moduleNode.getNodeType()==Node.ELEMENT_NODE) {
				System.out.println(((Element)moduleNode).getAttribute("name"));
				NodeList exceptionNodes=moduleNode.getChildNodes();//module children
				for(int j=0;j<exceptionNodes.getLength();j++) {
					Node exceptionNode=exceptionNodes.item(j);//exception recd
					if(exceptionNode.getNodeType()==Node.ELEMENT_NODE) {
						String exceptionName=((Element)exceptionNode).getNodeName();
//						System.out.println(exceptionName);

						if(exceptionName.equalsIgnoreCase(exp.getClass().getSimpleName())) {
								NodeList actionNodes=exceptionNode.getChildNodes();
								for(int k=0;k<actionNodes.getLength();k++) {	
									Node actionNode=actionNodes.item(k);
								
									if(actionNode.getNodeType()==Node.ELEMENT_NODE) {
										
										NamedNodeMap actionNodeListmap = ((Element)actionNode).getAttributes();
										for (int m = 0; m < actionNodeListmap.getLength(); ++m)
										 {
											 Node attr = actionNodeListmap.item(m);
											 if(attr!=null) {
												 String attrName=attr.getNodeName();
												 String attrValue=attr.getNodeValue();
												 if(!attrName.equals("name")) {
													 map2.put(attrName,attrValue);
//												 	map2.put("exception", exp.getClass().toString());
												 	}
												 
												 	
										 }	
										 }
										String actionName=	((Element)actionNode).getAttribute("name");
										listStrings.add(actionName);
										actionMap.put(actionName, "");
										//actionMap.put(exceptionName,listStrings);
										 map3.put(actionName, map2);

									}
								}
								
						
							
					
						}
					
				}
				
			}
			
		}
	
	}
	}
	catch(Exception e) {
		
	
	
		}
 
		    List<String> keys1 = new ArrayList<String>(actionMap.keySet());
		    System.out.println("Map 1");
		    for (String key : keys1) {
		    	System.out.println(key +": "+ actionMap.get(key));
		    }
		    List<String> keys2 = new ArrayList<String>(map2.keySet());
		    System.out.println("Map 2");
		    
		    for (String key : keys2) {
		    	System.out.println(key +": "+ map2.get(key) );
		    }
		    List<String> keys3 = new ArrayList<String>(map3.keySet());
		    System.out.println("Map 3");

		    for (String key : keys3) {
		    	System.out.println(key +": "+ map3.get(key) );
		    }


		return map3;
	
	
	}
	}
