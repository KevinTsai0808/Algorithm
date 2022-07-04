# Dynamic Programming
動態規劃的核心概念就是將原問題分解成數個子問題以解決原本複雜的問題，每一次計算子問題時都會儲存計算的答案，因此相較於貪婪演算法省去了許多重複計算的時間，而這些子問題的解會被用來解決規模更大的子問題，最後解決原題。

動態規劃最困難的地方在於看到題目時如何想出原問題與子問題的關係並加以寫出通式。  以下會介紹四種動態規劃常見的題目：
1. 裝配線調度問題（Assembly-Line Scheduling）
2. 矩陣鏈相乘問題（Matrix Chain Multiplication）
3. 最長共同子序列（Longest Common Subsequence）
4. 0-1背包問題（0-1 Knapsack）

# Assembly-Line Scheduling

