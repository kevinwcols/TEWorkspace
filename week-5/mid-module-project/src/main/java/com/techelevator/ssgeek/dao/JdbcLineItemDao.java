package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import com.techelevator.ssgeek.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcLineItemDao implements LineItemDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcLineItemDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Get all line items associated with a sale, ordered by line_item_id.  */
    @Override
    public List<LineItem> getLineItemsBySale(int saleId) {
        List<LineItem> lineItem = new ArrayList<>();

        String getLineItemSql =
                "SELECT li.line_item_id, li.sale_id, li.product_id, p.name, li.quantity, p.price FROM line_item li " +
                        "JOIN product p ON li.product_id = p.product_id " +
                        "WHERE li.sale_id = ? " +
                        "ORDER BY li.line_item_id;";

        SqlRowSet getLineItemResults =
                jdbcTemplate.queryForRowSet(getLineItemSql, saleId);
        while (getLineItemResults.next()){
            lineItem.add(mapRowToLineItem(getLineItemResults));
        }

        return lineItem;
    }

    private LineItem mapRowToLineItem(SqlRowSet results) {
        LineItem lineItem = new LineItem();
        lineItem.setLineItemId(results.getInt("line_item_id"));
        lineItem.setSaleId(results.getInt("sale_id"));
        lineItem.setProductId(results.getInt("product_id"));
        lineItem.setQuantity(results.getInt("quantity"));
        lineItem.setProductName(results.getString("name"));
        lineItem.setPrice(results.getBigDecimal("price"));

        return lineItem;
    }
}
