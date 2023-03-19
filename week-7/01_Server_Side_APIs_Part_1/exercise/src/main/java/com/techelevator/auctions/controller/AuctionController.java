package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.techelevator.auctions.dao.MemoryAuctionDao.auctions;



@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    // Step Two: Implement the list() method
    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(value="title_like", defaultValue="") String title,
                              @RequestParam(value="currentBid_lte", defaultValue="0") double bid) {
        // Step Seven: Search by title and price
        if ( !title.isEmpty() && bid != 0 ) {
            return dao.searchByTitleAndPrice(title, bid);
        }
        // Step Five: Add searching by title
        else if (!title.isEmpty()) {
            return dao.searchByTitle(title);
        }  // Step Six: Add searching by price
        else if (bid != 0) {
            return dao.searchByPrice(bid);
        }
        // Step Two: Implement the list() method
        return dao.list();
    }

    // Step Three: Implement the get() action
    // @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }
    // End of Step Three

    // Step Four: Implement the create() action
    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction task) {
        // if (task != null) {
            return dao.create(task);
        // }
        // return null;
    }
    // End of Step Four
}
