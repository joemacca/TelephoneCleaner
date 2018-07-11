import java.io.*;
import java.util.*;
import java.util.Collections.*;
import java.lang.Iterable;
import java.util.regex.Pattern;




/**
 * PhoneNumbers class which reads in numbers from standard input, determines 
 * whether or not they are valid telephone numbers based on preset criteria 
 * and then formats them as appropriate, printed to stdout.
 *
 * Structure:
 * 1) Read in file, perform a series of checks to determine what type of 
 *	number it might be, then pass number onto correspponding method.
 * 2) First validity check to ensure number doesn't violate some other rules.
 * 3) Clean the format to a form a contiguous String.
 * 4) Format the number. If the number has numbers and allowed to these are
 * converted to numbers here.
 * 5) Check for duplicates. Then add number to Array where it can then be printed
 * @author Joseph McManamon - 6021556
 */
public class PhoneNumbers {

	private static List<String> numList = new ArrayList<String>();
	private static List<Pattern> patternList = new ArrayList<Pattern>();

	//Initial code patterns
	private static Pattern p1 = Pattern.compile("\\(?\\d{4}\\)? \\w{5}");
	private static Pattern p2 = Pattern.compile("\\(?\\d{4}\\)? \\w{6}");
	private static Pattern p3 = Pattern.compile("\\(?\\d{4}\\)? \\w{7}");
	private static Pattern p4 = Pattern.compile("\\(?\\d{4}\\)? \\w{3} \\w{3}");
	private static Pattern p5 = Pattern.compile("\\(?\\d{4}\\)? \\w{3} \\w{4}");
	private static Pattern p6 = Pattern.compile("\\(?\\d{4}\\)? \\w{3}-\\w{3}");
	private static Pattern p7 = Pattern.compile("\\(?\\d{4}\\)? \\w{3}-\\w{4}");

	private static Pattern p8 = Pattern.compile("\\(?\\d{4}\\)?\\w{5}");
	private static Pattern p9 = Pattern.compile("\\(?\\d{4}\\)?\\w{6}");
	private static Pattern p10 = Pattern.compile("\\(?\\d{4}\\)?\\w{7}");
	private static Pattern p11 = Pattern.compile("\\(?\\d{4}\\)?\\w{3} \\w{3}");
	private static Pattern p12= Pattern.compile("\\(?\\d{4}\\)?\\w{3} \\w{4}");
	private static Pattern p13 = Pattern.compile("\\(?\\d{4}\\)?\\w{3}-\\w{3}");
	private static Pattern p14= Pattern.compile("\\(?\\d{4}\\)?\\w{3}-\\w{4}");

	//Initial codes (with up to 9 letters)
	private static Pattern p15= Pattern.compile("\\(?\\d{4}\\)? \\w{8}");
	private static Pattern p16= Pattern.compile("\\(?\\d{4}\\)? \\w{9}");
	private static Pattern p17= Pattern.compile("\\(?\\d{4}\\)?\\w{8}");
	private static Pattern p18= Pattern.compile("\\(?\\d{4}\\)?\\w{9}");
	private static Pattern p19= Pattern.compile("\\(?\\d{4} \\)?\\w{4} \\w{4}");
	private static Pattern p20= Pattern.compile("\\(?\\d{4} \\)?\\w{4} \\w{5}");
	private static Pattern p21= Pattern.compile("\\(?\\d{4}\\)?\\w{4} \\w{4}");
	private static Pattern p22= Pattern.compile("\\(?\\d{4}\\)?\\w{4} \\w{5}");

	
	//Mobile code patterns
	private static Pattern p23= Pattern.compile("\\(?\\d{3}\\)?\\d{6}");
	private static Pattern p24= Pattern.compile("\\(?\\d{4}\\)?\\d{7}");
	private static Pattern p25= Pattern.compile("\\(?\\d{3}\\)?\\d{8}");

	private static Pattern p26= Pattern.compile("\\(?\\d{3}\\)? \\d{6}");
	private static Pattern p27= Pattern.compile("\\(?\\d{4}\\)? \\d{7}");
	private static Pattern p28= Pattern.compile("\\(?\\d{3}\\)? \\d{8}");

	private static Pattern p29= Pattern.compile("\\(?\\d{3}\\)?\\d{3} \\d{3}");
	private static Pattern p30= Pattern.compile("\\(?\\d{4}\\)?\\d{3} \\d{4}");
	private static Pattern p31= Pattern.compile("\\(?\\d{3}\\)?\\d{4} \\d{4}");

