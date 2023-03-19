package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.util.List;

public class JdbcProductDaoTests extends BaseDaoTests {

    static Double p1 = 19.99;
    static BigDecimal bp1 = BigDecimal.valueOf(p1.doubleValue());

    static Double p2 = 11.99;
    static BigDecimal bp2 = BigDecimal.valueOf(p2.doubleValue());

    static Double p3 = 509.99999999;
    static BigDecimal bp3 = BigDecimal.valueOf(p3.doubleValue());

    static Double p4 = 34.99;
    static BigDecimal bp4 = BigDecimal.valueOf(p3.doubleValue());

    private static final Product PRODUCT_1 = new Product(1, "Plate", "Crystal Dinner Plate", bp1, "plate.png");
    private static final Product PRODUCT_2 = new Product(2, "Flashlight", "Bright LED Flashlight", bp2, "flashlight.jpg");
    private static final Product PRODUCT_3 = new Product(3, "Watch", "Garmin GPS 930 watch", bp3, null);
    private static final Product PRODUCT_4 = new Product(4, "Long Sleeve Shirt", "Warm, fleece long sleeve shirt", bp4, "long-sleeve_fleece_shirt.gif");

    private JdbcProductDao productDao;
    private Product testProduct;

    @Before
    public void setup() {
        productDao = new JdbcProductDao(dataSource);
        testProduct = new Product(0, "Test Product", "Test Description", bp2, "test.gif");
    }

    @Test
    public void getProduct_returns_correct_product_for_id() {
        Product product = productDao.getProduct(1);
        Assert.assertNotNull("getProduct returned null", product);
        assertProductsMatch("getProduct returned wrong or partial data", PRODUCT_1, product);

        product = productDao.getProduct(4);
        Assert.assertNotNull("getCustomer returned null", product);
        assertProductsMatch("getCustomer returned wrong or partial data", PRODUCT_4, product);
    }

    @Test
    public void getProduct_returns_null_when_id_not_found() {
        Product product = productDao.getProduct(99);
        Assert.assertNull("getProduct failed to return null for id not in database", product);
    }

    @Test
    public void getProducts_returns_list_of_all_products() {
        List<Product> products = productDao.getProducts();
        Assert.assertEquals("getProducts returned wrong number of products", 4, products.size());
        Assert.assertEquals("getProducts: first product id does not match expected, check sort order",
                PRODUCT_1.getProductId(), products.get(0).getProductId());
        /* assertProductsMatch("getProducts", PRODUCT_1, products.get(1));
        assertProductsMatch("getProducts", PRODUCT_2, products.get(1));
        assertProductsMatch("getProducts", PRODUCT_3, products.get(2));
        assertProductsMatch("getProducts", PRODUCT_4, products.get(3));  */
    }

    @Test
    public void getProductsWithNoSales_returns_correct_product_for_id() {
        List<Product> product = productDao.getProductsWithNoSales();
        Assert.assertEquals("getProductsWithNoSales returned wrong number or products", 1, product.size());
    }

    @Test
    public void createProduct_returns_product_with_id_and_expected_values() {
        Product createdProduct = productDao.createProduct(testProduct);

        Assert.assertNotNull("createProduct returned null", createdProduct);

        int newId = createdProduct.getProductId();
        Assert.assertTrue("createProduct failed to return a product with an id", newId > 0);

        testProduct.setProductId(newId);
        assertProductsMatch("createProduct returned wrong or partial data", testProduct, createdProduct);
    }

    @Test
    public void created_product_has_expected_values_when_retrieved() {
        Product createdProduct = productDao.createProduct(testProduct);

        int newId = createdProduct.getProductId();
        Product retrievedProduct = productDao.getProduct(newId);

        assertProductsMatch("createProduct did not save correct data in database", createdProduct, retrievedProduct);
    }

    @Test
    public void updated_customer_has_expected_values_when_retrieved() {
        Product product = productDao.getProduct(1);
        product.setName("A new name");
        product.setDescription("A new description");
        product.setPrice(BigDecimal.valueOf(1.99));
        product.setImageName("new.jpg");

        productDao.updateProduct(product);

        Product updatedProduct = productDao.getProduct(1);
        assertProductsMatch("updateProduct", product, updatedProduct);
    }

    @Test
    public void deleted_product_cant_be_retrieved() {
        // NOTE: We must delete one that isn't on any order
        productDao.deleteProduct(5);

        Product product = productDao.getProduct(5);
        Assert.assertNull("deleteProduct failed to remove product from database", product);

        List<Product> products = productDao.getProducts();
        Assert.assertEquals("deleteProduct removed the wrong number of products", 4, products.size());
    }

    @Test
    public void product_with_sales_cant_be_deleted() {
        // An exception is expected if the product has sales orders, and we try to delete the product.
        try {
            productDao.deleteProduct(6);
        } catch (DataIntegrityViolationException exception) {
            // The DAO threw an exception because the row couldn't be deleted. Test passes. Return from the method.
            return;
        }
        // If control gets here, then the row was deleted. It shouldn't have been deleted, because
        // sales orders are attached to this product. Therefore, FAIL the test.
        Assert.fail("A product with sales orders should not be deleted.");
    }
    
    private void assertProductsMatch(String messagePrefix, Product expected, Product actual) {
        String message = messagePrefix + ": unexpected data in field '%s'.";
        Assert.assertEquals(String.format(message, "productId"), expected.getProductId(), actual.getProductId());
        Assert.assertEquals(String.format(message, "name"), expected.getName(), actual.getName());
        Assert.assertEquals(String.format(message, "Description"), expected.getDescription(), actual.getDescription());
        Assert.assertEquals(String.format(message, "price"), expected.getPrice(), actual.getPrice());
        Assert.assertEquals(String.format(message, "image"), expected.getImageName(), actual.getImageName());
    }
}

