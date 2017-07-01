package com.ccc.arrays.mvc;

public class ArrayStructureMVC {

	public static void main(String[] args) {
		ArrayStructureView theView = new ArrayStructureView();
		ArrayStructureModel theModel = new ArrayStructureModel();
		ArrayStructureController theController = new ArrayStructureController(theView, theModel);
		theView.setVisible(true);
	}
}