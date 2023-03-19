package com.techelevator.controller;

import com.techelevator.dao.ShoppingCartDao;
import com.techelevator.model.ShoppingCart;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping( path = "/cart" )
public class ShoppingCartController {

    private ShoppingCartDao shoppingCartDao;

    public ShoppingCartController(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    // GET /cart - get the user's cart (Required Use Case 4)
    @RequestMapping(method = RequestMethod.GET)
    public List<ShoppingCart> list() {

        return shoppingCartDao.getShoppingCart();
    }

    // POST /cart/items - add item to cart (Required Use Case 5)
    @RequestMapping(path = "/items", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Integer create(@Valid @RequestBody ShoppingCart shoppingCartProduct) {
        return shoppingCartDao.createShoppingCartProduct(shoppingCartProduct);
    }

    // DELETE /cart/items/{itemId} - remove item from cart (Required Use Case 6)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "items/{itemId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int cartItemId, int userId, int productId) {
        shoppingCartDao.removeProductFromShoppingCart(cartItemId, userId, productId);
    }

    @RequestMapping(path = "/whoami")
    public String whoAmI( Principal principal ) {
        return principal.getName();
    }
}
