package com.ccc.playground.openhash;

import java.util.Scanner;

class WordList {
	// Reference to first Link in list
	// The last link added to the Linked List
	public Word firstWord = null;
	
	public void insert(Word wordToInsert, int hashKey) {
		Word previous = null;
		Word current = firstWord;
		
		wordToInsert.key = hashKey;
		
		while(current != null && wordToInsert.key > current.key) {
			previous = current;
			current = current.next;
		}
		
		if(previous == null) {
			firstWord = wordToInsert;
		} else {
			previous.next = wordToInsert;
		}
		
		wordToInsert.next = current;
	}
	
	public Word find(int hashKey, String wordToFind) {
		Word current = firstWord;
		
		/*
		 * Search for key, but stop searching if the hashKey < what we are searching for.
		 * Because, the list is sorted, this allows us to avoid searching the whole list.
		 */
		while(current != null && current.key <= hashKey) {
			if(current.theWord.equals(wordToFind)) {
				return current;
			}
			
			current = current.next;
		}
		
		return null;
	}
	
	public void displayWordList() {
		Word current = firstWord;
		
		while(current != null) {
			System.out.println(current);
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Make a 11 item array that will hold words and definitions
		
	}
}