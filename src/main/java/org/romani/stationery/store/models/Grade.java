package org.romani.stationery.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private int gradeId;

    @Column(name = "grade_number")
    @JsonIgnore
    private int grade;

    @OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "grade_id")
    @Fetch(FetchMode.JOIN)
    private List<ClassifiedProduct> classifiedProducts;

    public Grade() {
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<ClassifiedProduct> getClassifiedProducts() {
        return classifiedProducts;
    }

    public void setClassifiedProducts(List<ClassifiedProduct> classifiedProducts) {
        this.classifiedProducts = classifiedProducts;
    }
}
