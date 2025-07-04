public class Insertion {
    public static void main(String args []){

      int []array={10, 3, 7, 5, 13, 9};
      int n=6;
      int k=3;
    for(int x=1; x<n; x++){
        int tmp=array[x];
     int j = (x < k) ? x - 1 : k - 1;
        while(j>=0 && array[j]>tmp){
            array[j+1]=array[j];
            j=j-1;
        }
        array[j+1]=tmp;
    }
   for(int x=0; x<n; x++){
    System.out.print(array[x]+" ");
   }


    }
}
