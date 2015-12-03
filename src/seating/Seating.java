
package seating;

import java.util.ArrayList;
import java.util.List;

public class Seating {

    public static void main(String[] args) {
        List<Student> roster = new ArrayList<Student>();
        roster.add(new Student("Ann", 2));
        roster.add(new Student("Bob", 4));
        roster.add(new Student("Joe", 7));
        SeatingChart chart = new SeatingChart(roster,3,4);
        chart.print();
        System.out.println(chart.removeAbsentStudents(3));
        chart.print();
    }
}
class SeatingChart
{
    private Student[][] seats;
    int rows;
    int columns;
    SeatingChart(List<Student> studentList,int _rows, int _columns)
    {
        rows = _rows;
        columns = _columns;
        seats = new Student[rows][columns];
        int counter = 0;
        for(int c=0;c<rows;c++)
        {
            for(int r=0;r<columns;r++)
            {
                if(counter >= studentList.size())
                    break;
                seats[r][c] = studentList.get(counter);
                counter++;
                
            }
            if(counter >= studentList.size())
                    break;
        }
    }
    public int removeAbsentStudents(int req)
    {
        int abCount = 0;
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<columns;c++)
            {
                if(seats[r][c] != null && seats[r][c].getAbsenceCount() >= req)
                {
                    seats[r][c] = null;
                    abCount++;
                }
            }
        }
        return abCount;
    }
    public void print()
    {
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<columns;c++)
            {
                if(seats[r][c] != null)
                     System.out.print(seats[r][c].getName());
                else
                     System.out.print(seats[r][c]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
class Student
{
    private String name;
    private int absenceCount;
    Student(String _name, int _absent)
    {
        name = _name;
        absenceCount = _absent;
    }
    public String getName()
    {
        return(name);
    }
    public int getAbsenceCount()
    {
        return(absenceCount);
    }
}