package vn.com.vatekasia.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	private String description;
	private String expiredDate;
	private String condition;
	private String status;
	private String discountAmount;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
}
