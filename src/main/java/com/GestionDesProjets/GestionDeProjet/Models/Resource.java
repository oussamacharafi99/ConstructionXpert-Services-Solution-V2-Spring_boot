package com.GestionDesProjets.GestionDeProjet.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Task_ID", nullable = false)
    private Task task;

    @Column(name = "Resource_Name", nullable = false)
    private String resourceName;

    @Column(name = "Resource_Type", nullable = false)
    private String resourceType;;

    @Column(name = "Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

}
