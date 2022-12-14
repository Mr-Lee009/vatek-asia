package vn.com.vatekasia.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class EUser {

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

}
