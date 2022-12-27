package vn.com.vatekasia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import vn.com.vatekasia.enumeration.SessonEnum;
import vn.com.vatekasia.enumeration.StatusRoomEnum;
import vn.com.vatekasia.enumeration.TypeRoomEnum;

import java.util.Date;

@Table
@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private SessonEnum seasons;
    private String floor;
    private double price;
    private Long quantity;
    private Date time;
    @Column
    @Enumerated(EnumType.STRING)
    private StatusRoomEnum status;
    @Column
    @Enumerated(EnumType.STRING)
    private TypeRoomEnum typeRoomEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billId")
    private Bill bill;

}
