package com.springques.question.Controller;

import com.springques.question.Model.StoreInput;
import com.springques.question.Model.StoreOutput;
import com.springques.question.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreConrtroller {

    @Autowired
    private StoreService storeService;

    @PostMapping("/getProdAvailability")
    public ResponseEntity<StoreOutput> getProductAvailability(@RequestBody StoreInput storeInput){
        storeService.getAvailabilityList();
        storeService.getCapacityList();
        String status = storeService.getStatus(storeInput.getReqDate());
        if(status.equals("No Capacity") || status.equals("No Availability") || status.equals("Available")){
            StoreOutput storeOutput = new StoreOutput(storeInput,status);
            return new ResponseEntity<StoreOutput>(storeOutput, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
