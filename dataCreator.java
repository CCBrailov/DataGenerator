import java.util.Random;
import java.io.File;
import java.io.FileOutputStream;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataCreator {
    
    public static int sevenPointRating(int wght1, int wght2, int wght3, int wght4, int wght5, int wght6) {
        Random rand = new Random();
        int myInt = rand.nextInt(100);
        int rating = 0;

        if (myInt <= wght1) {
            rating = 1;
        }
        else if (myInt <= wght2) {
            rating = 2;
        }
        else if (myInt <= wght3) {
            rating = 3;
        }
        else if (myInt <= wght4) {
            rating = 4;
        }
        else if (myInt <= wght5) {
            rating = 5;
        }
        else if (myInt <= wght6) {
            rating = 6;
        }
        else if (myInt <= 100) {
            rating = 7;
        }

        return rating;

    }

    public static boolean trueOrFalse(int wght) {
        Random rand = new Random();
        int myInt = rand.nextInt(100);
        boolean trueOrFalse = false;

        if (myInt <= wght) {
            trueOrFalse = true;
        }
        else if (myInt <= 100) {
            trueOrFalse = false;
        }

        return trueOrFalse;

    }

    public static int diceRoll(int numSides, int numDice, int mod) {
        Random rand = new Random();
        int myInt;
        int result = 0;
        int i;

        for (i = 0; i < numDice; ++i) {
            myInt = rand.nextInt(numSides) + 1;
            result += myInt;
        }

        result += mod;
        return result;
    }

    public static int diceRoll(int numSides, int numDice) {
        Random rand = new Random();
        int myInt;
        int result = 0;
        int i;

        for (i = 0; i < numDice; ++i) {
            myInt = rand.nextInt(numSides) + 1;
            result += myInt;
        }

        return result;
    }

    public static int rateStimulation(int groupID) {
        
        int rating = 0;
        
        switch (groupID) {
            case 1:
                rating = sevenPointRating(10, 25, 40, 60, 75, 90);
                break;
            case 2:
                rating = sevenPointRating(10, 20, 35, 50, 70, 85);
                break;
            case 3:
                rating = sevenPointRating(5, 13, 25, 37, 55, 80);
                break;
        }
        
        return rating;
    }

    public static int rateSatisfaction(int groupID) {

        int rating = 0;
        
        // Change These Parameters
        
        switch (groupID) {
            case 1:
                rating = sevenPointRating(10, 20, 35, 50, 70, 85);
                break;
            case 2:
                rating = sevenPointRating(10, 25, 40, 60, 75, 90);
                break;
            case 3:
                rating = sevenPointRating(5, 13, 25, 37, 55, 80);
                break;
            
            
        }
        
        return rating;
    }

    public static int rateThoughtAboutPairs(int groupID) {

        int rating = 0;
        
        // Change These Parameters
        
        switch (groupID) {
            case 1:
                rating = sevenPointRating(5, 13, 25, 37, 55, 80);
                break;
            case 2:
                rating = sevenPointRating(10, 25, 40, 60, 75, 90);
                break;
            case 3:
                rating = sevenPointRating(10, 20, 35, 50, 70, 85);
                break;
        }
        
        return rating;
    }

    public static int rateRehearsedPairs(int groupID) {

        int rating = 0;
        
        // Change These Parameters
        // Case 1 & 2 use same distribution

        switch (groupID) {
            case 1:
                rating = sevenPointRating(5, 13, 25, 37, 55, 80);
                break;
            case 2:
                rating = sevenPointRating(10, 25, 40, 60, 75, 90);
                break;
            case 3:
                rating = sevenPointRating(10, 20, 35, 50, 70, 85);
                break;
        }
        
        return rating;
    }

    
    public static boolean fellAsleep(int groupID) {
        
        boolean slept = false;
        
        // Change These Parameters
        
        switch (groupID) {
            case 1:
                slept = trueOrFalse(2);
                break;
            case 2:
                slept = trueOrFalse(2);
                break;
            case 3:
                slept = trueOrFalse(2);
                break;
        }
        
        return slept;
    }

    public static int recallImmediate(int groupID) {
        
        int recallNum = 20;

        switch (groupID) {
            case 1:
            case 2:
            case 3:
                recallNum -= diceRoll(4, 1, -1) / 2;
                break;
        }

        return recallNum;

    }

    public static int recall8Minutes(int groupID) {

        //Almost 100% for Case 1
        //Down to 90% for Case 2

        int recallNum = 20;

        switch (groupID) {
            case 1:
                recallNum -= diceRoll(5, 1, -1) / 2;
                break;
            case 2:
                recallNum -= diceRoll(5, 1, -1);
               break;
            case 3:
                recallNum -= diceRoll(5, 1, -1) / 2;
                break;
        }
        
        return recallNum;
            
    }

    public static int recall24Hours(int groupID) {

        int recallNum = 20;

        switch (groupID) {
            case 1:
                recallNum -= diceRoll(7, 1, -1) / 2;
                break;
            case 2:
                recallNum -= diceRoll(7, 1, -1);
               break;
            case 3:
                recallNum -= diceRoll(4, 1, -1);
                break;
        }

        return recallNum;

    }

    public static void main(String[] args) throws Exception {
    
        int i;

        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
      
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet( " Data ");

        //Create row object
        XSSFRow row;

        //This data needs to be written (Object[])
        Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();

        empinfo.put( "1", new Object[] { //Headers
            "Group",
            "Stimulation Rating",
            "Satisfaction Rating", 
            "Thought About Pairs",
            "Rehearsed Pairs",
            "Fell Asleep", 
            "Immediate Recall",
            "8-Minute Recall",
            "24-Hour Recall"});
      
        for (i = 2; i < 101; ++i) { //Group 1 (Wakeful Rest)
            empinfo.put(String.valueOf(i), new Object[] {
                "Wakeful Rest",
                String.valueOf(rateStimulation(1)),
                String.valueOf(rateSatisfaction(1)), 
                String.valueOf(rateThoughtAboutPairs(1)),
                String.valueOf(rateRehearsedPairs(1)), 
                String.valueOf(fellAsleep(1)),
                String.valueOf(recallImmediate(1)),
                String.valueOf(recall8Minutes(1)),
                String.valueOf(recall24Hours(1))});
        }

        for (i = 102; i < 201; ++i) { //Group 2 (Social Media)
            empinfo.put(String.valueOf(i), new Object[] {
                "Social Media", String.valueOf(rateStimulation(2)), String.valueOf(rateSatisfaction(2)), 
                String.valueOf(rateThoughtAboutPairs(2)), String.valueOf(rateRehearsedPairs(2)), 
                String.valueOf(fellAsleep(2)), String.valueOf(recallImmediate(2)), String.valueOf(recall8Minutes(2)),
                String.valueOf(recall24Hours(2))});
        }

        for (i = 202; i < 301; ++i) { //Group 3 (Music)
            empinfo.put(String.valueOf(i), new Object[] {
                "Music", String.valueOf(rateStimulation(3)), String.valueOf(rateSatisfaction(3)), 
                String.valueOf(rateThoughtAboutPairs(3)), String.valueOf(rateRehearsedPairs(3)), 
                String.valueOf(fellAsleep(3)), String.valueOf(recallImmediate(3)), String.valueOf(recall8Minutes(3)),
                String.valueOf(recall24Hours(3))});
        }

        //Iterate over data and write to sheet
        Set < String > keyid = empinfo.keySet();
        int rowid = 0;
      
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = empinfo.get(key);
            int cellid = 0;
         
            for (Object obj : objectArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(
            new File("C:/Users/Charles/Documents/Group Project/DataSheet.xlsx"));
      
        workbook.write(out);
        out.close();
        System.out.println("DataSheet.xlsx written successfully");

    }

}