import java.util.Random;
import java.util.Vector;

public class CubeClass {
    private int width;
    private boolean[][][] arr;
    private Vector<Vector3> list = new Vector<Vector3>();
    public CubeClass(int width){
        this.width = width;
        init();
    }
    private void init(){
        arr = new boolean[width][width][width];
        Random rnd = new Random();
        for(int i = 0; i<width; i++){
            for(int j = 0; j<width; j++){
                for(int k = 0; k<width; k++){
                    arr[i][j][k] = rnd.nextBoolean();
                }
            }
        }
    }
    public void show(){
        for(Vector3 v:list){
            System.out.println(v);
        }
    }
    public void findHole(){
        for(int x = 0; x<width; x++){
            for(int y = 0; y<width; y++){
                for(int z = 0; z<width; z++){
                    int count = 0;
                    for(int xx = 0; xx<width; xx++){
                        if(!arr[xx][y][z]){
                            count++;
                        }
                    }
                    if(count == width){
                        if(x == 0 || y == 0 || z == 0){
                            list.add(new Vector3(x, y, z));
                        }
                    }
                    count = 0;
                    for(int yy = 0; yy<width; yy++){
                        if(!arr[x][yy][z]){
                            count++;
                        }
                    }
                    if(count == width){
                        if(x == 0 || y == 0 || z == 0){
                            list.add(new Vector3(x, y, z));
                        }
                    }

                    count = 0;
                    for(int zz = 0; zz<width; zz++){
                        if(!arr[x][y][zz]){
                            count++;
                        }
                    }
                    if(count == width){
                        if(x == 0 || y == 0 || z == 0){
                            list.add(new Vector3(x, y, z));
                        }
                    }
                }
            }
        }
    }
}
