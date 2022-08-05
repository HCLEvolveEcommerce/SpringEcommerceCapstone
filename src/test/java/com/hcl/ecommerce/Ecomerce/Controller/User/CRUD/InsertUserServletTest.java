package com.hcl.ecommerce.Ecomerce.Controller.User.CRUD;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class InsertUserServletTest {
    /**
     * Method under test: {@link InsertUserServlet#doGet(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoGet() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.InsertUserServlet.doGet(InsertUserServlet.java:22)
        //   In order to prevent doGet(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doGet(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        InsertUserServlet insertUserServlet = new InsertUserServlet();
        insertUserServlet.doGet(null, new Response());
    }

    /**
     * Method under test: {@link InsertUserServlet#doGet(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoGet2() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.InsertUserServlet.doGet(InsertUserServlet.java:22)
        //   In order to prevent doGet(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doGet(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        InsertUserServlet insertUserServlet = new InsertUserServlet();
        Response response = mock(Response.class);
        doNothing().when(response).addDateHeader((String) any(), anyLong());
        response.addDateHeader("firstname", 42L);
        insertUserServlet.doGet(null, response);
    }

    /**
     * Method under test: {@link InsertUserServlet#doPost(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoPost() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.InsertUserServlet.doGet(InsertUserServlet.java:22)
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.InsertUserServlet.doPost(InsertUserServlet.java:47)
        //   In order to prevent doPost(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doPost(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        InsertUserServlet insertUserServlet = new InsertUserServlet();
        insertUserServlet.doPost(null, new Response());
    }

    /**
     * Method under test: {@link InsertUserServlet#doPost(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoPost2() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.InsertUserServlet.doGet(InsertUserServlet.java:22)
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.InsertUserServlet.doPost(InsertUserServlet.java:47)
        //   In order to prevent doPost(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doPost(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        InsertUserServlet insertUserServlet = new InsertUserServlet();
        Response response = mock(Response.class);
        doNothing().when(response).addDateHeader((String) any(), anyLong());
        response.addDateHeader("firstname", 42L);
        insertUserServlet.doPost(null, response);
    }
}

