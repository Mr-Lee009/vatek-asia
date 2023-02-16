package vn.com.vatekasia.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "words")
@Entity
@Data
public class words {
    @Id
    private int id;
    @Column(name = "WORD")
    private String word;

    @Column(name = "MEAN")
    private String mean;

    @Column(name = "TOPIC")
    private String topic;
    @Column(name = "EXAMPLE")
    private String example;

}
