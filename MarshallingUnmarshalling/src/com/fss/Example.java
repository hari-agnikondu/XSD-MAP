package com.fss;


import java.io.File;
import java.math.BigDecimal;
import java.util.Collection;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.fss.marshalling.ExpenseT;
import com.fss.marshalling.ItemListT;
import com.fss.marshalling.ItemT;
import com.fss.marshalling.ObjectFactory;
import com.fss.marshalling.UserT;

public class Example {

	 public static void main(String[] args) throws JAXBException
	    {
	 
		 File file = new File("C:\\Users\\harikrishnaa\\Desktop\\CCLP_Workspace\\MarshallingUnmarshalling\\destination.xml");
	        ObjectFactory factory = new ObjectFactory();
	       
	        
	        UserT user = factory.createUserT();
	        user.setUserName("Sanaulla");
	 
	        ItemT item2 = factory.createItemT();
	        item2.setItemName("Seagate External HDD");
	        item2.setPurchasedOn("August 24, 2010");
	        item2.setAmount(new BigDecimal("6776.5"));
	        
	        ItemListT itemList = factory.createItemListT();
	        itemList.getItem().add(item2);
	 
	        ExpenseT expense = factory.createExpenseT();
	        expense.setUser(user);
	        expense.setItems(itemList);
	 
	        JAXBContext context = JAXBContext.newInstance("com.fss.marshalling");
	        JAXBElement<ExpenseT> element = factory.createExpenseReport(expense);
	        Marshaller marshaller = context.createMarshaller();
	        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
	        marshaller.marshal(element,file);
	        marshaller.marshal(element,System.out);
	        //--------------------
	        
	        File file2 = new File("C:\\Users\\harikrishnaa\\Desktop\\CCLP_Workspace\\MarshallingUnmarshalling\\destination.xml");
	        JAXBContext jaxbContext = JAXBContext.newInstance(ExpenseT.class.getPackage().getName());    
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        
	        System.out.println(jaxbUnmarshaller.unmarshal(file2));

	        
	        Schema schema = loadSchema("sample.xsd");
	        System.out.println("SChema name is : "+schema);
	        
	    }

	private static Schema  loadSchema(String name) {
		
		 String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	      SchemaFactory factory = SchemaFactory.newInstance(language);
	      System.out.println();
	      System.out.println("Schema Language: "+language);
	      System.out.println("Factory Class: "
	        + factory.getClass().getName());
	      
		Schema schema = null;
		try {
			schema = factory.newSchema(new File(name));
			 System.out.println();
		      System.out.println("Schema File: "+name);
		      System.out.println("Schema Class: "
		        + schema.getClass().getName());

		} catch (SAXException e) {
			e.printStackTrace();
		}
	     
		return null;
	}
	 

	
}
