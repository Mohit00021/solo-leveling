package com.mo.sololeveling.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    private String userName;
    private String title;
    private long xp;
    private LocalDate startDate;
    private String playerRank;
    private String speciality;

    @ManyToMany
    @JoinTable(
            name = "player_guild_membership",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "guild_id")
    )
    Set<Guild> guilds;
}
