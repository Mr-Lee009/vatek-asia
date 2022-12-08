package vn.com.vatekasia.entity;

import lombok.*;
import vn.com.vatekasia.enumeration.ESeason;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "season")
    private ESeason season;
    @Column(name = "price")
    private double price;
    @Column(name = "time_start")
    private LocalDateTime timeStart;
    @Column(name = "time_end")
    private LocalDateTime timeEnd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}
