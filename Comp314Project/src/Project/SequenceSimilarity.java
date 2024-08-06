/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Nabeela, Muhammad
package Project;

public class SequenceSimilarity {

    private static enum STATE {
        START, //States of our FSM
        MATCH,
        MISMATCH,
        END
    } //enum is special class used to rep a group of constants

    String DNAseq1, DNAseq2;

    public SequenceSimilarity(String DNAseq1, String DNAseq2) {
        this.DNAseq1 = DNAseq1;
        this.DNAseq2 = DNAseq2;

    }

    public boolean isValidSequence(String sequence) {

        boolean bflag = true;
        String validNucleotides = "ACGTU";//These are the only valid nuceltoides
        for (int i = 0; i < sequence.length(); i++) {
            if (validNucleotides.indexOf(sequence.charAt(i)) == -1) {
                bflag = false;
                break;
            }

        }
        return bflag;

    }

    public void Transition(int i, STATE currState, STATE nextState) {

        currState = nextState;//Transition for FSM
    }

    public double CalcDNASimilarity() {

        int i = 0;

        STATE currentState = STATE.START;

        int noOfMatches = 0;//keeps track of no of nucelotides at same index the same

        while (i < DNAseq1.length() && i < DNAseq2.length()) {
            char nucleotide1 = DNAseq1.charAt(i);
            char nucleotide2 = DNAseq2.charAt(i);
            int t = 0;
            switch (currentState) {

                case START:
                    if (nucleotide1 == nucleotide2) {
                        noOfMatches++;
                        t = 1; //If we find a match then it means we go to match state via 1
                        Transition(t, currentState, STATE.MATCH);
                    } else {
                        t = 0;
                        Transition(t, currentState, STATE.MISMATCH);
                    }
                    break;
                case MATCH:
                    if (nucleotide1 == nucleotide2) {
                        noOfMatches++;
                        t = 1;
                        Transition(t, currentState, STATE.MATCH);
                    } else {
                        t = 0;
                        Transition(t, currentState, STATE.MISMATCH);
                    }
                    break;

                case MISMATCH: //if you currenty at mismatch state
                    if (nucleotide1 == nucleotide2) {
                        noOfMatches++;
                        t = 1;
                        Transition(t, currentState, STATE.MATCH);
                    } else {
                        t = 0;
                        Transition(t, currentState, STATE.MISMATCH);
                    }
                    break;

                case END:
                    break;
            }//END of case
            i++;

        }//end of loop
        //Transition to end state since we finish read
        Transition(0, currentState, STATE.END);

        double similarity = Math.round((2.0 * noOfMatches) / (DNAseq1.length() + DNAseq2.length()) * 100);
        return similarity;
    }

}
