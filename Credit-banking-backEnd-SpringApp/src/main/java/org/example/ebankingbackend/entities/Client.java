package org.example.ebankingbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
@Data

@Entity
public class Client {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Credit> credits = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // Getters and Setters
}