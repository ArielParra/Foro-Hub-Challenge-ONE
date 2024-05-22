package com.foroHub.app.service.impl;

import com.foroHub.app.repository.TopicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foroHub.app.domain.TopicoEntity;
import com.foroHub.app.record.Topico;
import com.foroHub.app.record.TopicoUpdate;
import com.foroHub.app.service.ITppicoSrvc;

import jakarta.transaction.Transactional;

@Service
public class TopicoService implements ITppicoSrvc {

	private TopicoRepository repository;
	
	public TopicoService(TopicoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Page<TopicoEntity> paginacion(Pageable paginacion) {

		return repository.findByOrderByCreationDate(paginacion);
	}

	@Override
	public Topico getTopicoByID(Long id) {
		
		TopicoEntity topicoEntidad = repository.getById(id);
		Topico topico = new Topico(topicoEntidad.getTitulo(), topicoEntidad.getMensaje(), topicoEntidad.getAutor(), topicoEntidad.getCurso());
		return topico;
	}

	@Transactional
	@Override
	public Topico registrar(Topico topico) {
		
				TopicoEntity topicoEntidad  = repository.save(new TopicoEntity(topico));
		return new Topico(topicoEntidad.getTitulo(), topicoEntidad.getMensaje(), topicoEntidad.getAutor(), topicoEntidad.getCurso());
	
	}

	@Transactional
	@Override
	public Topico update(TopicoUpdate topico) {
		TopicoEntity topicoEntidad = repository.getById(topico.id());
		topicoEntidad.setRespuestas(topico.respuesta());
		topicoEntidad  = repository.save(topicoEntidad);
	return new Topico(topicoEntidad.getTitulo(), topicoEntidad.getMensaje(), topicoEntidad.getAutor(), topicoEntidad.getCurso());

	}

	@Transactional
	@Override
	public void del(Long id) {
		TopicoEntity topicoEntidad = repository.getById(id);
		repository.delete(topicoEntidad);
	}

}