	private static Pattern p32= Pattern.compile("\\(?\\d{3}\\)? \\d{3} \\d{3}");
	private static Pattern p33= Pattern.compile("\\(?\\d{3}\\)? \\d{3} \\d{4}");
	private static Pattern p34= Pattern.compile("\\(?\\d{3}\\)? \\d{4} \\d{4}");

	private static Pattern p35= Pattern.compile("\\(?\\d{3}\\)?\\d{3}-\\d{3}");
	private static Pattern p36= Pattern.compile("\\(?\\d{4}\\)?\\d{3}-\\d{4}");
	private static Pattern p37= Pattern.compile("\\(?\\d{3}\\)?\\d{4}-\\d{4}");

	private static Pattern p38= Pattern.compile("\\(?\\d{3}\\)? \\d{3}-\\d{3}");
	private static Pattern p39= Pattern.compile("\\(?\\d{3}\\)? \\d{3}-\\d{4}");
	private static Pattern p40= Pattern.compile("\\(?\\d{3}\\)? \\d{4}-\\d{4}");


	//Area code patterns
	private static Pattern p41= Pattern.compile("\\(?\\d{2}\\)? \\d{3} \\d{4}");
	private static Pattern p42= Pattern.compile("\\(?\\d{2}\\)?\\d{7}");
	private static Pattern p43= Pattern.compile("\\(?\\d{2}\\)?\\d{3} \\d{4}");
	private static Pattern p44= Pattern.compile("\\(?\\d{2}\\)?\\d{3}-\\d{4}");
	private static Pattern p45= Pattern.compile("\\(?\\d{2}\\)? \\d{3}-\\d{4}");




	public static void main (String[] args){
		buildPatternArray();
		Scanner sc = new Scanner(System.in);	
		while(sc.hasNext()){ 
			String s = sc.nextLine();
			if(regexCheck(s)){
				check(s);
			} else {
				numList.add(s + " INV");
			}
			
		}
		print();
	}

	public static void buildPatternArray(){
		patternList.add(p1);
		patternList.add(p2);
		patternList.add(p3);
		patternList.add(p4);
		patternList.add(p5);
		patternList.add(p6);
		patternList.add(p7);
		patternList.add(p8);
		patternList.add(p9);
		patternList.add(p10);
		patternList.add(p11);
		patternList.add(p12);
		patternList.add(p13);
		patternList.add(p14);
		patternList.add(p15);
		patternList.add(p16);
		patternList.add(p17);
		patternList.add(p18);
		patternList.add(p19);
		patternList.add(p20);
		patternList.add(p21);
		patternList.add(p22);
		patternList.add(p23);
		patternList.add(p24);
		patternList.add(p25);
		patternList.add(p26);
		patternList.add(p27);
		patternList.add(p28);
		patternList.add(p29);
		patternList.add(p30);
		patternList.add(p31);
		patternList.add(p32);
		patternList.add(p33);
		patternList.add(p34);
		patternList.add(p35);
		patternList.add(p36);
		patternList.add(p37);
		patternList.add(p38);
		patternList.add(p39);
		patternList.add(p40);
		patternList.add(p41);
		patternList.add(p42);
		patternList.add(p43);
		patternList.add(p44);
		patternList.add(p45);


	}

	public static boolean regexCheck(String s){
		for (Pattern p : patternList){
			if(p.matcher(s).matches()){
				return true;
			}
		}
		return false;
	}



