package servlet;

import controller.CartController;
import controller.DbWorker;
import controller.ProductController;
import model.Cart;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = null;
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") == null){
            cart = new Cart();
        }else {
            cart = (Cart)session.getAttribute("cart");
        }

        CartController cartController = new CartController(cart);

        String productId = req.getParameter("productId");

        if (productId != null) {
            DbWorker db = new DbWorker();
            ProductController productController = new ProductController(db);
            Product product = productController.getProduct(Integer.valueOf(productId));
            cartController.addProductToCartMap(product, 1);
            session.setAttribute("cart", cartController.getCart());
        }

        //resp.sendRedirect("./CartServlet");
       RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/cartView2.jsp");
       rd.forward(req, resp);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/cartView2.jsp");
        rd.forward(req, resp);

    }
}
