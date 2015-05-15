package seatOrganiser;

import java.io.FileInputStream;

public class Sorter {
	
	public static ArrayList<ArrayList<HSSFCell>> getSheetData(String filename) throws IOException {
    	
        // Make an ArrayList to store data

		ArrayList<ArrayList<HSSFCell>> sheetData = new ArrayList<ArrayList<HSSFCell>>();

        FileInputStream fis = null;
        try {

            fis = new FileInputStream(filename);
            
            // Create an excel workbook
            
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            
            // Call first sheet (Orrence may have more data)
            
            HSSFSheet sheet = workbook.getSheetAt(0);

            // Iteration for readability
            
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                ArrayList<HSSFCell> data = new ArrayList<HSSFCell>();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }

                sheetData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return sheetData;
    }

    private static void printSheetData(ArrayList sheetData) {
        
        // Iterates the data and prints it out to the console.
        
        for (int i = 0; i < sheetData.size(); i++) {
        	ArrayList list = (ArrayList) sheetData.get(i);
            for (int j = 0; j < list.size(); j++) {
                HSSFCell cell = (HSSFCell) list.get(j);
                System.out.print(cell.getRichStringCellValue().getString());
                if (j < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }
	
	public static void main(String args[]) throws Exception {
		
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
		
		ArrayList<ArrayList<HSSFCell>> sheetExampleData = getSheetData("Filemaker.xls");
		//printSheetData(sheetExampleData);
		
		eliminate(sheetExampleData,false,true,false,false,1);
		printSheetData(sheetExampleData);
	}
		
	public static void eliminate(ArrayList<ArrayList<HSSFCell>> sheetData, boolean freshmenIn, boolean sophomoresIn, boolean juniorsIn, boolean seniorsIn, int period) {
		for (int i = sheetData.size() - 1; i >= 0; i--) {
			
        	ArrayList<HSSFCell> list = (ArrayList<HSSFCell>) sheetData.get(i);
        	
            for (int j = list.size() - 1; j >= 0; j--) {
            	int temp = 0;
                if (j == 2 || j == 1) temp = Integer.parseInt(list.get(j).getStringCellValue());
                if (j == 2 && temp != period) sheetData.remove(i);
                if (j == 1) {
                	if (!freshmenIn && temp == 9) sheetData.remove(i);
                	if (!sophomoresIn && temp == 10) sheetData.remove(i);
                	if (!juniorsIn && temp == 11) sheetData.remove(i);
                	if (!seniorsIn && temp == 12) sheetData.remove(i);
                }
                //if (list.get(j).getCellType() == Cell.CELL_TYPE_NUMERIC) System.out.println(Integer.parseInt(list.get(j).getStringCellValue()));
            }

        }
	}
	
	public static boolean multipleShowsNeeded(ArrayList sheetData) {
		if (sheetData.size() > 629) {
        	return true;
        }
		return false;
	}
	
	public static boolean openBackDoors(ArrayList sheetData, boolean multipleShowsNeeded) {
		if (multipleShowsNeeded == true) {
			if (sheetData.size() / 2 > 456) {
	        	return true;
	        }
		}
		if (multipleShowsNeeded == false) {
			if (sheetData.size() > 456) {
	        	return true;
	        }
		}
		return false;
	}
}
