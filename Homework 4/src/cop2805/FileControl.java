//##########################################################################################
//### written by......................: Fatima Beyelhadj                             #######
//### Date written....................: 1/29/2022       							 #######
//### Purpose.........................: Homework 4 File control						 #######
//##########################################################################################

package cop2805;

import java.io.*;
import java.util.*;

public class FileControl {
	public static void main(String[] args) {
		List<Double> dataList;
		dataList = ReadFile("data.txt");
		Collections.sort(dataList);
		WriteFile(dataList, "data-sorted.txt");

	}// end of main
//###############################################################################################
	// function to read dataList from file

	public static List<Double> ReadFile(String file) {
		List<Double> dataList = new ArrayList<>();
		Scanner data = null;
		try {
			data = new Scanner(new File(file));
			while (data.hasNextLine())
				dataList.add(Double.parseDouble(data.next()));// convert each read line to double
		} catch (FileNotFoundException e) {// catch the exception
			System.out.println("File not found");
		}
		return dataList;// return the DataList
	}// end of ReadFile

//################################################################################################
	public static void WriteFile(List<Double> data, String file) {
		try {
			PrintWriter writer = new PrintWriter(new File(file));
			for (Double d : data) {
				System.out.println(d);
				writer.write(String.valueOf(d) + "\n");
			}
			writer.close();// close the stream
			System.out.println("Data has been written to file.");
		}
		catch (FileNotFoundException e) {// catch the exception
			e.printStackTrace();
		}
	}// end of WriteFile
	
//##################################################################################################
}// end of class FileControl
