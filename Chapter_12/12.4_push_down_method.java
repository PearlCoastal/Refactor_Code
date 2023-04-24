/*
 * @Author: FEIFEI SUN
 * @Description: 12.4 函数下移
 * @Detail: 超类中的某个函数置于一个or少数几个子类有关，最好将其从超类中挪走，放到真正关心他的子类中去
 * @Date: 2023-04-23 15:32:00
 *
 */

class Employee
{
    get quota { ... }
}

class Engineer extends Employee
{
    ...
}

class Salesman extends Employee
{
    ...
}

/***
 * 将quota方法下移
 */

class Employee
{
    ...
}

class Engineer extends Employee
{
    ...
}

class Salesman extends Employee
{
    get quota { ... }
}
