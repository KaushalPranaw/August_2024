package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
       int m=matrix.length;
       int n=matrix[0].length;
       List<Integer> ans=new ArrayList<>();
       int l=0, r=n-1, u=0, d=m-1;
       while (l<=r && u<=d){
           //l->r and u constant
           for(int i=l;i<=r;i++){
               ans.add(matrix[u][i]);
           }
           u++;

           //u->d and r is constant
           for(int i=u;i<=d;i++){
               ans.add(matrix[i][r]);
           }
           r--;

           if(u<=d){
               //r->l and d is constant
               for(int i=r;i>=l;i--){
                   ans.add(matrix[d][i]);
               }
               d--;
           }

           if(l<=r){
               //d->u and l constant
               for(int i=d;i>=u;i--){
                   ans.add(matrix[i][l]);
               }
               l++;
           }
       }
       return ans;


    }

}
