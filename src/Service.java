import java.util.ArrayList;

/**
 * @author 刘建雯
 */

public class Service implements ISinteraction {
    private DataBase dataBase;

    public Service(DataBase dataBase){
        this.dataBase = dataBase;
    }

    @Override
    public boolean checkForLogin(String username, String password) {
        return dataBase.checkForLogin(username,password);
    }

    @Override
    public String[] showMerchandise() {
        ArrayList<String> merchandiseName = dataBase.getMerchandiseName();
        ArrayList<Integer> merchandiseQuantity = dataBase.getMerchandiseQuantity();
        ArrayList<Double> merchandisePrice = dataBase.getMerchandisePrice();
        int size = merchandiseName.size();
        String[] merchandiseInfo = new String[size];
        for (int i = 0; i < size; i++) {
            merchandiseInfo[i] = merchandiseName.get(i)+"-"+merchandiseQuantity.get(i)+"-"+merchandisePrice.get(i);
        }
        return merchandiseInfo;
    }

    @Override
    public void addMerchandise(String merchandiseName, int merchandiseQuantity, double merchandisePrice) {
        dataBase.addMerchandise(merchandiseName, merchandiseQuantity, merchandisePrice);
    }

    @Override
    public void deleteMerchandise(int deleteMerchandise) {
        dataBase.deleteMerchandise(deleteMerchandise);
    }

    @Override
    public void setMerchandiseToShoppingCart(int merchanNum) {
        dataBase.setMerchandiseToShoppingCart(merchanNum);
    }

    @Override
    public boolean checkForMerchandise(int merchan) {
        ArrayList<Integer> quantity = dataBase.getMerchandiseQuantity();
        return quantity.get(merchan)>0 ;
    }

    @Override
    public boolean checkShoppingCartIsEmpty() {
        return dataBase.getShoppingCartMerchandiseQuantity().size() <= 0 ;
    }

    @Override
    public String[] getShoppingCartName() {
        ArrayList<String > shoppingCartName = dataBase.getShoppingCartMerchandiseName();
        return shoppingCartName.toArray(new String[0]);
    }

    @Override
    public int[] getShoppingCartNum() {
        ArrayList<Integer> shoppingCartQuantity = dataBase.getShoppingCartMerchandiseQuantity();
        int size = shoppingCartQuantity.size();
        int[] number = new int[size];
        for (int i = 0; i < size; i++) {
            number[i] = shoppingCartQuantity.get(i);
        }
        return number;
    }

    @Override
    public double settleAccount() {
        ArrayList<String> shoppingCartName = dataBase.getShoppingCartMerchandiseName();
        ArrayList<Integer> number = dataBase.getShoppingCartMerchandiseQuantity();
        double sum = 0;
        for (int i = 0; i < shoppingCartName.size(); i++) {
            sum += dataBase.getPrice(shoppingCartName.get(i))*number.get(i);
            dataBase.reduceQuantity(shoppingCartName.get(i));
        }
        dataBase.clearShoppingCart();
        return sum;
    }

    @Override
    public void deleteMerchandiseFromShoppingCart(int num) {
        dataBase.deleteMerchandiseFromShoppingCart(num);
    }

    @Override
    public void buyMerchandise(int num) {
        dataBase.reduceQuantity(num);
    }
}
