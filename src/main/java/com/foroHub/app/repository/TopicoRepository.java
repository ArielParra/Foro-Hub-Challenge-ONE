package com.foroHub.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foroHub.app.domain.TopicoEntity;


public interface TopicoRepository extends JpaRepository<TopicoEntity, Long> {
	   Page<TopicoEntity> findByOrderByCreationDate(Pageable paginacion);
}