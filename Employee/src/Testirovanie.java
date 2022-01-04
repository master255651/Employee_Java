import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Testirovanie {

	public static void main(String[] args) {
		
		ArrayList<Person> _persons = new ArrayList<Person>();
		
		try {
            File file = new File("InfoPersons.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
            	String[] LineFromFile = line.split(" ");
            	Person _newPerson = new Person(LineFromFile[0], LineFromFile[1], Integer.parseInt(LineFromFile[2]));
    		    _persons.add(_newPerson);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		ArrayList<Employee> _employees = new ArrayList<Employee>();
		
		try {
            File file = new File("InfoEmployees.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
            	String[] LineFromFile = line.split(" ");
            	Employee _newEmployee = new Employee(LineFromFile[0], LineFromFile[1], Integer.parseInt(LineFromFile[2]), LineFromFile[3], Integer.parseInt(LineFromFile[4]));
    		    _employees.add(_newEmployee);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		System.out.println("Information about workers: ");
		for(int i = 0; i < _persons.size(); i++) {
			_persons.get(i).Afisare();
			System.out.println();
		}
		
		System.out.println("Information about employees: ");
		for(int i = 0; i < _employees.size(); i++) {
			_employees.get(i).Afisare();
			_employees.get(i).ShowEmployer();
			_employees.get(i).ShowExperience();
			System.out.println();
		}
			
		System.out.println("Enter the last name of the worker you want to remove: ");
		Scanner in = new Scanner(System.in);
		String _personForDelete = in.nextLine();
		
		for(int i = 0; i < _persons.size(); i++) {
			if(_personForDelete.equals(_persons.get(i).GetSurname()))
				_persons.remove(_persons.get(i));
		}
		
		SaveFile("InfoPersons.txt", _persons);
		
		System.out.println("Enter information about the new employee: ");
		System.out.print("Name: ");
		in = new Scanner(System.in);
        String _name = in.nextLine();
        System.out.print("Surname: ");
        String _surname = in.nextLine();
        System.out.print("Age: ");
        int _age = in.nextInt();
        in.close();
     
        Person _newPerson = new Person(_name, _surname, _age);
        _persons.add(_newPerson);
        
        SaveFile("InfoPersons.txt", _persons);
	}
	
	public static <T> void SaveFile(String nameFile, ArrayList<T> _persons) {
		try
        {
			FileWriter writer = new FileWriter(nameFile);
			
			for(int i = 0; i < _persons.size(); i++) {
				String LinePersonInfo = ((Person) _persons.get(i)).GetInfoForFile();
				writer.write(LinePersonInfo);
				writer.flush();
			}
			
			writer.close();
			
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
	}
}