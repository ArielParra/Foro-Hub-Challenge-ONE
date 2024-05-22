package com.foroHub.app.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.foroHub.app.record.Topico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Topicos")
public class TopicoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "mensaje")
	private String mensaje;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	@Column(name = "autor")
	private Integer autor;
	@Column(name = "curso")
	private String curso;
	@Column(name = "respuestas")
	private String respuestas;
	public TopicoEntity(Topico topico) {
		this.titulo =  topico.titulo();
		this.mensaje =  topico.mensaje();
		this.autor =  topico.autor();
		this.curso =  topico.curso();
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public Integer getAutor() {
		return autor;
	}
	public String getCurso() {
		return curso;
	}
	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}
	@Override
	public String toString() {
		return "TopicoEntity [id=" + id + ", titulo=" + titulo + ", mensaje=" + mensaje + ", fechaCreacion="
				+ fechaCreacion + ", autor=" + autor + ", curso=" + curso + ", respuestas=" + respuestas + "]";
	}

}
