package org.romani.stationery.store.service.gradelevel;

import org.romani.stationery.store.models.GradeLevel;
import java.util.List;

public interface GradeLevelService {

    public List<GradeLevel> getGradeLevels();

    public void saveGradeLevel(GradeLevel gradeLevel);

    public GradeLevel getGradeLevel(int id);

    public void deleteGradeLevel(int id);
}
