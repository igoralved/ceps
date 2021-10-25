package com.example.acessingdatajpa;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/ceps")
public class CEPController {

	@Autowired
	private CEPRepository repositorio;
	
	@GetMapping("/retorna")
	//@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public CEP cadastraCEP(@RequestParam(value = "campo", defaultValue = "none") String campo,
			@RequestParam(value = "logradouro", defaultValue = "none") String l,
			@RequestParam(value = "complemento", defaultValue = "none") String c,
			@RequestParam(value = "bairro", defaultValue = "none")	String b, 
			@RequestParam(value = "localidade", defaultValue = "none") String l1, 
			@RequestParam(value = "uf", defaultValue = "none") String uf, 
			@RequestParam(value = "ibge", defaultValue = "none") String ibge, 
			@RequestParam(value = "gia", defaultValue = "none") String gia, 
			@RequestParam(value = "ddd", defaultValue = "none") String ddd, 
			@RequestParam(value = "siafi", defaultValue = "none") String siafi
			){
		CEP cep = new CEP(campo, l, c, b, l1, uf, ibge, gia, ddd, siafi);
		//repositorio.save(cep);
		return cep;
	}
	
	@GetMapping
	@ResponseBody
	public List<CEPDTO> listar(){
		List<CEP> lista = (List<CEP>) repositorio.findAll();
		return CEPDTO.converter(lista);
	}
	
	
	@PostMapping
	@RequestMapping("/cadastra")
	public ResponseEntity<CEPDTO> cadastrar(@RequestParam(value = "campo", defaultValue = "none") String campo,
			@RequestParam(value = "logradouro", defaultValue = "none") String l,
	@RequestParam(value = "complemento", defaultValue = "none") String c,
	@RequestParam(value = "bairro", defaultValue = "none")	String b, 
	@RequestParam(value = "localidade", defaultValue = "none") String l1, 
	@RequestParam(value = "uf", defaultValue = "none") String uf, 
	@RequestParam(value = "ibge", defaultValue = "none") String ibge, 
	@RequestParam(value = "gia", defaultValue = "none") String gia, 
	@RequestParam(value = "ddd", defaultValue = "none") String ddd, 
	@RequestParam(value = "siafi", defaultValue = "none") String siafi,
	UriComponentsBuilder uriBuilder){
		CEP cep = new CEP(campo, l, c, b, l1, uf, ibge, gia, ddd, siafi);
		String x = cep.getCampo();
		if(x == null || x.length() != 8) {
			return new ResponseEntity<CEPDTO>(HttpStatus.BAD_REQUEST);
		}
		for(int i = 0; i < x.length(); i++) {
			switch(x.charAt(i)) {
			case '0':
				break;
			case '1':
				break;
			case '2':
				break;
			case '3':
				break;
			case '4':
				break;
			case '5':
				break;
			case '6':
				break;
			case '7':
				break;
			case '8':
				break;
			case '9':
				break;
				default:
					return new ResponseEntity<CEPDTO>(HttpStatus.BAD_REQUEST);
			}
		}
		repositorio.save(cep);
		URI uri = uriBuilder.path("/ceps/{id}").buildAndExpand(cep.getId()).toUri();
		return ResponseEntity.created(uri).body(new CEPDTO(cep));
	}
	
	@RequestMapping("/detalha")
	@GetMapping
	public ResponseEntity<CEPDTO> detalhar(@RequestParam(value = "id", defaultValue = "0") Long id) {
		Optional<CEP> cepoptional = repositorio.findById(id);
		if(cepoptional.isPresent()) {
			return ResponseEntity.ok(new CEPDTO(cepoptional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@RequestMapping("/deleta")
	@DeleteMapping
	public ResponseEntity<?> remover(@RequestParam(value = "id", defaultValue = "0") Long id){
		Optional<CEP> optional = repositorio.findById(id);
		if(optional.isPresent()) {
			repositorio.deleteById(id);
			return ResponseEntity.ok().build();
		}return ResponseEntity.notFound().build();
	}
	
	@RequestMapping("/atualiza")
	@PutMapping
	public ResponseEntity<CEPDTO> atualizar(@RequestParam(value = "id", defaultValue = "0") Long id,
			@RequestBody CEPForm form){
		Optional<CEP> optional = repositorio.findById(id);
		if(optional.isPresent()) {
			CEP c = form.atualizar(id, repositorio);
			return ResponseEntity.ok(new CEPDTO(c));
		}return ResponseEntity.notFound().build();
	}
	
	
	
}
