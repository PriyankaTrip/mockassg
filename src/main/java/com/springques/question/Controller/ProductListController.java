package com.springques.question.Controller;

import com.springques.question.Model.ProductList;
import com.springques.question.Service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductListController {

    @Autowired
    public ProductListService productListService;
    @PostMapping("/sortProducts")
    public List<ProductList> getsortedList(@RequestBody List<ProductList> productLists){
        //System.out.println(productLists);
        return productListService.getsortProducts(productLists);

    }

}
