package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.User;

public class LibraryOperationsDao implements LibraryDao {
	Connection connection = null;

//	CREATE TABLE USERS(
//			ID int NOT NULL primary key,
//			username varchar(255),
//			role varchar(255),
//			contactNumber long,
//			password varchar(255)
//			);
//	

	@Override
	public void addUser(User user) throws DaoException {
		// TODO Auto-generated method stub
//		if(user != null)
//			throw new IllegalArgumentException("User is already created");
		String sql = "INSERT INTO USERS (ID,username,role,contactNumber,password) values (?,?,?,?,?)";

		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mindtree", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, user.getId());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getRole());
			statement.setString(4, user.getContactNumber());
			statement.setString(5, user.getPassword());
			statement.execute();

		} catch (Exception e) {
			throw new DaoException(e);

		}

	}


	@Override
	public String userLogin(int id, String password) throws DaoException {
		String sql = "SELECT role,username from USERS where id = ? and password = ?";
		String role = "";
		String sql2 = "INSERT into USERLOG(userID,username,LOGIN) values (?,?,?)";

		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mindtree", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			String username = "";
			while (resultSet.next()) {
				role = resultSet.getString("role");
				username = resultSet.getString("username");
			}
			if (role != "") {
				PreparedStatement statement2 = connection.prepareStatement(sql2);
				statement2.setInt(1, id);
				statement2.setString(2, username);
				statement2.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
				statement2.execute();
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);

		}
		return role;
	}

	@Override
	public int getUserLoggedInfo(int id) throws DaoException {
		String sql = "SELECT logID,userID,username,LOGIN from USERLOG where userID = ?";
		String info = "";
		int LogID = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LogID = resultSet.getInt("logID");
				info = resultSet.getString("userID")+" "+resultSet.getString("username")+" "+resultSet.getTimestamp("LOGIN").toString();

			}
			System.out.println(info);

		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}
		
		return LogID;
	}

	public void logoutMessage(int logID) throws DaoException{
		String sql = "UPDATE USERLOG SET LOGOUT = ? where logID = ?";
		String sql2 = "SELECT userID,username,LOGOUT from USERLOG where logID = ?";
 		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
			statement.setInt(2, logID);
			statement.execute();
			
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			statement2.setInt(1, logID);
			ResultSet resultSet = statement2.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("userID")+" "+resultSet.getString("username")+" "+resultSet.getTimestamp("LOGOUT").toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}
	}


	@Override
	public void addBook(Model.Book book) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO BOOKS(id,name,author,quantity,genre) values (?,?,?,?,?)";
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mindtree", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, book.getId());
			statement.setString(2, book.getName());
			statement.setString(3, book.getAuthorName());
			statement.setInt(4, book.getQuantity());
			statement.setString(5, book.getGenre());
			statement.execute();
		
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}
	}


	@Override
	public void updateBookQuantity(int id,int quantity) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "UPDATE BOOKS SET quantity = ? where id = ?";
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mindtree", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, quantity);
			statement.setInt(2, id);
			statement.execute();
			
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
	}


	@Override
	public void deleteBook(int id) throws DaoException {
		// TODO Auto-generated method stub
		String sql ="DELETE FROM BOOKS WHERE id = ?";
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mindtree", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}
		
	}


	@Override
	public void getBookDetails(int id) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "select name,author,quantity,genre from books where id =?";
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mindtree", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				System.out.println("\nid :"+id+"Book name :"+resultSet.getString("name")+"\nauthor :"+resultSet.getString("author")+"\ngenre :"+resultSet.getString("genre")+"\nquantity :"+resultSet.getString("quantity"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}
		
	}


	@Override
	public List<Model.Book> getBooks() throws DaoException {
		// TODO Auto-generated method stub
		String sql = "select * from books";
		List<Model.Book> books = new ArrayList<>();
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mindtree", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Model.Book book = new Model.Book();
				book.setId(resultSet.getInt("id"));
				book.setName(resultSet.getString("name"));
				book.setAuthorName(resultSet.getString("author"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setGenre(resultSet.getString("genre"));
				books.add(book);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}
		return books;
	}


	@Override
	public void buyBook(int id) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "update books set quantity = quantity - 1 where id = ?";
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mindtree", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}
		
	}
	
	
	

}
