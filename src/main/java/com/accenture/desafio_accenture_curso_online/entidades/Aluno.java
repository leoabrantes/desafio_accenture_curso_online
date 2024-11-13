package com.accenture.desafio_accenture_curso_online.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno implements Serializable  {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataCadastro;
	
	
	@ManyToMany(mappedBy = "alunos")
	private List<Curso> cursos = new ArrayList<>();


	public Aluno() {
		super();
	}


	public Aluno(Long id, String nome, String email, LocalDate dataCadastro, List<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.cursos = cursos;
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


	public List<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
