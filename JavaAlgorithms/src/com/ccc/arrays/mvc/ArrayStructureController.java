package com.ccc.arrays.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrayStructureController {
	private ArrayStructureView theView;
	private ArrayStructureModel theModel;

	public ArrayStructureController(ArrayStructureView theView, ArrayStructureModel theModel){

		this.theView = theView;
		this.theModel = theModel;

		theModel.generateRandomArray();

		// Add button listeners

		this.theView.addInsertButtonListener(new InsertButtonListener());
		this.theView.addDeleteButtonListener(new DeleteButtonListener());
		this.theView.addFindButtonListener(new FindButtonListener());
		this.theView.addSortButtonListener(new SortButtonListener());

		// Put random array data in the table model

		theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());

	}

	// ActionListener for the Insert Button

	class InsertButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {


			try{

				theModel.insertValue(theView.getTheValue());

				// Take the array data from the model & move it to the JTable

				theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());

			}

			catch(NumberFormatException ex){

				theView.sendMessageToUser("You Need a Value in the Value Box");

			}

		}

	}

	// ActionListener for the Insert Button

	class DeleteButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {

			try{

				theModel.deleteIndex(theView.getTheIndex());

				theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());

			}

			catch(NumberFormatException ex){

				theView.sendMessageToUser("You Need a Index in the Index Box");

			}

		}

	}

	// ActionListener for the Find Button

	class FindButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {

			String indexWithValue = "";

			try{

				if(theView.linearSearchRadioButton.isSelected()){

					indexWithValue = theModel.linearSearchForValue(theView.getTheValue());

				}

				theView.sendMessageToUser("Found in Index: " + indexWithValue);

			}

			catch(NumberFormatException ex){

				theView.sendMessageToUser("You Need a Value in the Value Box");

			}

		}

	}

	// ActionListener for the Sort Button

	class SortButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {

			try{

				if(theView.ascendingRadioButton.isSelected()){

					theModel.bubbleSort();

				} else {

					theModel.bubbleSortDescending();

				}

				theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());

			} catch(NumberFormatException ex) {
				theView.sendMessageToUser("Something Went Wrong");
			}	
		}	
	}
}
