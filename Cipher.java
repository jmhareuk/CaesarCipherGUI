/*
 * Title: Cipher
 * Author: James Hare
 * 
 * A class to encrypt a piece of data
 * by using a Caesar cipher.
 */
package caesarcipherwithgui;

/**
 *
 * @author James Hare
 */
public class Cipher {
    
    // instance variables
    private String message;                 // a message to encrypt
    private int shift;                      // a number to shift
    private int direction;                  // a direction to shift
    private char c;                         // a character place holder
    private StringBuffer bufferMessage;     // a String that can be modified
    
    // constructor
    public Cipher() {
        
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
     * setNumber() asks the user for an int input
     *             and sets it as the shift value.
     */
    public void setShift(int shiftValue) {
        shift = shiftValue;
    }
    
    /**
     * setDirection() Asks the user for an int input
     *                to set the direction of the
     *                shift.
     */
    public void setDirection(int dir) {
        direction = dir;
    }
    
    /**
     * encipher() Encrypts the message.
     * @return bufferMessage the encrypted message.
     */
    public StringBuffer encipher() {
        
        try {
            
            switch (direction) {
                
                case 1:
                    // sets bufferMessage as a clone of message.
                    bufferMessage = new StringBuffer(message);
                    
                    // goes through every character in bufferMessage.
                    for(int i = 0; i < bufferMessage.length(); i++){
                        c = bufferMessage.charAt(i);
                        
                        // shifts the character by the shift value.
                        if(c >= 32 && c <= 126) {
                            c = (char)(c + shift);
                            
                            if(c < 32) {
                                c += 95;
                            } else if (c > 126) {
                                c -= 96;
                            }
                            bufferMessage.setCharAt(i, c);
                        }
                    }
                    
                    // returns the encrypted message.
                    return bufferMessage;
                    
                case 2:
                    // sets bufferMessage as a clone of message.
                    bufferMessage = new StringBuffer(message);
                    
                    // goes through every character in bufferMessage.
                    for(int i = 0; i < bufferMessage.length(); i++) {
                        c = bufferMessage.charAt(i);
                        
                        // shifts the character by the negative shift value.
                        if(c >= 32 && c <= 126) {
                            c = (char)(c + -shift);
                            
                            if(c < 32) {
                                c += 95;
                            } else if (c > 126) {
                                c -= 96;
                            }
                            bufferMessage.setCharAt(i, c);
                        }
                    }
                    
                    // returns the encrypted message.
                    return bufferMessage;
                    
                default:
                    StringBuffer directionFailed = new StringBuffer("You failed to set the direction.");
                    return directionFailed;
            }
        } catch (Exception e) {
            
            StringBuffer aspectsFailed = new StringBuffer("You must enter a message and shift value.");
            return aspectsFailed;
            
        }
        
    }
    
    /**
     * decipher() Decrypts the message.
     * @return bufferMessage the decrypted message.
     */
    public StringBuffer decipher() {

        try {
            
            switch (direction) {
                
                case 1:
                    // sets bufferMessage as a clone of message.
                    bufferMessage = new StringBuffer(message);
                    
                    // goes through every character in bufferMessage.
                    for(int i = 0; i < bufferMessage.length(); i++){
                        c = bufferMessage.charAt(i);
                        
                        /**
                         * Shifts the character by the negative shift
                         * value. This is based on the way that the
                         * message was originally encrypted.
                         */
                        if(c >= 32 && c <= 126) {
                            c = (char)(c + -shift);
                            
                            if(c < 32) {
                                c += 95;
                            } else if (c > 126) {
                                c -= 96;
                            }
                            bufferMessage.setCharAt(i, c);
                        }
                    }
                    
                    // returns the decrypted message.
                    return bufferMessage;
                    
                case 2:
                    // sets bufferMessage as a clone of message.
                    bufferMessage = new StringBuffer(message);
                    
                    // goes through every character in bufferMessage.
                    for(int i = 0; i < bufferMessage.length(); i++) {
                        c = bufferMessage.charAt(i);
                        
                        /**
                         * Shifts the character by the shift
                         * value. This is based on the way that the
                         * message was originally encrypted.
                         */
                        if(c >= 32 && c <= 126) {
                            c = (char)(c + shift);
                            
                            if(c < 32) {
                                c += 95;
                            } else if (c > 126) {
                                c -= 96;
                            }
                            bufferMessage.setCharAt(i, c);
                        }
                    }
                    
                    // returns the decrypted message.
                    return bufferMessage;
                    
                default:
                    StringBuffer directionFailed = new StringBuffer("You failed to set the direction.");
                    return directionFailed;
            }
        } catch (Exception e) {
            
            StringBuffer aspectsFailed = new StringBuffer("You must enter a message and shift value.");
            return aspectsFailed;
            
        }
        
    }
    
}
