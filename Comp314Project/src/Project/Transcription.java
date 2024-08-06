package Project;

public class Transcription {

    private static final char[] NUCLEOTIDES = {'A', 'T', 'G', 'C'};

    public static String generateRNA(String S) {
        String DNA = S.toUpperCase();
        StringBuilder RNA = new StringBuilder();

        for (int i = 0; i < DNA.length(); i++) {
            char nucleotide = DNA.charAt(i);
            char rnaNucleotide;

            if (nucleotide == 'A') {
                rnaNucleotide = 'U';
            } else if (nucleotide == 'T') {
                rnaNucleotide = 'A';
            } else if (nucleotide == 'G') {
                rnaNucleotide = 'C';
            } else if (nucleotide == 'C') {
                rnaNucleotide = 'G';
            } else {
                System.out.println("Invalid nucleotide found: " + nucleotide);
                return ""; // Return empty string for invalid input
            }

            RNA.append(rnaNucleotide);
        }

        return RNA.toString();
    }

    public static boolean compareStrands(String DNA, String RNA) {
        String generatedRNA = generateRNA(DNA);
        return generatedRNA.equals(RNA);
    }
}
