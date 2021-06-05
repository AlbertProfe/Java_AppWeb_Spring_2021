package com.example.exemple1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/programming")
public class ProgrammingBooksController {
	
	//requests from web ..
	@RequestMapping("/javaCode")
	public String javaCode() {
		
		//controller gets a request from path-uri-url  "www.jaumevilados.com/ .../
		//" .... /programming/javaCode/ ..... to java.html
		// make some stuff
			
		return "javaResponse";			
	}
	
	@RequestMapping("/jsCode")
	public String jsCode() {
		
		
		
		return "jsResponse";
	}
	
	//some methods without @RequestMapping: static
	

}
