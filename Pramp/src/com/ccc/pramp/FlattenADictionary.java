package com.ccc.pramp;

import java.util.HashMap;

/**
 * A dictionary is a type of data structure that is supported natively in all major interpreted languages such as JavaScript, Python, Ruby and PHP, where it�s known as an Object, Dictionary, Hash and Array, respectively. In simple terms, a dictionary is a collection of unique keys and their values. The values can typically be of any primitive type (i.e an integer, boolean, double, string etc) or other dictionaries (dictionaries can be nested).
 * Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .
 * If you�re using a compiled language such Java, C++, C#, Swift and Go, you may want to use a Map/Dictionary/Hash Table that maps strings (keys) to a generic type (e.g. Object in Java, AnyObject in Swift etc.) to allow nested dictionaries.
 * 
 * Example:
 * input:  dict = {
 *             Key1 : 1,
 *             Key2 : {
 *                 a : 2,
 *                 b : 3,
 *                 c : {
 *                     d : 3,
 *                     e : 1
 *                 }
 *             }
 *         }
 * 
 * output: {
 *          Key1: 1,
 *          Key2.a: 2,
 *          Key2.b : 3,
 *          Key2.c.d : 3,
 *          Key2.c.e : 1
 *         }
 * 
 * Important: when you concatenate keys, make sure to add the dot character between them. For instance contacting Key2, c and d the result key would be Key2.c.d.
 * 
 * Constraints:
 * �	[time limit] 5000ms
 * �	[input] Dictionary dict
 * �	[output] Dictionary
 * 
 * 
 * 
 * @author gecasti
 *
 */
public class FlattenADictionary {
	
	public static void main(String[] args) {
		HashMap<String,Object> inputDictMap = new HashMap<String,Object>();
		HashMap<String,Object> nestedDictMap = new HashMap<String,Object>();
		nestedDictMap.put("a",2);
		nestedDictMap.put("b",3);
		
		HashMap<String,Object> lastDictMap = new HashMap<String,Object>();
		lastDictMap.put("d",3);
		lastDictMap.put("e",1);
		nestedDictMap.put("c",lastDictMap);
		
		inputDictMap.put("Key2",nestedDictMap);
		inputDictMap.put("Key1",1);
		
		System.out.println(inputDictMap);
		System.out.println(flattenDictionary(inputDictMap));
	}
	
	static HashMap<String, String> flattenDictionary(HashMap<String, Object> inputDictMap) {
		// your code goes here
		HashMap<String,String> flatDictionaryMap = new HashMap<String, String>();
		flattenDictionaryHelper("", inputDictMap, flatDictionaryMap);
		
		return flatDictionaryMap;
	}
	
	/**
	 * A recursion is natural choice for this kind of problem. We iterate over the keys in dict and distinguish between two cases:
	 * If the value mapped to a key is a primitive, we take that key and simply concatenate it to the flattened key we created up to this point.
	 * We then map the resultant key to the value in the output dictionary. If the value is a dictionary, we do the same concatenation, but instead
	 * of mapping the result to the value in the output dictionary, we recurse on the value with the newly formed key.
	 * 
	 * Time Complexity: O(N), where N is the number of keys in the input dictionary. We visit every key in dictionary only once, hence the linear time complexity.
	 * Space Complexity: O(N) since the output dictionary is asymptotically as big as the input dictionary. We also store recursive calls in the execution stack
	 *                   which in the worst case scenario could be O(N), as well. The total is still O(N).
	 * 
	 * @param initialKey
	 * @param inputDictMap
	 * @param flatDictionaryMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	static void flattenDictionaryHelper(String initialKey, HashMap<String, Object> inputDictMap, HashMap<String, String> flatDictionaryMap) {
		// Iterate over the keys in the input dictionary map
		for (String key : inputDictMap.keySet()) {
			Object value = inputDictMap.get(key);
			
			if(value instanceof Integer || value instanceof Character) {
				/*
				 * Case 1:  The value is of primitive data type
				 * We take that key and simply concatenate it to the flattened key we created up to this point.
				 * We then map the resultant key to the value in the output dictionary.
				 */
				if(initialKey == null || initialKey == "")
					flatDictionaryMap.put(key, String.valueOf(value));
				else
					flatDictionaryMap.put(initialKey + "." + key, String.valueOf(value));
			} else {
				/*
				 * Case 2:  The value is a dictionary, we do the same concatenation, but instead of mapping the
				 * result to the value in the output dictionary, we recurse on the value with the newly formed key.
				 */
				if(initialKey == null || initialKey == "")
					flattenDictionaryHelper(key, (HashMap<String, Object>) value, flatDictionaryMap);
				else
					flattenDictionaryHelper(initialKey + "." + key, (HashMap<String, Object>) value, flatDictionaryMap);
			}
		}
	}
}