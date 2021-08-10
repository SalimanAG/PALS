package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OpeJournalSetting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numParam;
	private String operation;
	private String journal;
	private Date dateDebut;
	private Date dateFin;

	public OpeJournalSetting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpeJournalSetting(Long numParam, String operation, String journal, Date dateDebut, Date dateFin) {
		super();
		this.numParam = numParam;
		this.operation = operation;
		this.journal = journal;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getNumParam() {
		return numParam;
	}

	public void setNumParam(Long numParam) {
		this.numParam = numParam;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "OpeJournalSetting [numParam=" + numParam + ", operation=" + operation + ", journal=" + journal
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	
}
