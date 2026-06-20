import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    // Requirements 3: lendBook enforcing business rules
    public boolean lendBook(String memberId, String isbn) {
        Member candidateMember = null;
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                candidateMember = m;
                break;
            }
        }

        Book candidateBook = null;
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                candidateBook = b;
                break;
            }
        }

        if (candidateMember == null || candidateBook == null) {
            System.out.println(">>> Error: Invalid Member ID or ISBN. Transaction rejected.");
            return false;
        }

        // Business Rule Check
        if (!candidateBook.isAvailable()) {
            System.out.println(">>> Transaction Rejected: The book '" + candidateBook.getTitle() + "' is already on an active loan!");
            return false;
        }

        // Fulfill lending process
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(14); // 2-week loan limit
        Loan cleanLoan = new Loan(candidateMember, candidateBook, borrowDate, dueDate);

        candidateBook.setAvailable(false);
        candidateMember.addLoan(cleanLoan);
        System.out.println(">>> Success: '" + candidateBook.getTitle() + "' successfully lent to " + candidateMember.getName() + ".");
        return true;
    }

    // Requirements 3: returnBook implementation
    public boolean returnBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (b.isAvailable()) {
                    System.out.println(">>> Error: The book '" + b.getTitle() + "' was already marked inside the library.");
                    return false;
                }
                
                // Track down the member holding this loan to clear it
                for (Member m : members) {
                    Loan targetLoan = null;
                    for (Loan ln : m.getLoans()) {
                        if (ln.getBook().getIsbn().equals(isbn)) {
                            targetLoan = ln;
                            break;
                        }
                    }
                    if (targetLoan != null) {
                        m.removeLoan(targetLoan);
                        b.setAvailable(true);
                        System.out.println(">>> Success: '" + b.getTitle() + "' returned successfully by " + m.getName() + ".");
                        return true;
                    }
                }
            }
        }
        System.out.println(">>> Error: Book matching ISBN: " + isbn + " not registered.");
        return false;
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> matched = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title) || b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matched.add(b);
            }
        }
        return matched;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Library State -> Total Registered Books: " + books.size() + " | Registered Members: " + members.size();
    }
}