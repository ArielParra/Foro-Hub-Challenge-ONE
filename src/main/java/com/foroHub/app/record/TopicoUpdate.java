package com.foroHub.app.record;

import jakarta.validation.constraints.NotBlank;

public record TopicoUpdate(
		Long id,
	 	@NotBlank
		String res) {
}
