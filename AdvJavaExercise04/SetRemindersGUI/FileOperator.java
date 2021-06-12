import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileOperator {

    /*
    This class is to read from files and write to files
     */

    private static String exportFileName;
    private static String importFileName;
    private static final String REMINDER_BORDER_START = "-!@ ";
    private static final String REMINDER_BORDER_END = " @!-";

    private static String FILE_SUFFIX = ".txt";
//----------------------------------------------------------------------------------------------------------------------
    // Creates a new file, the user is picking a name
    // checks if file name is already exist, if it does, msg is showing up

    public static boolean createExportFile(){

        boolean alreadyExist = false;
        exportFileName = JOptionPane.showInputDialog("Export file name","");


        try {
            File fo = new File(exportFileName + FILE_SUFFIX);
            alreadyExist = fo.createNewFile();
            if(!alreadyExist){
                fileAlreadyExistMessage();
            }
        }
        catch (IOException e){
            System.out.println("EXCEPTION! file could not be opened");
        }
        return alreadyExist;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Imports data from a file, generate a new HashMap with the dates and reminders from the file
    // If file does not exist, popping up a msg

    public static HashMap<Date,String> importFromAFile(){
        importFileName = JOptionPane.showInputDialog("Import file name" , "");
        HashMap<Date, String> newHmDateReminders = new HashMap<Date,String>();

        try{
            Scanner scan = new Scanner(new File(importFileName+FILE_SUFFIX));
            while (scan.hasNextLine() ){
                String remidnerToAdd = "";
                String dateLine = scan.nextLine(); // gets the date
                String[] dateSpecifics = dateLine.split(" ");
                Date dateToAdd = new Date(Integer.parseInt(dateSpecifics[0]),Integer.parseInt(dateSpecifics[1]),Integer.parseInt(dateSpecifics[2]));

                while(scan.hasNextLine()){ // gets the reminder and cut the borders parts
                    remidnerToAdd += scan.nextLine() + '\n';
                    if(remidnerToAdd.contains(REMINDER_BORDER_END)){
                        break;
                    }
                }
                String replace = remidnerToAdd.replace(REMINDER_BORDER_START, "");
                replace = replace.replace(REMINDER_BORDER_END,"");

                newHmDateReminders.put(dateToAdd, replace);
            }
            scan.close();

        }
        catch (IOException e){ // if there was an error with opening the file
            fileNotExistMessage();
            newHmDateReminders = null;
            System.out.println("EXCEPTION! file could not be opened");
        }
        return newHmDateReminders;
    }
//----------------------------------------------------------------------------------------------------------------------
    // After a file was created, updates it with dates and reminders from the HashMap data structure

    public static void insertRemindersToFile(ArrayList<Date> date , ArrayList<String> rem){
        try{
            try{
                FileWriter myWriter = new FileWriter(exportFileName+FILE_SUFFIX);
                int i = 0 ;

                while(i < date.size()){
                    String fullDate = date.get(i).toString();
                    String reminder = REMINDER_BORDER_START + rem.get(i++) + REMINDER_BORDER_END +'\n';
                    myWriter.append(fullDate+reminder);
                }

                myWriter.close();
            }
            catch (IOException  e){
                fileNotExistMessage();
                System.out.println("EXCEPTION! file could not be opened");
            }
        }
        catch (NullPointerException e){
            System.out.println("EXCEPTION! date object is corrupted!");
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Pops up an information msg, file is already exist

    private static void fileAlreadyExistMessage(){
        Object[] options = {"OK!"};
        JOptionPane.showOptionDialog(null,
                "File is already exist!","File Error",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
    }
//----------------------------------------------------------------------------------------------------------------------
    //    // Pops up an information msg, file is not exist

    private static void fileNotExistMessage(){
    Object[] options = {"OK!"};
    JOptionPane.showOptionDialog(null,
            "File is not exist!","File Error",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]);

}
//----------------------------------------------------------------------------------------------------------------------
}
