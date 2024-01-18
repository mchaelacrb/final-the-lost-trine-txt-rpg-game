package Main;

import java.util.concurrent.TimeUnit;

/**
 * Effects for the betterment of the game experience.
 * @author Bianca
 */

public class Effects {
    
    /**
     * Use to make the text the default color.
     */
    
	public static final String ANSI_RESET = "\u001B[0m";
        
     /**
     * Use to make the text color yellow.
     */
        
	private static final String ANSI_YELLOW = "\u001B[33m";
        
     /**
     * Use to make the text color green.
     */
        
	public static final String ANSI_GREEN = "\u001B[32m";
        
     /**
     * Use to make the text color red.
     */
        
	public static final String ANSI_RED = "\u001B[31m";
        
     /**
     * Use to make the text color blue.
     */
        
	public static final String ANSI_BLUE = "\u001B[34m";
        
     /**
     * Use to make the text color purple.
     */
        
	public static final String ANSI_PURPLE = "\u001B[35m";
        
     /**
     * Use to make the text color cyan.
     */
        
	public static final String ANSI_CYAN = "\u001B[36m";
        
     /**
     * Use to make the text bold.
     */
        
        public static final String ANSI_BOLD = " \033[1m";
	
        
        /**
         * 
         * @param delay
         * @param output 
         */
        
	public static void delayPrint(int delay, String output) {
		for (int i = 0; i < output.length(); i++) {
			char c= output.charAt(i);

	try { TimeUnit.MILLISECONDS.sleep(delay);
             System.out.print(c);
        } catch (Exception e) {
            e.printStackTrace();
	}
	}
	}
	
	public static void delay(int time, String type){ 
            if (type.equalsIgnoreCase("Sec")) {
		try { 
                    TimeUnit.SECONDS.sleep(time); 
		} catch (InterruptedException e) {
                    e.printStackTrace();
		}
            }else if(type.equalsIgnoreCase("mil")) { 
            try {
                TimeUnit.MILLISECONDS.sleep(time); 
		
            } catch (InterruptedException e) {
                e.printStackTrace();
	}
    }
}

        
        /**
         * This is to clear console by printing blank for 100 lines.
         */
        
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    /**
     * This is use to print a multiple lines to separate the text from the previous one.
     * @param n a throwaway variable to get how many lines to be printed.
     */
    
    public static void printLines(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    /**
     * This is use to print a multiple periods(.) to separate the text from the previous one.
     * @param y A throwaway variable to get how many periods to be printed.
     */

    public static void periods(int y) {
        for (int i = 0; i < y; i++) {
            System.out.print(".");
        }
        System.out.println();
    }

    /**
     * This is use to print the text to green and back to the default color of the text.
     * @param print String parameter to bring back an argument string in color green.
     */
    
    public static void greenText(String print) {
        System.out.println(ANSI_GREEN + "" + print + "" + ANSI_RESET);
    }
    
    /**
     * This is use to print the text to yellow and back to the default color of the text.
     * @param print String parameter to bring back an argument string in color yellow.
     */

    public static void yellowText(String print) {
        System.out.println(ANSI_YELLOW + "" + print + "" + ANSI_RESET);
    }
    
    /**
     * This is use to print the text to red and back to the default color of the text.
     * @param print String parameter to bring back an argument string in color red.
     */

    public static void redText(String print) {
        System.out.println(ANSI_RED + "" + print + "" + ANSI_RESET);
    }
    
    /**
     * This is use to print the text to purple and back to the default color of the text.
     * @param print String parameter to bring back an argument string in color purple.
     */
    
    public static void purpleText(String print) {
        System.out.print(ANSI_PURPLE + "" + print + "" + ANSI_RESET);
    }
    
    /**
     * This is use to print the text to cyan and back to the default color of the text.
     * @param print String parameter to bring back an argument string in color cyan.
     */
    
    public static void cyanText(String print) {
        System.out.print(ANSI_CYAN + "" + print + "" + ANSI_RESET);
    }
		
		
}
