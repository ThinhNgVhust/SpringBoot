package com.thinhbka.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	     
	    @Column(nullable = false, unique = true, length = 45)
	    private String email;
	     
	    @Column(nullable = false, length = 64)
	    private String password;
	     
	    @Column(name = "first_name", nullable = false, length = 20)
	    private String firstName;
	     
	    @Column(name = "last_name", nullable = false, length = 20)
	    private String lastName;
	    
	    @Column(name="photo", nullable = true,length = 64)
	    private String photo;
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		
		public String getPhoto() {
			return this.photo;
		}
		
		@Transient
	    public String getPhotosImagePath() {
	        if (photo == null || id == null) return null;
	         
	        return "/user-photos/" + id + "/" + photo;
	    }
}
