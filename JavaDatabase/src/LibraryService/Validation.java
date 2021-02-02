package LibraryService;
import java.util.Scanner;

import com.sun.jdi.Value;


public class Validation {
	static Scanner input = new Scanner(System.in);

	public double ValidateDoubleInput() {
		while (true) {
			String s = input.nextLine();
			try {
				double value = Double.parseDouble(s);
				if (value > 0)
					return value;
				else
					throw new Exception();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("The given input should be of POSITIVE NUMERIC type.Re-Enter the input");
			}

		}
	}

	public float ValdateFloatInput() {
		while (true) {
			String s = input.nextLine();
			try {
				float value = Float.parseFloat(s);
				if (value >= 0)
					return value;
				else
					throw new Exception();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("The given input should be of POSITIVE NUMERIC type.Re-Enter the input");
			}

		}
	}

	public boolean ValidateBooleanInput() {
		while (true) {
			String s = input.nextLine();
			if (s.equals("true") || s.equals(("false"))) {
				boolean value = Boolean.parseBoolean(s);
				return value;
			} else
				System.out.println("The given input should be only \"true\" or  \"false \" only");
		}

	}

//	public int ValidateIntegerInput() {
//		while (true) {
//			String s = input.nextLine();
//			try {
//				int value = Integer.parseInt(s);
//				if (value > 0)
//					return value;
//				else
//					throw new Exception();
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("The given input should be of POSITIVE NUMERIC type.Re-Enter the input");
//			}
//
//		}
//	}
	
	
	public int ValidateIntegerInput() {
		int number;
		do {
		    while (!input.hasNextInt()) {
		        System.out.println("That's not a number!");
		        input.next();
		    }
		    number = input.nextInt();
		    return number;
		} while (number <= 0);
	}

//	public long ValidateLongInput() {
//		while (true) {
//			String s = input.nextLine();
//			try {
//				long value = Long.parseLong(s);
//				if (value > 0)
//					return value;
//				else
//					throw new Exception();
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("The given input should be of POSITIVE NUMERIC type.Re-Enter the input");
//			}
//
//		}
//	}
	public long ValidateLongInput() {
		long number;
		do {
		    while (!input.hasNextLong()) {
		        System.out.println("That's not a number!");
		        input.next();
		    }
		    number = input.nextLong();
		    return number;
		} while (true);
		
	}
	public long validateMobileNumber() {
		long number;
		do {
			while (!input.hasNextLong()) {
		        System.out.println("That's not a number!");
		        input.next();
		    } 
			number = input.nextLong();
			if(getLenght(number) == 10)
				return number;
			else
				System.out.println("please enter valid moible number");
			
			
		}while(true);
	}

	public String ValidateStringInput() {
		do {
			//input.nextLine();
			String name = input.nextLine();

			if (name.length() > 0) {
				return name;

			} else {
				System.out.println("No input was recived.Please re-try by given the input. ");

			}

		} while (true);

	}
	public String ValidateStringInputAfterInterInput() {
		do {
			input.nextLine();
			String name = input.nextLine();

			if (name.length() > 0) {
				return name;

			} else {
				System.out.println("No input was recived.Please re-try by given the input. ");

			}

		} while (true);

	}
//	public String validateNumber() 
//	{
//		String in = "";
//		
//		while(true)
//		{
//		in = input.next();
//		Scanner scan=new Scanner(in);
//		
//		if(scan.hasNextInt())
//		{
//			String mobileNumber = in;
//			
//			if (mobileNumber.length() != 0 && mobileNumber != "null" && mobileNumber.length() == 10) 
//			{
//				return mobileNumber;
//			}
//			else if(mobileNumber.length() != 10)
//			{
//				System.out.println("Invalid Mobile Number");
//			}
//		} 
//		else
//		{
//			System.out.println("Value to this field should be a number");
//		}
//		}
//	}
	public int getLenght(long number) {
		int length = 0;
		long temp = 1;
		while (temp <= number) {
		    length++;
		    temp *= 10;
		}
		return length;
	}
	public String validateRole() {
		do {
			String roleString = input.nextLine().toLowerCase();
			if(roleString.length() > 0 && roleString.equals("teacher") || roleString.equals("student")) {
					return roleString;
			}else {
				System.out.println("Please enter valid Role");
			}
			
			
			
		}while(true);
	}

}
