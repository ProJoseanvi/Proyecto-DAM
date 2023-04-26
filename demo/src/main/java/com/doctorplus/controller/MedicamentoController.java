package com.doctorplus.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class MedicamentoController {
	
}
	
	/*@RestController
	@RequestMapping("/api") 
	
	public class UserRestController {
	}


@GetMapping("/medicamento/{nombre_medicamento}")
public Medicamento getMedicamento(@PathVariable String nombre_medicamento) {
    Medicamento medicamento = medicamentoService.findByNombre(nombre_medicamento);
    if(medicamento == null) {
        throw new RuntimeException("Medicamento no encontrado - "+nombre_medicamento);
    }
    return medicamento;
	}
}
	*/