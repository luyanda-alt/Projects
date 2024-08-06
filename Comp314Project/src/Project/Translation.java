// Mvelo, Luyanda, Innocent

package Project;

public class Translation {

    private enum State {
        START, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20,
        Phe, Leu, Ser, Tyr, Stop, Csy, Trp, Pro, His, Gin, Ars, Met,
        lle, Thr, Arg, Asn, Lys, Asp, Glu, Gly, Ala, Val;
    }

    private State currentState;
    private State TEMP;

    public Translation() {
        currentState = State.START;
    }

    // FSM for prefix of condons from a RNA
    public String prefix(String s) {

        for (int i = 0; i < 3; i++) {
            switch (currentState) {
                case START:
                    if (s.charAt(i) == 'U') {
                        currentState = State.q1;
                    } else if (s.charAt(i) == 'C') {
                        currentState = State.q6;
                    } else if (s.charAt(i) == 'A') {
                        currentState = State.q11;
                    } else if (s.charAt(i) == 'G') {
                        currentState = State.q16;
                    }
                    break;
                //U TRANSIONS
                case q1:

                    if (s.charAt(i) == 'U') {
                        currentState = State.q2;

                    } else if (s.charAt(i) == 'C') {
                        currentState = State.q3;

                    } else if (s.charAt(i) == 'A') {
                        currentState = State.q4;

                    } else if (s.charAt(i) == 'G') {
                        currentState = State.q5;

                    }
                    break;
                case q2:

                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G') {
                        currentState = State.Leu;

                    } else if (s.charAt(i) == 'U' || s.charAt(i) == 'C') {
                        currentState = State.Phe;

                    }
                    break;
                case q3:
                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G' || s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Ser;

                    }
                    break;
                case q4:
                    if (s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Tyr;
                    } else if (s.charAt(i) == 'A' || s.charAt(i) == 'G') {
                        currentState = State.Stop;
                    }
                    break;

                case q5:
                    if (s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Csy;
                    } else if (s.charAt(i) == 'G') {
                        currentState = State.Trp;
                    } else {
                        currentState = State.Stop;
                    }
                    break;
                //END OF U TRANSITION
                // start of C
                case q6:

                    if (s.charAt(i) == 'U') {
                        currentState = State.q7;

                    } else if (s.charAt(i) == 'C') {
                        currentState = State.q8;

                    } else if (s.charAt(i) == 'A') {
                        currentState = State.q9;

                    } else if (s.charAt(i) == 'G') {
                        currentState = State.q10;

                    }
                    break;
                case q7:

                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G' || s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Leu;
                    }
                    break;
                case q8:

                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G' || s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Pro;
                    }
                    break;
                case q9:

                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G') {
                        currentState = State.Gin;
                    } else if (s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.His;
                    }
                    break;
                case q10:
                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G' || s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Ars;
                    }

                    break;
                //end of C
                case q11:

                    if (s.charAt(i) == 'U') {
                        currentState = State.q12;

                    } else if (s.charAt(i) == 'C') {
                        currentState = State.q13;

                    } else if (s.charAt(i) == 'A') {
                        currentState = State.q15;

                    } else if (s.charAt(i) == 'G') {
                        currentState = State.q14;

                    }
                    break;
                case q12:

                    if (s.charAt(i) == 'A' || s.charAt(i) == 'U' || s.charAt(i) == 'C') {
                        currentState = State.lle;
                    } else if (s.charAt(i) == 'G') {
                        currentState = State.Met;
                    }
                    break;
                case q13:
                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G' || s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Thr;
                    }
                    break;
                case q14:

                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G') {
                        currentState = State.Ars;
                    } else if (s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Ser;
                    }
                    break;
                case q15:

                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G') {
                        currentState = State.Lys;
                    } else if (s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Asn;
                    }
                    break;
                //end A
                case q16:

                    if (s.charAt(i) == 'U') {
                        currentState = State.q17;

                    } else if (s.charAt(i) == 'C') {
                        currentState = State.q18;

                    } else if (s.charAt(i) == 'A') {
                        currentState = State.q20;

                    } else if (s.charAt(i) == 'G') {
                        currentState = State.q19;

                    }
                    break;
                case q17:
                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G' || s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Val;
                    }
                    break;
                case q18:
                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G' || s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Ala;
                    }
                    break;
                case q19:
                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G' || s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Gly;
                    }
                    break;
                case q20:
                    if (s.charAt(i) == 'A' || s.charAt(i) == 'G') {
                        currentState = State.Glu;
                    } else if (s.charAt(i) == 'C' || s.charAt(i) == 'U') {
                        currentState = State.Asp;
                    }
                    break;

            }

        }
        TEMP = currentState;
        currentState = State.START;
        return TEMP.toString();
    }

    public String print(String s) {
        String res = "";
        int crack = 0;
        while (crack + 2 < s.length()) {
            res = res + s.substring(crack, crack + 3) + "        :   " + prefix(s.substring(crack, crack + 3)) + "\n";
            crack = crack + 3;

        }
        return res;
    }
}
