import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 刘建雯
 */

public class DataBase implements SDinteraction{
    private final String username = "1248540980";
    private final String password = "12345";
    private ArrayList<String> merchandiseNameList = new ArrayList<>();
    private ArrayList<Integer> merchandiseQuantityList = new ArrayList<>();
    private ArrayList<Double> merchandisePriceList = new ArrayList<>();
    private MerchandiseShoppingCart shoppingCart = new MerchandiseShoppingCart();

    public DataBase(){
        String[] name = {"Cola","Sprite","Finda"};
        int[] quantity = {10,10,10};
        double[] price = {3,4,2.5};
        merchandiseNameList.addAll(Arrays.asList(name));
        for (int value : quantity) {
            merchandiseQuantityList.add(value);
        }
        for(double value : price){
            merchandisePriceList.add(value);
        }
    }

    public DataBase(String[] name, int[] quantity, double[] price){
        merchandiseNameList.addAll(Arrays.asList(name));
        for (int value : quantity) {
            merchandiseQuantityList.add(value);
        }
        for(double value : price){
            merchandisePriceList.add(value);
        }
    }


    @Override
    public boolean checkForLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public ArrayList<String> getMerchandiseName() {
        return merchandiseNameList;
    }

    @Override
    public ArrayList<Integer> getMerchandiseQuantity() {
        return merchandiseQuantityList;
    }

    @Override
    public ArrayList<Double> getMerchandisePrice() {
        return merchandisePriceList;
    }

    @Override
    public void addMerchandise(String merchandiseName, int merchandiseQuantity, double merchandisePrice) {
        merchandiseNameList.add(merchandiseName);
        merchandiseQuantityList.add(merchandiseQuantity);
        merchandisePriceList.add(merchandisePrice);
    }

    @Override
    public void deleteMerchandise(int deleteMerchandise) {
        merchandiseNameList.remove(deleteMerchandise);
        merchandiseQuantityList.remove(deleteMerchandise);
        merchandisePriceList.remove(deleteMerchandise);
    }

    @Override
    public void setMerchandiseToShoppingCart(int merchanNum) {
        shoppingCart.addIntoCart(merchandiseNameList.get(merchanNum));
    }

    @Override
    public ArrayList<String> getShoppingCartMerchandiseName() {
        return shoppingCart.getShoppingCartName();
    }

    @Override
    public ArrayList<Integer> getShoppingCartMerchandiseQuantity() {
        return shoppingCart.getShoppingCartQuantity();
    }

    @Override
    public void deleteMerchandiseFromShoppingCart(int num) {
        shoppingCart.deleteFromCart(num);
    }

    @Override
    public double getPrice(String merchandiseName) {
        int count = 0;
        for (int i = 0; i < merchandiseNameList.size(); i++) {
            if(merchandiseNameList.get(i).equals(merchandiseName)){
                count = i+1;
                break;
            }
        }
        if(count == 0){
            return 0;
        }else{
            return merchandisePriceList.get(count-1);
        }
    }

    @Override
    public void reduceQuantity(int num) {
        merchandiseQuantityList.set(num,merchandiseQuantityList.get(num)-1);
    }

    @Override
    public void reduceQuantity(String merchandiseName) {
        Integer count = null;
        for (int i = 0; i < merchandiseNameList.size(); i++) {
            if(merchandiseNameList.get(i).equals(merchandiseName)){
                count = i;
                break;
            }
        }
        if(count != null){
            merchandiseQuantityList.set(count,merchandiseQuantityList.get(count)-1);
        }
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
    }
}
