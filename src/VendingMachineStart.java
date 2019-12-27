/**
 * @author 刘建雯
 */

public class VendingMachineStart {
    public static void main(String[] args) {
        VendingMachineStart.initiate();
    }

    private static void initiate(){
        DataBase dataBase = new DataBase();
        Service service = new Service(dataBase);
        UserInterface userInterface = new UserInterface(service);
        userInterface.startUp();
    }
}
