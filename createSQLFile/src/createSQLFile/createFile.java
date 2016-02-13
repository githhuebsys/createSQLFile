package createSQLFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class createFile {

	List<SQLParms> recordsIn = new ArrayList<SQLParms>();
	List<String> recordsOut = new ArrayList<String>();
	int recordsInCount = 0;
	int recordsOutCount = 0;

	private void readFile() throws Exception {
		String line = null;

		// wrap a BufferedReader around FileReader
		File inFile = new File("c:/data/testfiles/input.txt");

		BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));

		// use the readLine method of the BufferedReader to read one line at a
		// time.
		// the readLine method returns null when there is nothing else to read.
		while ((line = bufferedReader.readLine()) != null) {
			//SQLParms mySQLParms = new SQLParms();
			SQLParms mySQLParms = buildSQLParm(line);
			recordsIn.add(mySQLParms);
			++recordsInCount;
		}

		// close the BufferedReader when we're done
		bufferedReader.close();
	}

	private void writeFile() throws Exception {
		// String line = null;

		// wrap a BufferedWriter around FileWriter
		File outFile = new File("c:/data/testfiles/output.txt");

		// if file doesnt exists, then create it
		if (!outFile.exists()) {
			outFile.createNewFile();
		}

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFile));

		// use the readLine method of the BufferedReader to read one line at a
		// time.
		// the readLine method returns null when there is nothing else to read.
		Iterator<String> recordItr = recordsOut.iterator();
		while (recordItr.hasNext()) {
			bufferedWriter.write(recordItr.next());
			bufferedWriter.newLine();
			++recordsOutCount;
		}

		// close the BufferedReader when we're done
		bufferedWriter.close();
	}

	private SQLParms buildSQLParm(String line) {
		// TODO Auto-generated method stub
		//String delimiters = "\\s+|,\\s*|\\.\\s*";
		String delimiters = "\\s+";
		String[] parms = line.split(delimiters); 
		SQLParms sP = new SQLParms();
		
		if (0 < parms.length)
			sP.setDiagnosticCode(parms[0]);
		if (1 < parms.length)
			sP.setDescription(parms[1]);
		if (2 < parms.length)
			sP.setBeginDate(parms[2]);
		if (3 < parms.length)
			sP.setBeginTime(parms[3]);
		if (4 < parms.length)
			sP.setEndDate(parms[4]);
		if (5 < parms.length)
			sP.setEndDate(parms[5]);
		return sP;
	}

	public static void main(String[] args) {
		try {

			createFile myCreateFile = new createFile();
			myCreateFile.readFile();
			
			Iterator<SQLParms> recordItr = myCreateFile.recordsIn.iterator();
			while (recordItr.hasNext()) {
				SQLParms work = recordItr.next();
				myCreateFile.recordsOut.add(work.toString());
			}
			
			myCreateFile.writeFile();
			System.out.println("Number of records read = " + myCreateFile.recordsInCount);
			System.out.println("Number of records written = " + myCreateFile.recordsOutCount);
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
