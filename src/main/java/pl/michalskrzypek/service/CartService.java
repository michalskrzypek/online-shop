package pl.michalskrzypek.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.dao.CartDAO;
import pl.michalskrzypek.dao.CartLineDAO;
import pl.michalskrzypek.entity.Cart;
import pl.michalskrzypek.entity.CartLine;
import pl.michalskrzypek.entity.Product;
import pl.michalskrzypek.model.AccountModel;

@Service
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	HttpSession session;
	
	public Cart getCart() {
		AccountModel model = (AccountModel) session.getAttribute("accountModel");
		Cart cart = model.getCart();
		return cart;	
	}
	
	public void addCartLine(Product product) {
	
		Cart cart = this.getCart();
		cart.setCartLines(cart.getCartLines()+1);
		
		CartLine cartLine = new CartLine();
		cartLine.setProduct(product);
		cartLine.setAvailable(product.isActive());
		cartLine.setCartId(cart.getId());
		cartLine.setProductCount(1);
		cartLine.setProductPrice(product.getUnitPrice());
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLineDAO.add(cartLine);
		
		cart.setTotal(this.countTotal());
		cartDAO.updateCart(cart);
		
	}
	
	public void deleteCartLine(CartLine cartLine) {
		Cart cart = this.getCart();
		
		cart.setCartLines(cart.getCartLines()-1);
		cartLineDAO.delete(cartLine.getId());
		
		cart.setTotal(this.countTotal());
		cartDAO.updateCart(cart);
		
	}
	
	public void updateCartLine(int cartLineId, int quantity) {
		
		CartLine cartLine = cartLineDAO.get(cartLineId);
		Cart cart = this.getCart();
		
		cartLine.setProductCount(quantity);
		cartLine.setTotal(cartLine.getProductPrice() * quantity);
		cartLineDAO.update(cartLine);
		
		cart.setTotal(this.countTotal());
		cartDAO.updateCart(cart);
		
	}
	
	public boolean checkProductInCartLine(Product product) {

		 AccountModel model = (AccountModel) session.getAttribute("accountModel");
		 try {
		if(cartLineDAO.get(model.getCart().getId(), product) != null) {
			return true;
		}else {
			return false;
		}}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Double countTotal() {
		
		List<CartLine> cartlines = this.getCartLines();
		double total = 0;
		for (CartLine line : cartlines) {
			double lineTotal = line.getProductCount() * line.getProductPrice();
			total += lineTotal;
		}
		return total;
		
	}
	
	
	public List<CartLine> getCartLines(){
		Cart cart = this.getCart();
		
		return cartLineDAO.listAll(cart.getId());
	}
	
}
