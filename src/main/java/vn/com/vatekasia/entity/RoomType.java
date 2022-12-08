package vn.com.vatekasia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room_type")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomType extends BaseEntity {
    @Column(name = "name")
    private String name;
}
