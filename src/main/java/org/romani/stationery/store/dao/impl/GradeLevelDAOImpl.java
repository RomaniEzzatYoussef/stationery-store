package org.romani.stationery.store.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.romani.stationery.store.dao.GradeLevelDAO;
import org.romani.stationery.store.models.GradeLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeLevelDAOImpl implements GradeLevelDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GradeLevel> getGradeLevels() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<GradeLevel> gradeLevelQuery = currentSession.createQuery("from GradeLevel", GradeLevel.class);
        List<GradeLevel> gradeLevels = gradeLevelQuery.getResultList();

        return gradeLevels;
    }

    @Override
    public void saveGradeLevel(GradeLevel gradeLevel) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(gradeLevel);

    }

    @Override
    public GradeLevel getGradeLevel(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        GradeLevel gradeLevel = currentSession.get(GradeLevel.class, id);

        return gradeLevel;
    }

    @Override
    public void deleteGradeLevel(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from GradeLevel where id=:gradeLevelId");
        query.setParameter("gradeLevelId", id);

        query.executeUpdate();
    }

}
