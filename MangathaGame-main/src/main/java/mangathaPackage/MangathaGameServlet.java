package mangathaPackage;
import java.io.IOException; 
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//import com.learning.hello.contoller.MangathaGameController;
//import com.learning.hello.contoller.MangathaGameController.Deck;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/mangathaGame")
public class MangathaGameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JakartaServletWebApplication application;
    private TemplateEngine templateEngine;
    
    public Players player1;
    public Players player2;
    private MangaLogic mangalogic;
    
    int round =1;
    boolean state = false;
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        

        application = JakartaServletWebApplication.buildApplication(getServletContext());
        final WebApplicationTemplateResolver templateResolver =
                new WebApplicationTemplateResolver(application);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  final IWebExchange webExchange = 
			        this.application.buildExchange(req, resp);
		  final WebContext ctx = new WebContext(webExchange);
		  String p1="";
		  String p2="";
		  String buttonId = req.getParameter("submitButton");
		  System.out.println(buttonId);
//		  if(buttonId == null) {
//			  
//		  }
		  if(buttonId != null) {
			  if(buttonId.equals("player1")) {
			  
				  p1 = req.getParameter("Player1Name");
				  String bet1 = req.getParameter("Player1Amount");
				  //System.out.println(req.getParameter("Player1CardPosition"));
				  Card cardType1 = new Card(req.getParameter("Player1Card"));
				  String cardPosition1 = req.getParameter("Player1CardPos");
				  System.out.println("name -"+p1);
				  System.out.println("bet -"+bet1);
				  System.out.println("type -"+cardType1);
				  System.out.println("card -"+cardPosition1);
				  player1 = new Players(p1, Integer.parseInt(bet1), cardType1, cardPosition1);
				  

			  }
			  if(buttonId.equals("player2")) {
				  
				  p2 = req.getParameter("Player2Name");
				  String bet2 = req.getParameter("Player2Amount");
				  Card cardType2 = new Card(req.getParameter("Player2Card"));
				  String cardPosition2 = req.getParameter("Player2CardPos");
				  player2 = new Players(p2, Integer.parseInt(bet2), cardType2, cardPosition2);
				  System.out.println("name -"+player2.getName());
				  System.out.println("bet -"+player2.getBet());
				  System.out.println("type -"+player2.getCardPosition());
				  System.out.println("card -"+player2.getCardType());
				  
			  }
			  
			 mangalogic = new MangaLogic(player1, player2);
		  }
		  String dealer = req.getParameter("Dealer");
		  if(dealer != null) {
			  state = mangalogic.Over();
			  ctx.setVariable("reading", mangalogic.getTopCard());
			  ctx.setVariable("round", round);
			  
			  ctx.setVariable("p1Name", player1.getName());
			  ctx.setVariable("p1BetAmmount", player1.getBet());
			  ctx.setVariable("p1CardType", player1.getCardType());
			  ctx.setVariable("p1CardPosition", player1.getCardPosition());
			  
			  ctx.setVariable("p2Name", player2.getName());
			  ctx.setVariable("p2BetAmmount", player2.getBet());
			  ctx.setVariable("p2CardType", player2.getCardType());
			  ctx.setVariable("p2CardPosition", player2.getCardPosition());
			  
			  round +=1;
		  }
		  if(state) {
			  if(player1.getWin()) {
				  ctx.setVariable("winner", player1.getName());
			  }
			  if(player2.getWin()) {
					  ctx.setVariable("winner", player2.getName());
			  }
		  }
		var out = resp.getWriter();
			    
		templateEngine.process("mangathaGame", ctx, out);

		  }
		 	  
	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    final IWebExchange webExchange = this.application.buildExchange(req, resp);
	    final WebContext ctx = new WebContext(webExchange);
	    //ctx.setVariable("reading", oc.getReading());
	    templateEngine.process("mangathaGame", ctx, resp.getWriter());
	    
	   
	    //System.out.println(oc.getReading());
	  }

}