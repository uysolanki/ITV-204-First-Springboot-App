package com.itvedant.cms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
public class Actor {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ano;
		private String aname;
		private int age;

		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		   @JoinTable(
		           name = "bollywood",
		           joinColumns = @JoinColumn(name = "fano"),
		           inverseJoinColumns = @JoinColumn(name = "fmno")
		           )
		List<Movie> porfolio;
}
