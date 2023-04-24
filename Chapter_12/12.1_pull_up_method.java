/*
 * @Author: FEIFEI SUN
 * @Description: 12.1 函数上移
 * @Detail: 避免重复代码，如果某个函数在各个子类中的函数体都相同，就应该上移
 * @Date: 2023-04-23 15:07:50
 *
 */

/***
 * Employee 和 Department 重复实现了 annualCost行为的函数，函数上移到超类
 */

class Employee extends Party
{
    get annualCost() { return this.monthlyCost * 12; }
}

class Department extends Party
{
    get totalAnnualCost() { return this.monthlyCost * 12; }
}

/***
 * STEP1. 用改变函数声明来统一他们的函数名
 */
class Department extends Party
{
    get annualCost() { return this.monthlyCost * 12; }
}

/***
 * STEP2. 从其中一个子类中将annualCost函数复制到超类Party中
 */
class Party
{
    get annualCost() { return this.monthlyCost * 12; }
}