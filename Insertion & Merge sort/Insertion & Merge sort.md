
# Insertion sort：O(n<sup>2</sup>)
>將原始資料，也就是input中的每一筆未排序資料加入已排序好的資料中，接著和前面的資料做比較並插入合適的位置。

- Pseudocode:

![8_a](https://user-images.githubusercontent.com/103521272/163130955-3e006dc0-5c7b-4272-9c26-005bc3a7b826.gif)

+ Python:

 <img width="500" alt="截圖 2022-06-17 下午10 40 00" src="https://user-images.githubusercontent.com/103521272/174320345-7ca202fb-aa5e-4621-9e6c-0a9c8bbb33a2.png">


程式碼較為直觀，在 for 迴圈中從 index1 開始取並將 "key" 設為目前的索引值，接著將 “i" 設為 key 的前一個索引以便比較。
在 while 迴圈中開始進行比較，若目前 i 對應的值比 key 大，則 i+1，也就是 key 的位置會宣告成 i 對應的值並且 i 往前一個位置。
迴圈會在 i 對應的值比 key 小時或是 i < 0 時（也就是 key 值為 input 中最小的數）停止。

# Merge sort：O(nlogn)
>利用Divide-and-conquer完成排序，會將input原始資料分割成左半部分和右半部分<br>分割後的兩筆資料再接著往下分割直到資料內剩一個元素，接著只剩一個元素的左半資料和右半資料進行合併<br>合併的過程會藉由比較左半、右半資料內元素來進行排序，最後形成完整的排序資料。

- Pseudocode (Merge) :

<img width="500" alt="Owtfo"  src="https://user-images.githubusercontent.com/103521272/163158082-e47366ad-3624-4729-a3e9-f269dedbc511.png" >

- Pseudocode (Merge sort) :

<img width="500" alt="wk49i" src="https://user-images.githubusercontent.com/103521272/163158251-2cf4fbae-dd29-4f11-8d28-3266af364866.png">

- Python:

<img width="500" alt="截圖 2022-04-16 下午3 59 05" src="https://user-images.githubusercontent.com/103521272/163667230-5735d4df-0525-4df3-949e-f33e19046b24.png">


在 Merge 函數中有四個參數，分別是要做排列的資料（data）、資料最左側索引值（left）、資料最右側索引值（Right）、資料中間索引值（middle），首先建立兩個 list 放置左半以及右半數列，要注意的是這時左半和右半都已是排列好的狀態。

<img width="500" alt="截圖 2022-04-16 下午3 55 06" src="https://user-images.githubusercontent.com/103521272/163667041-9fa86c08-901a-43ad-85ac-057329f55fb5.png"><img width="357" alt="截圖 2022-06-17 下午10 39 23" src="https://user-images.githubusercontent.com/103521272/174320250-0337a209-f659-445a-827e-f700ebda8c03.png">


這邊在 left 跟 right 建立 sentinel 由於 sentinel 是一個比 input 都大的數，因此我宣告他的值為 data 中最大的值加一。<br>

<img width="500" alt="截圖 2022-04-16 下午4 00 23" src="https://user-images.githubusercontent.com/103521272/163667258-5eff205a-a8af-4a69-bebc-bb7ac98f7359.png">

接著將 “i" ＆ "j" 設定成 0，目的是為了從 left 跟 right 最初的位置進行比較，比較小的放入 data 中且i（若 left 較小）或是 j（若 right 較小）加一。

<img width="413" alt="截圖 2022-04-16 下午4 11 50" src="https://user-images.githubusercontent.com/103521272/163667628-3a3b94a0-a184-4b63-bacd-790d88ebba1e.png">

在 Merge sort 函數中有三個參數，分別是要做排列的資料（data）、資料最左側索引值（left）、資料最右側索引值（Right），首先判斷 data 長度是否大於 1 ，接下來進行 Divide ，將 data 左右分割執行 Merge sort 最後將排序好的左半右半數列用 Merge 函數進行 conquer
























 




