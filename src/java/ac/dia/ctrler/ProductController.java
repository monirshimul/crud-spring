/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.ctrler;

import ac.dia.dao.ProductDao;
import ac.dia.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Round-32
 */


@Controller
@RequestMapping("/product")
public class ProductController {
    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll(Model m){//MVC er ekti class model.(view model)
      ProductDao pdao = new ProductDao();
      m.addAttribute("list", pdao.getAll());
      
      return "index";
    }
    
    
    
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam(value = "id")int id){
      ProductDao pdao = new ProductDao();
      Product p = pdao.getProduct(id);
      pdao.remove(p);
      
      return "redirect:all.htm";
    }
    
    
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id")int id,Model m){
      ProductDao pdao = new ProductDao();
      Product p = pdao.getProduct(id);
      m.addAttribute("pro", p);
      
      
      return "edit";
    }
    
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "product")Product p){
      ProductDao pdao = new ProductDao();
      pdao.edit(p);
        System.out.println(p.getDescription());
        
      
      return "redirect:all.htm";
    }
    
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute(value = "product")Product p){
      ProductDao pdao = new ProductDao();
      pdao.create(p);
        System.out.println(p.getDescription());
        
      
      return "redirect:all.htm";
    }
    
    
    
    
    @RequestMapping(value = "/newadd", method = RequestMethod.GET)
    public String newadd(@ModelAttribute(value = "product")Product p){

      return "add";
    }
    
}
