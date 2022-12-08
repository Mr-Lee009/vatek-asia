package vn.com.vatekasia.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @CreationTimestamp
    @Column(name = "created_time")
    private LocalDateTime createdTime;
    @UpdateTimestamp
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
}
