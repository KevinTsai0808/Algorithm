# Activity Selection Problem：O(nlogn)
>給予一系列的活動及他們的開始/結束時間，在時間不重疊的條件下找出可以使活動執行數量最大的策略

- Pseudocode：（Activity Selection Problem）

<img width="500" alt="截圖 2022-07-15 下午1 35 06" src="https://user-images.githubusercontent.com/103521272/179157643-90c94524-86d7-4adb-a47f-2c933830fed3.png">

在虛擬碼的 input 中可以看到分別為活動開始時間及活動結束時間，需要注意的是這裡的結束時間是已經排序好的狀態，之所以要排序結束時間的用意在於當每次迭代我們選擇了結束時間較早的活動時，就等於最大化剩餘的時間，這也是為什麼我們不會選擇排序開始時間的原因。  

從這裡也能看出貪婪演算法的性質，我們每次選擇的都是目前這個狀態的最佳解，而在滿足某些條件下，這個局部最佳解就是整體最佳解的一部分。

首先選擇排序好後的第一個活動，也就是結束時間最早的活動，接著從第二個活動開始走訪，如果第一個活動的結束時間和此活動的開始時間不衝突，則選擇此活動，接著繼續尋找與此活動的結束時間不衝突的活動，依此類推直到走訪完每個活動。

- Java：（Activity Selection Problem）

<img width="500" alt="截圖 2022-07-15 下午1 48 28" src="https://user-images.githubusercontent.com/103521272/179159249-0775eda7-6b59-47f7-8e43-53c549bd42d7.png">

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-15 下午2 43 51" src="https://user-images.githubusercontent.com/103521272/179166746-7e586926-a603-4bd7-99bd-128b1dc6425e.png">

<img width="500" alt="截圖 2022-07-15 下午2 44 20" src="https://user-images.githubusercontent.com/103521272/179166827-5a3c14e9-9739-4b8a-b063-f37de23e8987.png">


# Huffman Codes：O(nlogn)
>給予一系列字元出現的頻率，希望透過 variable length code 來將這些字元進行編碼，目標是最小化使用的位元

當我們對字元進行編碼時，通常比較熟知的方式是使用固定長度的編碼方式，像是字元 a 為 001，b 為 010 等等，但如果今天有些字元出現頻率很高，有些則很少，為了減少運算資源及空間的使用，更好的做法應該是給予出現頻率較高的字元長度較短的編碼，出現頻率較低的字元則給予長度較長的編碼。

- Pseudocode：（Huffman Codes）

<img width="500" alt="截圖 2022-07-15 下午2 15 05" src="https://user-images.githubusercontent.com/103521272/179162678-17b8de82-39d0-4e80-ae68-e3958af06522.png">

首先將所有節點都放入 Priority Queue（二元樹），接著透過迴圈每一次都取得 Priority Queue 中最小的兩個數（依照頻率排列），然後建立一個新的節點並加入 Priority Queue，節點的值為最小兩個數的頻率加總，由於每一次迴圈會將兩個節點合併，因此迴圈總共要執行 n-1 次，n 表示 input 的節點數量。

Huffman Codes 的貪婪策略在於每一次的迴圈都選擇對目前這個狀態而言，使頻率加起來最少的兩個字元，而這樣的選擇方法會使頻率出現低的字元出現在二元樹的底層（編碼較長），頻率出現高的字元則出現在二元樹的較上層（編碼較短）。

- Java：（Huffman Codes）

<img width="500" alt="截圖 2022-07-15 下午2 37 42" src="https://user-images.githubusercontent.com/103521272/179165885-74f1a14c-b960-45a2-b4bd-264cc83e644b.png">

當迴圈進行到最後一次時，我用一個物件變數 root 來儲存二元樹中的根節點，透過每一次迴圈中紀錄的左子節點（left）和右子節點（right）進行編碼的動作，其他關於 Codes 類別設定等程式碼都放在檔案中。


以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-15 下午2 45 07" src="https://user-images.githubusercontent.com/103521272/179166934-b6d1ff25-d92d-4df0-88c6-d9c4fa59d404.png">

<img width="500" alt="截圖 2022-07-15 下午2 45 26" src="https://user-images.githubusercontent.com/103521272/179166999-2fc4e53e-b18e-46fe-8095-e0081bdcff2c.png">
