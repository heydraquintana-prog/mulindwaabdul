public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();

        // 1. Create 3 Books
        Book b1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book b2 = new Book("978-0132350884", "Clean Code", "Robert C. Martin");
        Book b3 = new Book("978-0596009205", "Head First Design Patterns"); // Uses Overloaded constructor 1 via implicit default
        
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // 2. Create 2 Members
        Member m1 = new Member("VU-001", "Alice Namubiru");
        Member m2 = new Member("VU-002", "John Okello");
        
        library.registerMember(m1);
        library.registerMember(m2);

        System.out.println("================ INITIAL STATE ================");
        System.out.println(library);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println("===============================================\n");

        // 3. Perform sequences of loan actions
        System.out.println("--- Action 1: Lending 'Clean Code' to Alice ---");
        library.lendBook("VU-001", "978-0132350884");

        System.out.println("\n--- Action 2: Attempting to lend the SAME book ('Clean Code') to John (Expected to Fail) ---");
        library.lendBook("VU-002", "978-0132350884");

        System.out.println("\n--- Action 3: Lending 'Effective Java' to John ---");
        library.lendBook("VU-002", "978-0134685991");

        System.out.println("\n================ MID-TRANSACTION STATE ================");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println("========================================================\n");

        System.out.println("--- Action 4: Alice returns 'Clean Code' ---");
        library.returnBook("978-0132350884");

        System.out.println("\n--- Action 5: Try lending 'Clean Code' to John again now that it is freed ---");
        library.lendBook("VU-002", "978-0132350884");

        System.out.println("\n================ FINAL STATE ================");
        System.out.println(library);
        System.out.println(b2);
        System.out.println(m2);
        System.out.println("=============================================");
    }
}