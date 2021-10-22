package com.springques.question.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Availability {
    private String storeNo;
    private String productId;
    private String date;
    private double availQty;
}
