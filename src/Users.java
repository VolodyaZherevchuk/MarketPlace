import java.util.Arrays;
import java.util.Scanner;

public class Users {
    int[] idUser = {1, 2, 3};
    String[] nameFirst = {"Ivan", "Petr", "Vasilij"};
    String[] nameLast = {"Ivanov", "Petrov", "Sidorov"};
    float[] amountOfMoney ={100000.00f, 100000.00f, 100000.00f};

    public void displayListOfAllUsers () {
        System.out.println("\nlist of all users");
        for (int i = 0; i <3; i++) {
            System.out.println(idUser[i] + " " + nameFirst[i] + " " + nameLast[i] + " " + amountOfMoney[i]);
        }
    }


    public int returnIndex(int id){
        return Arrays.binarySearch(idUser, id);
    }

    public String returnName(int id) {
        return nameFirst[id] + " " + nameLast[id];
    }

    public int[] buyingProduct(Products products) {
        int[] result = {0,0};
        Scanner scanner =new Scanner(System.in);

        System.out.print("Input user Id ==> ");
        int idU = scanner.nextInt();
        int indexIdUser = returnIndex(idU);
        if (indexIdUser < 0){
            System.out.println("User id - " + idU + " not found");
            result[0] =-1;
            return result;
        } else {
            result[0] = indexIdUser;
        }

        System.out.print("Input product Id ==> ");
        int idP = scanner.nextInt();
        int indexIdProduct = products.returnIndex(idP);

        if (indexIdProduct < 0 ){
            System.out.println("Product id - " + idP + " not found");
            result[1] =-1;
            return result;
        } else {
            result[1] = indexIdProduct;
        }

        float price = products.ReturnPrice(indexIdProduct);
        if (price > amountOfMoney[indexIdUser]) {
            System.out.println("\nUser " + nameFirst[indexIdUser] +" does not have enough money");
        } else {
            System.out.println("\nUser " + nameFirst[indexIdUser] + " bought " + products.returnNameProduct(indexIdProduct));
            amountOfMoney[indexIdUser] -= price;
        }
        return result;
    }
}