	/**
	 * Determines what category the input number is part of (most closely 
	 * resembles) i.e. initial code, area code, mobile code. 
	 * Then determines what procedure to perform on it.
	 * 
	 * Also determines some validity.
	 *@param s number.
	 */
	public static void check(String s){
		/*First checks for major violations*/
		if(s.contains("  ")){
			numList.add(s + " INV");
			return;
		}
		if(s.contains("--")){
			numList.add(s + " INV");
			return;
		}

		/*Initial cases*/
		String case1 = "0508"; String case2 = "(0508)";
		String case3 = "0800"; String case4 = "(0800)";
		String case5 = "0900"; String case6 = "(0900)";

		String initCode = s.substring(0, Math.min(s.length(), 6)); 
		if (initCode.contains(case1) || initCode.contains(case2) || 
			initCode.contains(case3) || initCode.contains(case4) || 
			initCode.contains(case5) || initCode.contains(case6)){
			//Initial initCode
			initialPhone(s);
		return;
		}

		/*Mobile cases*/
		case1 = "021"; case2 = "(021)";
		case3 = "022"; case4 = "(022)";
		case5 = "027"; case6 = "(027)";
		String case7 = "025"; String case8 = "(025)";		
		String mobileCode = s.substring(0, Math.min(s.length(), 4)); 
		if (mobileCode.contains(case1) || mobileCode.contains(case2) || 
			mobileCode.contains(case3) || mobileCode.contains(case4) ||
			mobileCode.contains(case5) || mobileCode.contains(case6) ||
			mobileCode.contains(case7) || mobileCode.contains(case8)){
			mobilePhone(s);
			return;
		} 

		/*Area cases*/
		case1 = "02"; case2 = "(02)";
		case3 = "03"; case4 = "(03)";
		case5 = "04"; case6 = "(04)";
		case7 = "06"; case8 = "(06)";
		String case9 = "07"; String case10 = "(07)";
		String case11 = "09"; String case12 = "(09)";

		String areaCode = s.substring(0, Math.min(s.length(), 3)); 
		if(areaCode.contains(case1) || areaCode.contains(case2)){
			scottBasePhone(s);
			return;
		} 
		if (areaCode.contains(case3) || areaCode.contains(case4) || 
			areaCode.contains(case5) || areaCode.contains(case6) ||
			areaCode.contains(case7) || areaCode.contains(case8) ||
			areaCode.contains(case9) || areaCode.contains(case10) ||
			areaCode.contains(case11) || areaCode.contains(case12)){
			areaPhone(s);
			return;
		} 

	numList.add(s + " INV");
	}

	/**
	 * Formatting and cleaning function is the number has an Initial Code.
	 * Has a special case for when letters are present in the number. 
	 * 
	 *@param s number.
	 */
	public static void initialPhone(String s){
		/* Initial checks and basic formatting. Aim's to reduce variation
		   in the number as much as possible */

		String original = s; //When an invalid number is encountered

		if(s.contains("(") && s.contains(")")){
			s = s.replace("(", "");
			s = s.replace(")", "");
		}
		if(s.contains(" ")){
			s = s.replace(" ", "");
		}
		if(!firstValidityCheck(s, "init")){
			numList.add(original + " INV");
			return;
		} 
		String sEnd = s.substring(8, Math.min(s.length(), s.length())); 
		if (sEnd.contains("-")){
			numList.add(original + " INV");
			return;
		}

		if(s.contains("-")){
			s = s.replace("-", "");
		}



		/*Formatting based on what type of number it is.*/
		String type = s.substring(0, Math.min(s.length(), 4)); 
		StringBuilder sb = new StringBuilder(s);
		boolean hasLetter = s.matches(".*[a-zA-Z]+.*");
		


		if(!hasLetter){
			if (type.equals("0900")){
				if (s.length() != 9){
					numList.add(original + " INV");
					return;
				}
				//String regexStr = "^(0900\\)?[0-9]{5}$";
				sb.insert(4, " ");
				
			} else if (type.equals("0508")){
				if (s.length() != 10){
					numList.add(original + " INV");
					return;
				} else {
					sb.insert(4, " ");
					sb.insert(8, " ");
				}
			} else if (type.equals("0800")){
				if (s.length() != 10 && s.length() != 11){
					numList.add(original + " INV");
					return;
				}
				String regexStr = "^[0-9]{10}$";
				if(s.matches(regexStr)){
					sb.insert(4, " ");
					sb.insert(8, " ");
				} else {
					numList.add(original + " INV");
					return;
				}
				

			}
			s = sb.toString();

		} else if (hasLetter){
			if(type.equals("0508")){
				sEnd = s.substring(10, Math.min(s.length(), s.length())); 
				boolean hasNumberEnd = sEnd.matches(".*[1-9]+.*");
				s = convertToNumbers(s);
				if(s.length() > 13 || s.length() <= 9){
					numList.add(original + " INV");
					return;
				}
				if(s.length() != 10){
					if (hasNumberEnd){
						numList.add(original + " INV");
						return;
					}
					s = s.substring(0, Math.min(s.length(), 10)); 
				}
				sb = new StringBuilder(s);
				sb.insert(4, " ");
				sb.insert(8, " ");
			} else if (type.equals("0800")){
				//This is a mess

				if(s.length() > 13 || s.length() <= 9){
					numList.add(original + " INV");
					return;
				}
				if(s.length() == 10){
					String sEnd1 = s.substring(10, Math.min(s.length(), s.length())); 
					boolean hasNumberEnd1 = sEnd1.matches(".*[1-9]+.*");
					s = convertToNumbers(s);
					if (hasNumberEnd1){
						numList.add(original + " INV");
						return;
					}
					s = s.substring(0, Math.min(s.length(), 10)); 
				} else {
					if(s.length() >= 11){
						String sEnd2 = s.substring(11, Math.min(s.length(), s.length())); 
						boolean hasNumberEnd2 = sEnd2.matches(".*[1-9]+.*");
						s = convertToNumbers(s);

						if (hasNumberEnd2){
						numList.add(original + " INV");
						return;
					}

					}
					s = s.substring(0, Math.min(s.length(), 11)); 
				}
				sb = new StringBuilder(s);
				sb.insert(4, " ");
				sb.insert(8, " ");
			} else if (type.equals("0900")){
				sEnd = s.substring(9, Math.min(s.length(), s.length())); 
				boolean hasNumberEnd = sEnd.matches(".*[1-9]+.*");
				s = convertToNumbers(s);
				if(s.length() > 13 || s.length() <= 8){
					numList.add(original + " INV");
					return;
				}
				if(hasNumberEnd){
					numList.add(original + " INV");
					return;
				}
				s = s.substring(0, Math.min(s.length(), 9)); 
				sb = new StringBuilder(s);
				sb.insert(4, " ");
			}
			s = sb.toString();

		}

		if(duplicate(s)){
			numList.add(s + " DUP");
		} else { 
			numList.add(s);
		}
	}

