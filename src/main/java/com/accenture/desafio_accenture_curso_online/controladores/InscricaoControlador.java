package com.accenture.desafio_accenture_curso_online.controladores;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accenture.desafio_accenture_curso_online.dto.InscricaoDto;
import com.accenture.desafio_accenture_curso_online.servico.InscricaoServico;


@RestController
@RequestMapping(value = "/inscricoes")
public class InscricaoControlador {
	
	@Autowired
	private InscricaoServico inscricao;
	
	@GetMapping
	public ResponseEntity<Page<InscricaoDto>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "20") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<InscricaoDto> list = inscricao.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<InscricaoDto> findById(@PathVariable Long id){
		InscricaoDto dto = inscricao.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<InscricaoDto> delete(@PathVariable Long id){
		inscricao.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<InscricaoDto> update(@PathVariable Long id, @RequestBody InscricaoDto inscricaoDto){
		inscricaoDto = inscricao.update(id, inscricaoDto);
		return ResponseEntity.ok().body(inscricaoDto);
	}
	
	@PostMapping
	public ResponseEntity<InscricaoDto> insert(@RequestBody InscricaoDto InscricaoDto){
		InscricaoDto = inscricao.insert(InscricaoDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(InscricaoDto.getId()).toUri();		
		return ResponseEntity.created(uri).body(InscricaoDto);
	}
	
	

}
