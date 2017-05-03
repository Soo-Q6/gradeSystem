/**
 * 
 */
package gradeSystem;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author HPC
 *
 */
public class GradeStatusTest {
	static GradeStatus gradestatus=null;
	static DataStorage datastorage =null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ReadTxt read = new ReadTxt();
		datastorage = new DataStorage(read.getBufReader());
		//gradestatus = new GradeStatus(load);
		gradestatus=new GradeStatus(datastorage);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void getRankTest() {
		assertEquals(7,gradestatus.getRank(985002039));
		assertEquals(17,gradestatus.getRank(985002038));
	}
	@Test
	public void getStudentNameTest(){
		assertEquals("��ԣͥ",gradestatus.getStudentName(985002039));
		assertEquals("�����",gradestatus.getStudentName(985002038));
	}
	@Test
	public void showMeanTest(){
		assertEquals("lab1ƽ����90.31746lab2ƽ����87.71429lab3ƽ����89.09524mid-termƽ����89.52381final examƽ����89.730156",gradestatus.showMean());
	}
	@Test 
	public void getScoreByIDTest(){
		assertEquals(93,gradestatus.showScoreByID(985002039));
		assertEquals(91,gradestatus.showScoreByID(985002038));
	}

}
