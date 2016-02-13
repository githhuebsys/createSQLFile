package createSQLFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class createFile {

	List<SQLParms> recordsIn = new ArrayList<SQLParms>();
	List<String> inSQL = new ArrayList<String>();
	List<String> outSQL = new ArrayList<String>();
	List<String> recordsOut = new ArrayList<String>();
	int recordsInCount = 0;
	int recordsInSQLCount = 0;
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
			// SQLParms mySQLParms = new SQLParms();
			SQLParms mySQLParms = buildSQLParm(line);
			recordsIn.add(mySQLParms);
			++recordsInCount;
		}

		// close the BufferedReader when we're done
		bufferedReader.close();
	}

	private void readSQLFile() throws Exception {
		String line = null;

		// wrap a BufferedReader around FileReader
		File inFile = new File("c:/data/testfiles/inputSQL.txt");

		BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));

		// use the readLine method of the BufferedReader to read one line at a
		// time.
		// the readLine method returns null when there is nothing else to read.
		while ((line = bufferedReader.readLine()) != null) {
			inSQL.add(line);
			++recordsInSQLCount;
		}

		// close the BufferedReader when we're done
		bufferedReader.close();
	}

	private void createOutputSQLData(SQLParms work) {
		// TODO Auto-generated method stub
		String inSQLLine;
		String outSQLLine;
		Iterator<String> inSQLItr = inSQL.iterator();
		while (inSQLItr.hasNext()) {
			inSQLLine = inSQLItr.next();
			inSQLLine = inSQLLine.replace("&parm1", work.getParm1());
			inSQLLine = inSQLLine.replace("&parm2", work.getParm2());
			inSQLLine = inSQLLine.replace("&parm3", work.getParm3());
			inSQLLine = inSQLLine.replace("&parm4", work.getParm4());
			inSQLLine = inSQLLine.replace("&parm5", work.getParm5());
			recordsOut.add(inSQLLine);
		}

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
		// String delimiters = "\\s+|,\\s*|\\.\\s*";
		String delimiters = "\\s+|\\^\\s+";
		String[] parms = line.split(delimiters);
		SQLParms sP = new SQLParms();

		if (1 < parms.length)
			sP.setParm1(parms[1].trim());
		if (2 < parms.length)
			sP.setParm2(parms[2].trim());
		if (3 < parms.length)
			sP.setParm3(parms[3].trim());
		if (4 < parms.length)
			sP.setParm4(parms[4].trim());
		if (5 < parms.length)
			sP.setParm5(parms[5].trim());
		return sP;
	}

	public static void main(String[] args) {
		try {

			createFile myCreateFile = new createFile();
			myCreateFile.readFile();
			myCreateFile.readSQLFile();

			Iterator<SQLParms> recordItr = myCreateFile.recordsIn.iterator();
			while (recordItr.hasNext()) {
				SQLParms work = recordItr.next();
				myCreateFile.createOutputSQLData(work);
				// myCreateFile.recordsOut.add(work.toString());
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
