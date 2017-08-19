/*
 * Title: Brutus
 * Author: James Hare
 * 
 * A class that can be used in a brute-force
 * attack to discover a message encrypted by
 * the Cipher class.
 */
package caesarcipherwithgui;


/**
 *
 * @author James Hare
 */
public class Brutus {
    
    // instance variables
    private String message;                        // encryptd text
    private char c;                                // a character place holder
    private StringBuffer bufferMessage;            // a String that can be modified
    private int selection;                         // an int to represent a selection
    
    // constructor
    public Brutus() {
        
    }
    
    // methods
    /**
     * setMessage() asks the user for a String input
     *              and sets it as the message.
     */
    public void setMessage(String text) {
        message = text;
    }
    
    /**
     * crackTheMessage() allows the attacker to attempt
     *                   to crack the original message.
     * @param min a minimum shift value to try.
     * @param max a maximum shift value to try.
     * @return bufferMessage variations of the possible deciphered message.
     */
    public StringBuffer crackTheMessage() {
        
        // sets bufferMessage as a clone of message.
        bufferMessage = new StringBuffer(message);
        
        // tries every possible forward shift between the min and max shifts.
        for(int x = 1; x <= 26; x++) {

            // goes through every character in bufferMessage.
            for(int i = 0; i < bufferMessage.length(); i++){
                c = bufferMessage.charAt(i);
                
                // shifts the character by the shift value.
                if(c >= 32 && c <= 126) {
                    c = (char)(c + x);
                    
                    if(c < 32) {
                        c += 95;
                    } else if (c > 126) {
                        c -= 96;
                    }
                    bufferMessage.setCharAt(i, c);
                }
                
            }
            
            // Places a space between possible cracks
            bufferMessage.append(" // ");
        }
        
        // tries every possible backwards shift between the min and max shifts.
        for(int x = 1; x <= 26; x++) {
            
            // goes through every character in bufferMessage.
            for(int i = 0; i < bufferMessage.length(); i++){
                c = bufferMessage.charAt(i);
                
                // shifts the character by the shift value.
                if(c >= 32 && c <= 126) {
                    c = (char)(c + -x);
                    
                    if(c < 32) {
                        c += 95;
                    } else if (c > 126) {
                        c -= 96;
                    }
                    bufferMessage.setCharAt(i, c);
                }
                
            }
            
            // Places a space between possible cracks
            bufferMessage.append(" // ");
        }
        
        return bufferMessage;

    }
    
}