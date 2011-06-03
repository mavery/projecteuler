package mavery.projecteuler;

import java.util.List;

import mavery.projecteuler.util.EulerUtils;
import mavery.projecteuler.util.FileUtils;

public class Problem59
{
	public static final String KEY_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final int KEY_LENGTH = 3;

	// Values here derived from http://en.wikipedia.org/wiki/Letter_frequency
	private static final double minimumERatio = 0.09;
	private static final double minimumTRatio = 0.07;
	private static final double minimumARatio = 0.06;
	private static final double minimumLetterRatio = 0.75;

	/**
	 * Each character on a computer is assigned a unique code and the preferred
	 * standard is ASCII (American Standard Code for Information Interchange).
	 * For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
	 * 
	 * A modern encryption method is to take a text file, convert the bytes to
	 * ASCII, then XOR each byte with a given value, taken from a secret key.
	 * The advantage with the XOR function is that using the same encryption key
	 * on the cipher text, restores the plain text; for example, 65 XOR 42 =
	 * 107, then 107 XOR 42 = 65.
	 * 
	 * For unbreakable encryption, the key is the same length as the plain text
	 * message, and the key is made up of random bytes. The user would keep the
	 * encrypted message and the encryption key in different locations, and
	 * without both "halves", it is impossible to decrypt the message.
	 * 
	 * Unfortunately, this method is impractical for most users, so the modified
	 * method is to use a password as a key. If the password is shorter than the
	 * message, which is likely, the key is repeated cyclically throughout the
	 * message. The balance for this method is using a sufficiently long
	 * password key for security, but short enough to be memorable.
	 * 
	 * Your task has been made easy, as the encryption key consists of three
	 * lower case characters. Using cipher1.txt (right click and 'Save
	 * Link/Target As...'), a file containing the encrypted ASCII codes, and the
	 * knowledge that the plain text must contain common English words, decrypt
	 * the message and find the sum of the ASCII values in the original text.
	 */
	public static void main(String[] args) throws Exception
	{
		char[] encrypted = getEncryptedString("resources/Problem59.txt");

		for (String key : EulerUtils.buildCombinations(KEY_CHARACTERS,
				KEY_LENGTH, KEY_LENGTH))
		{
			StringBuffer decrypted = new StringBuffer();
			int eCount = 0, aCount = 0, tCount = 0, letterCount = 0;
			for (int i = 0; i < encrypted.length; i++)
			{
				char c = (char) (encrypted[i] ^ key.charAt(i % KEY_LENGTH));
				decrypted.append(c);

				if (Character.isLetter(c))
				{
					letterCount++;
				}
				if (c == 'e' || c == 'E')
				{
					eCount++;
				}
				if (c == 'a' || c == 'A')
				{
					aCount++;
				}
				if (c == 't' || c == 'T')
				{
					tCount++;
				}
			}

			if (letterCount > (int) (encrypted.length * minimumLetterRatio)
					&& eCount > (int) (letterCount * minimumERatio)
					&& aCount > (int) (letterCount * minimumARatio)
					&& tCount > (int) (letterCount * minimumTRatio))
			{
				int result = 0;
				for (int i = 0; i < decrypted.length(); i++)
				{
					result += (int) decrypted.charAt(i);
				}
				System.out.printf("KEY: \"%s\"\nMESSAGE: \"%s\"\nVALUE: %d\n", key, decrypted.toString(), result);
			}
		}
	}

	private static char[] getEncryptedString(String filename) throws Exception
	{
		List<String> lines = FileUtils.readLines(filename);
		char[] result = new char[lines.size()];
		int i = 0;
		for (String line : lines)
		{
			result[i++] = (char) Integer.parseInt(line);
		}
		return result;
	}

}
