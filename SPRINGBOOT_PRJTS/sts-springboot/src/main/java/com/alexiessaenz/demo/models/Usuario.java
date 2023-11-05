package com.alexiessaenz.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	public Usuario(String nombre, String apellido, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
}
