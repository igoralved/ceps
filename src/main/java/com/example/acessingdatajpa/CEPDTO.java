package com.example.acessingdatajpa;

import java.util.List;
import java.util.stream.Collectors;

public class CEPDTO {

	private Long id;
	
	private String campo;
	
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	
	public CEPDTO(CEP c0) {
		this.id = c0.getId();
		this.campo = c0.getCampo();
		this.logradouro = c0.getLogradouro();
		this.complemento = c0.getComplemento();
		this.bairro = c0.getBairro();
		this.localidade = c0.getLocalidade();
		this.uf = c0.getUf();
		this.ibge = c0.getIBGE();
		this.gia = c0.getGia();
		this.ddd = c0.getDDD();
		this.siafi = c0.getSiafi();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String c) {
		this.complemento = c;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getLocalidade() {
		return localidade;
	}
	
	public String getUf() {
		return uf;
	}
	
	public String getIBGE() {
		return ibge;
	}
	
	public String getGia() {
		return gia;
	}
	
	public String getDDD() {
		return ddd;
	}
	
	public String getSiafi() {
		return siafi;
	}
	
	public static List<CEPDTO> converter(List<CEP> lista){
		return lista.stream().map(CEPDTO::new).collect(Collectors.toList());
	}
	
	
}
