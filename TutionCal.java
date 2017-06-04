/**
 * 
 * 
 */
import java.util.Scanner; 
public class TutionCal 
{
  public static void main(String[] args) 
  { 
    int year=0;
    double tution= 10000;
    
    while(tution < 20000)
    {
      tution = tution * 1.07;
      year++;
    }
    System.out.println("Tuition will be doubled in " + year + " years");
    System.out.printf("Tuition will be $%.2f in %1d years" , tution, year);
  }
}
