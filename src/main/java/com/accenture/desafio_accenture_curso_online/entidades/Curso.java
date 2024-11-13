package com.accenture.desafio_accenture_curso_online.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="curso")
public class Curso implements Serializable  {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "inscricao",
			joinColumns = @JoinColumn(name = "curso_id"),
			inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private Set<Aluno> alunos = new HashSet<>();


	public Curso() {
	}


	public Curso(Long id, String nome, String descricao, LocalDate dataCriacao, Set<Aluno> alunos) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.alunos = alunos;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public LocalDate getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Set<Aluno> getAlunos() {
		return alunos;
	}


	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
}
