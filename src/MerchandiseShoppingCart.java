import java.util.ArrayList;

public class MerchandiseShoppingCart {
    private ArrayList<String> shoppingCartName;
    private ArrayList<Integer> shoppingCartQuantity;

    public MerchandiseShoppingCart(){
        this.shoppingCartName = new ArrayList<>();
        this.shoppingCartQuantity = new ArrayList<>();
    }

    public ArrayList<String> getShoppingCartName(){
        return shoppingCartName;
    }

    public ArrayList<Integer> getShoppingCartQuantity() {
        return shoppingCartQuantity;
    }

    public void addIntoCart(String name){
        shoppingCartName.add(name);
        shoppingCartQuantity.add(1);
    }

    public void deleteFromCart(int num){
        shoppingCartName.remove(num);
        shoppingCartQuantity.remove(num);
    }

    public void clear(){
        shoppingCartName.clear();
        shoppingCartQuantity.clear();
    }
}
