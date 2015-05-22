package seatOrganiser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class Arranger {

	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<HSSFCell>> firstShowStudents = Sorter.getSheetData("Filemaker.xls");
		//ArrayList<ArrayList<HSSFCell>> secondShowStudents = null;
		boolean multipleNeeded = Sorter.multipleShowsNeeded(firstShowStudents);
		breakIfTwo(firstShowStudents, multipleNeeded);
	}
	
	public static void breakIfTwo(ArrayList<ArrayList<HSSFCell>> firstShowStudents, boolean multipleNeeded) {
		
		ArrayList<ArrayList<HSSFCell>> temporary;
		ArrayList<HSSFCell> list;
		list = firstShowStudents.get(0);
		ArrayList<String> tempo = new ArrayList<String>(Arrays.asList(list.get(4).getStringCellValue()));
		
		for (int i = 1; i <= firstShowStudents.size()-1; i++) {
			list = firstShowStudents.get(i);
			tempo.add(list.get(4).getStringCellValue());
        }
		Collections.sort(tempo);
		if(multipleNeeded) {
			for (int i = 0; i < firstShowStudents.size(); i++) {
				list = firstShowStudents.get(i);
				tempo.add(list.get(4).getStringCellValue());
	        }
		}
		
	}
}
