package com.awadhesh22791.springmvclearningcrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{
	
	@Column(name = "first_name",nullable = false)
	private String firstName;
	@Column(name = "last_name",nullable = false)
	private String lastName;
	@Column(name = "email",nullable = false)
	private String email;
	
}
