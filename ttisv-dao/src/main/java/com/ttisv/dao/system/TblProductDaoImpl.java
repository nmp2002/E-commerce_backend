package com.ttisv.dao.system;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.PageResponse;
import com.ttisv.bean.system.TblProduct;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository
public class TblProductDaoImpl extends BaseDaoImpl<TblProduct> implements TblProductDao {

    @Override
    public TblProduct findByProductNameAndCategory(String productName, Long categoryId) {
        Session session = this.getCurrentSession();
        try {
            String sql = "SELECT p FROM TblProduct p WHERE p.productName = :productName AND p.categoryId = :categoryId";
            Query query = session.createQuery(sql)
                                 .setParameter("productName", productName)
                                 .setParameter("categoryId", categoryId);
            return (TblProduct) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TblProduct> getProductsByCategoryId(Long categoryId) {
        Session session = this.getCurrentSession();
        try {
            String sql = "SELECT p FROM TblProduct p WHERE p.categoryId = :categoryId";
            Query query = session.createQuery(sql)
                                 .setParameter("categoryId", categoryId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TblProduct findProductById(Long id) {
        try {
            Session session = this.getCurrentSession();
            String sql = "SELECT p FROM TblProduct p WHERE p.id = :id";
            Query query = session.createQuery(sql)
                                 .setParameter("id", id);
            return (TblProduct) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Optional: tìm theo tên gần đúng
    @Override
    public List<TblProduct> searchByProductName(String keyword) {
        Session session = this.getCurrentSession();
        try {
            String sql = "SELECT p FROM TblProduct p WHERE LOWER(p.productName) LIKE :keyword";
            Query query = session.createQuery(sql)
                                 .setParameter("keyword", "%" + keyword.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TblProduct createProduct(TblProduct product) {
        try {
            Session session = this.getCurrentSession();
            session.save(product);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TblProduct updateProduct(TblProduct product) {
        try {
            Session session = this.getCurrentSession();
            session.update(product);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteProduct(Long id) {
        try {
            Session session = this.getCurrentSession();
            TblProduct product = session.find(TblProduct.class, id);
            if (product != null) {
                session.delete(product);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PageResponse<TblProduct> getAllProducts(int page, int size, String search, Long categoryId) {
        Session session = this.getCurrentSession();
        PageResponse<TblProduct> response = new PageResponse<>();

        try {
            StringBuilder hql = new StringBuilder("FROM TblProduct p WHERE 1=1");

            if (search != null && !search.trim().isEmpty()) {
                hql.append(" AND LOWER(p.productName) LIKE :search");
            }
            if (categoryId != null) {
                hql.append(" AND p.categoryId = :categoryId");
            }

            String countHql = "SELECT COUNT(p.id) " + hql.toString();

            // Query đếm tổng
            Query countQuery = session.createQuery(countHql);
            if (search != null && !search.trim().isEmpty()) {
                countQuery.setParameter("search", "%" + search.trim().toLowerCase() + "%");
            }
            if (categoryId != null) {
                countQuery.setParameter("categoryId", categoryId);
            }
            Long totalItems = (Long) countQuery.getSingleResult();

            // Query lấy danh sách
            Query dataQuery = session.createQuery("SELECT p " + hql.toString());
            if (search != null && !search.trim().isEmpty()) {
                dataQuery.setParameter("search", "%" + search.trim().toLowerCase() + "%");
            }
            if (categoryId != null) {
                dataQuery.setParameter("categoryId", categoryId);
            }

            dataQuery.setFirstResult((page - 1) * size);
            dataQuery.setMaxResults(size);

            List<TblProduct> items = dataQuery.getResultList();

            // Set kết quả vào PageResponse
            response.setItems(items);
            response.setTotalItems(totalItems);
            response.setTotalPages((int) Math.ceil((double) totalItems / size));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public List<TblProduct> findByGroupCode(String groupCode) {
        try {
            Session session = this.getCurrentSession();
            // Tạm thời xóa JOIN FETCH để kiểm tra
            String hql = "SELECT p FROM TblProduct p WHERE p.groupCode = :groupCode";
            
            List<TblProduct> results = session.createQuery(hql, TblProduct.class)
                                              .setParameter("groupCode", groupCode)
                                              .getResultList();

            return results;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TblProduct> getFeaturedProducts() {
        try {
            Session session = this.getCurrentSession();
            String hql = "SELECT p FROM TblProduct p ORDER BY p.stockQuantity DESC";
            Query query = session.createQuery(hql);
            query.setMaxResults(8); // Lấy 8 sản phẩm còn hàng nhiều nhất
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
