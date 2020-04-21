package PastWork;
/*
SID: krishna87
LANG: JAVA
TASK: beads
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

class beads {
    @SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("beads.in"));
        PrintWriter pw = new PrintWriter(new File("beads.out"));
        int length = sc.nextInt();
        String necklace = sc.next();

        int max = 0;
        for (int i = 0; i < necklace.length(); i++) {
            char leftColor = necklace.charAt(i);
            char rightColor = necklace.charAt(i + 1 == necklace.length() ? 0 : i + 1);

            int leftAcc = 0;
            Iterator<Character> left = reverseIterator(i, necklace);
            while (left.hasNext()) {
                char color = left.next();
                if (color != leftColor && leftColor == 'w') {
                    leftColor = color;
                }
                if (color == leftColor || color == 'w') {
                    leftAcc++;
                } else {
                    break;
                }
            }

            int rightAcc = 0;
            Iterator<Character> right = forwardIterator(i + 1, necklace);
            while (right.hasNext()) {
                char color = right.next();
                if (color != rightColor && rightColor == 'w') {
                    rightColor = color;
                }
                if (color == rightColor || color == 'w') {
                    rightAcc++;
                } else {
                    break;
                }
            }

            max = Math.max(leftAcc + rightAcc, max);
        }

        pw.println(Math.min(max, necklace.length()));
        pw.close();
    }

    private static Iterator<Character> reverseIterator(final int index, final String necklace) {
        return new Iterator<Character>() {
            int currentIndex = index;
            int cnt = 0;
            int max = necklace.length();

            @Override
            public boolean hasNext() {
                return cnt < max;
            }

            @Override
            public Character next() {
                cnt++;
                if (this.currentIndex < 0) {
                    this.currentIndex = necklace.length() - 1;
                    return necklace.charAt(this.currentIndex--);
                } else {
                    return necklace.charAt(this.currentIndex--);
                }
            }

            @Override
            public void remove() {
                //
            }
        };
    }

    private static Iterator<Character> forwardIterator(final int index, final String necklace) {
        return new Iterator<Character>() {
            int currentIndex = index;
            int cnt = 0;
            int max = necklace.length();

            @Override
            public boolean hasNext() {
                return cnt < max;
            }

            @Override
            public Character next() {
                cnt++;
                if (this.currentIndex >= necklace.length()) {
                    this.currentIndex = 0;
                    return necklace.charAt(this.currentIndex++);
                } else {
                    return necklace.charAt(this.currentIndex++);
                }
            }

            @Override
            public void remove() {
                //
            }
        };
    }
}