package com.accenture.desafio_accenture_curso_online.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="inscricao")
public class Inscricao implements Serializable  {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno_id;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso_id;
	
	
	private LocalDate dataInscricao;


	public Inscricao() {
		super();
	}


	public Inscricao(Long id, Aluno aluno_id, Curso curso_id, LocalDate dataInscricao) {
		super();
		this.id = id;
		this.aluno_id = aluno_id;
		this.curso_id = curso_id;
		this.dataInscricao = dataInscricao;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Aluno getAluno_id() {
		return aluno_id;
	}


	public void setAluno_id(Aluno aluno_id) {
		this.aluno_id = aluno_id;
	}


	public Curso getCurso_id() {
		return curso_id;
	}


	public void setCurso_id(Curso curso_id) {
		this.curso_id = curso_id;
	}


	public LocalDate getDataInscricao() {
		return dataInscricao;
	}


	public void setDataInscricao(LocalDate dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
	
	
	
}
