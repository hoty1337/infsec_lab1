package com.hoty.sec.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "data_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
}
