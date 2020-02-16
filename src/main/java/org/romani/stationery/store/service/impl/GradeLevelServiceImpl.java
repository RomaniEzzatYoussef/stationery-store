package org.romani.stationery.store.service.impl;

import org.romani.stationery.store.dao.GradeLevelDAO;
import org.romani.stationery.store.models.GradeLevel;
import org.romani.stationery.store.service.GradeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class GradeLevelServiceImpl implements GradeLevelService {

    @Autowired
    private GradeLevelDAO gradeLevelDAO;

    @Override
    @Transactional
    public List<GradeLevel> getGradeLevels() {
        return gradeLevelDAO.getGradeLevels();
    }

    @Override
    @Transactional
    public void saveGradeLevel(GradeLevel gradeLevel) {

        gradeLevelDAO.saveGradeLevel(gradeLevel);
    }

    @Override
    @Transactional
    public GradeLevel getGradeLevel(int id) {

        return gradeLevelDAO.getGradeLevel(id);
    }

    @Override
    @Transactional
    public void deleteGradeLevel(int id) {

        gradeLevelDAO.deleteGradeLevel(id);
    }
}





