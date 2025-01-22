package com.itvedant.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="custid", length = 10)
	private int custId;  //cust_id
	@Column(name="custname")
	private String custName;  //cust_name
	
	@Column(unique = true,name = "custemail")
	private String custEmail;
	@Column(unique = true,name = "custmobile")
	private String custMobile;
}
