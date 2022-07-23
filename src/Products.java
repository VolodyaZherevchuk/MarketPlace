import java.util.Arrays;

public class Products {
    int[] idProduct = {1, 2, 3};
    String[] name = {"Acer", "ASUS", "Lenovo"};
    float[] price = {29999.99f, 22999.99f, 16999.99f};
    public void displayListOfAllProducts() {
        System.out.println("\nlist of all products");
        for (int i = 0; i <3; i++) {
            System.out.println(idProduct[i] + " " + name[i] + " " + price[i]);
        }
    }
    public float ReturnPrice(int id){
        return price[id];
    }

    public  String returnNameProduct(int id){
        return name[id];
    }

    public int returnIndex(int id){
        return Arrays.binarySearch(idProduct, id);
    }
}
