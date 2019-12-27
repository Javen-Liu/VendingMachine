# VendingMachine(自动售货机)

## 该系统分为了三层，分别为：UserInterface、Service、DataBase

## 1.UserInterface

 * 该层作为面向用户的界面，由于没有学习swing，而且现在基本也不太用得上，所以就没用GUI
 * 该层主要是给用户输出内容选项，其与Service层进行数据的传输

## 2.Service

 * 该层主要来进行业务逻辑操作，连接在UserInterface与DataBase之间，提供逻辑服务
 * 主要操作在Service层来操作，并将信息数据打包发给UserInterface层

## 3.DataBase

 * 该层作为数据层，用来存放数据，并且保证了只有Service层才可以操作
 * 其储存了商品信息以及购物车信息

## 4.辅助类

 * merchandise类为商品类，用于保存商品名称、数量以及价格

## 5.购物车类

 * 用于保存购物车信息

## 6.三大层之间的接口类

 * 三大层之间有两个接口层，分别为UserInterface与Service之间接口，以及Service与DataBase之间接口
 * 接口规定了每个层所能做到的操作

