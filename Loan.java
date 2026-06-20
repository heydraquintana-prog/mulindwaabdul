import java.time.LocalDate;

public class Loan {
    private final Member member;
    private final Book book;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;

    public Loan(Member member, Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public Member getMember() { return member; }
    public Book getBook() { return book; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }

    @Override
    public String toString() {
        return "Loan [Book=\"" + book.getTitle() + "\", Borrowed By=" + member.getName() + ", Due=" + dueDate + "]";
    }
}