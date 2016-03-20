package by.epam.training.java.vasilevskiy;
import java.util.InputMismatchException;
/**
 * The class implements methods to add record, delete record, edit record, view all entries, menu.
 */
import java.util.Scanner;

public class EntryInNotepad {
	private String[] array = new String[100];
	final static String TEXT_MENU = "Enter the number of the menu item:\n1 Add entry \n2 Delete entry \n3 Edit entry \n4 View all entries \n0 Exit";
	final static String TEXT_INCORRECT_ENTER = "Invalid input!";
	final static String TEXT_ENTER_NUMBER_POINT = "Enter the record number: ";
	final static String TEXT_ENTER = "Enter the text entries: ";
	final static String TEXT_ADD = "Record added!";
	final static String TEXT_NO_ENTRY = "No records!";
	final static String TEXT_ENTRY_DELETE = "Entry is deleted!";
	final static String TEXT_ENTRY_EDIT = "Record changed!";
	final static String TEXT_MENU_LINE = "------------------------------------";
	final static String TEXT_NO_EXIST = "No records exist!";

	private String pointMenu, entryForAdd, reversedText;
	private int entryForDelete, entryForEdit;
	private Scanner in;
	private int countEntry;

	private void editRecord() {
		System.out.print(TEXT_ENTER_NUMBER_POINT);
		// reading number point from command line
		in = new Scanner(System.in);
		try {
			entryForEdit = in.nextInt();
			// if true, enter number entry and change entry
			if (countEntry > 0 && entryForEdit > 0 && entryForEdit <= countEntry) {
				System.out.print(TEXT_ENTER);
				// reading from command line reversed text
				in = new Scanner(System.in);
				reversedText = in.nextLine();
				//assignment element of an array of new text
				array[entryForEdit - 1] = reversedText;
				System.out.println(TEXT_ENTRY_EDIT);
			} else System.out.println(TEXT_NO_EXIST);
			//return in menu
			menu();
			// if exception, return in menu
		} catch (InputMismatchException e) {
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
					// current items=next items
					array[i] = array[i + 1];
				}
				//counter minus 1
				countEntry--;
				System.out.println(TEXT_ENTRY_DELETE);
			}
			// return in menu
			menu();
			// if exception, return in menu
		} catch (InputMismatchException e) {
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
		// reading point menu from command line
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
