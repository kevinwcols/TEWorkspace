package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/auctions")
// Step Four: Add authentication to controller methods - do this in 2 lines of code
@PreAuthorize("isAuthenticated()")
// End of Step Four
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    // Step Four: Add authentication to controller methods - do this in 2 lines of code
    @PreAuthorize("permitAll()")
    // End of Step Four
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte) {

        if (!title_like.equals("")) {
            return dao.searchByTitle(title_like);
        }
        if (currentBid_lte > 0) {
            return dao.searchByPrice(currentBid_lte);
        }

        return dao.list();
    }

    // @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        Auction auction = dao.get(id);
        if (auction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        } else {
            return auction;
        }
    }

    // Step Five: Add authorization roles - create(): allow CREATOR and ADMIN roles
    @PreAuthorize("hasAnyRole('ADMIN', 'CREATOR')")
    // End of Step Five
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction create(@Valid @RequestBody Auction auction) {
        return dao.create(auction);
    }

    // Step Five: Add authorization roles - update(): allow CREATOR and ADMIN roles
    @PreAuthorize("hasAnyRole('ADMIN', 'CREATOR')")
    // End of Step Five
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Auction update(@Valid @RequestBody Auction auction, @PathVariable int id) {
        Auction updatedAuction = dao.update(auction, id);
        if (updatedAuction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        } else {
            return updatedAuction;
        }
    }

    // Step Five: Add authorization roles - delete(): allow ADMIN role
    @PreAuthorize("hasRole('ADMIN')")
    // End of Step Five
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }

    // Step Six: Return user identity (return the logged in user's name) - Add Principal class variable to method and return principal.getName()
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/whoami")
    public String whoAmI( Principal principal ) {
        return principal.getName();
       // return "";
    }

}
