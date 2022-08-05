package com.hcl.ecommerce.Ecomerce.Controller.User.CRUD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {SelectUserServlet.class})
@ExtendWith(SpringExtension.class)
class SelectUserServletTest {
    @Autowired
    private SelectUserServlet selectUserServlet;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link SelectUserServlet}
     *   <li>{@link SelectUserServlet#doPost(HttpServletRequest, HttpServletResponse)}
     * </ul>
     */
    @Test
    void testConstructor() throws IOException, ServletException {
        SelectUserServlet actualSelectUserServlet = new SelectUserServlet();
        MockHttpServletRequest request = new MockHttpServletRequest();
        actualSelectUserServlet.doPost(request, new Response());
        assertEquals("", actualSelectUserServlet.getServletInfo());
    }

    /**
     * Method under test: {@link SelectUserServlet#doGet(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoGet() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: null
        //       at java.lang.Integer.parseInt(Integer.java:614)
        //       at java.lang.Integer.parseInt(Integer.java:770)
        //       at com.hcl.ecommerce.Ecomerce.Controller.User.CRUD.SelectUserServlet.doGet(SelectUserServlet.java:22)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1070)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent perform(RequestBuilder)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   perform(RequestBuilder).
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/select-user", uriVariables);
        Object[] controllers = new Object[]{selectUserServlet};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }
}

