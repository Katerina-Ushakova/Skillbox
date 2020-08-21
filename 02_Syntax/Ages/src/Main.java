import jdk.jshell.VarSnippet;

public class Main
{
    public static void main (String[] args) {
        int vasyaAge = 18;
        int katyaAge = 22;
        int mishaAge = 35;

        int min = 0;
        int middle = 0;
        int max = 0;
        // max
        if (vasyaAge > katyaAge && vasyaAge > mishaAge) {
            max = vasyaAge;
        }
        if (katyaAge > mishaAge && katyaAge > vasyaAge) {
            max = katyaAge;
        }
        if (mishaAge > katyaAge && mishaAge > vasyaAge) {
            max = mishaAge;
        }
        System.out.println("Maximum age:" + max);


        //min
        if (vasyaAge < katyaAge && vasyaAge < mishaAge) {
            min = vasyaAge;
        }
        if (katyaAge < mishaAge && katyaAge < vasyaAge) {
            min = katyaAge;
        }
        if (mishaAge < vasyaAge && mishaAge < katyaAge) {
            min = mishaAge;
        }
        System.out.println("Minimal age:" + min);


        //middle
        if (vasyaAge > katyaAge && vasyaAge < mishaAge) {
            middle = vasyaAge;
        }
         else if (katyaAge > vasyaAge && katyaAge < mishaAge) {
            middle = katyaAge;
            }
         else
             middle = mishaAge;
         System.out.println("Middle age:" + middle);
    }
}
