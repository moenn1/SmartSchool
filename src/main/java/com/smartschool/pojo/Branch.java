package com.smartschool.pojo;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDateAccreditation() {
        return dateAccreditation;
    }

    public void setDateAccreditation(String dateAccreditation) {
        this.dateAccreditation = dateAccreditation;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String dateAccreditation;

    @OneToMany
    private List<Level> levels;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


}
