import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    //Creating ArrayList
    ArrayList<Person> people = new ArrayList<Person>();
    String name = "", age = "", color = "";
    
    //Creating new Person Objects and Adding them to ArrayList
    people.add(new Person("Jake", 22, "Maroon"));
    people.add(new Person("A", 87, "Pink"));
    people.add(new Person("B", 13, "Yellow"));
    people.add(new Person("C", 55, "Black"));
    people.add(new Person("D", 4, "Green"));
  
    //Try Block - Writer
    try {
      FileWriter toWriteFile;
      toWriteFile = new FileWriter("data.txt"); 
      BufferedWriter output = new BufferedWriter(toWriteFile);
    
     for(int i=0; i<people.size(); i++) {
        output.write(people.get(i).getName());
        output.newLine();
        output.write(Integer.toString(people.get(i).getAge()));
        output.newLine();
        output.write(people.get(i).getColor());

      output.newLine();
      output.flush();
      }

    output.close();
    }

    //Catch Block - Writer
    catch (IOException exception) {
      System.out.println("An error occurred: " + exception);
      }
    
    //Try Block - Reader
    try {
      FileReader myFile;
      myFile = new FileReader("data.txt");
      BufferedReader reader = new BufferedReader(myFile);

      while(reader.ready()) {
        name = reader.readLine();
        age = reader.readLine();
        color = reader.readLine();
        //Person thePerson = new Person(name, Integer.parseInt(age), capital);
       //people.add(thePerson);
      }
      reader.close();
    }
    //Catch Block - Reader
    catch (IOException exception) {
      System.out.println("An error occurred: " + exception);
      }

    for(int i=0; i<people.size(); i++) {
    System.out.printf("%-10s %-10s %-10s %n", people.get(i).getName(), people.get(i).getAge(), people.get(i).getColor());
    }
  
}
}

