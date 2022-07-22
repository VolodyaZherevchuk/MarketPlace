import java.util.*;
import java.util.stream.Collectors;

public class MarketPlace {
        static  Map<String, List<String>> historyPurchaseUser = new HashMap<>();
        public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            Products products = new Products();
            Users users = new Users();

            boolean flag = true;
            while (flag){
                System.out.println("\n\n   Menu");
                System.out.println("1. Display list of all users");
                System.out.println("2. Display list of all products");
                System.out.println("3. Buying a product");
                System.out.println("4. Display list of user products");
                System.out.println("5. Display list of users that bought product");
                System.out.println("6. Exit");
                System.out.print("===============> ");

                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        users.displayListOfAllUsers();
                        break;
                    case 2:
                        products.displayListOfAllProducts();
                        break;
                    case 3:
                        int[] array = users.buyingProduct(products);
                        if (array[0] > -1 && array[1] > -1) {
                            put(historyPurchaseUser, users.returnName(array[0]), products.returnNameProduct(array[1]));
                            //historyPurchaseUser.put(array[0], array[1]);
                            int a=1;

                        }
                        break;
                    case 4:
                        displayListOfUserProducts(products4);
                        break;
                    case 5:
                        break;
                    case 6:
                        flag = false;
                        break;

                }

            }
        }

        public static void displayListOfUserProducts (Products products){

            Scanner scanner = new Scanner(System.in);

            System.out.print("Input Id user ==> ");
            int idU = scanner.nextInt();
            int indexIdUser = products.returnIndex(idU);
            if (indexIdUser < 0){
                System.out.println("User id - " + idU + " not found");
            } else {
                historyPurchaseUser.forEach((s, strings) -> {
                    System.out.print(s + ": ");
                    System.out.println(strings.stream().collect(Collectors.joining(", ")));
                });
            }

        }

    private static <KEY, VALUE> void put(Map<KEY, List<VALUE>> map, KEY key, VALUE value) {
        map.compute(key, (s, strings) -> strings == null ? new ArrayList<>() : strings).add(value);
    }
}

class Products {
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

class Users {
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

        System.out.print("Input Id user ==> ");
        int idU = scanner.nextInt();
        int indexIdUser = returnIndex(idU);
        if (indexIdUser < 0){
            System.out.println("User id - " + idU + " not found");
            result[0] =-1;
            return result;
        } else {
            result[0] = indexIdUser;
        }

        System.out.print("Input Id product ==> ");
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
            System.out.println("User " + nameFirst[indexIdUser] +" does not have enough money");
        } else {
            System.out.println("User " + nameFirst[indexIdUser] + " to buy " + products.returnNameProduct(indexIdProduct));
            amountOfMoney[indexIdUser] -= price;
        }
        return result;
    }


}