package com.foroHub.app.record;

import jakarta.validation.constraints.NotBlank;

public record Topico(
	 	@NotBlank
		String titulo,
	 	@NotBlank
		String mensaje,
	 	@NotBlank
		Integer autor,
	 	@NotBlank
		String curso
		) {

}
