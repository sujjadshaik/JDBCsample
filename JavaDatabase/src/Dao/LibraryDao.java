package Dao;

import java.util.List;

import Model.Book;
import Model.User;

public interface LibraryDao {
	void addUser(User user) throws DaoException;
	void addBook(Book book) throws DaoException;
	String userLogin(int id,String password) throws DaoException;
	int getUserLoggedInfo(int id) throws DaoException;
	void updateBookQuantity(int id,int quantity) throws DaoException;
	void deleteBook(int id) throws DaoException;
	void getBookDetails(int id) throws DaoException;
	List<Book> getBooks() throws DaoException;
	void buyBook(int id) throws DaoException;

}
