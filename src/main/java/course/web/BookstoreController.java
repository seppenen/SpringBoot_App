package course.web;

import java.util.Optional;

import javax.management.relation.Role;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import course.domain.AuthorRepository;
import course.domain.Book;
import course.domain.BookRepository;
import course.domain.User;
import course.domain.UserRepository;


@Controller
public class BookstoreController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private AuthorRepository arepository;
	@Autowired 
	private UserRepository uRepo;
	
	 @RequestMapping(value="/booklist", method = RequestMethod.GET)
    public String bookList( User user, Model model) {
		 System.out.println("inside our method boklist");
        model.addAttribute("books", repository.findAll());
        model.addAttribute("role", user.getRole());
        
        return "booklist";
    }
	 @PreAuthorize("hasAuthority('ADMIN')")
	  @RequestMapping(value = "/add")
	    public String addStudent(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("authors", arepository.findAll());
	    	
	        return "addbook";
	    }     
	 

	    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
	    	return repository.findById(id);
	    }   
	  
	  
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(@Valid  Book book, BindingResult bindingresult, Model model){
			model.addAttribute("authors", arepository.findAll());
		  if (!bindingresult.hasErrors()) {
	        repository.save(book);
	        return "redirect:booklist";
		  }else {
			  
			  return "addbook";
		  }
		 
	    }    
	 
	   @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../booklist";
	    }  
	
}
