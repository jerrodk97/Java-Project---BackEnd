//Jerrod Koenigseder
package project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Predictor {
	private ArrayList<Instance> instances;
	private String fileName;
	private String weather;
	
	public Predictor() {
		instances = new ArrayList<Instance>();
		weather = null;
		fileName = null;
	}
	
	public Predictor(String wn, String fn) {
		this();
		fileName = fn;
		weather = wn;
		instances = new ArrayList<Instance>();
		readFile();
	}
	
	public String toString() {
		String toReturn = weather + ":\n";
		for (Instance instance : instances) {
			toReturn += instance.toString() + "\n";
		}
		return toReturn;
	} 
	public void add(Instance i) {
		instances.add(i);
		}
	
	public void update(String c, int t, int h, String w, String a) {
	for (Instance instance : instances) {
		if(c.equals(instance.getCondition()) && t==instance.getTemp() && h==instance.getHumidity() && w.equals(instance.getWindy())) {
			instance.setActivity(a);
			}
		}
	}
	public String getActivity(String c, int t, int h, String w) {
	String toReturn = "Your method doesn't work";
	for (Instance instance : instances) {
		if(c.equals(instance.getCondition()) && t==instance.getTemp() && h==instance.getHumidity() && w.equals(instance.getWindy())) {
			toReturn = instance.getActivity();
			return toReturn;
		}
			else
				toReturn = "Work on Java";
		
		}
		return toReturn;
	
	}
	
	
	public void writeFile() {
		doWrite(fileName);
	}
	
	public void writeFile(String altFileName) {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite(altFileName);		
	}// end of writeFile method
	
	private void doWrite(String fn) {
		// this method writes all of the data in the persons array to a file
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			
			
			for (Instance instance : instances) {
				Instance instances = instance;
					myOutfile.write (instance.getCondition()+",");
					myOutfile.write (instance.getTemp()+",");
					myOutfile.write (instance.getHumidity()+",");
					myOutfile.write (instance.getWindy()+",");
					myOutfile.write(instance.getActivity()+",");
					myOutfile.write("\n");
			}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}	
	
	


	private void readFile() {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line = null;
			while ((line = lineReader.readLine())!=null) {
				String[] tokens = line.split(",");
				Instance temp = new Instance(tokens[0],Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),tokens[3],tokens[4]);
				add(temp);			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String line = null;
				while ((line = lineReader.readLine())!=null) {
					String[] tokens = line.split(",");
					Instance temp = new Instance(tokens[0],Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),tokens[3],tokens[4]);
					add(temp);
					}			//	}
			} catch (Exception e2) {
				e.printStackTrace();
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	}} // end of readFile method	


	
