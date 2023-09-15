//package com.learning.hello;
//import java.io.IOException;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.templatemode.TemplateMode;
//import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
////import com.learning.hello.contoller.MangathaGameController;
//import com.learning.hello.contoller.MangathaGameController.Deck;
//
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//
//
//@WebServlet("/mangathaGame")
//public class MangathaGameServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private Deck deck;
//    private JakartaServletWebApplication application;
//    private TemplateEngine templateEngine;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        
//       Deck deck = new Deck();
//
//        application = JakartaServletWebApplication.buildApplication(getServletContext());
//        final WebApplicationTemplateResolver templateResolver =
//                new WebApplicationTemplateResolver(application);
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        templateResolver.setPrefix("/WEB-INF/templates/");
//        templateResolver.setSuffix(".html");
//        templateEngine = new TemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Shuffle the deck when the form is submitted
//        deck.shuffle();
//
//        // Create a context for Thymeleaf
//        final IWebExchange webExchange = this.application.buildExchange(req, resp);
//        final WebContext ctx = new WebContext(webExchange);
//
//        // You can add other attributes to the context if needed
//
//        // Process the template and send the response
//        templateEngine.process("mangathaGame", ctx, resp.getWriter());
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Create a context for Thymeleaf
//        final IWebExchange webExchange = this.application.buildExchange(req, resp);
//        final WebContext ctx = new WebContext(webExchange);
//
//        // You can add attributes to the context if needed
//
//        // Process the template and send the response
//        templateEngine.process("mangathaGame", ctx, resp.getWriter());
//    }
//}
//
//
////@WebServlet("/mangathaGame")
////public class MangathaGameServlet extends HttpServlet{
////private static final long serialVersionUID = 1L;
////private MangathaGameController mg;
////  private JakartaServletWebApplication application;
////  private TemplateE?ngine templateEngine;
////  @Override
////  public void init(ServletConfig config) throws ServletException {
////    super.init(config);
////    mg = new MangathaGameController();
////
////    
////    application = JakartaServletWebApplication.buildApplication(getServletContext());
////    final WebApplicationTemplateResolver templateResolver = 
////        new WebApplicationTemplateResolver(application);
////    templateResolver.setTemplateMode(TemplateMode.HTML);
////    templateResolver.setPrefix("/WEB-INF/templates/");
////    templateResolver.setSuffix(".html");
////    templateEngine = new TemplateEngine();
////    templateEngine.setTemplateResolver(templateResolver);
////  }
////
////
////  @Override
////  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////      // Get the action parameter
//////      String action = req.getParameter("action");
//////      if ("increment".equals(action)) {
//////          // Increment the reading
//////          odc.increment();
//////          req.setAttribute("increment", odc.getReading());
//////          req.setAttribute("decrement", null);
//////      } else if ("decrement".equals(action)) {
//////          // Decrement the reading
//////          odc.decrementReading();
//////          req.setAttribute("decrement", odc.getReading());
//////          req.setAttribute("increment", null);
//////      }
//////      
//////      
//////      var out = resp.getWriter();
//////      final IWebExchange webExchange = this.application.buildExchange(req, resp);
//////      final WebContext ctx = new WebContext(webExchange);
////////      ctx.setVariable("increment", odc.nextReading().getReading());
////////      ctx.setVariable("decrement", odc.prevReading().getReading());
////////      ctx.setVariable("current", odc.getReading());
////      //templateEngine.process("mangatha", ctx, out);
////
//// }
//// 
////
////
////@Override
////  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////    final IWebExchange webExchange = this.application.buildExchange(req, resp);
////    final WebContext ctx = new WebContext(webExchange);
////    templateEngine.process("mangathaGame", ctx, resp.getWriter());
////  }
////}
////
////
////
////
////
////
////
////
////
////
////
////
////package com.learning.hello;
////import java.io.IOException;
////import org.thymeleaf.TemplateEngine;
////import org.thymeleaf.context.WebContext;
////import org.thymeleaf.templatemode.TemplateMode;
////import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
////import org.thymeleaf.web.IWebExchange;
////import org.thymeleaf.web.servlet.JakartaServletWebApplication;
////import com.learning.hello.controller.MangathaController;
////import com.learning.hello.controller.OdometerController;
////import jakarta.servlet.ServletException;
////import jakarta.servlet.annotation.WebServlet;
////import jakarta.servlet.http.HttpServlet;
////import jakarta.servlet.http.HttpServletRequest;
////import jakarta.servlet.http.HttpServletResponse;
////
////
////@WebServlet("/MangathaDisplay")
////
////public class MangathaServlet extends HttpServlet {
////
////     private static final long serialVersionUID = 1L;
////    private JakartaServletWebApplication application;
////    private TemplateEngine templateEngine;
////    private MangathaController mangatha;
////     @Override
////
////     public void init() throws ServletException {
////        application = JakartaServletWebApplication.buildApplication(getServletContext());    
////        final WebApplicationTemplateResolver templateResolver = 
////            new WebApplicationTemplateResolver(application);
////        templateResolver.setTemplateMode(TemplateMode.HTML);
////        templateResolver.setPrefix("/WEB-INF/templates/");
////        templateResolver.setSuffix(".html");
////        templateEngine = new TemplateEngine();
////        templateEngine.setTemplateResolver(templateResolver);
////        mangatha = new MangathaController();
////    }
////
////
////     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
////            final IWebExchange webExchange = this.application.buildExchange(request, response);
////            final WebContext ctx = new WebContext(webExchange);
////            templateEngine.process("MangathaDisplay", ctx, response.getWriter());
////     }
////
////    @Override
////    protected void doPost(HttpServletRequest request, HttpServletResponse response)
////            throws ServletException, IOException {
////        String action = request.getParameter("action");
////        mangatha.shuffle();
////        final IWebExchange webExchange = this.application.buildExchange(request, response);
////        final WebContext ctx = new WebContext(webExchange);
////        ctx.setVariable("TopCard", mangatha.removeTop());
////        //response.sendRedirect(request.getContextPath() + "/mangathaDisplay");
////        templateEngine.process("MangathaDisplay", ctx, response.getWriter());
////    }
////
////}
//
// 
