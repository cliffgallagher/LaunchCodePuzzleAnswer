import java.util.ArrayList;

public class BracketIdentifierTwo {

    public static void main(String[] args) {
        System.out.println(bracketsAreValid("{{()(([]()())}}"));
    }

    public static boolean bracketsAreValid(String inputString) {
        
        ArrayList<Character> onlyBrackets = new ArrayList<>();
        int numOpenPar = 0;
        int numClosePar = 0;
        int numOpenBracket = 0;
        int numCloseBracket = 0;
        int numOpenSquare = 0;
        int numCloseSquare = 0;

        for (int i = 0; i < inputString.length(); ++i) {
            
            switch (inputString.charAt(i)) {
                case '(':
                    onlyBrackets.add(inputString.charAt(i));
                    ++numOpenPar;
                    break;
                case ')':
                    onlyBrackets.add(inputString.charAt(i));
                    ++numClosePar;
                    break;
                case '[':
                    onlyBrackets.add(inputString.charAt(i));
                    ++numOpenSquare;
                    break;
                case ']':
                    onlyBrackets.add(inputString.charAt(i));
                    ++numCloseSquare;
                    break;
                case '{':
                    onlyBrackets.add(inputString.charAt(i));
                    ++numOpenBracket;
                    break;
                case '}':
                    onlyBrackets.add(inputString.charAt(i));
                    ++numCloseBracket;
                    break;
            }
        }
        
        if ((numOpenPar != numClosePar) || (numOpenSquare != numCloseSquare) || (numOpenBracket != numCloseBracket)) {
            return false;
        } else {
            ArrayList<Character> openBrackets = new ArrayList<>();
            int numOpen = 0;

            for (Character c: onlyBrackets) {
                if ((c.charValue() == '(') || (c.charValue() == '[') || (c.charValue() == '{')) {
                    openBrackets.add(c);
                    ++numOpen;
                } else {
                    if (numOpen <= 0) {
                        return false;
                    } else {
                        if (!arePair(openBrackets.get(numOpen - 1), c)) {
                            return false;
                        } else {
                            openBrackets.remove(numOpen - 1);
                            --numOpen;
                        }
                    }
                }
            }

            return true;
        }
    }

    private static boolean arePair(Character open, Character close) {
        if ((open.charValue() == '(') && (close.charValue() == ')')) {
            return true;
        } else if ((open.charValue() == '[') && (close.charValue() == ']')) {
            return true;
        } else if ((open.charValue() == '{') && (close.charValue() == '}')) {
            return true;
        } else {
            return false;
        }
    }
    
}
