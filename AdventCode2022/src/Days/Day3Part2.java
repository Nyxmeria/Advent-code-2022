package Days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * --- Part Two ---
As you finish identifying the misplaced items, the Elves come to you with another issue.

For safety, the Elves are divided into groups of three. Every Elf carries a badge that identifies their group. 
For efficiency, within each group of three Elves, the badge is the only item type carried by all three Elves. 
That is, if a group's badge is item type B, then all three Elves will have item type B somewhere in their rucksack, and at most two of the Elves will be carrying any other item type.

The problem is that someone forgot to put this year's updated authenticity sticker on the badges. 
All of the badges need to be pulled out of the rucksacks so the new authenticity stickers can be attached.

Additionally, nobody wrote down which item type corresponds to each group's badges. 
The only way to tell which item type is the right one is by finding the one item type that is common between all three Elves in each group.

Every set of three lines in your list corresponds to a single group, but each group can have a different badge item type. 
So, in the above example, the first group's rucksacks are the first three lines:

vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
And the second group's rucksacks are the next three lines:

wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw
In the first group, the only item type that appears in all three rucksacks is lowercase r; this must be their badges. In the second group, their badge item type must be Z.

Priorities for these items must still be found to organize the sticker attachment efforts: here, they are 18 (r) for the first group and 52 (Z) for the second group. The sum of these is 70.

Find the item type that corresponds to the badges of each three-Elf group. What is the sum of the priorities of those item types?
 */
public class Day3Part2 {

	public static void main(String[] args) throws IOException {
		sumOfPriorities();

	}

	private static void sumOfPriorities() throws IOException {
		String relativePath = "../AdventCode2022/src/Inputs/InputDay3.txt";
		Path path = Paths.get(relativePath);
		int prioritiesSum = 0;
		List<String> lines = Files.readAllLines(path);
		//se lee cada linea
		for (int i = 0; i<lines.size();i+=3) {
		//String line = "vJrwLWtwJgWrhcsFMMfFFhFL";
			//primera línea
			String firstLine = lines.get(i);
			//segunda línea
			String secondLine = lines.get(i+1);
			//tercera línea
			String thirdLine = lines.get(i+2);
			//por cada caracter encontrado
			for (int j = 0; j < firstLine.length(); j++)
			{
				//vemos si la segunda línea lo contiene
				if (secondLine.contains(firstLine.substring(j, j+1))&&thirdLine.contains(firstLine.substring(j, j+1)) ) {
					char c = firstLine.charAt(j);
					if (Character.isUpperCase(c))
						prioritiesSum += (int) c - 38;
					else
						prioritiesSum += (int) c - 96;
					//no nos interesa seguir mirando
					break;	
				}
			}
		}
		System.out.println(prioritiesSum);
	}

}
