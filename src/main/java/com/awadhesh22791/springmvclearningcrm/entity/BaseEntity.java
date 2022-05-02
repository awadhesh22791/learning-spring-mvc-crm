package com.awadhesh22791.springmvclearningcrm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
	
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
	
}
