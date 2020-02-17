package org.romani.stationery.store.service.grade;

import org.romani.stationery.store.dao.grade.GradeDAO;
import org.romani.stationery.store.models.Grade;
import org.romani.stationery.store.service.grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDAO gradeDAO;

    @Override
    @Transactional
    public List<Grade> getGrades() {
        return gradeDAO.getGrades();
    }

    @Override
    @Transactional
    public void saveGrade(Grade grade) {

        gradeDAO.saveGrade(grade);
    }

    @Override
    @Transactional
    public Grade getGrade(int id) {

        return gradeDAO.getGrade(id);
    }

    @Override
    @Transactional
    public void deleteGrade(int id) {

        gradeDAO.deleteGrade(id);
    }
}





