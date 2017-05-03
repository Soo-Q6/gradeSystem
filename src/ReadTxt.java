package gradeSystem;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class ReadTxt {
	/**
	 * @uml.property  name="br"
	 */
	BufferedReader br;
	/**
	 * @uml.property  name="fr"
	 */
	FileReader fr;
	
	/**
	 * Constructor throws IOException
	 * 
	 * Time estimate: O(1)
	 */
    public ReadTxt() throws IOException {
        FileReader fr = new FileReader("D:\\ÎÄµµ\\JAVA\\HW2\\src\\gradeinput1.txt");
        br = new BufferedReader(fr);
        //DataStorage load = new DataStorage(br);
        /*while (br.ready()) {
            DataStorage load = n
        	load.setStudentData(br.readLine());
        }*/
        //System.out.println("Total number is: "+load.getDataSize());
        //load.showStudentData();
       // System.out.println(load.getGradeByID(962001051));
        //GradeStatus grade = new GradeStatus(load);
        //System.out.println(grade.getLab1ScoreByID(962001051));
        /*int x = 962001051;
        grade.showScoreByID(x);
        grade.showMean();
        grade.setNewWeight();
        System.out.println(grade.getRank(975002070));
        System.out.println(grade.getRank(962001051));
        System.out.println("Thanks for using.");*/
        //fr.close();
    }
    
    public BufferedReader getBufReader(){
    	return this.br;
    }
    
}
