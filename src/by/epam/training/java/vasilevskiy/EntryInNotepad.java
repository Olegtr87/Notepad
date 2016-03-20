package by.epam.training.java.vasilevskiy;
/**
 * The class implements methods to add record, delete record, edit record, view all entries, menu.
 */
import java.util.Scanner;

public class EntryInNotepad {
	private String[] array = new String[100];
	final static String TEXT_MENU = "Введите номер пункта меню:\n1. Добавить запись\n2. Удалить запись\n3. Редактировать запись\n4. Посмотреть все записи\n0. Выход";
	final static String TEXT_INCORRECT_ENTER = "Неправильный ввод!";
	final static String TEXT_ENTER_NUMBER_POINT = "Введите номер записи: ";
	final static String TEXT_ENTER = "Введите текст записи: ";
	final static String TEXT_ADD = "Запись добавлена!";
	final static String TEXT_NO_ENTRY = "Записей нет!";
	final static String TEXT_ENTRY_DELETE = "Запись удалена!";
	final static String TEXT_ENTRY_EDIT = "Запись изменена!";
	final static String TEXT_MENU_LINE = "------------------------------------";
	final static String TEXT_NO_EXIST = "Записи не существует!";

	private String pointMenu, entryForAdd, reversedText;
	private int entryForDelete, entryForEdit;
	private Scanner in;
	private int countEntry;

	private void editRecord() {
		System.out.print(TEXT_ENTER_NUMBER_POINT);
		// read text from command line
		in = new Scanner(System.in);
		try {
			entryForEdit = in.nextInt();
			// if true, enter number entry and change entry
			if (countEntry > 0 && entryForEdit > 0 && entryForEdit <= countEntry) {
				System.out.print(TEXT_ENTER);
				in = new Scanner(System.in);
				reversedText = in.nextLine();
				array[entryForEdit - 1] = reversedText;
				System.out.println(TEXT_ENTRY_EDIT);
			} else System.out.println(TEXT_NO_EXIST);
			//return in menu
			menu();
			// if exception, return in menu
		} catch (Exception e) {
			System.out.println(TEXT_INCORRECT_ENTER);
			menu();
		}
	}

	private void deleteElement() {
		System.out.print(TEXT_ENTER_NUMBER_POINT);
		// read text from command line
		in = new Scanner(System.in);
		try {
			entryForDelete = in.nextInt();
			// if true, delete entry and count--
			if (countEntry > 0 && entryForDelete > 0 && entryForDelete <= countEntry) {
				for (int i = entryForDelete - 1; i < countEntry - 1; i++) {
					array[i] = array[i + 1];
				}
				countEntry--;
				System.out.println(TEXT_ENTRY_DELETE);
			}
			// return in menu
			menu();
			// if exception, return in menu
		} catch (Exception e) {
			System.out.println(TEXT_INCORRECT_ENTER);
			menu();
		}
	}

	private void showAllElements() {
		if (countEntry == 0)
			System.out.println(TEXT_NO_ENTRY);
		else
			// show all entry
			for (int i = 0; i < countEntry; i++) {
			System.out.println(array[i]);
			}
		// return in menu
		menu();
	}

	private void addElement() {
		System.out.println(TEXT_ENTER);
		// read text from command line and add in entryForAdd
		in = new Scanner(System.in);
		entryForAdd = in.nextLine();
		// add entryForAdd in array
		array[countEntry] = entryForAdd;
		// count plus
		countEntry++;
		System.out.println(TEXT_ADD);
		// return in menu
		menu();
	}

	public void menu() {
		System.out.println(TEXT_MENU_LINE);
		System.out.println(TEXT_MENU);
		// read point menu from command line
		in = new Scanner(System.in);
		pointMenu = in.nextLine();
		System.out.println(TEXT_MENU_LINE);
		// action menu
		switch (pointMenu) {
		case "3":
			editRecord();
			break;
		case "2":
			deleteElement();
			break;
		case "4":
			showAllElements();
			break;
		case "1":
			addElement();
			break;
		case "0":
			break;
		default:
			System.out.println(TEXT_INCORRECT_ENTER);
			menu();
			break;
		}
		
	}
}
