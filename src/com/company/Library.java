package com.company;


import java.util.ArrayList;

public class Library {
    private static String HOURS="Libraries are open daily from 9am to 5pm";
    private String address;
    private ArrayList<Book> bookCollection= new ArrayList<>();


    public Library(String address ){
        this.address=address;
    }

    private void addBook(Book bookName) {
        this.bookCollection.add(bookName);
    }

    private static void printOpeningHours() {
        System.out.println(Library.HOURS);
    }

    private void printAddress() {
        System.out.println(this.address);
    }
    private void borrowBook(String title) {
        for( Book  book :this.bookCollection){
            if (book.title.equals(title)){
                if (book.isBorrowed()==false){
                book.borrowed();
                System.out.println("You successfully borrowed  "+title);
                return;
            }
                else{System.out.println("Sorry, this book is already borrowed."); return; }
        }
    }
        System.out.println("Sorry, this book is not in our catalog. ");
    }
    public void printAvailableBooks(){
        if (this.bookCollection.size()==0){System.out.println("No book in catalog");}
            for( Book  book :this.bookCollection){
                if (book.isBorrowed()==false){
                    System.out.println(book.title);
            }
        }
    }

    private void returnBook(String title) {
        for( Book  book :this.bookCollection){
            if (book.title.equals(title)){
                if(book.isBorrowed()==true){
                    book.returned();
                    System.out.println("You successfully returned "+title);
                    return;
                }
                else{System.out.println(title + "is not checked out"); return; }
            }
        }
        System.out.println("This book is not on record at this library");
    }




    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

}



