package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;

public class CommonCSVTest {
	
	@Test
	public void testComma() throws Exception {
		
		
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("foo.csv"));
            String[] header = new String[] {
            		"ID", "Name", "Designation", "Company, name"
            };
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader(header));
    
            csvPrinter.printRecord("1", "Sundar, Pichai", "CEO", "Google");
            csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft");
            csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple");

            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));

            csvPrinter.flush();            
	        
	}
	
	@Test
	public void testReading() throws Exception {
		
	    Reader reader = Files.newBufferedReader(Paths.get("foo.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader());
		System.out.println(csvParser.getHeaderMap());
		assertEquals(4, csvParser.getHeaderMap().keySet().size());
		
	}
	

}