	/**
	 * Formatting and cleaning function is the number has an mobile Code
	 * 
	 *@param s number.
	 */	
	public static void mobilePhone(String s){
		/* Initial checks and basic formatting*/

		String original = s;

		if(s.contains("(") && s.contains(")")){
			s = s.replace("(", "");
			s = s.replace(")", "");
		}

		if(s.contains(" ")){ 
			s = s.replace(" ", "");
		}

		if(!firstValidityCheck(s, "mobile"))
		{
			numList.add(original + " INV");
			return;
		} 
		if(s.contains("-")){
			s = s.replace("-", "");
		}
		
		String type = s.substring(0, Math.min(s.length(), 3)); 
		StringBuilder sb = new StringBuilder(s);
		if (type.equals("021")){
			if (s.length() != 9 && s.length() != 10 && s.length() != 11){
				numList.add(original + " INV");
				return;
			} 
			if (s.length() == 9 || s.length() == 10){
				sb.insert(3, " ");
				sb.insert(7, " ");
			} else if (s.length() == 11){
				sb.insert(3, " ");
				sb.insert(8, " ");
			}
		}
		if (type.equals("022") || type.equals("027")){
			if (s.length() != 10){
				numList.add(original + " INV");
				return;
			} 
			sb.insert(3, " ");
			sb.insert(7, " ");
		}
		if (type.equals("025")){
			if (s.length() != 9){
				numList.add(original + " INV");
				return;
			} 
			sb.setCharAt(2, '7');
			sb.insert(3, " ");
			sb.insert(4, "4");
			sb.insert(7, " ");
		}

		s = sb.toString();
		if(duplicate(s)){
			numList.add(s + " DUP");
		} else { 
			numList.add(s);
		}
	}

	/**
	 * Formatting and cleaning function is the number has a Scott base 
	 * code. 
	 *@param s number.
	 */	
	public static void scottBasePhone(String s){
		/* Initial checks and basic formatting*/
		String original = s; //If an invalid number is encountered

		if(s.contains("(") && s.contains(")")){
			s = s.replace("(", "");
			s = s.replace(")", "");
		}
		if(s.contains(" ")){
			s = s.replace(" ", "");
		}
		if(!firstValidityCheck(s, "scott")){
			numList.add(original + " INV");
			return;
		} 
		if(s.contains("-")){
			s = s.replace("-", "");
		}
		/*Formatting and final checks.*/
		String type = s.substring(0, Math.min(s.length(), 5)); 
		StringBuilder sb = new StringBuilder(s);
		if (type.equals("02409")){
			if (s.length() != 9){
				numList.add(original + " INV");
				return;
			} 
			sb.insert(2, " ");
			sb.insert(6, " ");
		
		} else {
			numList.add(original + " INV");
			return;
		}

		s = sb.toString();
		if(duplicate(s)){
			numList.add(s + " DUP");
		} else { 
			numList.add(s);
		}
	}

