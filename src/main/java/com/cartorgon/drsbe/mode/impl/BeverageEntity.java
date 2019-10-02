package com.cartorgon.drsbe.mode.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.cartorgon.drsbe.mode.Beverage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BEVERAGE")
@Validated
@Data @AllArgsConstructor @NoArgsConstructor
public class BeverageEntity implements Beverage {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String name;
	private int graduation;
}