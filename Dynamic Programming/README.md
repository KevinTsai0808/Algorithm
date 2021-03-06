# Dynamic Programming
動態規劃的核心概念就是將原問題分解成數個子問題以解決原本複雜的問題，每一次計算子問題時都會儲存計算的答案，因此相較於貪婪演算法省去了許多重複計算的時間，而這些子問題的解會被用來解決規模更大的子問題，最後解決原題。

動態規劃最困難的地方在於看到題目時如何想出原問題與子問題的關係並加以寫出通式。  以下會介紹四種動態規劃常見的題目：
1. 裝配線調度問題（Assembly-Line Scheduling）
2. 矩陣鏈相乘問題（Matrix Chain Multiplication）
3. 最長共同子序列（Longest Common Subsequence）
4. 0-1背包問題（0-1 Knapsack）

# Assembly-Line Scheduling：O(n)
>一個工廠有兩條裝配線，而每一條裝配線都各有 i 個工作站，當一個產品要被製造時必須經過每一個工作站以完成製作  
>然而由於加工的方法不同，因此同一個工作站下，兩條裝配線會有不同的加工時間，從一條裝配線轉移至另一條裝配線也會有轉換時間  
>因此必須思考哪一個工作站要於哪個一條裝配線加工以最小化產品製作時間

若是利用遍歷的方法進行解題，則整個演算法所需時間會高達 O(2^n)，因此利用動態規劃的方式進行解題。  
我們可以發現在每一次加工前，產品會從兩個方向抵達目前的工作站：
1. 同一條裝配線
2. 從另一條裝配線轉移

因此分別計算出兩種方向的時間成本並進行比較，就可以得出抵達目前工作站所需的最小時間成本，再利用目前算出的最佳解進行下一個工作站的成本計算，透過此方法，在計算下一個工作站時，不需從第一個工作站慢慢計算，只需要取得目前工作站的最佳解再加上下一個工作站的加工時間、轉換時間便可求出答案，以下是關係式：

<img width="500" alt="截圖 2022-07-04 下午6 06 58" src="https://user-images.githubusercontent.com/103521272/177132995-7c31108b-fe28-4716-abaf-0ca05d394767.png">

f1[]、f2[]儲存的是到 j 工作站的最小時間成本，e1、e2代表前置時間，也就是到第一個工作站前的時間成本，aij則表示第 i 個裝配線第 j 個工作站的加工時間，tij則表示第 i 個裝配線第 j 個工作站轉移至另一個裝配線第 j+1 個工作站的轉移成本，x1、x2則表示最後一個工作站到產品完成的作業時間。

- Pseudocode：（Assembly-Line Scheduling）

<img width="500" alt="截圖 2022-07-04 下午6 19 38" src="https://user-images.githubusercontent.com/103521272/177135166-f3d9aa2f-6af9-417b-90a9-11cdeff16e82.png">
<img width="500" alt="截圖 2022-07-04 下午6 19 58" src="https://user-images.githubusercontent.com/103521272/177135218-7a2e6310-173b-4698-ac64-29684058af68.png">

- Java： （Assembly-Line Scheduling）
<img width="500" alt="截圖 2022-07-04 下午6 22 58" src="https://user-images.githubusercontent.com/103521272/177135702-10e1513d-a1df-41e8-aa79-5b591c59be0a.png">

我採用的算法為 bottom up，在23、33行可以看出當抵達工作站時，只需比較 1.同一個裝配線前一個工作站的最佳解 2.另一個裝配線前一個工作站的最佳解加上轉移時間 的大小，便可以求出到達此工作站的最佳解。

l1[]、l2[]儲存的是從哪一條裝配線抵達此工作站，舉例來說，如果l1[3] = 1，則代表抵達第一條裝配線、第三個工作站的最佳路線是從第一條裝配線、第二個工作站過來的。

在43~50行則是計算兩條裝配線抵達最後一個工作站的最小時間成本加上各自的 x 並且比較大小。

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-04 下午6 56 24" src="https://user-images.githubusercontent.com/103521272/177141004-36fd85f5-7716-4458-ac98-31bbeee930db.png">

<im
    g width="500" alt="截圖 2022-07-04 下午6 59 42" src="https://user-images.githubusercontent.com/103521272/177141490-86f56b1f-ef42-4b36-aa66-7cbd17dbcdb7.png">

# Matrix Chain Multiplication：O(n^3)
>給定一個 n 個矩陣的序列，由於矩陣相乘的順序在運算的 cost 上會造成很大影響，因此希望找出最小化運算 cost 的矩陣鏈相乘順序  
>假設有個矩陣鏈 <A1, A2, A3> 分別為5x4 4x20 20x3，若是依照 (A1xA2)A3 的順序計算，則 cost 為5x4x20 + 5x20x3 = 700。
>若是依照 A1(A2xA3) 的順序計算，則 cost 為5x4x3 + 4x20x3 = 300
>隨著矩陣鏈長度增加，相乘順序在運算上則會出現巨大差異

