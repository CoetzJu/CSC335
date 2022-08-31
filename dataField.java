public class dataField {
    
    public int GRIDSIZE = 10;
    public int currentgrid [] [] = new int [GRIDSIZE] [GRIDSIZE];

    dataField(){

        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                currentgrid [x] [y] = 0;
            }
        }

    }
    //currentgrid [3] [4] = 3;

}
