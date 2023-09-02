package Days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * By the time you calculate the answer to the Elves' question, they've already realized that the Elf carrying the most Calories of food might eventually run out of snacks.

To avoid this unacceptable situation, the Elves would instead like to know the total Calories carried by the top three Elves carrying the most Calories. 
That way, even if one of those Elves runs out of snacks, they still have two backups.

In the example above, the top three Elves are the fourth Elf (with 24000 Calories), then the third Elf (with 11000 Calories), then the fifth Elf (with 10000 Calories). 
The sum of the Calories carried by these three elves is 45000.

Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
206289
 */
public class Day1Part2 {
	public static void main(String[] args) {
		String relativePath = "../AdventCode2022/src/Inputs/InputDay1.txt";
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Path filePath = Paths.get(relativePath);
		ArrayList<Integer> elves = new ArrayList<Integer>();
		
		try 
		{
	        // Read all lines from the file into a List of Strings
			List<String> lines = Files.readAllLines(filePath);
			int caloriesSum = 0; 
			for (String line : lines) {
				// New elf
				if (line.equals(""))
				{
					elves.add(caloriesSum);
					caloriesSum = 0;
				}
				// Same elf
				else
					caloriesSum += Integer.parseInt(line);
            }
		} 
		catch (IOException e) 
		{
				e.printStackTrace();
		}
		Collections.sort(elves, Collections.reverseOrder());
		System.out.println(elves.get(0)+elves.get(1)+elves.get(2));
		
	}
}
