import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class GenerateAndCompileSourceCodeDynamically 
{

	public static void main(String[] args) throws Exception 
	{
		System.out.println("********");
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter name of   java class");
		String class_name = s.next();
		 
		 StringBuffer strbuff = new StringBuffer();
		 strbuff.append("public abstract class "+class_name+"{"+"\n");
		 strbuff.append("abstract void display();"+"\n");
		 strbuff.append("}");
System.out.println(strbuff.toString());
File f = new File("E://App//DynamicCodes//jds//"+class_name+".java");
 
BufferedWriter writer = new BufferedWriter(new FileWriter(f));
writer.write(strbuff.toString());
 
writer.close();
if(!f.exists())
{
f.createNewFile();	
}
 
System.out.println("****");
runProcess("javac "+f.getPath());
	}
	private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
      }
	private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
      }

}