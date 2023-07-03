package task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ZooClub {
	
	private Map<Person, List<Animal>> map = new HashMap<>();
	private Scanner scanner;
	

	public void addPerson() throws InputMismatchException{
		scanner = new Scanner(System.in);
		
		System.out.print("Введіть ім'я учасника клубу: ");
		String personName = scanner.next();
		System.out.print("Введіть вік учасника клубу: ");
		int personAge = scanner.nextInt();
		map.put(new Person(personName, personAge), new ArrayList<Animal>());
	}
	
	public void showZooClub() {
		for (Map.Entry<Person, List<Animal>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	}
	
	public void addAnimal(){
		scanner = new Scanner(System.in);
		
		System.out.print("Введіть ім'я учасника клубу котрому буде додано тваринку: ");
		String name = scanner.next().toLowerCase();
		for (Map.Entry<Person, List<Animal>> entry : map.entrySet()) {
			if (entry.getKey().getName().toLowerCase().equals(name)){
				System.out.print("Введіть тип тваринки - Кіт або Пес: ");
				String typeAnimal = scanner.next().toLowerCase();
				if (typeAnimal.equals("кіт") || typeAnimal.equals("пес")) {
					System.out.print("Введіть ім'я тваринки: ");
					String nameAnimal = scanner.next();
					entry.getValue().add(new Animal(typeAnimal, nameAnimal));
					System.out.println("Тваринку додано");
				}else {
					System.out.println("\u001B[38;2;255;255;0mНевірно введений тип тваринки\u001B[0m");
				}
				return;
			}
			
		}
		System.out.println("\u001B[38;2;255;255;0mТакого учасника не існує\u001B[0m");
	}

	
	public void removeAnimal() {
		scanner = new Scanner(System.in);
		
		System.out.print("Введіть ім'я учасника клубу, тваринку котрого буде видалено: ");
		String name = scanner.next().toLowerCase();
		for (Map.Entry<Person, List<Animal>> entry : map.entrySet()) {
			if (entry.getKey().getName().toLowerCase().equals(name)) {
				System.out.print("Введіть ім'я тваринки яку буде видалено: ");
				String animalName = scanner.next().toLowerCase();
				Iterator<Animal> iterator = entry.getValue().iterator();
				while (iterator.hasNext()) {
					if (iterator.next().getName().toLowerCase().equals(animalName)) {
						iterator.remove();
						System.out.println("Тваринку видалено");
						return;
					}
				}
				System.out.println("\u001B[38;2;255;255;0mТваринку не знайдено\u001B[0m");
				return;
			}
			
		}
		System.out.println("\u001B[38;2;255;255;0mТакого учасника не існує\u001B[0m");
	}
	
	
	public void removePerson() {
		scanner = new Scanner(System.in);
		
		System.out.print("Введіть ім'я учасника клубу, якого буде видалено: ");
		String personName = scanner.next().toLowerCase();
		Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getKey().getName().toLowerCase().equals(personName)) {
				iterator.remove();
				System.out.println("Учасника видалено");
				return;
			}
		}
		System.out.println("\u001B[38;2;255;255;0mТакого учасника не існує\u001B[0m");
	}
	
	
	public void removeTypeAnimal() {
		scanner = new Scanner(System.in);
		int count = 0;
		
		System.out.print("Введіть тип тварин, який буде видалено: ");
		String animalType = scanner.next().toLowerCase();
		for (Map.Entry<Person, List<Animal>> entry : map.entrySet()) {
			Iterator<Animal> iterator = entry.getValue().iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getType().toLowerCase().equals(animalType)) {
					iterator.remove();
					count++;
				}
			}
		}
		System.out.println("Було видалено " + count + " тваринок");
	}
}
