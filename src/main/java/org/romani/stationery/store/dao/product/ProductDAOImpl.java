package org.romani.stationery.store.dao.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.romani.stationery.store.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProducts() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Product> productQuery = currentSession.createQuery("from Product", Product.class);
        List<Product> products = productQuery.getResultList();

        return products;
    }

    @Override
    public void saveProduct(Product product) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(product);

    }

    @Override
    public Product getProduct(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product product = currentSession.get(Product.class, id);

        return product;
    }

    @Override
    public void deleteProduct(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Product where id=:productId");
        query.setParameter("productId", id);

        query.executeUpdate();
    }

}
