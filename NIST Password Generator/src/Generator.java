import java.util.Random ;
import java.util.Scanner;





/**
 * 
 * 
 * @author Derell Facey
 * @version 1.0.0 2024-12-01 Initial implementation
 *
 */

public class Generator
    {
        private String password;
        
        /**
         * 
         */
        public Generator()
        {
            
        }
        
        /**
         * 
         * Generate a random password in accordance with the following requirements:
         * 
         * ***********************************************************
         * 
         *  - MUST HAVE AT LEAST 8 CHARACTERS
         *  - MUST HAVE AT LEAST 1 UPPERCASE LETTER
         *  - MUST HAVE AT LEAST 1 LOWERCASE LETTER
         *  - MUST HAVE AT LEAST 1 DIGIT
         *  - MUST HAVE AT LEAST 1 SPECIAL CHARACTER
         *  
         *  Source:
         *  https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-63b.pdf
         */
        public void generate()
        {
        
            Random random = new Random();
            StringBuilder newPassword = new StringBuilder();
            
            newPassword.setLength( random.nextInt(8,20));
            
            //random index for inserting characters into string at random positions
            int randIndex = random.nextInt(newPassword.length());
            int tmp;
            
            
            //parse the random int to char, according to ascii
            
            //ensures there is an Uppercase
            char upperCase = (char) (random.nextInt(65,90));
            
            newPassword.setCharAt( randIndex, upperCase );
            
           // System.out.println( newPassword.charAt( randIndex ) ) ;
            
            //ensures the next required char is in a blank index
            while(isBlank(newPassword.charAt( randIndex )))
                {   
                randIndex = random.nextInt(newPassword.length());
                }
            
            
            //ensures there is a lowercase
            char lowerCase = (char)(random.nextInt(97,122));
            
            newPassword.setCharAt( randIndex, lowerCase );
            
         //   System.out.println( newPassword.charAt( randIndex ) ) ;
            
            while(isBlank(newPassword.charAt( randIndex )))
                {   
                randIndex = random.nextInt(newPassword.length());
                }
            
            //ensures there is a number
            char num = (char)( random.nextInt(48,57));
            
            newPassword.setCharAt( randIndex, num );
            
         //   System.out.println( newPassword.charAt( randIndex ) ) ;
            
            while(isBlank(newPassword.charAt( randIndex )))
                {   
                randIndex = random.nextInt(newPassword.length());
                }
            
            tmp = random.nextInt(3);
            
            //ensures there is a special character
            char special = 0;
            if(tmp == 0)
                {
                 special = (char)( random.nextInt(33,47));
                }
            
            if(tmp == 1)
                {
                 special = (char)( random.nextInt(58,64));
                }
            
            if(tmp == 2)
                {
                 special = (char)( random.nextInt(91,96));
                }
            
            if(tmp == 2)
                {
                 special = (char)( random.nextInt(123,126));
                }
           
            newPassword.setCharAt( randIndex, special );
            
           // System.out.println( newPassword.charAt( randIndex ) ) ;
            
            //remaining are random chars
            
            for(int i = 0; i<newPassword.length();i++)
                {
                   if( newPassword.charAt( i ) != 0)
                       {
                       continue;
                       }
                   newPassword.setCharAt( i, (char)(random.nextInt(93)+33) );
                }
            
            //set password
            setPassword(newPassword.toString());
            
           
        }
        
        /**
         * 
         * 
         * @param password password String
         * @return true is valid, false if not valid
         */
        public static boolean validPassword(String password)
        {
        
        if  (validLength(password) && validChars(password) && hasUpperCase(password)
                             && hasLowerCase(password) && hasSpecial(password) & hasNum(password))
            {
            return true;
            }
        return false;
        }
        
        /**
         * 
         * 
         * @param c character from index
         * @return true if character in index is null(0), false if not
         */
        public static boolean isBlank(char c)
        {
            if(c != 0)
                {
                    return false;
                }
            return true;
        }
        /**
         * 
         * 
         * @param password String
         */
        public void setPassword(String password)
        {
            this.password = password;
        }
        /**
         * 
         * 
         * @return password
         */
        public String getPassword()
        {
            return this.password;
        }
    
        /**
         * 
         * 
         * @param password String
         * @return false if password is long than 8 char and less than limit, 
         * true if password is more than 8 chars and less than 20
         */
        public static boolean validLength(String password)
        {
            if(password.length() < 8 || password.length() > 20)
                {
                return false;
                }
            
        return true;
        }
        
        /**
         * 
         * 
         * @param password String
         * @return true if char is not a 'space', false if it is a 'space'
         */
        public static boolean validChars(String password)
        {
        for(int i = 0; i < password.length();i++)
            {
                if(password.charAt( i ) == ' ')
                    {
                    return false;
                    }
            }
        return true;
        }
        
        /**
         * 
         * 
         * @param password String
         * @return true if the password has an uppercase letter, false if not
         */
        public static boolean hasUpperCase(String password)
        {
        
            for(int i = 0; i < password.length();i++)
                {
                    if(password.charAt( i ) >= 65 && password.charAt( i ) <= 90)
                        {
                        return true;
                        }
                }
            return false;
        }
        
        
        /**
         * 
         * 
         * @param password String
         * @return true if the password has a lowercase letter, false if not
         */
        public static boolean hasLowerCase(String password)
            {
            
            for(int i = 0; i < password.length();i++)
                {
                    if(password.charAt( i ) >= 97 && password.charAt( i ) <= 122)
                        {
                        return true;
                        }
                }
            return false;
        }
        
        /**
         * 
         * 
         * @param password String
         * @return true if password has a special char, false if not
         */
        public static boolean hasSpecial(String password)
            {
            
            for(int i = 0; i < password.length();i++)
                {
                    if(         (password.charAt( i ) >= 33 && password.charAt( i ) <= 47)
                                                    || (password.charAt( i ) >= 58 && password.charAt( i ) <=64)
                                                    || (password.charAt( i ) >= 94 && password.charAt( i ) <= 96)
                                                    || (password.charAt( i ) >= 123 && password.charAt(i) <=126))
                        {
                        return true;
                        }
                }
            return false;
        }
        
        /**
         * 
         * 
         * @param password String
         * @return true if password has an integer(number), false if not
         */
        public static boolean hasNum(String password)
            {
            
            for(int i = 0; i < password.length();i++)
                {
                    if(password.charAt( i ) >= 48 && password.charAt( i ) <= 57)
                        {
                        return true;
                        }
                }
            return false;
        }
        
        
        
        public static void main (String [] args)
            {
            
            Scanner in = new Scanner(System.in);
            String ans;
            String userPassword;
            
         
            System.out.printf( "Generate new password?%n(Y/N): " );
            ans = in.next();
            
            
            while(!ans.equals( "Y" ) && !ans.equals( "y" ) && !ans.equals( "n" ) && !ans.equals( "N" ))
                {
                   
                    System.out.printf( "Please select yes or no.%n(Y/N): " );
                    ans = in.next();
                }
            
            
            //Generates a password for user using generator
            
            if(ans.equals("y") || ans.equals("Y"))
                {
                Generator password = new Generator();
                password.generate();
                
                //Displays password and asks user if they want to use it, or generate a new one
                System.out.printf( "Use this password? : \"%s\"%n(Y/N): " , password.getPassword() ) ;  
                
                ans = in.next();
                    
                    while(!ans.equals( "Y" ) && !ans.equals( "y" ) && !ans.equals( "n" ) && !ans.equals( "N" ))
                        {
                           
                            System.out.printf( "Please select yes or no.%n(Y/N): " );
                            ans = in.next();
                        }
                    
                    //If the client answers no ('n' or 'N') generate new password
                    //loop until answer is yes
                    
                    while(ans.equals("N") || ans.equals( "n" ))
                        {
                        
                        System.out.printf("%nGENERATING NEW PASSWORD...%n");
                        password.generate();
                        System.out.printf( "%n" + "Use this password? : \"%s\"%n(Y/N): " , password.getPassword() ) ;
                        ans = in.next();
                        
                            while(!ans.equals( "Y" ) && !ans.equals( "y" ) && !ans.equals( "n" ) && !ans.equals( "N" ))
                                {
                                   
                                    System.out.printf( "Please select yes or no.%n(Y/N): " );
                                    ans = in.next();
                                }
                        
                        }
                    
                    //Displays newly generated password (Password are generated according to the password guidlelines)
                    if(ans.equals("y") || ans.equals("Y"))
                        {
                            userPassword = password.getPassword();
                            System.out.printf("%n" + "NEW PASSWORD: \"%s\"", userPassword);
                        }
                    
                
                }
            
            
            
            //For if the user select no, and instead wants to choose their own password
            if(ans.equals("n") || ans.equals("N"))
                {
                    System.out.printf( "%nCHOOSE PASSWORD (Must have: 12 characters, 1 upper case, 1 lower case" +
                                                    " 1 digit, and 1 special character) :%n" );
                    
                    userPassword = in.next();
                    
                    while(!validPassword(userPassword))
                        {
                            System.out.printf("Invalid Password!%n"+
                                                            "*Password must have: 12 characters, " +
                                                            "1 upper case, 1 lower case" +
                                                              " 1 digit, and 1 special character.*%n%n");
                            
                            System.out.print( "CHOOSE A NEW PASSWORD: " );
                            userPassword = in.next();
                            
                        }
                    
                    System.out.printf("%n" + "NEW PASSWORD: \"%s\"", userPassword);
                }
            
            }
    }


   // end class generator


