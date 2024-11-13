package com.accenture.desafio_accenture_curso_online.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.accenture.desafio_accenture_curso_online.entidades.Aluno;
import com.accenture.desafio_accenture_curso_online.entidades.Curso;
import com.accenture.desafio_accenture_curso_online.entidades.Inscricao;

public class InscricaoDto implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Aluno aluno_id;
	
	private Curso curso_id;
	
	private LocalDate dataInscricao;


	public InscricaoDto() {
		super();
	}
	
	public InscricaoDto(Long id, Aluno aluno_id, Curso curso_id, LocalDate dataInscricao) {
		super();
		this.id = id;
		this.aluno_id = aluno_id;
		this.curso_id = curso_id;
		this.dataInscricao = dataInscricao;
	}


	public InscricaoDto(Inscricao inscricao) {
		id = inscricao.getId();
		this.aluno_id = inscricao.getAluno_id();
		this.curso_id = inscricao.getCurso_id();
		this.dataInscricao = inscricao.getDataInscricao();
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
