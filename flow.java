
/**
 * This is where the information of the pipe network is
 * it also contains the flow algorythm
 *
 * @author Juan
 * @version 0.1
 */

public class flow
{
    public int GRIDSIZE = 10;
    public int currentgrid [] [] = new int [GRIDSIZE] [GRIDSIZE];
    flow(){
        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                currentgrid [x] [y] = 0;
            }
        }
    }
    //currentgrid [3] [4] = 3;


}
