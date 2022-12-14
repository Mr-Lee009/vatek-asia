package vn.com.vatekasia.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import vn.com.vatekasia.service.TypePersonEnum;

@Table
@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long phoneNumber;
	private String email;
	private Long age;
	private String checkIn;
	private String checkOut;
	private Long cartId;
	private Date bookingDate;
	@Column
	@Enumerated(EnumType.STRING)
	private TypePersonEnum typePersonEnum;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

}
