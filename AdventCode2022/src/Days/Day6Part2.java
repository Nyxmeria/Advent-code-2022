package Days;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * --- Part Two ---
Your device's communication system is correctly detecting packets, but still isn't working. It looks like it also needs to look for messages.

A start-of-message marker is just like a start-of-packet marker, except it consists of 14 distinct characters rather than 4.

Here are the first positions of start-of-message markers for all of the above examples:

mjqjpqmgbljsphdztnvjfqwrcgsmlb: first marker after character 19
bvwbjplbgvbhsrlpgdmjqwftvncz: first marker after character 23
nppdvjthqldpwncqszvftbrmjlhg: first marker after character 23
nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg: first marker after character 29
zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw: first marker after character 26
How many characters need to be processed before the first start-of-message marker is detected?
2414
 */
public class Day6Part2 {

	public static void main(String[] args) throws IOException {
		numberOfCharacters();
	}

	private static void numberOfCharacters() throws IOException {
		String relativePath = "../AdventCode2022/src/Inputs/InputDay6.txt";
		Path path = Paths.get(relativePath);
		BufferedReader br = Files.newBufferedReader(path);
		String line = br.readLine();
		System.out.println(line);
		boolean found = false;
		int i = 13;
		while (!found)
		{
			found = true;
			for (int j = i; j>i-13 ;j--) {
				if (!found)
					break;
				for(int z = j-1; z>=i-13;z--) {
					if (line.charAt(j)==line.charAt(z))
					{
						found = false;
						break;
					}
				}			
			}
			i++;
		}
		System.out.println(i);
	}

}