	/**
	 * Formatting and cleaning function is the number has an area code. 
	 *@param s number.
	 */	
	public static void areaPhone(String s){
		String original = s; //If an invalid number is encountered

		if(s.contains("(") && s.contains(")")){
			s = s.replace("(", "");
			s = s.replace(")", "");
		}
		if(s.contains(" ")){
			s = s.replace(" ", "");
		}
		if(!firstValidityCheck(s, "area")){
			
		} 
		if(s.contains("-")){
			s = s.replace("-", "");
		}
		/*Formatting and final checks.*/
		String type = s.substring(2, Math.min(s.length(), 5)); 
		StringBuilder sb = new StringBuilder(s);

		if (s.length() != 9){
			numList.add(original + " INV");
			return;
		}
		if(s.charAt(2) == '1'){
			numList.add(original + " INV");
			return;
		}
		if(type.equals("900") || type.equals("911") || type.equals("999")){
			numList.add(original + " INV");
			return;
		}
		sb.insert(2, " ");
		sb.insert(6, " ");
		s = sb.toString();

		if(duplicate(s)){
			numList.add(s + " DUP");
		} else { 
			numList.add(s);
		}
		
	}
	/**
	 * Validity check function which find violations that are not
	 * allowed in any type of number i.e. lowercase letters. etc
	 *@param s number.
	 *@param type of code we're dealing with.
	 */	

	public static Boolean firstValidityCheck(String s, String type){
		boolean hasLetter = s.matches(".*[a-zA-Z]+.*");
		boolean hasLowercase = !s.equals(s.toUpperCase());

		if (type.equals("init")){

			if (s.length() <= 8){
				return false;
			}
			if(hasLetter){
				if(hasLowercase) return false;
				if(s.contains("-")) return false;
			}
			if(s.charAt(4) == '-'){
				return false;
			}
		}  
		if (type.equals("scott")){
			if (s.length() <=8){
				return false;
			}
			if(s.charAt(2) == '-'){
				return false;
			}

			if(hasLetter){
				return false;
			}
		}
		if (type.equals("mobile")){
			if (s.length() <=8){
				return false;
			}
			if(s.charAt(3) == '-'){
				return false;
			}

			if(hasLetter){
				return false;
			}
		}

		if (type.equals("area")){
			if (s.length() <= 8){
				return false;
			}
			if(s.charAt(3) == '-'){
				return false;
			}

			if(hasLetter){
				return false;
			}
		}
		return true;
	}
	/**
	 * Converts capital letters into corresponding number.
	 *@param s number.
	 *@return s updated String
	 */	
	public static String convertToNumbers(String s){
		boolean hasLetter = s.matches(".*[a-zA-Z]+.*");
		StringBuilder sb = new StringBuilder();

			for (char c : s.toCharArray()){
				if(c == 'A' || c == 'B' || c == 'C'){
					sb.append("2");
				} else if(c == 'D' || c == 'E' || c == 'F'){
					sb.append("3");
				} else if(c == 'G' || c == 'H' || c == 'I'){
					sb.append("4");
				} else if(c == 'J' || c == 'K' || c == 'L'){
					sb.append("5");
				} else if(c == 'M' || c == 'N' || c == 'O'){
					sb.append("6");
				} else if(c == 'P' || c == 'Q' || c == 'R' || c == 'S'){
					sb.append("7");
				} else if(c == 'T' || c == 'U' || c == 'V'){
					sb.append("8");
				} else if(c == 'W' || c == 'X' || c == 'Y' || c == 'Z'){
					sb.append("9");
				} else sb.append(c);
			}
		s = sb.toString();
		return s;
	}
	/**
	 * Checks to see if duplicate
	 *@param s number.
	 *@return boolean
	 */	
	public static boolean duplicate(String s){
		if (numList.contains(s)){
			return true;
		} else{
		return false;
	}
	}


	public static void print(){
		for(int i = 0; i < numList.size(); i++){
			System.out.println("" + numList.get(i));
		}
	}



}
/**
Validity checks
Initial initCodes:
- 0508 must have 6 numbers.
- 0800 may have 6 or 7 numbers.
- 0900 must have 5 numbers

Area initCodes:
- 02 has a number length of 7 digits. First 3 MUST be 409.
- 03, 04, 05, 06, 07, 09 has a number length of 7 digits.
	->First digit must be 3 through 9, BUT NOT 900, 911, or 999

Mobile initCodes:
- 021 has length of 6-8 digits.
- 022, 027 must be 7 digits.
- 025 6 digits (will be modified later).

Acceptable input numbers
- No spaces, entirely numbers i.e. 024097777
- The initCode may be surrounded by parenthesis (027).
- Blocks of digits may be separated by a hyphen e.g 03 444-1234 but not 03-444-1234
- Numbers with initial initCodes may contain letters up to length 9 e.g. 0800 PIZZAHUT
- 025 numbers must be converted to 027 with a 4 put in place of the number section
	-> e.g. 025 123 456 becomes 027 4123456

*/