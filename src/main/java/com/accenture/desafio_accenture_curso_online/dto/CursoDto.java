package com.accenture.desafio_accenture_curso_online.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.accenture.desafio_accenture_curso_online.entidades.Curso;

public class CursoDto implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	
	private List<AlunoDto> alunosDto = new ArrayList<>();


	public CursoDto() {
		super();
	}


	public CursoDto(Long id, String nome, String email, LocalDate dataCadastro, List<AlunoDto> alunosDto) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = email;
		this.dataCriacao = dataCadastro;
		this.alunosDto = alunosDto;
	}
	
	public CursoDto(Curso curso) {
		id = curso.getId();
		nome = curso.getNome();
		descricao = curso.getDescricao();
		dataCriacao = curso.getDataCriacao();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return descricao;
	}


	public void setEmail(String email) {
		this.descricao = email;
	}


	public LocalDate getDataCadastro() {
		return dataCriacao;
	}


	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCriacao = dataCadastro;
	}


	public List<AlunoDto> getAlunosDto() {
		return alunosDto;
	}


	public void setAlunosDto(List<AlunoDto> alunosDto) {
		this.alunosDto = alunosDto;
	}


}
