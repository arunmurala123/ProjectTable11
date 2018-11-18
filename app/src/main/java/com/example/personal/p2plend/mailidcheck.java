
    import java.util.regex.*;
    class MailTest
    {
    public static boolean isValid(String email,String password)
    {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
    "[a-zA-Z0-9_+&*-]+)*@" +
    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
    "A-Z]{2,7}$";
	String passwordRegex="^[a-zA-Z0-9$&+,:;=?@#|'<>.^*()%!-];
    Pattern pat = Pattern.compile(emailRegex);
	Pattern pat1= pattern.compile(passwordRegex);
    if (email == null)
    return false;
    return pat.matcher(email).matches();
	return pat1.matcher(password).matches();
    }
   /*checking email id
        public static void main(String args[])
        {
            String r="vikramkaringu*gmail.com";
                if(isValid(r))
                {
                    System.out.println("True");
                }
            else
            System.out.println("False");
        }
 */           
        
    }

