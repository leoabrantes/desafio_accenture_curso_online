package com.accenture.desafio_accenture_curso_online.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.accenture.desafio_accenture_curso_online.entidades.Aluno;

public class AlunoDto implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataCadastro;
	
	private List<CursoDto> cursosDto = new ArrayList<>();


	public AlunoDto() {
		super();
	}


	public AlunoDto(Long id, String nome, String email, LocalDate dataCadastro, List<CursoDto> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.cursosDto = cursos;
	}
	
	public AlunoDto(Aluno aluno) {
		id = aluno.getId();
		nome = aluno.getNome();
		email = aluno.getEmail();
		dataCadastro = aluno.getDataCadastro();
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
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public List<CursoDto> getCursosDto() {
		return cursosDto;
	}


	public void setCursos(List<CursoDto> cursosDto) {
		this.cursosDto = cursosDto;
	}


}
