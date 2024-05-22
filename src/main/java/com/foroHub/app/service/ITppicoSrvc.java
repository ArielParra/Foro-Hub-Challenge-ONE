package com.foroHub.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.foroHub.app.domain.TopicoEntity;
import com.foroHub.app.record.Topico;
import com.foroHub.app.record.TopicoUpdate;

public interface ITppicoSrvc {
	public Page<TopicoEntity> paginacion(Pageable paginacion);
	public Topico getTopicoByID(Long id);
	public Topico registrar(Topico topico);
	public Topico update(TopicoUpdate topico);
	public void del(Long id);
}
