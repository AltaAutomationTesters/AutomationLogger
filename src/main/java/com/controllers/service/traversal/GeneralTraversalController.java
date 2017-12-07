package com.controllers.service.traversal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.controllers.service.entity.CurrentTimeBeans;
import com.util.FileUtils;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/")
public class GeneralTraversalController {

	String fileName = getCurrentTimeStamp();
	
	@RequestMapping(value = { "login" }, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(Map<String, Object> model) throws IOException {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = { "terminal" }, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView terminal(Map<String, Object> model) throws IOException {
		ModelAndView mav = new ModelAndView("terminal");
		return mav;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = { "getFile" }, produces = { "application/json" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity getFile(@RequestParam(value = "fileName", required = false) String fileName,
			HttpServletRequest request) throws IOException {

		ResponseEntity respEntity = null;
		File result = new File("src/main/resources/static/files/" + fileName);

		if (result.exists()) {
			InputStream inputStream = new FileInputStream(result.getAbsolutePath());
			String type = result.toURL().openConnection().guessContentTypeFromName(fileName);
			byte[] out = org.apache.commons.io.IOUtils.toByteArray(inputStream);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("content-disposition", "attachment; filename=" + fileName);
			responseHeaders.add("Content-Type", type);
			respEntity = new ResponseEntity(out, responseHeaders, HttpStatus.OK);
		} else {
			respEntity = new ResponseEntity("File Not Found", HttpStatus.OK);
		}
		return respEntity;
	}

	// 20:46:18 IST|INFO |
	
	@RequestMapping(value = "logger.do", method = { RequestMethod.GET, RequestMethod.POST })
	public void logger(HttpEntity<String> httpEntity) {
		String line = getCurrentTimeStamp()+" "+"IST"+"|"+"INFO"+" "+"|"+" "+ httpEntity.getBody();
		
		
		
		if(CurrentTimeBeans.getInstance().getCurrentTime().equals("00:00")) {
			
		}
		
		FileUtils.writeToFile("<br>" + line, "src/main/resources/static/files/logs", true);
	}

	public String getCurrentTimeStamp() {
	    return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	
	

}