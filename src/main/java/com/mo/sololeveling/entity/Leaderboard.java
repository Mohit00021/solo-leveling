//package com.mo.sololeveling.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Leaderboard {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "category_skills_id")
//    private Skills category;
//
//    @ManyToOne
//    @JoinColumn(name = "player_id")
//    private Player player;
//
//
//    private Long rank;
//
//    private Double score;
//}
