package com.meapps.abc2num;

public final class ABC2NumCore {
    public static int adc2Num(String letter) {
        int result = 0;
        for (int now=0; now < letter.length(); now++) {
            switch (letter.substring(now, now + 1)) {

                case "A":
                    result += 1;
                    break;
                case "B":
                    result += 2;
                    break;
                case "C":
                    result += 3;
                    break;
                case "D":
                    result += 4;
                    break;
                case "E":
                    result += 5;
                    break;
                case "F":
                    result += 6;
                    break;
                case "G":
                    result += 7;
                    break;
                case "H":
                    result += 8;
                    break;
                case "I":
                    result += 9;
                    break;
                case "J":
                    result += 10;
                    break;
                case "K":
                    result += 11;
                    break;
                case "L":
                    result += 12;
                    break;
                case "M":
                    result += 13;
                    break;
                case "N":
                    result += 14;
                    break;
                case "O":
                    result += 15;
                    break;
                case "P":
                    result += 16;
                    break;
                case "Q":
                    result += 17;
                    break;
                case "R":
                    result += 18;
                    break;
                case "S":
                    result += 19;
                    break;
                case "T":
                    result += 20;
                    break;
                case "U":
                    result += 21;
                    break;
                case "V":
                    result += 22;
                    break;
                case "W":
                    result += 23;
                    break;
                case "X":
                    result += 24;
                    break;
                case "Y":
                    result += 25;
                    break;
                case "Z":
                    result += 26;
                    break;
                case " ":
                case ",":
                case ".":
                case "?":
                case "!":
                case "\"":
                default:
                    break;
            }
        }
        return result;
    }
}
