/*
 * Author: Omar S. Gómez
 * Date: January 2020
 * Course: Software Architectures
 */
package net.springboot.restapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oil_production")
public class OilProduction {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String month;
	 
	 private Integer production;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getProduction() {
		return production;
	}

	public void setProduction(Integer production) {
		this.production = production;
	}	 
	
}
