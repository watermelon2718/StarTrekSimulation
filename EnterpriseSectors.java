import java.util.Arrays;
import java.util.Random;

public class EnterpriseSectors {
    public static enum Loyalty {FDERATN, ROMULAN, KLINGON, FERENGI, UNALGND};
    private static Loyalty[] loyalties = {Loyalty.FDERATN, Loyalty.ROMULAN, Loyalty.KLINGON, Loyalty.FERENGI, Loyalty.UNALGND};
    //represents war/peace state of sector

    private static EnterpriseSectors[][] starMap;
    private Loyalty loyalty;
    private boolean safe;
    private static Random generator = new Random();

    public EnterpriseSectors(Loyalty loyalty) {
        this.safe = generator.nextBoolean();
        this.loyalty = loyalty;
    }
    //loop through sectors, each row/column, return loyalty and status (t/f)

    public static void createStarMap(int xBound, int yBound) {
        //create starmap
        //assign to starMap
        starMap = new EnterpriseSectors[xBound][yBound];
        
        for (int i = 0; i < starMap.length; i++) {
            for (int j = 0; j < starMap[i].length; j++) {
                starMap[i][j] = new EnterpriseSectors(loyalties[generator.nextInt(loyalties.length)]);
            }
        }

    }

    public static EnterpriseSectors[][] getStarMap() {
        EnterpriseSectors[][] starMapCopy = Arrays.copyOf(starMap, starMap.length);
        return starMapCopy;
    }

    public static String starMapToString() {
        String starMapDescription = "";

        for(int i = 0; i < starMap.length; i++) {
            for(int j = 0; j < starMap[i].length; j++) {
                starMapDescription += "\t\t";
                starMapDescription += starMap[i][j].loyalty; 
            }
            starMapDescription += "\n\n";
        }

        return starMapDescription;
    }

    public String toString() {
        return loyalty.toString();
    }
}
