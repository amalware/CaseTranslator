public class Main {
    /**
     * @author Amal Suleiman
     * Challenge published Helen Yu on edabit
     * Convert from camelCasing to snakeCasing and vice versa
     * I am also extending this challenge by adding a gui, however, these features will be added later
     */
    public static void main(String[] args){
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(to_Snake_Case("helloEdabit"));
    }
    public static String toCamelCase(String snake_casing){

        //Seperate terms
        String[] split_terms = snake_casing.split("_");
        String[] splitTerms = new String[split_terms.length];

        splitTerms[0] = split_terms[0].toLowerCase(); //Since first term will remain lowercase, we can enter it as is

        //Captialize first letter of each remaining term
        for(int i = 1; i<= split_terms.length-1;i++) {
            if (!split_terms[i].isEmpty()) { //Does the term have at least 1 character?
                String firstLetter = split_terms[i].substring(0, 1).toUpperCase(); //Get first letter, captialize it
                String remainingLetters = split_terms[i].substring(1); //Get remaining letters

                String newTerm = String.join("", firstLetter, remainingLetters);
                splitTerms[i] = newTerm;
            }
        }

        String camelCase = "";
        for (String term: splitTerms){ //Output shold not have nulls or spaces
            if (term != null && !term.isEmpty()) { camelCase += term; }
        }

        return camelCase;
    }
    public static String to_Snake_Case(String camelCasing){

        //Seperate terms
        String[] splitTerms = camelCasing.split("(?=[A-Z])"); //THIS IS CALLED A LOOKAHEAD- IT ALLOWS ME TO KEEP THE DELIMITER (split value) WHEN SPLITTING STRING. THIS ONE SPECIFICALLY KEEPS THE CAPITAL LETTER
        String[] split_terms = new String[splitTerms.length];

        //Make first letter lowercase
        for(int i = 0; i<= splitTerms.length-1;i++){
            split_terms[i] = splitTerms[i].toLowerCase(); //lol just lowercase everything. no need to split into first or remaining letters. Also, since all the terms should be lowercase, just throw in the first [index 0] element
        }

        return String.join("_", split_terms);
    }

}

