package org.romani.stationery.store.dao.grade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.romani.stationery.store.models.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeDAOImpl implements GradeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Grade> getGrades() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Grade> gradeQuery = currentSession.createQuery("from Grade", Grade.class);
        List<Grade> grades = gradeQuery.getResultList();

        return grades;
    }

    @Override
    public void saveGrade(Grade grade) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(grade);

    }

    @Override
    public Grade getGrade(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Grade grade = currentSession.get(Grade.class, id);

        return grade;
    }

    @Override
    public void deleteGrade(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Grade where id=:gradeId");
        query.setParameter("gradeId", id);

        query.executeUpdate();
    }

}
