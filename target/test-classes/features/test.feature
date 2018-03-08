Feature:  在百度中搜索
  
@TestNgScenario
  Scenario: 搜索TestNg
    Given  打开百度，验证title
    When  输入 "TestNg"
    Then  点击搜索按钮
    Then  清除搜索框
  @login
  Scenario Outline: 登录门店
    Given 打开门店地址 "http://192.168.1.79/terminal/waiter_1"
    When 输入用户名 "<username>" ，密码 "<password>"
    Then 点击登录按钮
    Examples:
    | username | password |
    | 1 | acewill |
    | 1 | 1 |

