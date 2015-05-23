package seatOrganiser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.apache.poi.hssf.usermodel.HSSFCell;

@SuppressWarnings("unused")
public class Arranger {

	public static void main(String[] args) throws IOException {
    	ArrayList<ArrayList<HSSFCell>> firstShowStudents = Sorter.getSheetData("Filemaker.xls");
		ArrayList<ArrayList<HSSFCell>> secondShowStudents = new ArrayList<ArrayList<HSSFCell>>();
		boolean multipleNeeded = Sorter.multipleShowsNeeded(firstShowStudents);
		breakIfTwo(firstShowStudents, multipleNeeded);
	}
	
	public static void breakIfTwo(ArrayList<ArrayList<HSSFCell>> firstShowStudents, boolean multipleNeeded) {
		
		ArrayList<ArrayList<HSSFCell>> temp;
		ArrayList<HSSFCell> list;
		list = firstShowStudents.get(0);
		ArrayList<String> temporary = new ArrayList<String>();
		temporary.add(list.get(4).getStringCellValue());
				
		for (int i = 1; i < firstShowStudents.size(); i++) {
			list = firstShowStudents.get(i);
			temporary.add(list.get(4).getStringCellValue());
        }
		
		Collections.sort(temporary);
				
		if(multipleNeeded) {
			for (int i = 0; i < firstShowStudents.size(); i++) {
				list = firstShowStudents.get(i);
				if() {
					
				}
				temporary.add(list.get(4).getStringCellValue());
	       }
		}
	}
}
