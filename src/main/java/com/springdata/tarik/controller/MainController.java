package com.springdata.tarik.controller;

import com.springdata.tarik.model.Category;
import com.springdata.tarik.model.Commit;
import com.springdata.tarik.model.Product;
import com.springdata.tarik.model.User;
import com.springdata.tarik.repository.CategoryRepository;
import com.springdata.tarik.repository.CommitRepository;
import com.springdata.tarik.repository.ProductRepository;
import com.springdata.tarik.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/hi")
    public String main() {

        return customerService.addCustomer();
    }

    @GetMapping(value = "/addcategories")
    public String addCategories() {
        Category category = new Category();
        category.setCategoryName("Kategori 1");
        categoryRepository.save(category);

        Category category2 = new Category();
        category2.setCategoryName("Kategori 2");
        categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setCategoryName("Kategori 3");
        categoryRepository.save(category3);

        Category category4 = new Category();
        category4.setCategoryName("Kategori 4");
        categoryRepository.save(category4);

        Category category5 = new Category();
        category5.setCategoryName("Kategori 5");
        categoryRepository.save(category5);

        Category category6 = new Category();
        category6.setCategoryName("Kategori 6");
        categoryRepository.save(category6);


        return "categori eklemece";
    }


    @GetMapping(value = "/addproduct")
    public String addProductWithSingleCategory() {
        Product product = new Product();
        product.setProductName("Product 1");
        product.getProductCategories().add(categoryRepository.findById(1L).orElse(null));
        productRepository.save(product);
        return "product eklendi";
    }

    @GetMapping(value = "/addproductmultiplecategories")
    public String addProductWithMultipleCategory() {
        Product product = new Product();
        product.setProductName("Product 2");
        product.getProductCategories().add(categoryRepository.findById(1L).orElse(null));
        product.getProductCategories().add(categoryRepository.findById(2L).orElse(null));
        product.getProductCategories().add(categoryRepository.findById(3L).orElse(null));
        productRepository.save(product);
        return "product eklendi";
    }


    @GetMapping(value = "/addsubcategories")
    public String addSubCategories() {
        Category category = new Category();
        category.setCategoryName("Kategori 6");
        category.getParentCategories().add(categoryRepository.findById(1L).orElse(null));
        categoryRepository.save(category);
        return "sub category eklendi";
    }

    @GetMapping(value = "/getProductsByCategories")
    public String getProductsByCategories() {
        List<Product> products = categoryRepository.findById(1L).orElse(null).getProducts();
        for (Product p : products) {
            System.out.println(p.getProductName());

        }


        return "ok";

    }

    @Autowired
    CommitRepository commitRepository;

    public List<Commit> betweendates(Date baslangic, Date bitis) {


        List<Commit> merhaba = commitRepository.findByDayBetweenOrderByUserAscDayDesc(baslangic, bitis);

        return merhaba;
    }


    public Boolean hasWork(List<Commit> commits) {
        for (int i = 0; i < commits.size() - 1; i++) {

            long diff = commits.get(i).getDay().getTime() - commits.get(i + 1).getDay().getTime();
            diff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

            if(diff>3){
                return false;
            }
        }

        return true;
    }

    @GetMapping(value = "/leyla")
    public List<Commit> merhaba() throws ParseException {
        Date baslangic = new SimpleDateFormat("yyyy-MM-dd").parse("2015-01-01");
        Date bitis = new SimpleDateFormat("yyyy-MM-dd").parse("2015-01-15");


        List<Commit> merhaba = betweendates(baslangic, bitis);
        hasWork(merhaba);
        Map<User, List<Commit>> users =
                merhaba.stream().collect(Collectors.groupingBy(Commit::getUser));

        for (Map.Entry<User, List<Commit>> entry : users.entrySet()) {
           if(hasWork(entry.getValue())){
               System.out.println(entry.getKey().getName());
           }
        }

        //users.entrySet().stream().forEach(userListEntry -> System.out.println(hasWork(userListEntry.getValue())));


        return merhaba;
    }


}
