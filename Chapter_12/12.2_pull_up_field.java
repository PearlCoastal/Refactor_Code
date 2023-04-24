/*
 * @Author: FEIFEI SUN
 * @Description: 12.2 字段上移
 * @Detail: 如果子类的字段中有重复的近似的名字，使用的方式也近似，可以提升到超类中
 * @Date: 2023-04-23 15:17:15
 *
 */

/***
 * 重构前
 */
class Employee
{
    ...
}

class Salesman extends Employee
{
private
    String name;
}

class Engineer extends Employee
{
private
    String name;
}

/***
 * 重构后
 */
class Employee
{
protected
    String name; // 将name字段上移
}

class Salesman extends Employee
{
    ...
}

class Engineer extends Employee
{
    ...
}
