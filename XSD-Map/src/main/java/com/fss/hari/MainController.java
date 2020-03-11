package com.fss.hari;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/xsd")
public class MainController {

	StringBuilder st = new StringBuilder();
	
	@RequestMapping(value = "/{root}", method = RequestMethod.POST)
	public Map<String,String> xsdtoMap(@PathVariable("root") String root, @RequestBody String fileName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{


		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> attributes = null;

		attributes = objectMapper.readValue(fileName,
				new TypeReference<Map<String,Object>>() {
				});

		String file = (String) attributes.get("filename");
		/*
		URL url = MainController.class.getClassLoader()
				.getResource(file);
*/
		XSDElement mainElement = XSDParser.parseXSD(file, root);

		StringBuilder str = new StringBuilder();
		Map<String, String> map = new HashMap<>();
		printData(mainElement, 0, map, str);
		
		return map;
	}
	
	
	private void printData(XSDElement xsdElement, int level, Map<String, String> map, StringBuilder str) {

		String subName = "";

		if (str.length() <= 0)
			st.append(xsdElement.getName());
		map.put(st.append(str).toString(), xsdElement.getType());

		for (XSDAttribute attribute : xsdElement.getAttributes()) {
			for (String option : attribute.getOptions()) {
			}
		}
		if (xsdElement.getChildren().size() > 0) {
			for (XSDElement child : xsdElement.getChildren()) {
				subName = child.getName();
				printData(child, level + 2, map, new StringBuilder("." + subName));
			}
		}
		int lastIndex = st.lastIndexOf(".");
		if (lastIndex != -1)
			st.delete(lastIndex, st.length());
	}
}
