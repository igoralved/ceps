package com.example.acessingdatajpa;

import java.util.List;
import java.util.Optional;

public class CEPForm {

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
	
	public CEP atualizar(Long id, CEPRepository rep) {
		Optional<CEP> o = rep.findById(id);
		CEP c = o.get();
		c.setBairro(bairro);
		c.setCampo(campo);
		c.setComplemento(complemento);
		c.setLogradouro(logradouro);
		c.setLocalidade(localidade);
		c.setUf(uf);
		c.setIBGE(ibge);				
		c.setGia(gia);
		c.setSiafi(siafi);
		return c;
	}
	
}
