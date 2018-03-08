$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.feature");
formatter.feature({
  "id": "在百度中搜索",
  "description": "",
  "name": "在百度中搜索",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "在百度中搜索;爬虫",
  "tags": [
    {
      "name": "@papaya",
      "line": 18
    }
  ],
  "description": "",
  "name": "爬虫",
  "keyword": "Scenario",
  "line": 19,
  "type": "scenario"
});
formatter.step({
  "name": "打开地址 \"https://www.dianping.com/beijing\"",
  "keyword": "Given ",
  "line": 20
});
formatter.step({
  "name": "点击 \"小吃快餐\"",
  "keyword": "When ",
  "line": 21
});
formatter.step({
  "name": "列出所有的店名字",
  "keyword": "Then ",
  "line": 22
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.dianping.com/beijing",
      "offset": 6
    }
  ],
  "location": "MyStepdefs.打开地址(String)"
});
formatter.result({
  "duration": 22412496933,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "小吃快餐",
      "offset": 4
    }
  ],
  "location": "MyStepdefs.点击(String)"
});
formatter.result({
  "duration": 1474088353,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.列出所有的店名字()"
});
formatter.result({
  "duration": 26436014833,
  "status": "passed"
});
formatter.after({
  "duration": 1002098,
  "status": "passed"
});
});