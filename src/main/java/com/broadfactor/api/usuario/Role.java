package com.broadfactor.api.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class Role {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
}
