public class main {
    public static void main(String[] args) {
        
    }

    public static boolean isalnum(char val){
        return (val >= 'a' && val <= 'z') || (val >= 'A'&& val <= 'Z') || (val >= '0' && val <= '9');
    }

    public void lexicalSolver(char word[]) {
        int start = 0;
        int end = 0;
        int peek = 0;
        String conv = "";
        String value = "";
        for (int i = 0; i < word.length; i++) {
            start = i;
            end = i;
            if (isalnum(word[i])) {
                while (isalnum(word[end])) {
                    peek = end + 1;
                    if (!isalnum(word[peek]) && (word[peek] != '\0')) {
                        break;
                    } else {
                        end++;
                    }
                }
                conv = String.valueOf(word[i]);
                value = conv.substring(start, peek - start);
                if (check(value, Keyword)) {
                    System.out.println(value + " - is a keyword" );
                } else {
                    System.out.println(value + " - is an Identifier" );
                }
            } else {
                while (!isalnum(word[end])) {
                    peek = end;
                    if ((word[peek] != '\0')) {
                        break;
                    } else {
                        end++;
                    }
                }
                value = conv.substring(start, 1);
                if (check(value, Punctuator)) {
                    System.out.println(value + " - is a Punctuator" );
                } else if (check(value, Operator)) {
                    System.out.println(value + " - is an Operator" );
                } else {
                    System.out.println(value + " -  does not exist" );
                }
            }
            i = end;
        }
    }
}
