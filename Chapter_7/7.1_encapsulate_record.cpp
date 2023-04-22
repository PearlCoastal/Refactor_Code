/*
 * @Author: FEIFEI SUN
 * @Description: 7.1 封装记录
 */

/***
 * 重构前
 */

// 一个被大量使用的常量
const organization = {name : "Acme Gooseberries", country : "GB"};

// 对这个常量进行读取和更新的地方
result += `<h1> ${organization.name}</ h1>`;
organization.name = newName;

/***
 * STEP1. 封装变量
 */
function getRawDataOfOrganization() { return organization; }

// 读取变量
result += `<h1> ${getRawDataOfOrganization().name}</ h1>`;

// 更新变量
getRawDataOfOrganization().name = newName;