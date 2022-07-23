import java.util.*;
import java.util.stream.Collectors;

public class MarketPlace {
        static  Map<String, List<String>> historyPurchaseUser = new HashMap<>();
        static  Map<String, List<String>> historyPurchaseProduct = new HashMap<>();

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
                            put(historyPurchaseProduct, products.returnNameProduct(array[1]), users.returnName(array[0]));
                        }
                        break;
                    case 4:
                        displayListOfUserProducts(users, products);
                        break;
                    case 5:
                        displayListOfUsersThatBoughtProduct(users, products);
                        break;
                    case 6:
                        flag = false;
                        break;
                }

            }
        }

        public static void displayListOfUserProducts (Users users, Products products){

            Scanner scanner = new Scanner(System.in);

            System.out.print("Input user Id ==> ");
            int idU = scanner.nextInt();
            int indexIdUser = products.returnIndex(idU);
            if (indexIdUser < 0){
                System.out.println("User id - " + idU + " not found");
            } else {
                String user = users.returnName(indexIdUser);
                if (historyPurchaseUser.containsKey(user)) {
                    System.out.print("\n" + user + " products: ");
                    System.out.println(historyPurchaseUser.get(user).stream().collect(Collectors.joining(", ")));
                }
            }
        }

        public static void displayListOfUsersThatBoughtProduct (Users users, Products products) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Input product Id ==> ");
            int idP = scanner.nextInt();
            int indexIdProduct = users.returnIndex(idP);
            if (indexIdProduct < 0){
                System.out.println("Product id - " + idP + " not found");
            } else {
                String product = products.returnNameProduct(indexIdProduct);
                if (historyPurchaseProduct.containsKey(product)) {
                    System.out.print("\n" + product + " was bought by: ");
                    System.out.println(historyPurchaseProduct.get(product).stream().collect(Collectors.joining(", ")));
                }
            }
        }

    private static <KEY, VALUE> void put(Map<KEY, List<VALUE>> map, KEY key, VALUE value) {
        map.compute(key, (s, strings) -> strings == null ? new ArrayList<>() : strings).add(value);
    }
}



