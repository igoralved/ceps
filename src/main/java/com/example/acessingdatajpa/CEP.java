package com.example.acessingdatajpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
public class CEP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	public CEP() {
		
	}
	
	public CEP(String field, String l, String c, String b, String l1, String uf, String ibge, String gia, 
			String ddd, String siafi) {
		this.campo = field;
		this.logradouro = l;
		this.complemento = c;
		this.bairro = b;
		this.localidade = l1;
		this.uf = uf;
		this.ibge = ibge;
		this.gia = gia;
		this.ddd = ddd;
		this.siafi = siafi;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public void setCampo(String field) {
		this.campo = field;
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
	
	public void setBairro(String b) {
		this.bairro = b;
	}
	
	public String getLocalidade() {
		return localidade;
	}
	
	public void setLocalidade(String l) {
		this.localidade = l;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getIBGE() {
		return ibge;
	}
	
	public void setIBGE(String ibge) {
		this.ibge = ibge;
	}
	
	public String getGia() {
		return gia;
	}
	
	public void setGia(String gia) {
		this.gia = gia;
	}
	
	public String getDDD() {
		return ddd;
	}
	
	public void setDDD(String ddd) {
		this.ddd = ddd;
	}
	
	public String getSiafi() {
		return siafi;
	}
	
	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}
	
}
