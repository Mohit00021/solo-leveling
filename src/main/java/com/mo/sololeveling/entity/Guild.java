package com.mo.sololeveling.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guild_id")
    private Long id;
    private String guildName;
    private LocalDate creationDate;
    private Long capacity;

}
