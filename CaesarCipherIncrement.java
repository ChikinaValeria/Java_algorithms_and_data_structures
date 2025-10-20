/**
 * Codes demonstrates a simple Caesar cipher (shift +1) to encrypt and decrypt messages.
 */
public class CaesarCipherIncrement
{
    /**
     * Encode and decode a message using a constant key of 1.
     */
    public static void main(String[] args)
    {
        final int KEY_VALUE = 1;

        String encoded = "";
        String decoded = "";
        String message = "Peter Piper picked a peck of pickled peppers";

        System.out.println("Original Message:\n" + message + "\n");

        // Encoding
        for (int scan = 0; scan < message.length(); scan++)
        {
            encoded += (char) (message.charAt(scan) + KEY_VALUE);
        }

        System.out.println ("Encoded Message:\n" + encoded + "\n");

        // Decoding
        for (int scan = 0; scan < encoded.length(); scan++)
        {
            decoded += (char) (encoded.charAt(scan) - KEY_VALUE);
        }

        System.out.println ("Decoded Message:\n" + decoded);
    }
}