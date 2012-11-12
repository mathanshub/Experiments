import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/*
Given a paragraph of text, write a program to find the first shortest sub-segment that contains each of the given k words at least once. A segment is said to be shorter than other if it contains less number of words.

Ignore characters other than [a-z][A-Z] in the text. Comparison between the strings should be case-insensitive. 

If no sub-segment is found then the program should output “NO SUBSEGMENT FOUND”.

 
Input format :
 
First line of the input contains the text.
Next line contains k , the number of  words given to be searched.
Each of the next k lines contains a word.
 
 
Output format :
 
Print first shortest sub-segment that contains given k words , ignore special characters, numbers.If no sub-segment is found it should return “NO SUBSEGMENT FOUND”
 
Sample Input :
 
This is a test. This is a programming test. This is a programming test in any language.
4
this
a
test
programming
 
Sample Output :
 
a programming test This
 
Explanation :
In this test case segment "a programming test. This" contains given four words. You have to print without special characters, numbers so output is "a programming test This".  Another segment "This is a programming test." also contains given  four words but have more number of words. 
 
Constraint :

Total number of character in a paragraph will not be more than 200,000.
0 < k <= no. of words in paragraph.
0 < Each word length < 15

*/
public class ShortestSubSeg {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String input = bf.readLine().trim();
		int no_words = Integer.parseInt(bf.readLine());
		HashMap<String, Integer> searchWords = new HashMap<String, Integer>();
		for (int i = 1; i <= no_words; i++) {
			 String str = bf.readLine().trim();
			 str=str.replaceAll("[,|.|!|@|#|$|%|^|&|*|(|)|{|}|<|>|/|-|_|~|`|\\d]", "");
			searchWords.put(str.toLowerCase(), i);
		}
		String input_words[] = input.split(" ");
		LinkedList<String> inputWords = new LinkedList<String>();
		for (int i = 0; i < input_words.length; i++) {
			//int l = input_words[i].length() - 1;
			//char c = input_words[i].charAt(l);
			inputWords.add(input_words[i].trim().replaceAll("[^A-Za-z]", ""));
			/*if (c == '.') {
				inputWords.add(input_words[i].substring(0, l));
			} else
				inputWords.add(input_words[i]);*/
		}
		int setKeys[] = new int[inputWords.size()];
		int wordPos = 0;
		for (String word : inputWords) {
			setKeys[wordPos]=0;
			for (String key : searchWords.keySet()) {
				if (word.equalsIgnoreCase(key)) {
					setKeys[wordPos] = searchWords.get(key);
					break;
				}
				
			}
			wordPos += 1;
		}

		int windowElem = searchWords.size();

		HashSet<Integer> isInteresting = new HashSet<Integer>();

		for (int m = 1; m <= windowElem; m++)
			isInteresting.add(m);

		int i = 0;
		int nDistinctInteresting = 0;
		int minRange = setKeys.length + 2;
		int minI = 0;
		int minJ = 0;
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();

		/*for (int p = 1; p <= windowElem; p++) {
			count.put(p, 0);

			//
		}
		count.put(0, 0);*/
		
		
		
		for(int p=0;p<setKeys.length;p++){
			count.put(setKeys[p], 0);
		}
		int val;
		for (int j = 0; j < setKeys.length; j++) {
			//if(count.get(setKeys[j])!=null)
			if (count.get(setKeys[j]) == 0
					&& isInteresting.contains(setKeys[j]))
				nDistinctInteresting += 1;
			if(count.get(setKeys[j])!=null){
				val = count.get(setKeys[j]);
			count.put(setKeys[j], ++val);
			}
			else 
				count.put(setKeys[j], 1);
			if (nDistinctInteresting == windowElem) {

				while (count.get(setKeys[i]) > 1
						|| !isInteresting.contains(setKeys[i])) {
					val = count.get(setKeys[i]);
					count.put(setKeys[i], --val);
					i++;
				}
				if ((j - i)+1 < minRange) {
					minI = i;
					minJ = j;
					minRange = j - i+1;
				}

			}

		}

		if (minRange <= setKeys.length) {
			for (int r = minI; r <= minJ; r++) {
				System.out.print(inputWords.get(r) + " ");
			}
		} else {
			System.out.println("NO SUBSEGMENT FOUND");
		}

	}

}
