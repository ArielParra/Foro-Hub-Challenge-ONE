package com.foroHub.app.record;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRes(
		 	@NotBlank
	        String nombre,
	        @NotBlank
	        @Email
	        String email,
	        @NotBlank
	        String mensaje
	        ) {
}
