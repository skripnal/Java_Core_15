package task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner;
		ZooClub zooClub = new ZooClub();
		
		while (true) {
			scanner = new Scanner(System.in);
			System.out.println("\u001B[32m1 - Додати учасника клубу");
			System.out.println("2 - Додати тваринку до учасника клубу");
			System.out.println("3 - Видалити тваринку учасника клубу");
			System.out.println("4 - Видалити учасника з клубу");
			System.out.println("5 - Видалити конкретну тваринку зі всіх власників");
			System.out.println("6 - Вивести на консоль зооклуб");
			System.out.println("0 - Завершити виконання програми\u001B[0m");
			try {
				switch (scanner.nextInt()) {
				case 1:{
					zooClub.addPerson();
					break;
				}
				case 2:{
					zooClub.addAnimal();
					break;
				}
				case 3:{
					zooClub.removeAnimal();
					break;
				}
				case 4:{
					zooClub.removePerson();
					break;
				}
				case 5:{
					zooClub.removeTypeAnimal();
					break;
				}
				case 6:{
					zooClub.showZooClub();
					break;
				}
				case 0:{
					System.exit(0);
				}
					
				default:
					System.out.println("\u001B[38;2;255;255;0mДанної команди не існує\u001B[0m");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("\u001B[31mНевірний формат введення!\u001B[0m");
			}
			
		}
	}
	
}
