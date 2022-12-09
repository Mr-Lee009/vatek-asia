package vn.com.vatekasia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import vn.com.vatekasia.enumeration.EUserRole;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column
    @Enumerated(EnumType.STRING)
    private EUserRole role;
    @CreationTimestamp
    @Column(name = "created_time")
    private LocalDateTime createdTime;
    @UpdateTimestamp
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
}
