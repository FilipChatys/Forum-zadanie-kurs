package controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.book.store.services.IAuthenticationService;
import pl.camp.it.book.store.services.IBookService;
import pl.camp.it.book.store.session.SessionData;

@Controller
public class CommonController {
    @Autowired
    private IBookService bookService;

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionData sessionData;

    @GetMapping(path = {"/main", "/"})
    public String main(Model model,
                       @RequestParam(required = false) String pattern) {
        if(pattern == null) {
            model.addAttribute("books", this.bookService.getAllBooks());
        } else {
            model.addAttribute("books", this.bookService.getFilteredBooks(pattern));
        }
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        return "index";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        return "contact";
    }
}
