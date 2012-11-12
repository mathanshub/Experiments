import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;


public class ShortestSegment {

	
	public static void main(String[] args)throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String paragraph = bf.readLine();
		int no_words = Integer.parseInt(bf.readLine());
		
		
		//Form Map object with words needed with integer values for each word
		HashMap<String, Integer> wordsReqMap = new HashMap<String, Integer>();
		for (int i = 1; i <= no_words; i++) {
			wordsReqMap.put(bf.readLine().replaceAll("[^A-Za-z]", "").toLowerCase(), i);
		}
		
		//Form List of words present in paragraph.
		String inputWords[] = paragraph.split(" ");
		LinkedList<String> paragraphWordsList = new LinkedList<String>();
		for (int i = 0; i < inputWords.length; i++) {
			paragraphWordsList.add(inputWords[i].replaceAll("[^A-Za-z]", ""));
		}
		
		
		//form and integer array having values at each index as the which requeired word in present in that position in the input para
		int array[] = new int[inputWords.length];//size of the array will be total number of words in the input para.
		int wordPosInPara = 0;
		int value;
		for(String word:paragraphWordsList){
			if(wordsReqMap.containsKey(word.toLowerCase()))
				value=wordsReqMap.get(word.toLowerCase());
			else
				value=0;
			array[wordPosInPara]=value;
			wordPosInPara+=1;
		}
		
		/*for(int pos=0;pos<array.length;pos++)
			System.out.print(array[pos]+"\t");*/
	
		//Hashset for the intertesd numbers
		HashSet<Integer> interestedNumbers = new HashSet<Integer>();
		for (int m = 1; m <= no_words; m++)
			interestedNumbers.add(m);
		
		Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
		
		
		/*for (int p = 0; p <= no_words; p++) {
			mapCount.put(p, 0);
		}*/
		
		for (int p = 0; p <= inputWords.length; p++) {
			mapCount.put(p, 0);
		}
		int i = 0,nDistinctInteresting = 0;
		int minRange = array.length+1,minI = 0,minJ = 0;
		int val;
		for(int j=0;j<array.length;j++){
			
			if (mapCount.get(array[j]) == 0 && interestedNumbers.contains(array[j]))
				nDistinctInteresting += 1;
			mapCount.put(array[j], mapCount.get(array[j])+1);
			
			if (nDistinctInteresting == no_words){
				while (mapCount.get(array[i]) > 1	|| !interestedNumbers.contains(array[i])) {
					val = mapCount.get(array[i]);
					mapCount.put(array[i], --val);
					i++;
				}
				if ((j - i)+1 < minRange) {
					minI = i;minJ = j;minRange = j - i+1;
				}
			}

		}

		if (minRange <= array.length) {
			for (int r = minI; r <= minJ; r++) {
				System.out.print(inputWords[r].replaceAll("[^A-Za-z]", "") + " ");
			}
		} else {
			System.out.println("NO SUBSEGMENT FOUND");
		}

			
		}
		
	
}
