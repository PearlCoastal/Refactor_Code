/*
 * @Author: FEIFEI SUN
 * @Description: 8.2 搬移字段
 * @Detail: 如果数据结构已经不适应于需求，应该马上修缮
 * @Date: 2023-04-23 15:01:43
 *
 */

/***
 * 重构前
 * 把 discountRate 字段从 Customer 类中搬移到 CustomerContract 中
 */
class Customer
{
    constructor(name, discountRate)
    {
        this._name = name;
        this._discountRate = discountRate;
        this._contract = new CustomerContract(dateToday());
    }
    get discountRate() { return this._discountRate; }
    becomePreferred()
    {
        this._discountRate += 0.03;
        // other nice things
    }
    applyDiscount(amount)
    {
        return amount.subtract(amount.multiply(this._discountRate));
    }
}

class CustomerContract
{
    constructor(startDate)
    {
        this._startDate = startDate;
    }
}

/***
 * STEP1. 封装变量将对 _discountRate字段的访问封装起来
 */
class Customer
{
    constructor(name, discountRate)
    {
        this._name = name;
        this._setDiscountRate(discountRate);
        this._contract = new CustomerContract(dateToday());
    }
    get discountRate() { return this._discountRate; }

    _setDiscountRate(aNumber) { this._discountRate = aNumber; }
    becomePreferred()
    {
        this._setDiscountRate(this.discountRate + 0.03);
        // other nice things
    }
    applyDiscount(amount)
    {
        return amount.subtract(amount.multiply(this.discountRate));
    }
}

// 在 CustomerContract 中添加一个对应的字段和访问函数
class CustomerContract
{
    constructor(startDate, discountRate)
    {
        this._startDate = startDate;
        this._discountRate = discountRate;
    }
    get discountRate() { return this._discountRate; }
    set discountRate(arg) { this._discountRate = arg; }
}