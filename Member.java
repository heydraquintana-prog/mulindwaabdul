import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String memberId;
    private final String name;
    private final List<Loan> loans;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.loans = new ArrayList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Loan> getLoans() { return loans; }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    public void removeLoan(Loan loan) {
        this.loans.remove(loan);
    }

    @Override
    public String toString() {
        return "Member [ID=" + memberId + ", Name=" + name + ", Active Loans=" + loans.size() + "]";
    }
}