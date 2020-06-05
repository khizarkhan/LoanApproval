package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String name;
	    private String email;
	    private String role;
	    private String password;
	    public User(String name, String email, String role) {
			super();
			this.name = name;
			this.email = email;
			this.role = role;
		}
	    public User() {
	    }

        @Column
	    public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Column
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		  @Column
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		  @Column
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		  @Column
		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		

	    

	    
}
