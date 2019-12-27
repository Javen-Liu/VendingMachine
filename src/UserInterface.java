import java.util.Scanner;

/**
 * @author 刘建雯
 */

public class UserInterface {
    private Service service;

    public UserInterface(Service service){
        this.service = service;
    }

    public void startUp(){
        System.out.println("[ welcome to the vending machine system ]");
        while(true){
            System.out.println("[ what do you want to do next? ]");
            System.out.println("  1.login");
            System.out.println("  2.shop");
            System.out.println("  3.quit");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input){
                case 1: this.loginPage();
                    break;
                case 2: this.shopPage();
                    break;
                case 3:
                    System.out.println("[ see you next time! ]");
                    return;
                default:
                    System.out.println("[ wrong input! ]");
                    break;
            }
        }
    }

    public void loginPage(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("[ Login ( input 0 to quit) ]");
            System.out.println(" please input username:");
            String username = scanner.nextLine();
            if(Integer.parseInt(username) == 0){
                return;
            }
            System.out.println(" please input password:");
            String password = scanner.nextLine();
            if(Integer.parseInt(password) == 0){
                return;
            }
            boolean check = service.checkForLogin(username,password);
            if(check){
                this.managePage();
            }else{
                System.out.println(" sorry username or password is wrong");
            }
            return;
        }
    }

    public void shopPage(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("[ welcome to vending machine for shopping ]");
        while(true){
            System.out.println("[ what do you want to do next? ]");
            System.out.println("  1. check for the merchandise");
            System.out.println("  2. set merchandise to shopping cart");
            System.out.println("  3. buy merchandise directly");
            System.out.println("  4. check on shopping cart");
            System.out.println("  5. quit");
            int nextStep = scanner.nextInt();
            if(!"12345".contains(String.valueOf(nextStep))){
                System.out.println("[ wrong input ]");
                continue;
            }
            switch (nextStep){
                case 1:
                    this.showMerchandise();
                    break;
                case 2:
                    System.out.println("[ please input merchandise number you wanna buy ]");
                    int merchandiseNum = scanner.nextInt();
                    if(service.checkForMerchandise(merchandiseNum-1)){
                        service.setMerchandiseToShoppingCart(merchandiseNum-1);
                        System.out.println("[ set successfully! ]");
                        System.out.println();
                    }else{
                        System.out.println("[ sorry, this merchandise has sold out ]");
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("[ please input merchandise number you wanna buy ]");
                    int merchan = scanner.nextInt();
                    if(service.checkForMerchandise(merchan-1)){
                        System.out.println("[ buy successfully ]");
                        System.out.println();
                        service.buyMerchandise(merchan-1);
                    }else {
                        System.out.println("[ sorry, this merchandise has sold out ]");
                        System.out.println();
                    }
                    break;
                case 4:
                    this.intoShoppingCart();
                    break;
                default:
                    System.out.println("[ see you next time ]");
                    return;
            }
        }
    }

    public void managePage(){
        Scanner scanner =new Scanner(System.in);
        while(true){
            System.out.println("[ what do you want to do? ]");
            System.out.println("  1. check for merchandise");
            System.out.println("  2. add merchandise");
            System.out.println("  3. delete merchandise");
            System.out.println("  4. quit");
            int nextStep = scanner.nextInt();
            if("1234".contains(String.valueOf(nextStep))){
                switch (nextStep){
                    case 1:
                        this.showMerchandise();
                        break;
                    case 2:
                        System.out.println("please input merchandise name:");
                        scanner.nextLine();
                        String merchandiseName = scanner.nextLine();
                        System.out.println("please input merchandise quantity:");
                        int merchandiseQuantity = scanner.nextInt();
                        System.out.println("please input merchandise price:");
                        double merchandisePrice = scanner.nextDouble();
                        service.addMerchandise(merchandiseName,merchandiseQuantity,merchandisePrice);
                        break;
                    case 3:
                        System.out.println("please input the number of merchandise you want to delete");
                        int deleteMerchandise = scanner.nextInt();
                        service.deleteMerchandise(deleteMerchandise);
                        break;
                    default:
                        return;
                }
            }else {
                System.out.println("[ wrong input ]");
            }
        }
    }

    public void showMerchandise(){
        String[] merchandise = service.showMerchandise();
        String[] merchandiseInfo;
        int length = merchandise.length;
        String[] merchandiseName = new String[length];
        int[] merchandiseQuantity = new int[length];
        double[] merchandisePrice = new double[length];
        for (int i = 0; i < merchandise.length; i++) {
            merchandiseInfo = merchandise[i].split("-");
            merchandiseName[i] = merchandiseInfo[0];
            merchandiseQuantity[i] = Integer.parseInt(merchandiseInfo[1]);
            merchandisePrice[i] = Double.parseDouble(merchandiseInfo[2]);
        }
        for (int i = 0; i < merchandiseName.length; i++) {
            System.out.println("[ "+(i+1)+". "+merchandiseName[i]+" ]  quantity: "+merchandiseQuantity[i]+"  price: "+merchandisePrice[i]);
        }
        System.out.println();
    }

    public void intoShoppingCart(){
        Scanner scanner = new Scanner(System.in);
        String[] merchanName = service.getShoppingCartName();
        int[] merchanQuantity = service.getShoppingCartNum();
        while(true){
            if(!service.checkShoppingCartIsEmpty()){
                for (int i = 0; i < merchanName.length; i++) {
                    System.out.println("[ "+(i+1)+". "+merchanName[i]+" ] : "+merchanQuantity[i]);
                }
                System.out.println("[ what do you want to do next? ]");
                System.out.println("  1. settle account");
                System.out.println("  2. delete merchandise from shopping cart");
                System.out.println("  3. quit");
                int nextStep = scanner.nextInt();
                if("123".contains(String.valueOf(nextStep))){
                    switch (nextStep){
                        case 1:
                            double sum = service.settleAccount();
                            System.out.println("[ buy successfully! ]");
                            System.out.println("[ totally "+sum+" yuan ]");
                            return;
                        case 2:
                            System.out.println(" please input number of merchandise:");
                            int nextMerchan = scanner.nextInt();
                            if(nextMerchan>0 && nextMerchan<merchanName.length){
                                service.deleteMerchandiseFromShoppingCart(nextMerchan-1);
                            }
                            return;
                        default:
                            return;
                    }
                }
            }else{
                while(true){
                    System.out.println("[ shopping cart is empty ]");
                    System.out.println("[ please input \"0\" to quit ]");
                    int next = scanner.nextInt();
                    if (next == 0){
                        return;
                    }
                }
            }
        }
    }
}
