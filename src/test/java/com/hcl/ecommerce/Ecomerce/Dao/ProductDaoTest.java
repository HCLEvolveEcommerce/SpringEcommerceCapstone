package com.hcl.ecommerce.Ecomerce.Dao;

import static org.mockito.Mockito.mock;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class ProductDaoTest {
    /**
     * Method under test: {@link ProductDao#ProductDao(Connection)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ProductDao.con
        //     ProductDao.query
        //     ProductDao.pst
        //     ProductDao.rs

        new ProductDao(mock(Connection.class));
    }
}

