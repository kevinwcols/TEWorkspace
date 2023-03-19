package com.techelevator.auctions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController(AuctionDao dao) {
        this.dao = dao;
    }

    @RequestMapping( path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte) {

        if( !title_like.equals("") ) {
            return dao.searchByTitle(title_like);
        }
        if(currentBid_lte > 0) {
            return dao.searchByPrice(currentBid_lte);
        }

        return dao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        Auction auction = dao.get(id);
        if (auction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        } else {
            return dao.get(id);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)   // Step Two: Modify the create() method
    @RequestMapping( path = "", method = RequestMethod.POST)
    public Auction create(@Valid // Step Four: Update the controller's create() method To enforce validation in the controller, add an annotation before the Auction argument
                              @RequestBody Auction auction) {
        return dao.create(auction);
    }

    // Step Five: Implement the update() method
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Auction update(@Valid @RequestBody Auction auction, @PathVariable int id) {
        Auction checkAuction = dao.update(auction, id);
        if (checkAuction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        } else {
            return checkAuction;
         }
       //  return dao.update(auction, id);
    }

    // Step Six: Implement the delete() method
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
            dao.delete(id);
    }
}
