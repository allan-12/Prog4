package com.example.prog4.model;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patrimoine {
    private String possesseur;
    private LocalDateTime derniereModification;

}
