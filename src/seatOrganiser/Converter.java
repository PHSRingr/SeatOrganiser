package seatOrganiser;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * Converter takes a sorted database (from Sorter and Arranger) and essentially converts it a nicer
 * 3D Array, which can be output like the auditorium and is much easier to work with and comprehend.
 */
public class Converter {
	
	public static String toStr( String[][] array3d) {
	    String s = "";
	    for (int row=0; row < array3d.length ; row++) {
	      s += Arrays.toString(array3d[row]) + "\n";
	    }
	    return s;
	}
	
	//takes the repeated outputs from the below methods and merges repeated elements, essentially cleaning it up.
	public static String[][][] cleanUp(String[][][] array) {
		for (int f = 0; f < array.length; f++) {
			for (int g = 0; g < array[f].length; g++) {
		        ArrayList<String> tmp  = new ArrayList<String>();
		        for (int h = 0; h < array[f][g].length; h++) {
		        	if (array[f][g][h]!=null){
		            int count = 1;
		            while(h + count < array[f][g].length && array[f][g][h].equals(array[f][g][h+count])) 
		            	count++;
		            tmp.add(array[f][g][h] + "(" + count + ")");
		            h += count - 1; //Update h to skip identical element
		        	}
		        } array[f][g] = tmp.toArray(new String[tmp.size()]);
			}
		}
		return array;
	}
	
	//This method makes it so that smaller shows are closer to the front
	public static String[][][] displayShortNicely(ArrayList<ArrayList<HSSFCell>> sheetData) {
		String[][] left = new String[14][];
		left[0] = new String[7];
		left[1] = new String[8];
		left[2] = new String[8];
		left[3] = new String[9];
		left[4] = new String[10];
		left[5] = new String[8];
		left[6] = new String[11];
		left[7] = new String[12];
		left[8] = new String[12];
		left[9] = new String[13];
		left[10] = new String[14];
		left[11] = new String[14];
		left[12] = new String[14];
		left[13] = new String[14];
		
		String[][] middle = new String[14][];
		middle[0] = new String[9];
		middle[1] = new String[10];
		middle[2] = new String[10];
		middle[3] = new String[10];
		middle[4] = new String[11];
		middle[5] = new String[9];
		middle[6] = new String[12];
		middle[7] = new String[12];
		middle[8] = new String[12];
		middle[9] = new String[13];
		middle[10] = new String[14];
		middle[11] = new String[14];
		middle[12] = new String[14];
		middle[13] = new String[14];
		
		String[][] right = new String[14][];
		right[0] = new String[7];
		right[1] = new String[8];
		right[2] = new String[8];
		right[3] = new String[9];
		right[4] = new String[10];
		right[5] = new String[10];
		right[6] = new String[11];
		right[7] = new String[12];
		right[8] = new String[12];
		right[9] = new String[13];
		right[10] = new String[14];
		right[11] = new String[8];
		right[12] = new String[8];
		right[13] = new String[8];
		
		String[][][] niceOutput = new String[3][][];
		niceOutput[0] = left;
		niceOutput[1] = middle;
		niceOutput[2] = right;
		
		int leftRow;
		int middleRow;
		int rightRow;
		// set how far we are into the left row
		if (sheetData.size()/3 < 7) leftRow = 1;
		else if (sheetData.size()/3 < 15) leftRow = 2;
		else if (sheetData.size()/3 < 23) leftRow = 3;
		else if (sheetData.size()/3 < 32) leftRow = 4;
		else if (sheetData.size()/3 < 42) leftRow = 5;
		else if (sheetData.size()/3 < 50) leftRow = 6;
		else if (sheetData.size()/3 < 61) leftRow = 7;
		else if (sheetData.size()/3 < 73) leftRow = 8;
		else if (sheetData.size()/3 < 85) leftRow = 9;
		else if (sheetData.size()/3 < 98) leftRow = 10;
		else if (sheetData.size()/3 < 112) leftRow = 11;
		else if (sheetData.size()/3 < 126) leftRow = 12;
		else if (sheetData.size()/3 < 140) leftRow = 13;
		else leftRow = 14;
		// centre row
		if (sheetData.size()/3 < 9) middleRow = 1;
		else if (sheetData.size()/3 < 19) middleRow = 2;
		else if (sheetData.size()/3 < 29) middleRow = 3;
		else if (sheetData.size()/3 < 39) middleRow = 4;
		else if (sheetData.size()/3 < 50) middleRow = 5;
		else if (sheetData.size()/3 < 59) middleRow = 6;
		else if (sheetData.size()/3 < 71) middleRow = 7;
		else if (sheetData.size()/3 < 83) middleRow = 8;
		else if (sheetData.size()/3 < 95) middleRow = 9;
		else if (sheetData.size()/3 < 108) middleRow = 10;
		else if (sheetData.size()/3 < 122) middleRow = 11;
		else if (sheetData.size()/3 < 136) middleRow = 12;
		else if (sheetData.size()/3 < 150) middleRow = 13;
		else middleRow = 14;
		// right row
		if (sheetData.size()/3 < 7) rightRow = 1;
		else if (sheetData.size()/3 < 15) rightRow = 2;
		else if (sheetData.size()/3 < 23) rightRow = 3;
		else if (sheetData.size()/3 < 32) rightRow = 4;
		else if (sheetData.size()/3 < 42) rightRow = 5;
		else if (sheetData.size()/3 < 52) rightRow = 6;
		else if (sheetData.size()/3 < 63) rightRow = 7;
		else if (sheetData.size()/3 < 75) rightRow = 8;
		else if (sheetData.size()/3 < 87) rightRow = 9;
		else if (sheetData.size()/3 < 100) rightRow = 10;
		else if (sheetData.size()/3 < 114) rightRow = 11;
		else if (sheetData.size()/3 < 122) rightRow = 12;
		else if (sheetData.size()/3 < 130) rightRow = 13;
		else rightRow = 14;
		double[] news = {leftRow, middleRow, rightRow};
		
		int i = 0;
		boolean flag = false;
		for (int f = 0; f < niceOutput.length; f++) {
			for (int g = 0; g < news[f]; g++) {
				for (int h = 0; h < niceOutput[f][g].length; h++) {
					try{
					ArrayList<HSSFCell> list = sheetData.get(i);
					String name = "none";
					name = list.get(4).getStringCellValue();
					niceOutput[f][g][h] = name;
					if (i < sheetData.size() - 1) i++;
					else if (i == sheetData.size() - 1 && !flag) {niceOutput[f][g][h] = name; flag = true;}
					else niceOutput[f][g][h] = null;}
					catch(Exception e){}
				}
			}
		}
		
		return niceOutput;
		
	}
	
