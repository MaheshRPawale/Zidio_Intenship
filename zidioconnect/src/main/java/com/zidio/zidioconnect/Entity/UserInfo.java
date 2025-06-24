package com.zidio.zidioconnect.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserInfo {
	
	@Id
	//@GeneratedValue
   @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Auto increment
	private Long id;

	@Column(nullable = false , length=100)
	private String name;
	
	@Column(nullable = false ,unique=true,length =255)
	private String email;
	
	@Column(nullable = false) // false insert compulsary , true optional or default
	private String password;
	
	@Column(nullable=false)
	private String rol; // STUDENT, RECRUITER, ADMIN
}
