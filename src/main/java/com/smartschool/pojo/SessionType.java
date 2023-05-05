package com.smartschool.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SessionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "sessionType")
    private List<Absence> absences = new ArrayList<>();

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

}
