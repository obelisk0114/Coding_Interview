package facebook;

/*
 * giving a list of strings to form a single new string with some rules. 
 * connect strings by ;  if a string contains ;  use "" to wrap the string. 
 * if a string contains ", replace " with "".
 */

public class Connect_String {
	String connector(String[] arr) {
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				String tmp = arr[i].charAt(j) + ""; 
				if (tmp.equals(";")) {
					result = result + "\"" + ";" + "\"";
				}
				else if (tmp.equals("\"")) {
					result = result + "\"\"";
				}
				else {
					result += tmp;
				}
			}
			result += ";";
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connect_String connect = new Connect_String();
		String[] arr = {"1", "2", "3", ";", "4", "5", "6", "\"", "7", "8", "9"};
		System.out.println(connect.connector(arr));

	}

}
