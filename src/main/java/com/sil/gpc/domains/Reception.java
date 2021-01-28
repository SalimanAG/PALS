package com.sil.gpc.domains;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reception {

	@Id
	@Column(length = 12)
	private String numReception;
	@Column(length = 150)
	private String observation;
	private Date dateReception;
	
	public Reception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reception(String numReception, String observation, Date dateReception) {
		super();
		this.numReception = numReception;
		this.observation = observation;
		this.dateReception = dateReception; 
	}

	public String getNumReception() {
		return numReception;
	}

	public void setNumReception(String numReception) {
		this.numReception = numReception;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getDateReception() {
		return dateReception;
	}

	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}

	@Override
	public String toString() {
		return "Reception [numReception=" + numReception + ", observation=" + observation + ", dateReception="
				+ dateReception + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateReception, numReception, observation);
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
		Reception other = (Reception) obj;
		return Objects.equals(dateReception, other.dateReception) && Objects.equals(numReception, other.numReception)
				&& Objects.equals(observation, other.observation);
	}
	
}