	//this works for the larger shows
	public static String[][][] displayNicely(ArrayList<ArrayList<HSSFCell>> sheetData) {
		String[][] room64 = new String[8][];
		room64[0] = new String[9];
		room64[1] = new String[8];
		room64[2] = new String[13];
		room64[3] = new String[13];
		room64[4] = new String[12];
		room64[5] = new String[11];
		room64[6] = new String[11];
		room64[7] = new String[11];

		String[][] room63 = new String[7][];
		room63[0] = new String[15];
		room63[1] = new String[15];
		room63[2] = new String[15];
		room63[3] = new String[15];
		room63[4] = new String[10];
		room63[5] = new String[10];
		room63[6] = new String[5];
		
		String[][] left = new String[14][];
		left[0] = new String[7];
		left[1] = new String[8];
		left[2] = new String[8];
		left[3] = new String[9];
		left[4] = new String[10];
		left[5] = new String[8];
		left[6] = new String[11];
		left[7] = new String[12];
		left[8] = new String[12];
		left[9] = new String[13];
		left[10] = new String[14];
		left[11] = new String[14];
		left[12] = new String[14];
		left[13] = new String[14];
		
		String[][] middle = new String[14][];
		middle[0] = new String[9];
		middle[1] = new String[10];
		middle[2] = new String[10];
		middle[3] = new String[10];
		middle[4] = new String[11];
		middle[5] = new String[9];
		middle[6] = new String[12];
		middle[7] = new String[12];
		middle[8] = new String[12];
		middle[9] = new String[13];
		middle[10] = new String[14];
		middle[11] = new String[14];
		middle[12] = new String[14];
		middle[13] = new String[14];
		
		String[][] right = new String[14][];
		right[0] = new String[7];
		right[1] = new String[8];
		right[2] = new String[8];
		right[3] = new String[9];
		right[4] = new String[10];
		right[5] = new String[10];
		right[6] = new String[11];
		right[7] = new String[12];
		right[8] = new String[12];
		right[9] = new String[13];
		right[10] = new String[14];
		right[11] = new String[8];
		right[12] = new String[8];
		right[13] = new String[8];
		
		String[][][] niceOutput = new String[3][][];
		niceOutput[0] = left;
		niceOutput[1] = middle;
		niceOutput[2] = right;
		
		if (Sorter.openBackDoors(sheetData)) {
			niceOutput = new String[5][][];
			niceOutput[0] = left;
			niceOutput[1] = room64;
			niceOutput[2] = middle;
			niceOutput[3] = right;
			niceOutput[4] = room63;
		}
		int i = 0;
		boolean flag = false;
		for (int f = 0; f < niceOutput.length; f++) {
			for (int g = 0; g < niceOutput[f].length; g++) {
				for (int h = 0; h < niceOutput[f][g].length; h++) {
					ArrayList<HSSFCell> list = sheetData.get(i);
					String name = "none";
					name = list.get(4).getStringCellValue();
					niceOutput[f][g][h] = name;
					if (i < sheetData.size() - 1) i++;
					else if (i == sheetData.size() - 1 && !flag) {niceOutput[f][g][h] = name; flag = true;}
					else niceOutput[f][g][h] = null;
				}
			}
		}
		
		return niceOutput;
		
	}

}
