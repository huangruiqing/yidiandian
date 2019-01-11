### 正则表达式
Regular Expression 表达式 | Description 描述
--- | ---
**.** | Matches any character【. 匹配任何字符】
**^** regex | Finds regex that must match at the beginning of the line.【找到必须以regex开始】
regex$ | Finds regex that must match at the end of the line.【找到必须以regex结尾】
[abc]| Set definition, can match the letter a or b or c.【比配a或b或c】
[abc][vz] | Set definition, can match a or b or c followed by either v or z.【比配a或b或c 后面跟着或v或z】
[^abc] | When a caret appears as the first character inside square brackets, it negates the pattern. This pattern matches any character except a or b or c.【当插入符号作为方括号内的第一个字符出现时，它会否定该模式。此模式匹配除a或b或c之外的任何字符】
[a-d1-7] | Ranges: matches a letter between a and d and figures from 1 to 7, but not d1.【范围：匹配a和d之间的字母以及1到7之间的数字，但不匹配d1】
X/Z | Finds X or Z.【找到X或Z】
XZ | Finds X directly followed by Z.【直接找到X，然后是Z】
$ | Checks if a line end follows.【检查线路末端是否跟随】