首先要從原問題中劃分出子問題，假設原問題為求出 <A1, A2, A3, A4, A5, A6> 的相乘順序，我們可以知道矩陣乘法是兩兩相乘，因此在問題的最後會是兩個子矩陣鏈的相乘得出原問題的最佳解
則我們可以假設最佳切割點為 k ，若是 k = A2，那麼兩個子矩陣鏈就分別為 <A1, A2> 和 <A3, A4, A5, A6>，接著繼續將子問題分解，求出 <A3, A4, A5, A6> 的最佳切割點，便可以往下分解問題。  

從以上假設可以發現，若是我們從矩陣鏈長度為2的情況開始計算最佳切割點以及運算 cost ，則當我們計算到矩陣鏈較長的運算 cost 時，便已經確定子問題的最佳切割點，因此只需要考慮當前問題的切割點
。舉例來說，假設我們要計算 <A2, A3, A4, A5>，表示我們已經知道矩陣鏈長度為3以下的最佳切割點了，也就是 <A2, A3, A4> 及 <A3, A4, A5> 的最佳解，因此我們只需要考慮以下三種情況的大小：
1. A2(A3xA4xA5)
2. (A2xA3)(A4xA5)
3. (A2xA3xA4)A5
也就是遍歷目前長度下的每個切割點計算 cost 並找出最佳解。   

我們假設矩陣 Ai 的 row & column 為 p(i-1)xpi，m[i, j]表示 Ai~Aj的最小運算 cost，以下是關係式：

<img width="500" alt="截圖 2022-07-04 下午7 42 28" src="https://user-images.githubusercontent.com/103521272/177147854-6a3ffdb1-f9e7-4397-b0ed-0c1de3ea1c9d.png">

- Pseudocode：（MCM）

<img width="500" alt="截圖 2022-07-04 下午7 48 42" src="https://user-images.githubusercontent.com/103521272/177148841-9b9b2f7d-755a-4aff-abb2-99c1afcb8b97.png">

- Java：（MCM）

<img width="500" alt="截圖 2022-07-04 下午7 49 48" src="https://user-images.githubusercontent.com/103521272/177149027-37ca828d-aacb-4d07-add9-443b255dab39.png">

s[i][j] 以及 m[i][j] 分別儲存 Ai~Aj的最佳切割點以及最小 cost ，在19~32行中，先從矩陣鏈長度為2開始計算，遍歷每一種長度為2的情況並計算 cost，接著尋訪矩陣鏈長度為3的每一種情況，透過剛剛算出的長度為2的最佳解找出長度為3的最佳切割點並儲存 cost 及切割點，依此類推。

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-04 下午8 01 04" src="https://user-images.githubusercontent.com/103521272/177150678-4baa6610-0410-41a7-abf9-8db4fa103124.png">
<img width="500" alt="截圖 2022-07-04 下午8 02 17" src="https://user-images.githubusercontent.com/103521272/177150863-6bd62925-e6dd-4c25-b930-ff389f0ee193.png">

# Longest Common Subsequence：O(mn)
>給予兩個不同的序列，尋找出兩個序列中最長的子序列  
>例如 x = <A, B, C, B, D, A, B>，y = <B, D, C, A, B, A>，那麼這兩個序列的 LCS 為 <B, C, B, A>

首先從原問題分解出子問題，假設 x = <x1, x2, x3, x4, x5> , y = <y1, y2, y3, y4, y5, y6> 為 Input ，而 x, y 的 LCS 為序列 z = <z1, z2, z3, ..., zk>，那麼我們可以將 LCS 分成以下情況討論：
1.  LCS 包含 x 的最後一個元素以及 y 的最後一個元素
2.  LCS 包含 x 的最後一個元素，不包含 y 的最後一個元素 
3.  LCS 包含 y 的最後一個元素，不包含 x 的最後一個元素 
4.  LCS 包含 x 或 y 的最後一個元素 

針對第一種情況，由於 x, y 的最後一個元素皆在 LCS 中，因此可以確定 zk 為此元素，可以將原問題解讀成 <x1, x2, x3, x4> 和 <y1, y2, y3, y4, y5> 的 LCS+1。 

針對第二種情況，由於 x 的最後一個元素在 LCS 中，因此可以確定 zk 為 x 的最後一個元素，而此 LCS 和 y 的最後一個元素無關，因此可以將原問題解讀成 <x1, x2, x3, x4, x5> 和 <y1, y2, y3, y4, y5> 的 LCS。

針對第三種情況，由於 y 的最後一個元素在 LCS 中，因此可以確定 zk 為 y 的最後一個元素，而此 LCS 和 x 的最後一個元素無關，因此可以將原問題解讀成 <x1, x2, x3, x4> 和 <y1, y2, y3, y4, y5, y6> 的 LCS。

