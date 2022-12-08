package vn.com.vatekasia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vatekasia.enumeration.ERoomStatus;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ERoomStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}
