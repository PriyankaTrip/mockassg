package com.springques.question.Service;
import com.springques.question.Model.ProductList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductListService {

    List<ProductList> products = new ArrayList<>();
    public List<ProductList> getsortProducts(List<ProductList> productLists){
        System.out.println(productLists);

        return null;
    }
}
