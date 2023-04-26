package com.doctorplus.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorplus.dao.MedicamentosDao;
import com.doctorplus.dto.Medicamento;


@RestController
@RequestMapping("/public/")
public class GreetingController {

	private static final Logger logger = LogManager.getLogger(GreetingController.class);
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();


	@GetMapping("/greeting")
	public Medicamento greeting(@RequestParam(value = "name", defaultValue = "2727") String code){
		logger.info("code:" + code);
		
		MedicamentosDao dao = new MedicamentosDao();
		Medicamento result = dao.get(code);
		logger.info(result.toString());
		
		return result;
	}
	
	/*@GetMapping("/private/greeting")
	public Medicamento greetingPrivate(@RequestParam(value = "name", defaultValue = "2727") String code){
		logger.info("code:" + code);
		
		MedicamentosDao dao = new MedicamentosDao();
		Medicamento result = dao.get(code);
		logger.info(result.toString());
		
		return result;
	}*/
	
	
	/*public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}*/

}