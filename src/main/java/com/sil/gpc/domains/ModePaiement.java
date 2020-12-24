package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "ModePaiement")
public class ModePaiement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long idModePay;

	@Column(name = "codeModPay", length = 5)
	@PrimaryKeyJoinColumn(name = "ModPay_PK")//*******************Pourquoi encore ceci
	private String codeModPay;
	@Column(name="libeModPay",nullable = false, length = 30, unique = true, updatable = true)
	private String libeModPay;
	

	@OneToMany(targetEntity = OpCaisse.class, mappedBy = "modePaiement")
	public List<ModePaiement> opérationsMode;//**************Pas bien compris, ça doit être OpCaisse non ?
	
	public ModePaiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModePaiement(String codeModPay, String libeModPay) {
		super();
		this.codeModPay = codeModPay;
		this.libeModPay = libeModPay;
	}

	public String getCodeModPay() {
		return codeModPay;
	}

	public void setCodeModPay(String codeModPay) {
		this.codeModPay = codeModPay;
	}

	public String getLibeModPay() {
		return libeModPay;
	}

	public void setLibeModPay(String libeModPay) {
		this.libeModPay = libeModPay;
	}
	
	
	
}
