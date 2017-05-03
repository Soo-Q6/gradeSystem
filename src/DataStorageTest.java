package gradeSystem;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataStorageTest {
	static DataStorage datastorage =null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ReadTxt read = new ReadTxt();
		datastorage = new DataStorage(read.getBufReader());
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/** 
	 * unit test for getting students' grade string from input file.
	 */
	@Test
	public void getGradeByIDtest() {
		assertEquals("92 95 89 97 92",datastorage.getGradeByID(985002039));
		assertEquals("99 87 86 96 89",datastorage.getGradeByID(985002038));
	}
	
	/**
	 * unit test to find out whether the input ID is in the input file or not.
	 */
	@Test
	public void containStudentIDTest(){
		assertFalse(datastorage.containStudentID(900002039));
		assertTrue(datastorage.containStudentID(985002039));
	}

}
