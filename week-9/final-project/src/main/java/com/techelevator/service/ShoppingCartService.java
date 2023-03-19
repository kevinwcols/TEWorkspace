package com.techelevator.service;

import com.techelevator.model.TaxDto;
import com.techelevator.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@Component
public class ShoppingCartService {

    // Import userDao methods
    private User userModel;

    // Get current Users state code, return the percentage and convert into a decimal
    public TaxDto getSalesTax(){
        String getStateCode =  userModel.getStateCode();
        String url = "https://teapi.netlify.app/api/statetax?state="+getStateCode;

        RestTemplate restTemplate = new RestTemplate();

        TaxDto salesTax = restTemplate.getForObject(url, TaxDto.class);

        return salesTax;
    }

/*  needs to be in controller as this is where the user logic will be used
  public String whoAmI( Principal principal ) {
        return principal.getName();
    }
*/
}
