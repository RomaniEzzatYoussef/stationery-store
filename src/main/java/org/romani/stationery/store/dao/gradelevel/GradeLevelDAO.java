package org.romani.stationery.store.dao.gradelevel;

import org.romani.stationery.store.models.GradeLevel;
import java.util.List;


public interface GradeLevelDAO {


    public List<GradeLevel> getGradeLevels();

    public void saveGradeLevel(GradeLevel gradeLevel);

    public GradeLevel getGradeLevel(int id);

    public void deleteGradeLevel(int id);
}
