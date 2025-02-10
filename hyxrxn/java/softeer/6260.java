import java.io.*;
import java.util.*;

public class Main {

    static int n, a, s, p, m, q;
    static int maxi, maxiSum = 0;
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            maxi = 0;
            List<Suggestion> suggestions = new ArrayList<>();
            a = sc.nextInt();
            for (int j = 0; j < a; j++) {
                s = sc.nextInt();
                p = sc.nextInt();
                suggestions.add(new Suggestion(s, p));
                if (p > maxi) {
                    maxi = p;
                }
            }
            customers.add(new Customer(suggestions));
            maxiSum += maxi;
        }

        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            q = sc.nextInt();
            if (q > maxiSum) {
                System.out.print("-1 ");
            } else {
                System.out.print(calculateMinimun(q) + " ");
            }
        }
    }

    static int calculateMinimun(int q) {
        int answer = 1000000000;
        int lower = 1;
        int upper = 1000000000;
        while(lower <= upper) {
            int middle = (lower + upper + 1) / 2;
            if (middleCan(middle, q)) {
                upper = middle - 1;
                answer = middle;
            } else {
                lower = middle + 1;
            }
        }
        return answer;
    }

    static boolean middleCan(int size, int q) {
        int sum = 0;
        for (Customer customer : customers) {
            sum += customer.calculateMaximunPrice(size);
            if (sum >= q) {
                return true;
            }
        }
        return false;
    }
}

class Suggestion {
    int s;
    int p;

    public Suggestion(int s, int p) {
        this.s = s;
        this.p = p;
    }
}

class Customer {
    List<Suggestion> suggestions;

    public Customer(List<Suggestion> suggestions) {
        this.suggestions = sortSuggestions(suggestions);
    }

    List<Suggestion> sortSuggestions(List<Suggestion> suggestions) {
        List<Suggestion> real = new ArrayList<>();
        suggestions.sort((a, b) -> a.s - b.s);
        int maxi = 0;
        for (Suggestion suggestion : suggestions) {
            if (suggestion.p > maxi) {
                real.add(suggestion);
                maxi = suggestion.p;
            }
        }
        return real;
    }

    public int calculateMaximunPrice(int size) {
        if (suggestions.get(0).s > size) {
            return 0;
        } else if (suggestions.get(suggestions.size() - 1).s < size) {
            return suggestions.get(suggestions.size() - 1).p;
        }
        int answer = 0;
        int lower = 0;
        int upper = suggestions.size() - 1;
        while(lower <= upper) {
            int middle = (lower + upper + 1) / 2;
            if (suggestions.get(middle).s > size) {
                lower = middle + 1;
                answer = middle;
            } else {
                upper = middle - 1;
            }
        }
        return suggestions.get(answer).p;
    }
}

// https://softeer.ai/practice/6260
