package seatOrganiser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;

@SuppressWarnings("unused")
public class Arranger {


	public static void main(String[] args) throws IOException {
    	ArrayList<ArrayList<HSSFCell>> firstShowStudents = Sorter.getSheetData("Filemaker.xls", 2, false, false, false, false);
    	
    	firstShowStudents = sortByTeacher(firstShowStudents);
    	    	
		ArrayList<ArrayList<HSSFCell>> secondShowStudents = new ArrayList<ArrayList<HSSFCell>>();
		
		breakIfTwo(firstShowStudents, secondShowStudents);
		
		firstShowStudents = newTogether(firstShowStudents);
		
		secondShowStudents = newTogether(secondShowStudents);
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<ArrayList<HSSFCell>> sortByTeacher(ArrayList<ArrayList<HSSFCell>> sheetData) {
		ColumnComparator cc = new ColumnComparator(1);
    	Collections.sort(sheetData, cc);
    	cc.setColumn(4);
    	Collections.sort(sheetData, cc);
    	return sheetData;
	}
	
	public static boolean isInteger(String string) {
	    try {
	        Integer.valueOf(string);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public static void breakIfTwo(ArrayList<ArrayList<HSSFCell>> firstShowStudents, ArrayList<ArrayList<HSSFCell>> secondShowStudents) {
		ArrayList<ArrayList<HSSFCell>> temporary = new ArrayList<ArrayList<HSSFCell>>();
		boolean multipleNeeded = Sorter.multipleShowsNeeded(firstShowStudents);
		if (multipleNeeded) {
			int i = firstShowStudents.size()/2;
			while (firstShowStudents.get(i) == firstShowStudents.get(i-1)) {
				i++;
			}
			for (i = i + 0; i <= firstShowStudents.size() - 1; i++) {
				secondShowStudents.add(firstShowStudents.get(i));
			}
			
			i = firstShowStudents.size()/2;
			while (firstShowStudents.get(i) == firstShowStudents.get(i-1)) {
				i++;
			}
			for (i = i - 1; i >= 0; i--) {
				temporary.add(firstShowStudents.get(i));
			}
			firstShowStudents.clear();
			firstShowStudents.addAll(temporary);
		}
	}
	
	public static ArrayList<ArrayList<HSSFCell>> newTogether(ArrayList<ArrayList<HSSFCell>> sheetData) {
		
		ArrayList<ArrayList<HSSFCell>> temporary = new ArrayList<ArrayList<HSSFCell>>();
		ArrayList<ArrayList<HSSFCell>> otherTemporary = new ArrayList<ArrayList<HSSFCell>>();
		
		for(int i = sheetData.size()-1; i >= 0; i--) {
			ArrayList<HSSFCell> list = sheetData.get(i);
			if (isInteger(list.get(3).getStringCellValue())) {
				if(Integer.parseInt(list.get(3).getStringCellValue()) > 100) {
					otherTemporary.add(list);
					sheetData.remove(i);
					i--;
				}
			}
		}
		
		for(int i = 0; i < otherTemporary.size(); i++) {
			ArrayList<HSSFCell> list = otherTemporary.get(i);
			temporary.add(list);
		}
		
		for(int i = 0; i < sheetData.size(); i++) {
			ArrayList<HSSFCell> list = sheetData.get(i);
			if (isInteger(list.get(3).getStringCellValue())) {
				if(Integer.parseInt(list.get(3).getStringCellValue()) > 100) {
					sheetData.remove(i);
					i--;
				}
			}
		}
		for(int i = 0; i < sheetData.size(); i++) {
			ArrayList<HSSFCell> list = sheetData.get(i);
			temporary.add(list);
		}
		
		return temporary;
	}
}
