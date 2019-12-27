/**
 * @author 刘建雯
 */

public interface ISinteraction {
    /**
     * 检查登陆用户名和密码是否正确
     * @param username  用户名
     * @param password  密码
     * @return  用户名和密码是否正确
     */
    public boolean checkForLogin(String username,String password);

    /**
     * 获取商品相关信息
     * @return  商品名称、数量以及单价信息的字符串
     */
    public String[] showMerchandise();

    /**
     * 向商品清单里添加商品
     * @param merchandiseName   商品名称
     * @param merchandiseQuantity   商品数量
     * @param merchandisePrice  商品单价
     */
    public void addMerchandise(String merchandiseName,int merchandiseQuantity,double merchandisePrice);

    /**
     * 从商品清单中删除指定商品
     * @param deleteMerchandise     指定商品编号
     */
    public void deleteMerchandise(int deleteMerchandise);

    /**
     * 将商品放入购物车
     * @param merchanNum    指定商品编号
     */
    public void setMerchandiseToShoppingCart(int merchanNum);

    /**
     * 检查商品是否还有
     * @param merchan   指定商品编号
     * @return  商品是否还有
     */
    public boolean checkForMerchandise(int merchan);

    /**
     * 检查购物车是否是空的
     * @return  商品是否是空的
     */
    public boolean checkShoppingCartIsEmpty();

    /**
     * 获取购物车里商品名称
     * @return  购物车里商品名称的String[]数组
     */
    public String[] getShoppingCartName();

    /**
     * 获取购物车里商品数量
     * @return  购物车里商品数量的int[]数组
     */
    public int[] getShoppingCartNum();

    /**
     * 结账
     * @return  购物车中商品总价
     */
    public double settleAccount();

    /**
     * 从购物车删除指定商品
     * @param num   指定商品编号
     */
    public void deleteMerchandiseFromShoppingCart(int num);

    /**
     * 直接购买商品
     * @param num   商品编号
     */
    public void buyMerchandise(int num);
}
