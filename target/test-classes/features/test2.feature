Feature: 大众点评
@papaya
Scenario: 爬虫
Given 打开地址 "https://www.dianping.com/beijing"
When 点击 "小吃快餐"
Then  列出所有的店名字