針對第四種情況，由於此 LCS 跟 x 的最後一個元素和 y 的最後一個元素無關，因此可以將原問題解讀成 <x1, x2, x3, x4> 和 <y1, y2, y3, y4, y5> 的 LCS。

根據以上情況可以得出以下關係式：

<img width="500" alt="截圖 2022-07-05 上午10 45 35" src="https://user-images.githubusercontent.com/103521272/177239371-3a48bcbe-a62f-460a-9c34-a5437bd1575c.png">

c[i, j] 代表的是 <x1,..., xi> 和 <y1,..., yj> 的 LCS 長度。  
由於我們並不知道真正的 LCS 為何，因此透過判斷 x 和 y的元素是否相等來決定是以上哪一種情況。
  
- Pseudocode：（LCS）
    
<img width="500" alt="截圖 2022-07-05 上午10 53 35" src="https://user-images.githubusercontent.com/103521272/177240200-e8e6c839-444a-4ced-8aa4-c00c846f8ed3.png">
<img width="500" alt="截圖 2022-07-05 上午10 54 17" src="https://user-images.githubusercontent.com/103521272/177240269-efdd75c7-47c8-44d0-9bf4-aa5dee831709.png">

- Java：（LCS）  

<img width="500" alt="截圖 2022-07-05 上午10 55 38" src="https://user-images.githubusercontent.com/103521272/177240386-be48790a-94fa-4609-9cf2-8dbe3f9212f9.png">

b[i][j] 用來記錄目前屬於1, 2, 3哪一種情況，0表示情況1、1表示情況2、2表示情況3。  

以下是主程式碼及執行結果：
    
<img width="500" alt="截圖 2022-07-05 上午11 06 21" src="https://user-images.githubusercontent.com/103521272/177241540-07ae1bb3-6b1d-4036-9054-05031d1bd8aa.png">
<img width="500" alt="截圖 2022-07-05 上午11 10 36" src="https://user-images.githubusercontent.com/103521272/177241958-0cf59b07-4854-454b-b366-3ff64f70d3cd.png">

# 0-1knapsack：O(nW)
> n 表示物品數量，W 表示背包可容納重量  
> 給予一群物品的重量以及價格資訊，在背包重量限制下最大化物品的總價值
> 0-1表示物品只有放或是不放兩個選擇，不能放入物品的部分
    
一開始看見題目時，可能會想說利用價值和重量的比值作為優先選擇的依據進行解題，然而這可能不會導致問題的最佳解，舉例來說，有3個物品，w(weight) = <10, 20, 30>，v(value) = <60, 100, 120>，W(capacity) = 50，若是利用比值為依據做選擇，則答案為物品1和物品3，總價值為180，然而最佳解為物品2和物品3，總價值為220。

因此我們透過動態規劃的思維進行問題分解，每一件物品都可以選擇放或是不放，當考慮其中一個物品時可以分成以下三種情況：
1. 物品重量大於耐重，原問題最佳解為剩下物品的最佳解
2. 物品重量小於耐重：
    2.1 若是不放，則背包總價值為考慮完上一個物品的總價值
    2.2 若是要放，則考慮上一個物品時必須先扣掉目前物品的重量（預留背包空間），背包總價值為考慮完上一個物品的總價值加上目前物品的價值
    
而決定放不放的關鍵因素就是比較1. 扣掉目前物品的重量的耐重限制下，考慮完上一個物品的總價值加上目前物品的價值 以及2. 耐重限制不變，考慮完上一個物品的總價值 的大小，若是1較大，則放入此物品，若是2較大，則不放。
    
以下是關係式：
    
<img width="500" alt="截圖 2022-07-05 下午1 11 35" src="https://user-images.githubusercontent.com/103521272/177253912-c52b4124-77d8-4d37-a2fd-70b1331f9857.png">

c[i][M] 表示耐重限制為 M 下，考慮完第 i 個物品的背包總價值。
    
- Pseudocode：（0-1knapsack）

<img width="500" alt="截圖 2022-07-05 下午1 23 11" src="https://user-images.githubusercontent.com/103521272/177255275-3ca9b142-e56d-411f-ada5-0d8a3ec828e6.png">

- Java：（0-1knapsack）    

<img width="500" alt="截圖 2022-07-05 下午1 32 28" src="https://user-images.githubusercontent.com/103521272/177256351-446f2936-e9cd-45b1-acdc-392e84f16f47.png">

b[i][j] 表示在耐重為 j 的情況下，放不放物品 i ，1表示放，反之則為0。   

以下是主程式碼以及執行結果：
    
<img width="500" alt="截圖 2022-07-05 下午1 35 49" src="https://user-images.githubusercontent.com/103521272/177256723-605d47dd-b20a-484c-bc82-9bfc9ed4400c.png">
    
<img width="500" alt="截圖 2022-07-05 下午1 36 52" src="https://user-images.githubusercontent.com/103521272/177256846-96c0dea4-312d-4270-bbbe-8c724c613812.png">
