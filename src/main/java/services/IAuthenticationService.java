package services;

import pl.camp.it.book.store.exceptions.LoginAlreadyExistException;
import pl.camp.it.book.store.model.User;

public interface IAuthenticationService {
    void authenticate(String login, String password);
    void logout();
    void register(User user) throws LoginAlreadyExistException;
}