/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.dao;

import ac.dia.pojo.Product;
import ac.dia.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Round-32
 */
public class ProductDao {
    
    
    public List<Product> getAll(){
    
    Session s= HibernateUtil.getSessionFactory().getCurrentSession();
    List<Product> products = new ArrayList<Product>();
    try{
    s.beginTransaction();
    products = s.createCriteria(Product.class).list();
    s.getTransaction().commit();
    } catch(Exception e){
    e.printStackTrace();
    
    }
    return products;
    }
    
    
    
    public void create(Product p){
    
    Session s= HibernateUtil.getSessionFactory().getCurrentSession();
    try{
        s.beginTransaction();
        s.save(p);
        s.getTransaction().commit();
    
    
    }catch(Exception e){
        e.printStackTrace();
        s.getTransaction().rollback();
    }
    }
    
    
    
    public void remove(Product p){
    
    Session s= HibernateUtil.getSessionFactory().getCurrentSession();
    try{
        s.beginTransaction();
        s.delete(p);
        s.getTransaction().commit();
    
    
    }catch(Exception e){
        e.printStackTrace();
        s.getTransaction().rollback();
    }
    }
    
    
    public void edit(Product p){
    
    Session s= HibernateUtil.getSessionFactory().getCurrentSession();
    try{
        s.beginTransaction();
        System.out.println(p.getDescription()+"---------");
        s.update(p);
        s.getTransaction().commit();
    
    
    }catch(Exception e){
        e.printStackTrace();
        s.getTransaction().rollback();
    }
    }
    
    
    
    // For Finding Product...
    public Product getProduct (int id){
    
    Session s= HibernateUtil.getSessionFactory().getCurrentSession();
    Product p = new Product();
    try{
        s.beginTransaction();
        p = (Product) s.get(Product.class, id);
        s.getTransaction().commit();
    
    
    }catch(Exception e){
        e.printStackTrace();
        s.getTransaction().rollback();
    }
    
    return p;
    }
    
    
    
    
}
