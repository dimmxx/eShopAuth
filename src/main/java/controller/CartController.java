package controller;

import model.Cart;
import model.Product;

import java.util.Iterator;
import java.util.Map;

public class CartController {

    private Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    public void addProductToCartMap(Product product, int quantity) {
        if (cart.getProductMap().containsKey(product)) {
            cart.getProductMap().put(product, cart.getProductMap().get(product) + quantity);
        } else {
            cart.getProductMap().put(product, quantity);
        }
    }

    public void deleteProductFromMap(int id) {
        Iterator<Product> it = cart.getProductMap().keySet().iterator();
        while (it.hasNext()) {
            Product key = it.next();
            if (key.getId() == id) {
                it.remove();
            }
        }
    }

    public void changeQuantityInMap(int id, int quantity){
        Iterator<Product> it = cart.getProductMap().keySet().iterator();
        while (it.hasNext()){
            Product key = it.next();
            if(key.getId() == id){
                cart.getProductMap().put(key, quantity);
            }
        }
    }


    public Cart getCart() {
        return cart;
    }

}


