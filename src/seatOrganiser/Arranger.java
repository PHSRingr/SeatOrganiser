package seatOrganiser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class Arranger {
	
	@SuppressWarnings("unchecked")
	public static ArrayList<ArrayList<HSSFCell>> sortByTeacher(ArrayList<ArrayList<HSSFCell>> sheetData) {
		ColumnComparator cc = new ColumnComparator(1);
    	Collections.sort(sheetData, cc);
    	cc.setColumn(4);
    	Collections.sort(sheetData, cc);
    	return sheetData;
	}
	
	public static ArrayList<ArrayList<HSSFCell>> addTeachers(ArrayList<ArrayList<HSSFCell>> sheetData) {
		boolean sketchy = false;
		for(int i = 0; i <= sheetData.size()-1; i++) {
			ArrayList<HSSFCell> list = sheetData.get(i);
			if (i != sheetData.size() - 1 && list.get(4).getStringCellValue() != sheetData.get(i+1).get(4).getStringCellValue() && !sketchy) {sheetData.add(i, list); sketchy = true;}
			else sketchy = false;
		}
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
				if(Integer.parseInt(list.get(3).getStringCellValue()) > 100 || Integer.parseInt(list.get(3).getStringCellValue()) < 12) {
					otherTemporary.add(list);
					sheetData.remove(i);
				}
			}
		}
		
		for(int i = 0; i < otherTemporary.size(); i++) {
			ArrayList<HSSFCell> list = otherTemporary.get(i);
			temporary.add(list);
		}
		
		for(int i = 0; i < sheetData.size(); i++) {
			ArrayList<HSSFCell> list = sheetData.get(i);
			temporary.add(list);
		}
		
		return temporary;
	}
	
	public static ArrayList<ArrayList<HSSFCell>> loudToBack(ArrayList<ArrayList<HSSFCell>> sheetData, List<String> items) {
		ArrayList<ArrayList<HSSFCell>> temporary = new ArrayList<ArrayList<HSSFCell>>();
		for (int i = items.size() - 1; i >= 0; i--) {
			for (int j = sheetData.size() - 1; j >= 0; j--) {
				ArrayList<HSSFCell> list = sheetData.get(j);
				if (list.get(4).getRichStringCellValue().getString().trim().equals(items.get(i))) {
					temporary.add(list);
					sheetData.remove(j);
				}
			}
		}
		ArrayList<ArrayList<HSSFCell>> merged = new ArrayList<ArrayList<HSSFCell>>(sheetData);
		merged.addAll(temporary);
		Sorter.printSheetData(temporary);
		return merged;
	}
}

