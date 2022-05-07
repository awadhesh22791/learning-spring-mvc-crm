package com.awadhesh22791.springmvclearningcrm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6510599142407528994L;
	@NotNull
	@Size(min = 4,max = 45,message = "Mandatory field.")
	@Column(name = "first_name",nullable = false)
	private String firstName;
	@NotNull
	@Size(min = 4,max = 45,message = "Mandatory field.")
	@Column(name = "last_name",nullable = false)
	private String lastName;
	@NotNull
	@Size(min = 4,max = 45,message = "Mandatory field.")
	@Column(name = "email",nullable = false)
	private String email;
	
	@Formula("concat(first_name, ' ',last_name)")
	private String fullName;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private Integer id;

	@Column(name = "created_at",nullable = false)
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updated_at",nullable = false)
	@UpdateTimestamp
	private Date updatedAt;

	public void prepareToUpdate(Customer customer) {
		this.firstName=customer.getFirstName();
		this.lastName=customer.getLastName();
		this.email=customer.getEmail();
	}
	

}
