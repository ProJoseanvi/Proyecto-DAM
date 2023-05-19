package com.doctorplus.controller;

import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;


import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.doctorplus.dao.MedsDao;
import com.doctorplus.dao.PatientsDao;
import com.doctorplus.dao.UsersDao;
import com.doctorplus.dto.Med;
import com.doctorplus.dto.User;
import com.doctorplus.dto.Patient;
import com.doctorplus.service.InMemoryUsers;
import com.doctorplus.service.JwtTokenService;
import com.doctorplus.service.JwtUserDetailsService;

//Este es el método pricipal que controla el login y autenticación del usuario

@RestController
public class PatientsController {
	
	private static final Logger logger = LogManager.getLogger(RecipeController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenService jwtTokenService;
	
	
	@Autowired
	private PatientsDao patientsDao;
		
	@GetMapping("/patients/list")
    public ListPatientsResponse list(@RequestHeader (name="Authorization") String bearerToken) {
		ListPatientsResponse response = new ListPatientsResponse();
		String token = bearerToken.substring(7);
    	logger.info("user token: " + token);
    	
    	List<Patient> meds = patientsDao.list();
    	response.setPatients(meds);
    	
        
        return response;
    }
	
	/*@PostMapping("/receta")
	public ResponseEntity<String> crearReceta(@RequestBody Receta receta) {
	    
		// Realizamos las validaciones necesarias
	    if (receta.getRecetaId() == null || receta.getRecetaId().isEmpty()) {
	        return ResponseEntity.badRequest().body("El receta_id es obligatorio");
	    }

	    // habría que crear aquí las acciones necesarias para crear la receta en la bd

	    // devolvemos respuesta exitosa
	    return ResponseEntity.ok("Receta creada exitosamente");
	
	}
	
	    
	}

	 */
}
