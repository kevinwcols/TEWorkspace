package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import com.techelevator.ssgeek.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaleDao implements SaleDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcSaleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

/* Get a sale from the datastore that has the given id.
   If the id is not found, return null.  */
    @Override
    public Sale getSale(int saleId) {
        Sale sale = null;

        String getSaleSql =
                "SELECT c.name, s.sale_id, s.customer_id, s.sale_date, s.ship_date FROM sale s " +
                        "JOIN customer c on s.customer_id = c.customer_id " +
                        "WHERE s.sale_id = ?;";

        SqlRowSet getSaleResults =
                jdbcTemplate.queryForRowSet(getSaleSql, saleId);
        while (getSaleResults.next()){
            sale = mapRowToSale(getSaleResults);
        }

        return sale;
    }

/* Get all sales from the datastore that have not been shipped (ship date is null),
   ordered by sale_id. Only unshipped orders may be shipped or deleted.  */
    @Override
    public List<Sale> getSalesUnshipped() {
        List<Sale> sale = new ArrayList<>();

        String getSaleSql =
                "SELECT c.name, s.sale_id, s.customer_id, s.sale_date, s.ship_date FROM sale s " +
                        "JOIN customer c on s.customer_id = c.customer_id " +
                        "WHERE s.ship_date is null " +
                        "ORDER BY s.sale_id;";

        SqlRowSet getSaleResults =
                jdbcTemplate.queryForRowSet(getSaleSql);
        while (getSaleResults.next()){
            sale.add(mapRowToSale(getSaleResults));
        }

        return sale;
    }

/* Get all sales from the datastore for a given customer, ordered by sale_id.  */
    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
        List<Sale> sale = new ArrayList<>();

        String getSaleSql =
                "SELECT c.name, s.sale_id, s.customer_id, s.sale_date, s.ship_date FROM sale s " +
                        "JOIN customer c on s.customer_id = c.customer_id " +
                        "WHERE s.customer_id = ? " +
                        "ORDER BY s.sale_id;";

        SqlRowSet getSaleResults =
                jdbcTemplate.queryForRowSet(getSaleSql, customerId);
        while (getSaleResults.next()){
            sale.add(mapRowToSale(getSaleResults));
        }

        return sale;
    }

/* Get all sales from the datastore for a given product, ordered by sale_id.  */
    @Override
    public List<Sale> getSalesByProductId(int productId) {
        List<Sale> sale = new ArrayList<>();

        String getSaleSql =
                "SELECT c.name, s.sale_id, s.customer_id, s.sale_date, s.ship_date FROM sale s " +
                        "JOIN customer c on s.customer_id = c.customer_id " +
                        "JOIN line_item li on s.sale_id = li.sale_id " +
                        "WHERE li.product_id = ? " +
                        "ORDER BY s.sale_id;";

        SqlRowSet getSaleResults =
                jdbcTemplate.queryForRowSet(getSaleSql, productId);
        while (getSaleResults.next()){
            sale.add(mapRowToSale(getSaleResults));
        }

        return sale;
    }

/* Add a new sale into the datastore.   */
    @Override
    public Sale createSale(Sale newSale) {
        String sql = "INSERT INTO sale ( customer_id, sale_date, ship_date ) " +
                "VALUES (?, ?, ?) RETURNING sale_id";
        Integer sale_id =
                jdbcTemplate.queryForObject(sql, Integer.class,
                        newSale.getCustomerId(), newSale.getSaleDate(), newSale.getShipDate());
        Sale tempSale = getSale(sale_id);

        return tempSale;
    }

/* Update a sale to the datastore. Only called on sales that are already in the datastore. */
    @Override
    public void updateSale(Sale updatedSale) {
        String sql = "UPDATE sale SET customer_id = ?, sale_date = ?, ship_date = ? " +
                        "WHERE sale_id = ?;";
        Integer numberOfRows =
                jdbcTemplate.update(sql, updatedSale.getCustomerId(), updatedSale.getSaleDate(), updatedSale.getShipDate(), updatedSale.getSaleId());

  }

/* Remove a sale from the datastore.
 * Only unshipped orders may be shipped or deleted.  */
    @Override
    public void deleteSale(int saleId) {
        String deleteLineItemSql = "DELETE FROM line_item li WHERE li.sale_id = ? "+
                                    "AND li.sale_id in (SELECT s.sale_id from sale s WHERE s.ship_date is null);";
        jdbcTemplate.update(deleteLineItemSql, saleId);

        String deleteSaleSql = "DELETE FROM sale WHERE sale_id = ? "+
                                    "AND ship_date is null;";
        jdbcTemplate.update(deleteSaleSql, saleId);
    }

    private Sale mapRowToSale(SqlRowSet results) {
        Sale sale = new Sale();
        sale.setSaleId(results.getInt("sale_id"));
        sale.setCustomerId(results.getInt("customer_id"));
        sale.setCustomerName(results.getString("name"));
        sale.setSaleDate(LocalDate.parse(results.getString("sale_date")));
        if ( results.getString("ship_date") != null ) {
            sale.setShipDate(LocalDate.parse(results.getString("ship_date"))); }
        else {  // else condition if no data is returned
            sale.setShipDate(null);
        }

        return sale;
    }
}
