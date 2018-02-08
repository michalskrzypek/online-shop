package pl.michalskrzypek.dao;

import java.util.List;

import pl.michalskrzypek.entity.Cart;
import pl.michalskrzypek.entity.CartLine;

public interface CartLineDAO {

	public CartLine get(int id);

	public boolean add(CartLine cartLine);

	public boolean update(CartLine cartLine);

	public boolean delete(int id);

	public List<CartLine> listAll(int cartId);

	public List<CartLine> listAvailable(int cartId);

	public CartLine get(int cartId, int productId);
}
