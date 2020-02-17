package org.romani.stationery.store.service.grade;

import org.romani.stationery.store.models.Grade;

import java.util.List;

public interface GradeService {

    public List<Grade> getGrades();

    public void saveGrade(Grade grade);

    public Grade getGrade(int id);

    public void deleteGrade(int id);
}
