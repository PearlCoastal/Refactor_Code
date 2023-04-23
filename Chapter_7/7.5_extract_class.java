/*
 * @Author: FEIFEI SUN
 * @Description: 7.5 提炼类
 */

/***
 * 重构前
 */
class Person
{
    get name() { return this._name; }
    set name(arg) { this._name = arg; }
    get telephoneNumber()
    {
        return `(${this.officeAreaCode})$ { this.officeNumber }
        `;
    }
    get officeAreaCode() { return this._officeAreaCode; }
    set officeAreaCode(arg) { this._officeAreaCode = arg; }
    get officeNumber() { return this._officeNumber; }
    set officeNumber(arg) { this._officeNumber = arg; }
}

/***
 * STEP1. 将与电话号码相关的行为分离到一个独立的类中
 */
class Person
{
    constructor()
    {
        this._telephoneNumber = new TelephoneNumber();
    }
}

class TelephoneNumber
{
    get officeAreaCode() { return this._officeAreaCode; }
    set officeAreaCode(arg) { this._officeAreaCode = arg; }
}

/***
 * STEP2. 搬移字段
 */
class Person
{
    get officeAreaCode() { return this._telephoneNumber.officeAreaCode; }
    set officeAreaCode(arg) { this._telephoneNumber.officeAreaCode = arg; }
}

/***
 * STEP3. 清理一下变量，电话号码不应该有办公室的概念
 */
class TelephoneNumber
{
    get areaCode() { return this._areaCode; }
    set areaCode(arg) { this._areaCode = arg; }
    get number() { return this._number; }
    set number(arg) { this._number = arg; }
}

class Person
{
    get officeAreaCode() { return this._telephoneNumber.areaCode; }
    set officeAreaCode(arg) { this._telephoneNumber.areaCode = arg; }
    get officeNumber() { return this._telephoneNumber.number; }
    set officeNumber(arg) { this._telephoneNumber.number = arg; }
}

/***
 * STEP4. TelephoneNumber类中有一个 get number也没什么道理，应用函数改名
 */
class TelephoneNumber
{
    toString()
    {
        return `(${this.areaCode})$ { this.number }
        `;
    }
}

class Person
{
    get telephoneNumber() {return this._telephoneNumber.toString();}
}
