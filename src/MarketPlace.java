import java.util.Scanner;

public class MarketPlace {

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
                        break;
                    case 4
                        flag = false;
                        break;
                    case 5:
                        break;
                    case 6:
                        flag = false;
                        break;

                }

            }
        }
}

class Products {
    int[] id = {1, 2, 3};
    String[] name = {"Acer", "ASUS", "Lenovo"};
    float[] price = {29999.99f, 22999.99f, 16999.99f};
    public void displayListOfAllProducts() {
        for (int i = 0; i <3; i++) {
            System.out.println(id[i] + " " + name[i] + " " + price[i]);
        }
    }
}

class Users {
    int[] id = {1, 2 ,3};
    String[] nameFirst = {"Ivan", "Petr", "Vasilij"};
    String[] nameLast = {"Ivanov", "Petrov", "Sidorov"};
    float[] amountOfMoney ={100000.00f, 100000.00f, 100000.00f};

    public void displayListOfAllUsers () {
        System.out.println("list of all users");
        for (int i = 0; i <3; i++) {
            System.out.println(id[i] + " " + nameFirst[i] + " " + nameLast[i] + " " + amountOfMoney[i]);
        }
    }


}