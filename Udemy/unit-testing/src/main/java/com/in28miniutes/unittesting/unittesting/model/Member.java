package com.in28miniutes.unittesting.unittesting.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class Member {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private LocalDate birthday;

}
