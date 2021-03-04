package com.sil.gpc.domains;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inventaire {
@Id
	private String numInv;
	private Date dateInv;
	private String descrInv;
	
	@ManyToOne(targetEntity = Exercice.class)
	@JoinColumn(referencedColumnName = "codeExercice")
	private Exercice exo;
	
	@ManyToOne(targetEntity = Magasin.class)
	@JoinColumn(referencedColumnName = "codeMagasin")
	private Magasin magasin;

	/**
	 * 
	 */
	public Inventaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numInv
	 * @param dateInv
	 * @param descrInv
	 * @param exo
	 * @param magasin
	 */
	public Inventaire(String numInv, Date dateInv, String descrInv, Exercice exo, Magasin magasin) {
		this.numInv = numInv;
		this.dateInv = dateInv;
		this.descrInv = descrInv;
		this.exo = exo;
		this.magasin = magasin;
	}

	/**
	 * @return the numInv
	 */
	public String getNumInv() {
		return numInv;
	}

	/**
	 * @param numInv the numInv to set
	 */
	public void setNumInv(String numInv) {
		this.numInv = numInv;
	}

	/**
	 * @return the dateInv
	 */
	public Date getDateInv() {
		return dateInv;
	}

	/**
	 * @param dateInv the dateInv to set
	 */
	public void setDateInv(Date dateInv) {
		this.dateInv = dateInv;
	}

	/**
	 * @return the descrInv
	 */
	public String getDescrInv() {
		return descrInv;
	}

	/**
	 * @param descrInv the descrInv to set
	 */
	public void setDescrInv(String descrInv) {
		this.descrInv = descrInv;
	}

	/**
	 * @return the exo
	 */
	public Exercice getExo() {
		return exo;
	}

	/**
	 * @param exo the exo to set
	 */
	public void setExo(Exercice exo) {
		this.exo = exo;
	}

	/**
	 * @return the magasin
	 */
	public Magasin getMagasin() {
		return magasin;
	}

	/**
	 * @param magasin the magasin to set
	 */
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	@Override
	public String toString() {
		return "Inventaire [numInv=" + numInv + ", dateInv=" + dateInv + ", descrInv=" + descrInv + ", exo=" + exo
				+ ", magasin=" + magasin + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateInv, descrInv, exo, magasin, numInv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Inventaire other = (Inventaire) obj;
		return Objects.equals(dateInv, other.dateInv) && Objects.equals(descrInv, other.descrInv)
				&& Objects.equals(exo, other.exo) && Objects.equals(magasin, other.magasin)
				&& Objects.equals(numInv, other.numInv);
	}
	
	
}
