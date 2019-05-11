package servlet;

import controller.DbWorker;
import controller.ProductController;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        DbWorker db = new DbWorker();
        ProductController productController = new ProductController(db);

        List<Product> products = productController.getProductsFromDb(req.getParameter("category"));

        req.setAttribute("products", products);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/product.jsp");
        rd.forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
