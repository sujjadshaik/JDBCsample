package LibraryApp;

import Dao.DaoException;
import Dao.LibraryOperationsDao;
import LibraryService.Validation;
import Model.Book;
import Model.User;

public class LibraryApplication {
	static Validation validation = new Validation();
	static LibraryOperationsDao operationsDao = new LibraryOperationsDao();
	static String ROLE = "";
	static int lOGGEIN = 0;

	public static void main(String[] args) {
		do {
			System.out
					.println("Enter 1 to Register user\nEnter 2 to login\nEnter 3 display submenu\nEnter 4 to logout");
			int in = validation.ValidateIntegerInput();
			switch (in) {
			case 1:
				if (lOGGEIN == 0)
					registerUser();
				else {
					System.out.println("Please logout!!");
				}
				break;
			case 2:
				if (lOGGEIN == 0) {
					ROLE = loginUser();
					if (ROLE == "")
						System.out.println("Invalid credentials");
					else {
						System.out.println("Logged in as " + ROLE);

					}
				} else {
					System.out.println("Already logged in as " + ROLE);
				}
				break;
			case 3:
				if (ROLE.equals("student")) {
					displayStudentMenu();
				} else if (ROLE.equals("teacher")) {
					displayTeacherMenu();
				} else {
					System.out.println("please LOGIN");
				}
				break;
			case 4:
				if (lOGGEIN != 0) {
					try {
						operationsDao.logoutMessage(lOGGEIN);
						System.out.println("LOGGED OUT AS " + ROLE);
						ROLE = "";
						lOGGEIN = 0;

					} catch (DaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("Please LOGIN");
				}

				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		} while (true);

	}

	private static void registerUser() {
		int id;
		String username, role, contactNumber, passwordS;
		System.out.println("Enter id");
		id = validation.ValidateIntegerInput();
		System.out.println("Enter name");
		username = validation.ValidateStringInputAfterInterInput();
		System.out.println("please enter your role Teacher or Student");
		role = validation.validateRole();
		System.out.println("Enter contact number");
		contactNumber = validation.ValidateStringInput();
		System.out.println("Enter password");
		passwordS = validation.ValidateStringInput();
		try {
			operationsDao.addUser(new User(id, username, role, contactNumber, passwordS));

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	private static String loginUser() {
		int id;
		String password;
		String role = "";
		System.out.println("Enter id");
		id = validation.ValidateIntegerInput();
		System.out.println("Enter password");
		password = validation.ValidateStringInputAfterInterInput();
		try {
			role = operationsDao.userLogin(id, password);
			lOGGEIN = operationsDao.getUserLoggedInfo(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return role;

	}

	private static void displayStudentMenu() {
		int exit = 0;
		do {
			System.out.println("Enter 1 to list books\nEnter 2 to buy books\nEnter 3 to go to MAIN MENU");
			int in = validation.ValidateIntegerInput();
			switch (in) {
			case 1:
				getBooks();
				break;
			case 2:
				buyBook();
				break;
			case 3:
				System.out.println("Enter 3 again to exit");
				exit = validation.ValidateIntegerInput();
				break;

			default:
				System.out.println("invalid input!!");
				break;
			}
			if (exit == 3)
				break;

		} while (true);
	}

	private static void displayTeacherMenu() {
		int exit = 0;
		do {
			System.out.println(
					"Enter 1 to add Book\nEnter 2 to upate book quantity\nEnter 3 to delete book\nEnter 4 to get Book Details\nEnter 5 to display all books\nEnter 6 to go to MAIN MENU");
			int in = validation.ValidateIntegerInput();
			switch (in) {
			case 1:
				addBook();
				break;
			case 2:
				updateBookQuantity();
				break;
			case 3:
				deleteBook();
				break;
			case 4:
				getBookDetails();
				break;
			case 5:
				getBooks();
				break;
			case 6:
				System.out.println("Enter 6 again to exit");
				exit = validation.ValidateIntegerInput();
				break;
			default:
				System.out.println("invalid input");
				break;

			}
			if (exit == 6)
				break;

		} while (true);

	}
	private static void addBook() {
		System.out.println("Enter book id");
		int id = validation.ValidateIntegerInput();
		System.out.println("Enter book name");
		String name = validation.ValidateStringInputAfterInterInput();
		System.out.println("Enter author name");
		String author = validation.ValidateStringInput();
		System.out.println("Enter quantity of books");
		int quantity = validation.ValidateIntegerInput();
		System.out.println("Enter genre");
		String genre = validation.ValidateStringInputAfterInterInput();
		try {
			operationsDao.addBook(new Book(id,name,author,quantity,genre));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	private static void updateBookQuantity() {
		System.out.println("Enter book id");
		int id = validation.ValidateIntegerInput();
		System.out.println("Enter quantity of books");
		int quantity = validation.ValidateIntegerInput();
		try {
			operationsDao.updateBookQuantity(id, quantity);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	private static void deleteBook() {
		System.out.println("Enter book id");
		int id = validation.ValidateIntegerInput();
		try {
			operationsDao.deleteBook(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	private static void getBookDetails() {
		System.out.println("Enter book id");
		int id = validation.ValidateIntegerInput();
		try {
			operationsDao.getBookDetails(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	private static void getBooks() {
		try {
			for(Book book : operationsDao.getBooks()) {
				System.out.println("id :"+book.getId()+"\name :"+book.getName()+"\nauthor :"+book.getAuthorName()+"\ngenre :"+book.getGenre()+"\nQuantity :"+book.getQuantity());
				
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	private static void buyBook() {
		System.out.println("Enter book id");
		int id = validation.ValidateIntegerInput();
		try {
			operationsDao.buyBook(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
