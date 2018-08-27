/**
This program will take file as input and parse it into csv file
*/
import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.charset.*;
class GenerateCSVFromFile {
	private static final String USER_PATH = System.getProperty("user.home");
	private static final String FILE_HEADER = "item,lt,rt,forma,data item (unit) ";
	private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String USER_DIRECTORY = System.getProperty("user.home");
	private static final String FILE_PATH = USER_PATH+"/Downloads/jdsroom/testFile.txt";
    private static final String CSV_PATH = USER_PATH+"/Downloads/jdsroom/testCSV.csv";

	
    public static void fileToCSV(String filePath,String csvPath){
	  FileWriter fileWriter = null;
	  List<String> l = readFileInList(filePath);
       Iterator<String> itr = l.iterator();
    try {
            fileWriter = new FileWriter(csvPath);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            String st=null;
           while (itr.hasNext()){
                  st = format(itr.next());
                fileWriter.append(st);
                fileWriter.append(NEW_LINE_SEPARATOR);
				}
			} catch (Exception e) {

            System.out.println("Error in CsvFileWriter !!!");

            e.printStackTrace();

        } finally {
			try {
                fileWriter.flush();
                fileWriter.close();

            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
	}
	}

	private static List<String> readFileInList(String fileName){
    List<String> buffer = Collections.emptyList();
    try{
      buffer =Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);}
    catch (IOException e) {
      // do something
      e.printStackTrace();  }
    return buffer;
  }

	private static String format(String format){
		StringBuffer sb=new StringBuffer();
		//generate the StringTokenizer by removing all braces from given data
		StringTokenizer st = new StringTokenizer(format.replaceAll("[\\p{Ps}\\p{Pe}]", ""));
		int i=0;
		 while (st.hasMoreTokens()) {
			 if(i!=0)
				 sb.append(COMMA_DELIMITER);
			 sb.append(st.nextToken());
			 i++;
		 }
		 return sb.toString();
		}
	public static void main(String[] args) 
	{
		String filePath=USER_PATH+"\\Pictures\\jds\\testData.txt";
		//call parse method which will generate the csv file in the mentioned location
		try{
		fileToCSV(filePath,CSV_PATH);
		System.out.println("csv file is successfully generated...please check the csv file location");		}
		catch(Exception e){
		System.out.println("parsing process was un successful");
		}
	}
}
