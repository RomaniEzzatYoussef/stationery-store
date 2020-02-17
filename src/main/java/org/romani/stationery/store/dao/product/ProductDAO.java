package org.romani.stationery.store.dao.product;

import org.romani.stationery.store.models.Product;
import java.util.List;

public interface ProductDAO {

    public List<Product> getProducts();

    public void saveProduct(Product product);

    public Product getProduct(int id);

    public void deleteProduct(int id);
}
