package vn.com.vatekasia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.vatekasia.service.RoleEnum;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(updatable = false, nullable = false)
	private Long clientId;

	@Column(unique = true)
	private String username;

	@Column
	private String fullname;

	@Column
	private String phonenumber;

	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@Column
	private String active;

	@Column
	@Enumerated(EnumType.STRING)
	private RoleEnum role;

}
