package com.awadhesh22791.springmvclearningcrm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerListSorting {
	private Boolean sortByFirstName;
	private Boolean sortByLastName;
	private Boolean sortByEmail;
}
