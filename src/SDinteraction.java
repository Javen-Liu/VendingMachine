import java.util.ArrayList;

/**
 * @author 刘建雯
 */

public interface SDinteraction {
    /**
     * 检查登陆是否正确
     * @param username  用户名
     * @param password  密码
     * @return  用户名和密码是否正确
     */
    public boolean checkForLogin(String username, String password);

    /**
     * 获取商品清单的商品名称
     * @return  储存商品名称的ArrayList
     */
    public ArrayList<String> getMerchandiseName();

    /**
     * 获取商品清单中商品数量
     * @return  储存商品数量的ArrayList
     */
    public ArrayList<Integer> getMerchandiseQuantity();

    /**
     * 获取商品清单中商品单价
     * @return  储存商品价格的ArrayList
     */
    public ArrayList<Double> getMerchandisePrice();

    /**
     * 向商品清单中添加商品以及数量和单价
     * @param merchandiseName   商品名称
     * @param merchandiseQuantity   商品数量
     * @param merchandisePrice  商品价格
     */
    public void addMerchandise(String merchandiseName, int merchandiseQuantity, double merchandisePrice);

    /**
     * 从商品清单中删除指定商品
     * @param deleteMerchandise     商品编号
     */
    public void deleteMerchandise(int deleteMerchandise);

    /**
     * 将指定编号商品放入购物车
     * @param merchanNum    商品编号
     */
    public void setMerchandiseToShoppingCart(int merchanNum);

    /**
     * 获取购物车中商品名称
     * @return  购物车中商品名称的ArrayList
     */
    public ArrayList<String> getShoppingCartMerchandiseName();

    /**
     * 获取购物车中商品数量
     * @return  购物车中商品数量的ArrayList
     */
    public ArrayList<Integer> getShoppingCartMerchandiseQuantity();

    /**
     * 从购物车中删除指定商品
     * @param num   商品编号
     */
    public void deleteMerchandiseFromShoppingCart(int num);

    /**
     * 获得商品的单价
     * @param merchandiseName   商品名称
     * @return  商品的单价
     */
    public double getPrice(String merchandiseName);

    /**
     * 商品数量减一
     * @param num   商品编号
     */
    public void reduceQuantity(int num);

    /**
     * 商品减一
     * @param merchandiseName   商品名称
     */
    public void reduceQuantity(String merchandiseName);

    /**
     * 清空购物车
     */
    public void clearShoppingCart();
}
