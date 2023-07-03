package services;

public interface ICartService {
    void addProductToCart(int id);
    void confirm();
    void removeFromCart(int id);
    void clearCart();
    double calculateCartSum();
}
