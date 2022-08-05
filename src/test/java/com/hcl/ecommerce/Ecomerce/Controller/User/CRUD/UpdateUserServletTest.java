package com.hcl.ecommerce.Ecomerce.Controller.User.CRUD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class UpdateUserServletTest {
    /**
     * Method under test: {@link UpdateUserServlet#doGet(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoGet() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: null
        //       at java.lang.Integer.parseInt(Integer.java:614)
        //       at java.lang.Integer.parseInt(Integer.java:770)
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.UpdateUserServlet.doGet(UpdateUserServlet.java:23)
        //   In order to prevent doGet(HttpServletRequest, HttpServletResponse)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doGet(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserServlet updateUserServlet = new UpdateUserServlet();
        MockHttpServletRequest request = new MockHttpServletRequest();
        updateUserServlet.doGet(request, new Response());
    }

    /**
     * Method under test: {@link UpdateUserServlet#doGet(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoGet2() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.UpdateUserServlet.doGet(UpdateUserServlet.java:23)
        //   In order to prevent doGet(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doGet(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserServlet updateUserServlet = new UpdateUserServlet();
        updateUserServlet.doGet(null, new Response());
    }

    /**
     * Method under test: {@link UpdateUserServlet#doGet(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoGet3() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "https://example.org/example"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Integer.parseInt(Integer.java:652)
        //       at java.lang.Integer.parseInt(Integer.java:770)
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.UpdateUserServlet.doGet(UpdateUserServlet.java:23)
        //   In order to prevent doGet(HttpServletRequest, HttpServletResponse)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doGet(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserServlet updateUserServlet = new UpdateUserServlet();
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getParameter((String) any())).thenReturn("https://example.org/example");
        updateUserServlet.doGet(defaultMultipartHttpServletRequest, new Response());
    }

    /**
     * Method under test: {@link UpdateUserServlet#doGet(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoGet4() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: java.sql.SQLNonTransientConnectionException: Could not create connection to database server.
        //       at com.hcl.ecommerce.Ecomerce.Model.DbCon.getConnection(DbCon.java:22)
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.UpdateUserServlet.doGet(UpdateUserServlet.java:40)
        //   In order to prevent doGet(HttpServletRequest, HttpServletResponse)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doGet(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserServlet updateUserServlet = new UpdateUserServlet();
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getParameter((String) any())).thenReturn("42");
        updateUserServlet.doGet(defaultMultipartHttpServletRequest, new Response());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link UpdateUserServlet}
     *   <li>{@link UpdateUserServlet#doPost(HttpServletRequest, HttpServletResponse)}
     * </ul>
     */
    @Test
    void testConstructor() throws IOException, ServletException {
        UpdateUserServlet actualUpdateUserServlet = new UpdateUserServlet();
        MockHttpServletRequest request = new MockHttpServletRequest();
        actualUpdateUserServlet.doPost(request, new Response());
        assertEquals("", actualUpdateUserServlet.getServletInfo());
    }
}

